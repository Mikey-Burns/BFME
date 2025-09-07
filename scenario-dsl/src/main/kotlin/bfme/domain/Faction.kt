package bfme.domain

/**
 * Enumeration of the factions available to use in a scenario.
 */
enum class Faction(val codeName: String, val spawnForTemplate: String, val armyPrefix: String, val armyIcon: String) {
    MEN("FactionMen", "PlayerMen", "MenOfTheWest", "MoWArmyIcon"),
    ELVES("FactionElves", "PlayerElves", "Elven", "ElfArmyIcon"),
    DWARVES("FactionDwarves", "PlayerDwarves", "Dwarven", "DwarfArmyIcon"),
    MORDOR("FactionMordor", "PlayerMordor", "Mordor", "MordorArmyIcon"),
    ISENGARD("FactionIsengard", "PlayerIsengard", "Isengard", "IsengardArmyIcon"),
    GOBLINS("FactionWild", "PlayerWild", "CorruptedWild", "WildArmyIcon"),
    ANGMAR("FactionAngmar", "PlayerAngmar", "Angmar", "AngmarArmyIcon")
}
