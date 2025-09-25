package bfme.domain

import bfme.domain.Faction.*

/**
 * Enumeration of the different armies we can spawn at the start of a scenario.
 * When adding a new army here, it must also be added to data/ini/common/livingworlddefaultarmies.inc
 *
 * When an Army is used in SpawnArmies in OwnershipSet, we use codeName.
 * When an Army is used in SpawnArmy in an Act, we use a faction specific name via forFaction().
 */
enum class Army(
    val codeName: String,
    private val menArmyName: String = codeName,
    private val elvesArmyName: String = codeName,
    private val dwarvesArmyName: String = codeName,
    private val mordorArmyName: String = codeName,
    private val isengardArmyName: String = codeName,
    private val goblinsArmyName: String = codeName,
    private val angmarArmyName: String = codeName
) {
    HERO_ARMY_1(
        "HeroArmy1",
        "AragornPlayerArmy",
        "ThranduilPlayerArmy",
        "GimliPlayerArmy",
        "WitchKingPlayerArmy",
        "SarumanPlayerArmy",
        "DrogothPlayerArmy",
        "RogashPlayerArmy"
    ),
    HERO_ARMY_2(
        "HeroArmy2",
        "TheodenPlayerArmy",
        "ElrondPlayerArmy",
        "DainPlayerArmy",
        "FellBeast1PlayerArmy",
        "LurtzPlayerArmy",
        "ShelobPlayerArmy",
        "MorgramirPlayerArmy"
    ),
    HERO_ARMY_3(
        "HeroArmy3",
        "BoromirPlayerArmy",
        "HaldirPlayerArmy",
        "GloinPlayerArmy",
        "MouthOfSauronArmy",
        "SharkuPlayerArmy",
        "GorkilPlayerArmy",
        "WitchKingArmy"
    ),
    HERO_ARMY_4(
        "HeroArmy4",
        "EomerPlayerArmy",
        "GlorfindelPlayerArmy",
        "CaptainofDalePlayerArmy",
        "GothmogPlayerArmy",
        "WormTongueArmy",
        "AzogPlayerArmy",
        "HwaldarPlayerArmy"
    ),
    HERO_ARMY_5(
        "HeroArmy5",
        "MoW_CreateAHeroArmy",
        "Elven_CreateAHeroArmy",
        "Dwarven_CreateAHeroArmy",
        "Mordor_CreateAHeroArmy",
        "Isengard_CreateAHeroArmy",
        "Wild_CreateAHeroArmy",
        "Angmar_CreateAHeroArmy"
    ),
    GARRISON_ARMY_1(
        "GarrisonArmy1",
        "MenOfTheWest_StartingArmy",
        "Elven_StartingArmy",
        "Dwarven_StartingArmy",
        "Mordor_StartingArmy",
        "Isengard_StartingArmy",
        "CorruptedWild_StartingArmy",
        "Angmar_StartingArmy"
    ),
    FORTRESS_DEFENSE_ARMY(
        "FortressDefenseArmy",
        "MenOfTheWest_FortressDefenseArmy",
        "Elven_FortressDefenseArmy",
        "Dwarven_FortressDefenseArmy",
        "Mordor_FortressDefenseArmy",
        "Isengard_FortressDefenseArmy",
        "CorruptedWild_FortressDefenseArmy",
        "Angmar_FortressDefenseArmy"
    ),
    FORTRESS_ATTACK_ARMY(
        "FortressAttackArmy",
        "MenOfTheWest_FortressAttackArmy",
        "Elven_FortressAttackArmy",
        "Dwarven_FortressAttackArmy",
        "Mordor_FortressAttackArmy",
        "Isengard_FortressAttackArmy",
        "CorruptedWild_FortressAttackArmy",
        "Angmar_FortressAttackArmy"
    ),
    EXTRA_HERO_ONE_ARMY(
        "ExtraHeroOneArmy",
        menArmyName = "GandalfArmy",
        elvesArmyName = "LegolasArmy"
    ),
    EXTRA_HERO_TWO_ARMY(
        "ExtraHeroTwoArmy",
        menArmyName = "FaramirArmy",
        elvesArmyName = "ArwenArmy"
    ),
    SPECIALTY_ONE_ARMY(
        "SpecialtyOneArmy",
        "MenOfTheWest_SpecialtyOneArmy",
        "Elven_SpecialtyOneArmy",
        "Dwarven_SpecialtyOneArmy",
        "Mordor_SpecialtyOneArmy",
        "Isengard_SpecialtyOneArmy",
        "Wild_SpecialtyOneArmy",
        "Angmar_SpecialtyOneArmy"
    ),
    SPECIALTY_TWO_ARMY(
        "SpecialtyTwoArmy",
        "MenOfTheWest_SpecialtyTwoArmy",
        "Elven_SpecialtyTwoArmy",
        "Dwarven_SpecialtyTwoArmy",
        "Mordor_SpecialtyTwoArmy",
        "Isengard_SpecialtyTwoArmy",
        "Wild_SpecialtyTwoArmy",
        "Angmar_SpecialtyTwoArmy"
    ),
    SPECIALTY_THREE_ARMY(
        "SpecialtyThreeArmy",
        "MenOfTheWest_SpecialtyThreeArmy",
        "Elven_SpecialtyThreeArmy",
        "Dwarven_SpecialtyThreeArmy",
        "Mordor_SpecialtyThreeArmy",
        "Isengard_SpecialtyThreeArmy",
        "Wild_SpecialtyThreeArmy",
        "Angmar_SpecialtyThreeArmy"
    ),
    ELITE_ARMY(
        "EliteArmy",
        "MenOfTheWest_EliteArmy",
        "Elven_EliteArmy",
        "Dwarven_EliteArmy",
        "Mordor_EliteArmy",
        "Isengard_EliteArmy",
        "Wild_EliteArmy",
        "Angmar_EliteArmy"
    );

    /**
     * Get the correct codename for an army based on the faction it spawns for.
     */
    fun forFaction(faction: Faction): String = when (faction) {
        MEN -> menArmyName
        ELVES -> elvesArmyName
        DWARVES -> dwarvesArmyName
        MORDOR -> mordorArmyName
        ISENGARD -> isengardArmyName
        GOBLINS -> goblinsArmyName
        ANGMAR -> angmarArmyName
    }

}
