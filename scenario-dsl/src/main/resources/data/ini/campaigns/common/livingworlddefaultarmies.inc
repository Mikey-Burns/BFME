//-------------------------------------------------------------------------------------------------
//    Default army composition for each faction
//-------------------------------------------------------------------------------------------------


//-------------------------------------------------------------------------------------------------
// Men of the West
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No                // Default is "Yes". If set to "No", then this army will only be spawned if directed to do so elsewhere (such as when an Ownership spawns an army).
    SpawnForTemplates = PlayerMen            // Required for armies, not allowed for cities.
    HeroTemplateName = GondorAragornMP
    PlayerArmy = AragornPlayerArmy
    Icon = HeroAragornIcon
    ; MoveSpeed = 15.0    ;;; Each army can have a custom move speed (the default is in LivingWorld.ini)
    Banner = BannerMen
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    HeroTemplateName = RohanTheoden
    PlayerArmy = TheodenPlayerArmy
    Icon = HeroTheodenIcon
    Banner = BannerMen
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    HeroTemplateName = GondorBoromir
    PlayerArmy = BoromirPlayerArmy
    Icon = HeroBoromirIcon
    Banner = BannerMen
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    HeroTemplateName = RohanEomer
    PlayerArmy = EomerPlayerArmy
    Icon = HeroEomerIcon
    Banner = BannerMen
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    HeroTemplateName = CreateAHero
    PlayerArmy = MoW_CreateAHeroArmy
    Icon = Mow_HeroCreateAHeroIcon
    Banner = BannerMen
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_StartingArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_FortressDefenseArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_FortressAttackArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_SpecialtyOneArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_SpecialtyTwoArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_SpecialtyThreeArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = MenOfTheWest_EliteArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = ExtraHeroOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = GandalfArmy
    Icon = MoWArmyIcon
End

SpawnArmy
    ScriptingName = ExtraHeroTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMen
    PlayerArmy = FaramirArmy
    Icon = MoWArmyIcon
End

//-------------------------------------------------------------------------------------------------
// Elves
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    HeroTemplateName = ElvenThranduil
    PlayerArmy = ThranduilPlayerArmy
    Icon = HeroThranduilIcon
    Banner = BannerElves
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    HeroTemplateName = ElvenElrond
    PlayerArmy = ElrondPlayerArmy
    Icon = HeroElrondIcon
    Banner = BannerElves
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    HeroTemplateName = ElvenHaldir
    PlayerArmy = HaldirPlayerArmy
    Icon = HeroHaldirIcon
    Banner = BannerElves
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    HeroTemplateName = ElvenGlorfindel
    PlayerArmy = GlorfindelPlayerArmy
    Icon = HeroGlorfindelIcon
    Banner = BannerElves
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    HeroTemplateName = CreateAHero
    PlayerArmy = Elven_CreateAHeroArmy
    Icon = Elven_HeroCreateAHeroIcon
    Banner = BannerElves
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_StartingArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_FortressDefenseArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_FortressAttackArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_SpecialtyOneArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_SpecialtyTwoArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_SpecialtyThreeArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = Elven_EliteArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = ExtraHeroOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = LegolasArmy
    Icon = ElfArmyIcon
End

SpawnArmy
    ScriptingName = ExtraHeroTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerElves
    PlayerArmy = ArwenArmy
    Icon = ElfArmyIcon
End


//-------------------------------------------------------------------------------------------------
// Dwarves
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    HeroTemplateName = DwarvenGimli
    PlayerArmy = GimliPlayerArmy
    Icon = HeroGimliIcon
    Banner = BannerDwarves
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    HeroTemplateName = DwarvenDain
    PlayerArmy = DainPlayerArmy
    Icon = HeroDainIcon
    Banner = BannerDwarves
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    HeroTemplateName = DwarvenGloin
    PlayerArmy = GloinPlayerArmy
    Icon = HeroGloinIcon
    Banner = BannerDwarves
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    HeroTemplateName = DwarvenCaptainofDale
    PlayerArmy = CaptainofDalePlayerArmy
    Icon = HeroCaptainofDaleIcon
    Banner = BannerDwarves
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    HeroTemplateName = CreateAHero
    PlayerArmy = Dwarven_CreateAHeroArmy
    Icon = Dwarven_HeroCreateAHeroIcon
    Banner = BannerDwarves
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_StartingArmy
    Icon = DwarfArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_FortressDefenseArmy
    Icon = DwarfArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_FortressAttackArmy
    Icon = DwarfArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_SpecialtyOneArmy
    Icon = DwarfArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_SpecialtyTwoArmy
    Icon = DwarfArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_SpecialtyThreeArmy
    Icon = DwarfArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerDwarves
    PlayerArmy = Dwarven_EliteArmy
    Icon = DwarfArmyIcon
End


//-------------------------------------------------------------------------------------------------
// Mordor
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    HeroTemplateName = MordorWitchKingOnFellBeast
    PlayerArmy = WitchKingPlayerArmy
    Icon = HeroWitchKingIcon
    Banner = BannerMordor
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    HeroTemplateName = KhamulFellBeast
    PlayerArmy = FellBeast1PlayerArmy
    Icon = HeroFellBeast1Icon
    Banner = BannerMordor
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    HeroTemplateName = MordorMouthOfSauron
    PlayerArmy = MouthOfSauronArmy
    Icon = HeroMouthOfSauronIcon
    Banner = BannerMordor
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    HeroTemplateName = MordorGothmog
    PlayerArmy = GothmogPlayerArmy
    Icon = HeroGothmogIcon
    Banner = BannerMordor
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    HeroTemplateName = CreateAHero
    PlayerArmy = Mordor_CreateAHeroArmy
    Icon = Mordor_HeroCreateAHeroIcon
    Banner = BannerMorder
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_StartingArmy
    Icon = MordorArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_FortressDefenseArmy
    Icon = MordorArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_FortressAttackArmy
    Icon = MordorArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_SpecialtyOneArmy
    Icon = MordorArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_SpecialtyTwoArmy
    Icon = MordorArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_SpecialtyThreeArmy
    Icon = MordorArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerMordor
    PlayerArmy = Mordor_EliteArmy
    Icon = MordorArmyIcon
