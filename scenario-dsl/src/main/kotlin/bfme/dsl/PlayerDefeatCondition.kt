package bfme.dsl

@WotrDsl
class PlayerDefeatCondition : WotrElement {
    override val clazz: Class<out WotrElement> = PlayerDefeatCondition::class.java
    private val _teams = mutableListOf<Int>()
    val teams: List<Int> get() = _teams.toList()
    var loseIfCapitalLost: Boolean = false
    var numControlledRegionsLessOrEqualTo = -1

    fun teams(teams: List<Int>) {
        _teams.addAll(teams)
    }

    override fun validate(): List<Violation> = buildList {
        if (teams.isEmpty()) add(violation("'teams' must not be empty"))
    }

    override fun render(): String = "TODO: PDC"
}