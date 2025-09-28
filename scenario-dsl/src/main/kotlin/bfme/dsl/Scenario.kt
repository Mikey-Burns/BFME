package bfme.dsl

import bfme.domain.Territory

/**
 * DSL element for the actual scenario details.
 */
@WotrDsl
class Scenario : WotrElement {
    override val clazz: Class<out WotrElement> = Scenario::class.java

    // region Fields
    var name: String = ""
    var description: String = ""
    var gameType: String = ""
    var objectives: String = ""
    var fiction: String = ""
    var victoriousText: String = ""
    var defeatedText: String = ""
    var regionCampaign: String = "DefaultCampaign"
    var customVictoryCondition: Boolean = false
    var minPlayers: Int = 6
    var maxPlayers: Int = 6

    private val _disableRegions = mutableListOf<Territory>()
    val disableRegions: List<Territory> get() = _disableRegions.toList()

    private val _disallowStartInRegions = mutableSetOf<Territory>()
    val disallowStartInRegions: List<Territory> get() = _disallowStartInRegions.toList()

    private val _defaultStartSpots = mutableListOf<Territory>()
    val defaultStartSpots: List<Territory> get() = _defaultStartSpots.toList()

    private val _playerDefeatConditions = mutableListOf<PlayerDefeatCondition>()
    val playerDefeatConditions: List<PlayerDefeatCondition> get() = _playerDefeatConditions.toList()

    private val _teamDefeatConditions = mutableListOf<TeamDefeatCondition>()
    val teamDefeatConditions: List<TeamDefeatCondition> get() = _teamDefeatConditions.toList()

    private val _teamVictoryConditions = mutableListOf<TeamVictoryCondition>()
    val teamVictoryConditions: List<TeamVictoryCondition> get() = _teamVictoryConditions.toList()

    private val _startingRestrictions = mutableListOf<StartingRestriction>()
    val startingRestrictions: List<StartingRestriction> get() = _startingRestrictions.toList()

    private val _ownershipSets = mutableListOf<OwnershipSet>()
    val ownershipSets: List<OwnershipSet> get() = _ownershipSets.toList()
    // endregion

    // region Functions
    /**
     * Disable a region.
     * Multiple regions can be disabled.
     */
    fun disable(territory: Territory) {
        _disableRegions.add(territory)
    }

    /**
     * Disallow starting in a region.
     * Multiple regions can be disallowed.
     */
    fun disallowStart(territory: Territory) {
        _disallowStartInRegions.add(territory)
    }

    /**
     * Set a default starting region.
     * Multiple regions can be set as default starting points.
     */
    fun defaultStart(territory: Territory) {
        _defaultStartSpots.add(territory)
    }
    // endregion

    override fun validate(): List<Violation> = buildList {
        if (name.isEmpty()) add(violation("'name' must not be empty"))
        if (description.isEmpty()) add(violation("'description' must not be empty"))
        if (gameType.isEmpty()) add(violation("'gameType' must not be empty"))
        if (objectives.isEmpty()) add(violation("'objectives' must not be empty"))
        if (fiction.isEmpty()) add(violation("'fiction' must not be empty"))
        if (victoriousText.isEmpty()) add(violation("'victoriousText' must not be empty"))
        if (defeatedText.isEmpty()) add(violation("'defeatedText' must not be empty"))
        if (minPlayers !in 2..6) add(violation("'minPlayers' must be between 2 and 6"))
        if (maxPlayers !in 2..6) add(violation("'maxPlayers' must be between 2 and 6"))
        if (maxPlayers < minPlayers) add(violation("'maxPlayers' must be greater than or equal to minPlayers"))

        defaultStartSpots.forEach { startSpot ->
            if (startSpot in disallowStartInRegions) add(violation("'${startSpot.codeName}' cannot be a default start spot if it is disallowed"))
            if (startSpot in disableRegions) add(violation("'${startSpot.codeName}' cannot be a default start spot if it is disabled"))
        }

        addAll(playerDefeatConditions.flatMap(PlayerDefeatCondition::validate))
        addAll(teamDefeatConditions.flatMap(TeamDefeatCondition::validate))
        addAll(teamVictoryConditions.flatMap(TeamVictoryCondition::validate))
        addAll(startingRestrictions.flatMap(StartingRestriction::validate))
        addAll(ownershipSets.flatMap(OwnershipSet::validate))
    }

