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
        if (violations.isNotEmpty()) throw IllegalStateException(violations.joinToString("\n"))
        return buildString {
            appendLine("//-------------------------------------------------------------------------------------------------")
            appendLine("// Scenario Name:\t$name")
            appendLine("// Scenario Description:\t$description")
            appendLine("// Unavailable Territories:\tNone")
            appendLine("// # of Players:\t6")
            appendLine("//-------------------------------------------------------------------------------------------------")
            appendLine()
            appendLine("LivingWorldCampaign WOTRScenario$number")
            appendLine("\tIsEvilCampaign = No")
            appendLine()
            appendLine("\t#include \"..\\Common\\LivingWorldDefaultRTSSettings.inc\"")
            appendLine()
            appendLine(scenario?.render())
            appendLine()
            // TODO: Act One
            appendLine("End")
        }
    }

    fun LivingWorldCampaign.scenario(block: Scenario.() -> Unit) {
        scenario = Scenario().apply(block)
    }
}

fun livingWorldCampaign(block: LivingWorldCampaign.() -> Unit): LivingWorldCampaign = LivingWorldCampaign().apply(block)
