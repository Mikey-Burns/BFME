package bfme.dsl

@WotrDsl
class TeamDefeatCondition : WotrElement {
    override val clazz: Class<out WotrElement> = TeamDefeatCondition::class.java
    private val _teams = mutableListOf<Int>()
    val teams: List<Int> get() = _teams.toList()
    var numControlledRegionsLessOrEqualTo = -1

    fun teams(teams: List<Int>) {
        _teams.addAll(teams)
    }

    override fun validate(): List<Violation> = buildList {
        if (teams.isEmpty()) add(violation("'teams' must not be empty"))
    }

    override fun render(): String = "TODO: TDC"
}
