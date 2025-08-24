package bfme.dsl

import bfme.domain.Building
import bfme.domain.Territory

@WotrDsl
class SpawnBuildings : WotrElement {
    override val clazz: Class<out WotrElement> = SpawnBuildings::class.java

    private val _buildings = mutableListOf<Building>()
    val buildings: List<Building> get() = _buildings.toList()

    var region: Territory? = null

    override fun validate(): List<Violation> {
        TODO("Not yet implemented")
    }

    override fun render(): String {
        TODO("Not yet implemented")
    }
}