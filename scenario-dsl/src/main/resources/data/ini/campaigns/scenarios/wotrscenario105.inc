//-------------------------------------------------------------------------------------------------
// Scenario Name: Erebor Madness
// Scenario Description: This is a 6 player game with preset starting locations where the humans control Erebor and Dol Guldur.  The AI control the surrounding territories.
// The AI spawns increasingly large armies every turn in their home bases for 10 turns, even if the territory has been captured.
// To win, the humans must control at least one fortress for 10 turns.  If both fortress fall, they lose.
//-------------------------------------------------------------------------------------------------

LivingWorldCampaign WOTRScenario105

    IsEvilCampaign = No

    ;////////////// RTS Settings /////////////
    #include "..\Common\LivingWorldDefaultRTSSettings.inc"

    Scenario
        DisplayName = LWScenario:WOTRScenario105
        DisplayDescription = LWScenario:WOTRScenario105Description
        DisplayGameType = LWScenario:WOTRGameType003
        DisplayObjectives = LWScenario:WOTRObjectives005
        DisplayFiction = LWScenario:WOTRScenarioFiction003
        DisplayVictoriousText = LWScenario:WOTRScenarioWin101
        DisplayDefeatedText = LWScenario:WOTRScenarioLose101

        RegionCampaign = FortressRegion

        UseMpRulesVictoryCondition = No
        MinPlayers = 6
        MaxPlayers = 6

        DisableRegions = Amon_Sul Anfalas Angmar Arnor Barrow_Downs Belfalas Buckland Cair_Andros Cardolan CarnDum Carrock Dunland Enedwaith Ettenmoors Fangorn Forlindon Fornost Forodwaith Gap_Of_Rohan Grey_Havens Harad Harlindon Helms_Deep High_Pass Isengard Ithilien Lostriand Lothlorien Minas_Morgul Minas_Tirith Minhiriath Mordor MountGundabad Mount_Doom Osgiliath Redhorn_Pass Rhudaur Rhun Rivendell Rohan The_Black_Gate The_Brown_Lands The_Dead_Marshes The_Shire Tower_Hills Umbar
        DefaultStartSpots = Dol_Guldur Erebor Celduin Mirkwood Iron_Hills Dagorlad

        PlayerDefeatCondition
            Teams = 1 2
            LoseIfCapitalLost = No
            NumControlledRegionsLessOrEqualTo = -1
        End

        TeamDefeatCondition
            Teams = 1 2
            NumControlledRegionsLessOrEqualTo = -1
        End

        TeamVictoryCondition
            Teams = 1
            ControlledRegions = Dol_Guldur Erebor
            ControlledRegionsHeldForTurns = 10
        End

        TeamVictoryCondition
            Teams = 2
            ControlledRegions = Dol_Guldur Erebor
            ControlledRegionsHeldForTurns = 1
        End

        StartingRestriction
            Factions = FactionElves
            Regions = Dol_Guldur
            Teams = 1
        End

        StartingRestriction
            Factions = FactionMen
            Regions = Erebor
            Teams = 1
        End

        StartingRestriction
            Factions = FactionMordor
            Regions = Celduin
            Teams = 2
        End

        StartingRestriction
            Factions = FactionDwarves
            Regions = Mirkwood
            Teams = 2
        End

        StartingRestriction
            Factions = FactionIsengard
            Regions = Iron_Hills
            Teams = 2
        End

        StartingRestriction
            Factions = FactionAngmar
            Regions = Dagorlad
            Teams = 2
        End

        ; Player One
        OwnershipSet
            Regions = Dol_Guldur
            StartRegion = Dol_Guldur

            SpawnArmies
                Armies = ExtraHeroOneArmy FortressAttackArmy FortressDefenseArmy
                Region = Dol_Guldur
            End

            SpawnArmies
                Armies = ExtraHeroTwoArmy FortressAttackArmy FortressDefenseArmy
                Region = Erebor
            End

            SpawnBuildings
                Buildings = LW_ARMORY
                Region = Dol_Guldur
            End
        End

        ; Player Two
        OwnershipSet
            Regions = Erebor
            StartRegion = Erebor

            SpawnArmies
                Armies = ExtraHeroOneArmy FortressAttackArmy
                Region = Erebor
            End

            SpawnArmies
                Armies = ExtraHeroTwoArmy FortressAttackArmy
                Region = Dol_Guldur
            End

            SpawnBuildings
                Buildings = LW_ARMORY
                Region = Erebor
            End
        End

        ; Computer 1
        OwnershipSet
            Regions = Celduin
            StartRegion = Celduin

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Celduin
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Mirkwood
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy4
                Region = Dagorlad
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Celduin
            End
        End

        ; Computer 2
        OwnershipSet
            Regions = Mirkwood
            StartRegion = Mirkwood

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Mirkwood
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = Dagorlad
            End

            SpawnArmies
                Armies = HeroArmy4
                Region = Celduin
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Mirkwood
            End
        End

        ; Computer 3
        OwnershipSet
            Regions = Iron_Hills
            StartRegion = Iron_Hills

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Dagorlad
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = Celduin
            End

            SpawnArmies
                Armies = HeroArmy4
                Region = Mirkwood
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Iron_Hills
            End
        End

        ; Computer 4
        OwnershipSet
            Regions = Dagorlad
            StartRegion = Dagorlad

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Dagorlad
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Celduin
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = Mirkwood
            End

            SpawnArmies
                Armies = HeroArmy4
                Region = Iron_Hills
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Dagorlad
            End
        End
    End

    ;//////////////////////////////////////////////////
    Act One
    ;//////////////////////////////////////////////////

        ;///////////////// Armies ////////////////
        #include "..\Common\LivingWorldDefaultArmies.inc"

        ;//////////////// VISUAL FLUFF ////////////////
        EyeTowerPoints
            LookPoint = X:436 Y:687 ; Rohan
            LookPoint = X:481 Y:287
            LookPoint = X:1179 Y:461
            LookPoint = X:947 Y:917
            LookPoint = X:172 Y:573 ; Isengard
            LookPoint = X:160 Y:560 ; Isengard
            LookPoint = X:175 Y:557 ; Isengard
            LookPoint = X:171 Y:348 ; Helm's Deep
            LookPoint = X:257 Y:535 ; Helm's Deep
            LookPoint = X:120 Y:350 ; Helm's Deep
            LookPoint = X:157 Y:420 ; Helm's Deep
        End
    End

    Act Two
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_CreateAHeroArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_CreateAHeroArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_CreateAHeroArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_CreateAHeroArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Three
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Four
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressDefenseArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressDefenseArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressDefenseArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressDefenseArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Five
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressDefenseArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressDefenseArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressDefenseArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressDefenseArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Six
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyOneArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyOneArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyOneArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyOneArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyOneArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyOneArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyOneArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyOneArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyOneArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyOneArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyOneArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyOneArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Seven
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyTwoArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyTwoArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyTwoArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_StartingArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyTwoArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyTwoArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyTwoArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_StartingArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyTwoArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyTwoArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyTwoArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_StartingArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyTwoArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyTwoArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyTwoArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_StartingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Eight
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_EliteArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_EliteArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_EliteArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_EliteArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Nine
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_EliteArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyThreeArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyThreeArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyThreeArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = WitchKingPlayerArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = FellBeast1PlayerArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = MouthOfSauronArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = GothmogPlayerArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_CreateAHeroArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_EliteArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyThreeArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyThreeArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyThreeArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = GimliPlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = DainPlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = GloinPlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = CaptainofDalePlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_CreateAHeroArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_EliteArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyThreeArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyThreeArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyThreeArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = SarumanPlayerArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = LurtzPlayerArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = SharkuPlayerArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = WormTongueArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_CreateAHeroArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_EliteArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyThreeArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyThreeArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyThreeArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = RogashPlayerArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = MorgramirPlayerArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = WitchKingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = HwaldarPlayerArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_CreateAHeroArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End

    Act Ten
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_FortressAttackArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_EliteArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyThreeArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyThreeArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyThreeArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyOneArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyOneArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyOneArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyTwoArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyTwoArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_SpecialtyTwoArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = WitchKingPlayerArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = FellBeast1PlayerArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = MouthOfSauronArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = GothmogPlayerArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerMordor
            PlayerArmy = Mordor_CreateAHeroArmy
            Icon = MordorArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_EliteArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyThreeArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyThreeArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyThreeArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyOneArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyOneArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyOneArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyTwoArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyTwoArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_SpecialtyTwoArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = GimliPlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = DainPlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = GloinPlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = CaptainofDalePlayerArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_CreateAHeroArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_EliteArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyThreeArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyThreeArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyThreeArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyOneArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyOneArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyOneArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyTwoArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyTwoArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_SpecialtyTwoArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = SarumanPlayerArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = LurtzPlayerArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = SharkuPlayerArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = WormTongueArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_CreateAHeroArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_FortressAttackArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_EliteArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyThreeArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyThreeArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyThreeArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyOneArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyOneArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyOneArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyTwoArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyTwoArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_SpecialtyTwoArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = RogashPlayerArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = MorgramirPlayerArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = WitchKingArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = HwaldarPlayerArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerAngmar
            PlayerArmy = Angmar_CreateAHeroArmy
            Icon = AngmarArmyIcon
            SpawnAtActStart = Yes
        End
    End
End

LivingWorldRegionCampaign FortressRegion
    RegionConqueredSound = Gui_RegionConquered
    RegionEffectsManagerName = WotRRegionEffects
    RegionBonusArmy = LW:RegionBonusArmy_Good
    RegionBonusResource = LW:RegionBonusResource
    RegionBonusLegendary = LW:RegionLegendaryBonus
    HeroOnlyArmyCommandPoints = 0
    SmallArmyCommandPoints = 120
    MediumArmyCommandPoints = 240

    // Regions
    #include "..\common\livingworldregionswithoutbonus.inc"

    ConcurrentRegionBonus
        Territory = LW:TerritoryCustom
        EffectName = CustomEffect
        Regions = Dol_Guldur Erebor
        ArmyBonus = 0
        ResourceBonus = 0
        LegendaryBonus = 45
        AttackBonus = 0
        DefenseBonus = 5
        ExperienceBonus = 5
        FreeInnUnitsBonus = 0
        FreeBuilderBonus = 0
        UnifiedEvaEvent = WorldUnifyNorthernWastes
        LostEvaEvent = WorldLostNorthernWastes
        LookAtCenter = X:-65 Y:2085
        LookAtHeading = 0
        LookAtZoom = 0.71
    End
End
