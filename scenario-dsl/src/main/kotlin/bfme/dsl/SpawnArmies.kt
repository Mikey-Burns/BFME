package bfme.dsl

import bfme.domain.Army
import bfme.domain.Territory

@WotrDsl
class SpawnArmies : WotrElement {
    override val clazz: Class<out WotrElement> = SpawnArmies::class.java

    private val _armies = mutableListOf<Army>()
    val armies: List<Army> get() = _armies.toList()

    var region: Territory? = null

    override fun validate(): List<Violation> {
        TODO("Not yet implemented")
    }

    override fun render(): String {
        TODO("Not yet implemented")
    }
}