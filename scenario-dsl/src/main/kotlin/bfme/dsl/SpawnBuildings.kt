package bfme.dsl

import bfme.domain.Building
import bfme.domain.Territory

@WotrDsl
class SpawnBuildings : WotrElement {
    override val clazz: Class<out WotrElement> = SpawnBuildings::class.java

    var region: Territory? = null
    
    private val _buildings = mutableListOf<Building>()
    val buildings: List<Building> get() = _buildings.toList()

    fun buildings(buildings: List<Building>) {
        _buildings.addAll(buildings)
    }

    override fun validate(): List<Violation> = buildList {
        if (region == null) add(violation("'region' must not be empty"))
        if (buildings.isEmpty()) add(violation("'buildings' must not be empty"))
    }

    override fun render(): String {
        TODO("Not yet implemented")
    }
}