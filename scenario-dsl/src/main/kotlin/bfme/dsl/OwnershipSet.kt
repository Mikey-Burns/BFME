package bfme.dsl

import bfme.domain.Territory

/**
 * DSL representation of the territories and armies that a player begins a scenario with.
 */
@WotrDsl
class OwnershipSet : WotrElement {
    override val clazz: Class<out WotrElement> = OwnershipSet::class.java

    // region Fields
    var label: String? = null
    var startRegion: Territory? = null

    private val _regions = mutableListOf<Territory>()
    val regions: List<Territory> get() = _regions.toList()

    private val _spawnArmies = mutableListOf<SpawnArmies>()
    val spawnArmies: List<SpawnArmies> get() = _spawnArmies.toList()

    private val _spawnBuildings = mutableListOf<SpawnBuildings>()
    val spawnBuildings: List<SpawnBuildings> get() = _spawnBuildings.toList()
    // endregion

    /**
     * Add a territory to the player's starting setup.
     * A player can have multiple territories.
     */
    fun region(region: Territory) {
        _regions.add(region)
    }

    override fun validate(): List<Violation> = buildList {
        if (startRegion == null) add(violation("'startRegion' must not be empty"))
        if (regions.isEmpty()) add(violation("'regions' must not be empty"))

        addAll(spawnArmies.flatMap(SpawnArmies::validate))
        addAll(spawnBuildings.flatMap(SpawnBuildings::validate))
    }

    override fun render(): String = buildString {
        if (label != null) appendLine(2, "; ${label!!}")
        appendLine(2, "OwnershipSet")
        if (regions.isNotEmpty())
            appendLine(3, "Regions = ${regions.joinToString(" ", transform = Territory::codeName)}")
        if (startRegion != null) appendLine(3, "StartRegion = ${startRegion!!.codeName}")
        appendLine()

        val armies = spawnArmies.joinToString("\n", transform = SpawnArmies::render)
        if (armies.isNotEmpty()) append(armies)

        if (spawnArmies.isNotEmpty() && spawnBuildings.isNotEmpty()) appendLine()

        val buildings = spawnBuildings.joinToString("\n", transform = SpawnBuildings::render)
        if (buildings.isNotEmpty()) append(buildings)

        appendLine(2, "End")
    }

    // region Child DSLs
    /**
     * Add an army spawn to the player's starting setup.
     * A player can spawn multiple armies.
     */
    fun OwnershipSet.spawnArmies(block: SpawnArmies.() -> Unit) {
        _spawnArmies.add(SpawnArmies().apply(block))
    }

    /**
     * Add a building spawn to the player's starting setup.
     * A player can spawn multiple buildings.
     */
    fun OwnershipSet.spawnBuildings(block: SpawnBuildings.() -> Unit) {
        _spawnBuildings.add(SpawnBuildings().apply(block))
    }
    // endregion
}