End


//-------------------------------------------------------------------------------------------------
// Isengard
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    HeroTemplateName = IsengardSaruman
    PlayerArmy = SarumanPlayerArmy
    Icon = HeroSarumanIcon
    Banner = BannerIsengard
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    HeroTemplateName = IsengardLurtz
    PlayerArmy = LurtzPlayerArmy
    Icon = HeroLurtzIcon
    Banner = BannerIsengard
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    HeroTemplateName = IsengardSharku
    PlayerArmy = SharkuPlayerArmy
    Icon = HeroSharkuIcon
    Banner = BannerIsengard
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    HeroTemplateName = IsengardWormTongue
    PlayerArmy = WormTongueArmy
    Icon = HeroWormTongueIcon
    Banner = BannerIsengard
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    HeroTemplateName = CreateAHero
    PlayerArmy = Isengard_CreateAHeroArmy
    Icon = Isengard_HeroCreateAHeroIcon
    Banner = BannerIsengard
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_StartingArmy
    Icon = IsengardArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_FortressDefenseArmy
    Icon = IsengardArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_FortressAttackArmy
    Icon = IsengardArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_SpecialtyOneArmy
    Icon = IsengardArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_SpecialtyTwoArmy
    Icon = IsengardArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_SpecialtyThreeArmy
    Icon = IsengardArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerIsengard
    PlayerArmy = Isengard_EliteArmy
    Icon = IsengardArmyIcon
End


//-------------------------------------------------------------------------------------------------
// Wild
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    HeroTemplateName = Drogoth
    PlayerArmy = DrogothPlayerArmy
    Icon = HeroDrogothIcon
    Banner = BannerWild
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    HeroTemplateName = WildShelob
    PlayerArmy = ShelobPlayerArmy
    Icon = HeroShelobIcon
    Banner = BannerWild
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    HeroTemplateName = WildGoblinKing
    PlayerArmy = GorkilPlayerArmy
    Icon = HeroGorkilIcon
    Banner = BannerWild
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    HeroTemplateName = WildAzog
    PlayerArmy = AzogPlayerArmy
    Icon = HeroAzogIcon
    Banner = BannerWild
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    HeroTemplateName = CreateAHero
    PlayerArmy = Wild_CreateAHeroArmy
    Icon = Wild_HeroCreateAHeroIcon
    Banner = BannerWild
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = CorruptedWild_StartingArmy
    Icon = WildArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = CorruptedWild_FortressDefenseArmy
    Icon = WildArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = CorruptedWild_FortressAttackArmy
    Icon = WildArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = Wild_SpecialtyOneArmy
    Icon = WildArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = Wild_SpecialtyTwoArmy
    Icon = WildArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = Wild_SpecialtyThreeArmy
    Icon = WildArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerWild
    PlayerArmy = Wild_EliteArmy
    Icon = WildArmyIcon
End

//-------------------------------------------------------------------------------------------------
// Angmar
//-------------------------------------------------------------------------------------------------

SpawnArmy
    ScriptingName = HeroArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    HeroTemplateName = AngmarRogash
    PlayerArmy = RogashPlayerArmy
    Icon = HeroRogashIcon
    Banner = BannerAngmar
End

SpawnArmy
    ScriptingName = HeroArmy2
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    HeroTemplateName = AngmarMorgramir
    PlayerArmy = MorgramirPlayerArmy
    Icon = HeroMorgramirIcon
    Banner = BannerAngmar
End

SpawnArmy
    ScriptingName = HeroArmy3
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    HeroTemplateName = AngmarWitchking
    PlayerArmy = WitchKingArmy
    Icon = HeroAngmarWitchkingIcon
    Banner = BannerAngmar
End

SpawnArmy
    ScriptingName = HeroArmy4
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    HeroTemplateName = AngmarHwaldar
    PlayerArmy = HwaldarPlayerArmy
    Icon = HeroHwaldarIcon
    Banner = BannerAngmar
End

SpawnArmy
    ScriptingName = HeroArmy5
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    HeroTemplateName = CreateAHero
    PlayerArmy = Angmar_CreateAHeroArmy
    Icon = Angmar_HeroCreateAHeroIcon
    Banner = BannerAngmar
End

SpawnArmy
    ScriptingName = GarrisonArmy1
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_StartingArmy
    Icon = AngmarArmyIcon
End

SpawnArmy
    ScriptingName = FortressDefenseArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_FortressDefenseArmy
    Icon = AngmarArmyIcon
End

SpawnArmy
    ScriptingName = FortressAttackArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_FortressAttackArmy
    Icon = AngmarArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyOneArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_SpecialtyOneArmy
    Icon = AngmarArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyTwoArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_SpecialtyTwoArmy
    Icon = AngmarArmyIcon
End

SpawnArmy
    ScriptingName = SpecialtyThreeArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_SpecialtyThreeArmy
    Icon = AngmarArmyIcon
End

SpawnArmy
    ScriptingName = EliteArmy
    SpawnAtActStart = No
    SpawnForTemplates = PlayerAngmar
    PlayerArmy = Angmar_EliteArmy
    Icon = AngmarArmyIcon
End

