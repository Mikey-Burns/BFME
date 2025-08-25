package bfme.dsl

import bfme.domain.Army
import bfme.domain.Territory

@WotrDsl
class SpawnArmies : WotrElement {
    override val clazz: Class<out WotrElement> = SpawnArmies::class.java

    var region: Territory? = null

    private val _armies = mutableListOf<Army>()
    val armies: List<Army> get() = _armies.toList()

    fun armies(armies: List<Army>) {
        _armies.addAll(armies)
    }

    override fun validate(): List<Violation> = buildList {
        if (region == null) add(violation("'region' must not be empty"))
        if (armies.isEmpty()) add(violation("'armies' must not be empty"))
    }

    override fun render(): String {
        TODO("Not yet implemented")
    }
}