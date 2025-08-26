package bfme.dsl

import bfme.domain.Building
import bfme.domain.Territory

@WotrDsl
class SpawnBuildings : WotrElement {
    override val clazz: Class<out WotrElement> = SpawnBuildings::class.java

    var region: Territory? = null

    private val _buildings = mutableListOf<Building>()
    val buildings: List<Building> get() = _buildings.toList()

    fun building(building: Building) {
        _buildings.add(building)
    }

    override fun validate(): List<Violation> = buildList {
        if (region == null) add(violation("'region' must not be empty"))
        if (buildings.isEmpty()) add(violation("'buildings' must not be empty"))
    }

    override fun render(): String = buildString {
        appendLine(3, "SpawnBuildings")
        appendLine(4, "Buildings = ${buildings.joinToString(" ", transform = Building::codeName)}")
        appendLine(4, "Region = ${region!!.codeName}")
        appendLine(3, "End")
    }
}