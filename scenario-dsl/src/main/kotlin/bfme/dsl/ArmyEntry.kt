package bfme.dsl

import bfme.domain.Army
import bfme.domain.Faction

/**
 * DSL element for an ArmyEntry to be spawned on a turn
 */
@WotrDsl
class ArmyEntry : WotrElement {
    override val clazz: Class<out WotrElement> = ArmyEntry::class.java

    var name: String = ""
    var faction: Faction? = null
    var army: Army? = null

    override fun validate(): List<Violation> = buildList {
        if (name.isEmpty()) add(violation("'name' must not be empty"))
        if (faction == null) add(violation("'faction' must not be empty"))
        if (army == null) add(violation("'army' must not be empty"))
    }

    override fun render(): String = buildString {
        appendLine(2, "SpawnArmy")
        appendLine(3, "ScriptingName = $name")
        appendLine(3, "SpawnForTemplates = ${faction?.spawnForTemplate}")
        appendLine(3, "PlayerArmy = ${faction?.armyPrefix}_${army?.codeName}")
        appendLine(3, "Icon = ${faction?.armyIcon}")
        appendLine(3, "SpawnAtActStart = Yes")
        appendLine(2, "End")
    }
}