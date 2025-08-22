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

    override fun validate(): List<Violation> {
        TODO("Not yet implemented")
    }

    override fun render(): String = buildString {
        appendLine("TODO: Scenario")
        appendLine(playerDefeatConditions.joinToString("\n") { pdc -> pdc.render() })
        appendLine(teamDefeatConditions.joinToString("\n") { tdc -> tdc.render() })
    }


}


fun Scenario.teamDefeatCondition(block: TeamDefeatCondition.() -> Unit): TeamDefeatCondition =
    TeamDefeatCondition().apply(block)