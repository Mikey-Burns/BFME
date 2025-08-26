package bfme.dsl

@WotrDsl
class LivingWorldCampaign : WotrElement {
    override val clazz: Class<out WotrElement> = LivingWorldCampaign::class.java
    var name: String = ""
    var description: String = ""
    var number: Int = -1
    var scenario: Scenario? = null

    override fun validate(): List<Violation> = buildList {
        if (name.isEmpty()) add(violation("'name' must not be empty"))
        if (description.isEmpty()) add(violation("'description' must not be empty"))
        if (number < 0) add(violation("'number' must be greater than 0"))
        if (scenario == null) add(violation("'scenario' must not be null"))
        addAll(scenario?.validate() ?: emptyList())
    }

    override fun render(): String {
        val violations = validate()
        if (violations.isNotEmpty()) throw WotrException(violations)
        return buildString {
            appendLine("//-------------------------------------------------------------------------------------------------")
            appendLine("// Scenario Name: $name")
            appendLine("// Scenario Description: $description")
            appendLine("//-------------------------------------------------------------------------------------------------")
            appendLine()
            appendLine("LivingWorldCampaign WOTRScenario${number.digitToChar().toString().padStart(3, '0')}")
            appendLine()
            appendLine(1, "IsEvilCampaign = No")
            appendLine()
            appendLine(1, ";////////////// RTS Settings /////////////")
            appendLine(1, "#include \"..\\Common\\LivingWorldDefaultRTSSettings.inc\"")
            appendLine()
            append(scenario?.render())
            appendLine()
            appendLine(1, ";//////////////////////////////////////////////////")
            appendLine(1, "Act One")
            appendLine(1, ";//////////////////////////////////////////////////")
            appendLine()
            appendLine(2, ";///////////////// Armies ////////////////")
            appendLine(2, "#include \"..\\Common\\LivingWorldDefaultArmies.inc\"")
            appendLine()
            appendLine(2, ";//////////////// VISUAL FLUFF ////////////////")
            appendLine(2, "EyeTowerPoints")
            appendLine(2, "    LookPoint = X:436 Y:687 ; Rohan")
            appendLine(2, "    LookPoint = X:481 Y:287")
            appendLine(2, "    LookPoint = X:1179 Y:461")
            appendLine(2, "    LookPoint = X:947 Y:917")
            appendLine(2, "    LookPoint = X:172 Y:573 ; Isengard")
            appendLine(2, "    LookPoint = X:160 Y:560 ; Isengard")
            appendLine(2, "    LookPoint = X:175 Y:557 ; Isengard")
            appendLine(2, "    LookPoint = X:171 Y:348 ; Helm's Deep")
            appendLine(2, "    LookPoint = X:257 Y:535 ; Helm's Deep")
            appendLine(2, "    LookPoint = X:120 Y:350 ; Helm's Deep")
            appendLine(2, "    LookPoint = X:157 Y:420 ; Helm's Deep")
            appendLine(2, "End")
            appendLine(1, "End")
            appendLine("End")
        }
    }

    fun LivingWorldCampaign.scenario(block: Scenario.() -> Unit) {
        scenario = Scenario().apply(block)
    }
}

fun livingWorldCampaign(block: LivingWorldCampaign.() -> Unit): LivingWorldCampaign = LivingWorldCampaign().apply(block)
