package bfme.dsl

@WotrDsl
class TeamDefeatCondition : WotrElement {
    override val clazz: Class<out WotrElement> = TeamDefeatCondition::class.java
    private val _teams = mutableListOf<Int>()
    val teams: List<Int> get() = _teams.toList()
    var numControlledRegionsLessOrEqualTo = -1

    /**
     * Add a team to the defeat condition.
     * Defeat conditions can apply to one or more teams.
     */
    fun team(team: Int) {
        _teams.add(team)
    }

    override fun validate(): List<Violation> = buildList {
        if (teams.isEmpty()) add(violation("'teams' must not be empty"))
    }

    override fun render(): String = buildString {
        appendLine(2, "TeamDefeatCondition")
        appendLine(3, "Teams = ${teams.joinToString(" ")}")
        appendLine(3, "NumControlledRegionsLessOrEqualTo = $numControlledRegionsLessOrEqualTo")
        appendLine(2, "End")
    }
}
