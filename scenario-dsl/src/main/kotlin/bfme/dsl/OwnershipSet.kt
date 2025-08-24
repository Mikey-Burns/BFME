package bfme.dsl

import bfme.domain.Territory

@WotrDsl
class OwnershipSet : WotrElement {
    override val clazz: Class<out WotrElement> = OwnershipSet::class.java

    // region Fields
    var startRegion: Territory? = null

    private val _regions = mutableListOf<Territory>()
    val regions: List<Territory> get() = _regions.toList()

    private val _spawnArmies = mutableListOf<SpawnArmies>()
    val spawnArmies: List<SpawnArmies> get() = _spawnArmies.toList()

    private val _spawnBuildings = mutableListOf<SpawnBuildings>()
    val spawnBuildings: List<SpawnBuildings> get() = _spawnBuildings.toList()
    // endregion

    // region Functions
    fun regions(regions: List<Territory>) {
        _regions.addAll(regions)
    }
    // endregion

    override fun validate(): List<Violation> {
        TODO("Not yet implemented")
    }

    override fun render(): String {
        TODO("Not yet implemented")
    }

    // region Child DSLs
    fun OwnershipSet.spawnArmies(block: SpawnArmies.() -> Unit) {
        _spawnArmies.add(SpawnArmies().apply(block))
    }

    fun OwnershipSet.spawnBuildings(block: SpawnBuildings.() -> Unit) {
        _spawnBuildings.add(SpawnBuildings().apply(block))
    }
    // endregion
}
