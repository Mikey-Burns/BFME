package bfme.dsl

import bfme.domain.Faction
import bfme.domain.Territory

@WotrDsl
class StartingRestriction : WotrElement {
    override val clazz: Class<out WotrElement> = StartingRestriction::class.java

    private val _factions = mutableListOf<Faction>()
    val factions: List<Faction> get() = _factions.toList()

    private val _regions = mutableListOf<Territory>()
    val regions: List<Territory> get() = _regions.toList()

    val teams: Int = -1
    override fun validate(): List<Violation> {
        TODO("Not yet implemented")
    }

    override fun render(): String {
        TODO("Not yet implemented")
    }
}