package bfme.domain

/**
 * Enumeration of the factions available to use in a scenario.
 */
enum class Faction(val codeName: String) {
    MEN("FactionMen"),
    ELVES("FactionElves"),
    DWARVES("FactionDwarves"),
    MORDOR("FactionMordor"),
    ISENGARD("FactionIsengard"),
    GOBLINS("FactionWild"),
    ANGMAR("FactionAngmar")
}