    override fun render(): String = buildString {
        appendLine(1, "Scenario")
        appendLine(2, "DisplayName = $name")
        appendLine(2, "DisplayDescription = $description")
        appendLine(2, "DisplayGameType = $gameType")
        appendLine(2, "DisplayObjectives = $objectives")
        appendLine(2, "DisplayFiction = $fiction")
        appendLine(2, "DisplayVictoriousText = $victoriousText")
        appendLine(2, "DisplayDefeatedText = $defeatedText")
        appendLine()
        appendLine(2, "RegionCampaign = $regionCampaign")
        appendLine()
        appendLine(2, "UseMpRulesVictoryCondition = ${if (customVictoryCondition) "No" else "Yes"}")
        appendLine(2, "MinPlayers = $minPlayers")
        appendLine(2, "MaxPlayers = $maxPlayers")

        if (disableRegions.isNotEmpty() || disallowStartInRegions.isNotEmpty() || defaultStartSpots.isNotEmpty()) appendLine()

        if (disableRegions.isNotEmpty()) {
            val disableRegion = disableRegions.map(Territory::codeName).sorted().joinToString(" ")
            appendLine(2, "DisableRegions = $disableRegion")
        }
        if (disallowStartInRegions.isNotEmpty()) {
            val disallowStart = disallowStartInRegions.map(Territory::codeName).sorted().joinToString(" ")
            appendLine(2, "DisallowStartInRegions = $disallowStart")
        }
        if (defaultStartSpots.isNotEmpty()) {
            val defaultStart = defaultStartSpots.joinToString(" ", transform = Territory::codeName)
            appendLine(2, "DefaultStartSpots = $defaultStart")
        }

        if (playerDefeatConditions.isNotEmpty()) {
            appendLine()
            append(playerDefeatConditions.joinToString("\n", transform = PlayerDefeatCondition::render))
        }

        if (teamDefeatConditions.isNotEmpty()) {
            appendLine()
            append(teamDefeatConditions.joinToString("\n", transform = TeamDefeatCondition::render))
        }

        if (teamVictoryConditions.isNotEmpty()) {
            appendLine()
            append(teamVictoryConditions.joinToString("\n", transform = TeamVictoryCondition::render))
        }

        if (startingRestrictions.isNotEmpty()) {
            appendLine()
            append(startingRestrictions.joinToString("\n", transform = StartingRestriction::render))
        }

        if (ownershipSets.isNotEmpty()) {
            appendLine()
            append(ownershipSets.joinToString("\n", transform = OwnershipSet::render))
        }

        appendLine(1, "End")
    }

    // region Child DSLs
    /**
     * Specify a player defeat condition.
     * Multiple player defeat conditions can be specified.
     */
    fun Scenario.playerDefeatCondition(block: PlayerDefeatCondition.() -> Unit) {
        _playerDefeatConditions.add(PlayerDefeatCondition().apply(block))
    }

    /**
     * Specify a team defeat condition.
     * Multiple team defeat conditions can be specified.
     */
    fun Scenario.teamDefeatCondition(block: TeamDefeatCondition.() -> Unit) {
        _teamDefeatConditions.add(TeamDefeatCondition().apply(block))
    }

    /**
     * Specify a team victory condition.
     * Multiple team victory conditions can be specified.
     */
    fun Scenario.teamVictoryCondition(block: TeamVictoryCondition.() -> Unit) {
        _teamVictoryConditions.add(TeamVictoryCondition().apply(block))
    }

    /**
     * Specify a starting restriction.
     * Multiple starting restrictions can be specified.
     */
    fun Scenario.startingRestriction(block: StartingRestriction.() -> Unit) {
        _startingRestrictions.add(StartingRestriction().apply(block))
    }

    /**
     * Specify a player's ownership set.
     * Multiple ownership sets can be specified.
     */
    fun Scenario.ownershipSet(block: OwnershipSet.() -> Unit) {
        _ownershipSets.add(OwnershipSet().apply(block))
    }
    // endregion
}
