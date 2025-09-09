package bfme.dsl

/**
 * DSL element for an Act, where we can spawn units after a number of turns.
 */
@WotrDsl
class Act : WotrElement {
    override val clazz: Class<out WotrElement> = Act::class.java
    var number: String = ""

    private val _armyEntries = mutableListOf<ArmyEntry>()
    val armyEntries: List<ArmyEntry> get() = _armyEntries.toList()

    override fun validate(): List<Violation> = buildList {
        if (number.isEmpty()) add(violation("'number' must not be empty"))
        addAll(armyEntries.flatMap(ArmyEntry::validate))
    }

    override fun render(): String = buildString {
        appendLine(1, "Act $number")
        append(armyEntries.joinToString("\n", transform = ArmyEntry::render))
        appendLine(1, "End")
    }

    /**
     * Add an army entry to an act.
     */
    fun Act.armyEntry(block: ArmyEntry.() -> Unit) {
        _armyEntries.add(ArmyEntry().apply(block))
    }
}

