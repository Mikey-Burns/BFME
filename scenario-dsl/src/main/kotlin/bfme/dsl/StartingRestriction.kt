package bfme.dsl

import bfme.domain.Faction
import bfme.domain.Territory

/**
 * DSL element for a starting restriction.
 */
@WotrDsl
class StartingRestriction : WotrElement {
    override val clazz: Class<out WotrElement> = StartingRestriction::class.java

    private val _factions = mutableListOf<Faction>()
    val factions: List<Faction> get() = _factions.toList()

    private val _regions = mutableListOf<Territory>()
    val regions: List<Territory> get() = _regions.toList()

    var teams: Int = -1

    /**
     * Specify a faction to restrict to.
     */
    fun faction(faction: Faction) {
        _factions.add(faction)
    }

    /**
     * Specify a territory to restrict to.
     */
    fun region(region: Territory) {
        _regions.add(region)
    }

    override fun validate(): List<Violation> = buildList {
        if (teams !in 1..2) add(violation("'team' must be 1 or 2"))
        if (factions.isEmpty() && regions.isEmpty()) add(violation("'factions' and 'regions' must not both be empty"))
    }

    override fun render(): String = buildString {
        appendLine(2, "StartingRestriction")
        if (factions.isNotEmpty())
            appendLine(3, "Factions = ${factions.joinToString(" ", transform = Faction::codeName)}")
        if (regions.isNotEmpty())
            appendLine(3, "Regions = ${regions.joinToString(" ", transform = Territory::codeName)}")
        if (teams > 0) appendLine(3, "Teams = $teams")
        appendLine(2, "End")
    }
}
