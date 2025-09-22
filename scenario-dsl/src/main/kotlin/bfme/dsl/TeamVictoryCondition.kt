package bfme.dsl

import bfme.domain.Territory

/**
 * DSL representation of how a team can be victorious.
 */
@WotrDsl
class TeamVictoryCondition : WotrElement {
    override val clazz: Class<out WotrElement> = TeamVictoryCondition::class.java
    private val _teams = mutableListOf<Int>()
    val teams: List<Int> get() = _teams.toList()
    private val _regions = mutableListOf<Territory>()
    val regions: List<Territory> get() = _regions.toList()
    var numTurns = 1

    /**
     * Add a team to the victory condition.
     * Victory conditions can apply to one or more teams.
     */
    fun team(team: Int) {
        _teams.add(team)
    }

    /**
     * Add a region to the victory condition
     */
    fun region(region: Territory) {
        _regions.add(region)
    }

    override fun validate(): List<Violation> = buildList {
        if (teams.isEmpty()) add(violation("'teams' must not be empty"))
        if (regions.isEmpty()) add(violation("'regions' must not be empty"))
        if (numTurns <= 0) add(violation("'numTurns' must be greater than 0"))
    }

    override fun render(): String = buildString {
        appendLine(2, "TeamVictoryCondition")
        appendLine(3, "Teams = ${teams.joinToString(" ")}")
        appendLine(3, "ControlledRegions = ${regions.joinToString(" ", transform = Territory::codeName)}")
        appendLine(3, "ControlledRegionsHeldForTurns = $numTurns")
        appendLine(2, "End")
    }
}
