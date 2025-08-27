package bfme.domain

/**
 * Enumeration of the different armies we can spawn at the start of a scenario.
 * When adding a new army here, it must also be added to data/ini/common/livingworlddefaultarmies.inc
 */
enum class Army(val codeName: String) {
    HERO_ARMY_1("HeroArmy1"),
    HERO_ARMY_2("HeroArmy2"),
    HERO_ARMY_3("HeroArmy3"),
    HERO_ARMY_4("HeroArmy4"),
    HERO_ARMY_5("HeroArmy5"),
    GARRISON_ARMY_1("GarrisonArmy1"),
    FORTRESS_DEFENSE_ARMY("FortressDefenseArmy"),
    FORTRESS_ATTACK_ARMY("FortressAttackArmy"),

}
