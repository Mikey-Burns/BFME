package bfme.dsl

/**
 * DSL element for a set of region definitions.
 */
@WotrDsl
class LivingWorldRegionCampaign : WotrElement {
    override val clazz: Class<out WotrElement> = LivingWorldRegionCampaign::class.java

    var name: String = ""
    private val _concurrentRegionBonuses = mutableListOf<ConcurrentRegionBonus>()
    val concurrentRegionBonuses: List<ConcurrentRegionBonus> get() = _concurrentRegionBonuses.toList()

    override fun validate(): List<Violation> = buildList {
        if (name.isEmpty()) add(violation("'name' must not be empty"))

        addAll(concurrentRegionBonuses.flatMap(ConcurrentRegionBonus::validate))
    }

    override fun render(): String = buildString {
        appendLine("LivingWorldRegionCampaign $name")
        appendLine(1, "RegionConqueredSound = Gui_RegionConquered")
        appendLine(1, "RegionEffectsManagerName = WotRRegionEffects")
        appendLine(1, "RegionBonusArmy = LW:RegionBonusArmy_Good")
        appendLine(1, "RegionBonusResource = LW:RegionBonusResource")
        appendLine(1, "RegionBonusLegendary = LW:RegionLegendaryBonus")
        appendLine(1, "HeroOnlyArmyCommandPoints = 0")
        appendLine(1, "SmallArmyCommandPoints = 120")
        appendLine(1, "MediumArmyCommandPoints = 240")
        appendLine()
        appendLine(1, "// Regions")
        appendLine(1, "#include \"..\\common\\livingworldregionswithoutbonus.inc\"")
        appendLine()
        append(concurrentRegionBonuses.joinToString("\n", transform = ConcurrentRegionBonus::render))
        appendLine("End")
    }

    fun LivingWorldRegionCampaign.concurrentRegionBonus(block: ConcurrentRegionBonus.() -> Unit) {
        _concurrentRegionBonuses.add(ConcurrentRegionBonus().apply(block))
    }
}

