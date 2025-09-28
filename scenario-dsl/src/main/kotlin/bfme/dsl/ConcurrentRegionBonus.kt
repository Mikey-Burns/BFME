package bfme.dsl

import bfme.domain.Territory

/**
 * DSL element for a custom grouping of territories.
 */
@WotrDsl
class ConcurrentRegionBonus : WotrElement {
    override val clazz: Class<out WotrElement> = ConcurrentRegionBonus::class.java
    var armyBonus: Int = 0
    var resourceBonus: Int = 0
    var legendaryBonus: Int = 0
    var attackBonus: Int = 0
    var defenseBonus: Int = 0
    var experienceBonus: Int = 0
    var freeInnUnitsBonus: Int = 0
    var freeBuilderBonus: Int = 0
    private val _regions = mutableListOf<Territory>()
    val regions: List<Territory> get() = _regions.toList()

    override fun validate(): List<Violation> = buildList {
        if (armyBonus < 0) add(violation("'armyBonus' must be greater than or equal to 0"))
        if (resourceBonus < 0) add(violation("'resourceBonus' must be greater than or equal to 0"))
        if (legendaryBonus < 0) add(violation("'legendaryBonus' must be greater than or equal to 0"))
        if (attackBonus < 0) add(violation("'attackBonus' must be greater than or equal to 0"))
        if (defenseBonus < 0) add(violation("'defenseBonus' must be greater than or equal to 0"))
        if (experienceBonus < 0) add(violation("'experienceBonus' must be greater than or equal to 0"))
        if (freeInnUnitsBonus < 0) add(violation("'freeInnUnitsBonus' must be greater than or equal to 0"))
        if (freeBuilderBonus < 0) add(violation("'freeBuilderBonus' must be greater than or equal to 0"))
    }

    override fun render(): String = buildString {
        appendLine(1, "ConcurrentRegionBonus")
        appendLine(2, "Territory = LW:TerritoryCustom")
        appendLine(2, "EffectName = CustomEffect")
        appendLine(2, "Regions = ${regions.map(Territory::codeName).sorted().joinToString(" ")}")
        appendLine(2, "ArmyBonus = $armyBonus")
        appendLine(2, "ResourceBonus = $resourceBonus")
        appendLine(2, "LegendaryBonus = $legendaryBonus")
        appendLine(2, "AttackBonus = $attackBonus")
        appendLine(2, "DefenseBonus = $defenseBonus")
        appendLine(2, "ExperienceBonus = $experienceBonus")
        appendLine(2, "FreeInnUnitsBonus = $freeInnUnitsBonus")
        appendLine(2, "FreeBuilderBonus = $freeBuilderBonus")
        appendLine(2, "UnifiedEvaEvent = WorldUnifyNorthernWastes")
        appendLine(2, "LostEvaEvent = WorldLostNorthernWastes")
        appendLine(2, "LookAtCenter = X:-65 Y:2085")
        appendLine(2, "LookAtHeading = 0")
        appendLine(2, "LookAtZoom = 0.71")
        appendLine(1, "End")
    }

    /**
     * Specify a territory to include in the region.
     */
    fun region(region: Territory) {
        _regions.add(region)
    }
}