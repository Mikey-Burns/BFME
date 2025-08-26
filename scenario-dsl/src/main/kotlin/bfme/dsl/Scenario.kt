package bfme.dsl

import bfme.domain.Territory

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
    var minPlayers: Int = 6
    var maxPlayers: Int = 6

    private val _disallowStartInRegions = mutableSetOf<Territory>()
    val disallowStartInRegions: List<Territory> get() = _disallowStartInRegions.toList()

    private val _defaultStartSpots = mutableListOf<Territory>()
    val defaultStartSpots: List<Territory> get() = _defaultStartSpots.toList()

    private val _playerDefeatConditions = mutableListOf<PlayerDefeatCondition>()
    val playerDefeatConditions: List<PlayerDefeatCondition> get() = _playerDefeatConditions.toList()

    private val _teamDefeatConditions = mutableListOf<TeamDefeatCondition>()
    val teamDefeatConditions: List<TeamDefeatCondition> get() = _teamDefeatConditions.toList()

    private val _startingRestrictions = mutableListOf<StartingRestriction>()
    val startingRestrictions: List<StartingRestriction> get() = _startingRestrictions.toList()

    private val _ownershipSets = mutableListOf<OwnershipSet>()
    val ownershipSets: List<OwnershipSet> get() = _ownershipSets.toList()
    // endregion

    // region Functions

    fun disallowStart(territory: Territory) {
        _disallowStartInRegions.add(territory)
    }

    fun disallowStart(territories: Collection<Territory>) {
        _disallowStartInRegions.addAll(territories)
    }

    fun defaultStart(territory: Territory) {
        _defaultStartSpots.add(territory)
    }

    fun defaultStart(territories: Collection<Territory>) {
        _defaultStartSpots.addAll(territories)
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

        // TODO: Disallow Start
        // TODO: Default Start

        addAll(playerDefeatConditions.flatMap(PlayerDefeatCondition::validate))
        addAll(teamDefeatConditions.flatMap(TeamDefeatCondition::validate))
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
        appendLine(2, "RegionCampaign = DefaultCampaign")
        appendLine()
        appendLine(2, "MinPlayers = $minPlayers")
        appendLine(2, "MaxPlayers = $maxPlayers")
        appendLine()

        val pdcs = playerDefeatConditions.joinToString("\n", transform = PlayerDefeatCondition::render)
        if (pdcs.isNotEmpty()) appendLine(pdcs)
        val tdcs = teamDefeatConditions.joinToString("\n", transform = TeamDefeatCondition::render)
        if (tdcs.isNotEmpty()) append(tdcs)

        appendLine(1, "End")
    }

    // region Child DSLs
    fun Scenario.playerDefeatCondition(block: PlayerDefeatCondition.() -> Unit) {
        _playerDefeatConditions.add(PlayerDefeatCondition().apply(block))
    }

    fun Scenario.teamDefeatCondition(block: TeamDefeatCondition.() -> Unit) {
        _teamDefeatConditions.add(TeamDefeatCondition().apply(block))
    }

    fun Scenario.startingRestriction(block: StartingRestriction.() -> Unit) {
        _startingRestrictions.add(StartingRestriction().apply(block))
    }

    fun Scenario.ownershipSet(block: OwnershipSet.() -> Unit) {
        _ownershipSets.add(OwnershipSet().apply(block))
    }
    // endregion
}