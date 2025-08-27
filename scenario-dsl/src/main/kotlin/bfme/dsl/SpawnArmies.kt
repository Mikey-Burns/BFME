package bfme.dsl

import bfme.domain.Army
import bfme.domain.Territory

/**
 * DSL element for spawning armies to a territory.
 */
@WotrDsl
class SpawnArmies : WotrElement {
    override val clazz: Class<out WotrElement> = SpawnArmies::class.java

    var region: Territory? = null

    private val _armies = mutableListOf<Army>()
    val armies: List<Army> get() = _armies.toList()

    /**
     * Specify an army to spawn into the territory.
     * Multiple armies can be specified.
     */
    fun army(army: Army) {
        _armies.add(army)
    }

    override fun validate(): List<Violation> = buildList {
        if (region == null) add(violation("'region' must not be empty"))
        if (armies.isEmpty()) add(violation("'armies' must not be empty"))
    }

    override fun render(): String = buildString {
        appendLine(3, "SpawnArmies")
        appendLine(4, "Armies = ${armies.joinToString(" ", transform = Army::codeName)}")
        appendLine(4, "Region = ${region!!.codeName}")
        appendLine(3, "End")
    }
}
