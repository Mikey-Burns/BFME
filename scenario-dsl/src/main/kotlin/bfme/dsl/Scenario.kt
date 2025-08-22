package bfme.dsl

import bfme.domain.Territory

@WotrDsl
class Scenario : WotrElement {
    override val clazz: Class<out WotrElement> = Scenario::class.java

    // Fields
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

    private val _playerDefeatConditions = mutableListOf<PlayerDefeatCondition>()
    val playerDefeatConditions: List<PlayerDefeatCondition> get() = _playerDefeatConditions.toList()

    private val _teamDefeatConditions = mutableListOf<TeamDefeatCondition>()
    val teamDefeatConditions: List<TeamDefeatCondition> get() = _teamDefeatConditions.toList()

    // TODO: Starting Restrictions
    // TODO: Ownership Sets

    // Functions

    fun disallowStart(territory: Territory) {
        _disallowStartInRegions.add(territory)
    }

    fun disallowStart(territories: Collection<Territory>) {
        _disallowStartInRegions.addAll(territories)
    }

    fun Scenario.playerDefeatCondition(block: PlayerDefeatCondition.() -> Unit) {
        _playerDefeatConditions.add(PlayerDefeatCondition().apply(block))
    }

    fun Scenario.teamDefeatCondition(block: TeamDefeatCondition.() -> Unit) {
        _teamDefeatConditions.add(TeamDefeatCondition().apply(block))
    }

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
    }

    override fun render(): String = buildString {
        appendLine("TODO: Scenario")
        appendLine(playerDefeatConditions.joinToString("\n") { pdc -> pdc.render() })
        appendLine(teamDefeatConditions.joinToString("\n") { tdc -> tdc.render() })
    }
}


fun Scenario.teamDefeatCondition(block: TeamDefeatCondition.() -> Unit): TeamDefeatCondition =
    TeamDefeatCondition().apply(block)