//-------------------------------------------------------------------------------------------------
// Scenario Name: Fortress Defense - Escalation
// Scenario Description: This is a 6 player game with preset starting locations where the humans control the fortresses, and the AI control the rest.
// The AI spawns increasingly large armies every turn in their home bases for 10 turns, even if the territory has been captured.
//-------------------------------------------------------------------------------------------------

LivingWorldCampaign WOTRScenario104

    IsEvilCampaign = No

    ;////////////// RTS Settings /////////////
    #include "..\Common\LivingWorldDefaultRTSSettings.inc"

    Scenario
        DisplayName = LWScenario:WOTRScenario104
        DisplayDescription = LWScenario:WOTRScenario104Description
        DisplayGameType = LWScenario:WOTRGameType003
        DisplayObjectives = LWScenario:WOTRObjectives005
        DisplayFiction = LWScenario:WOTRScenarioFiction003
        DisplayVictoriousText = LWScenario:WOTRScenarioWin101
        DisplayDefeatedText = LWScenario:WOTRScenarioLose101

        RegionCampaign = DefaultCampaign

        MinPlayers = 6
        MaxPlayers = 6

        DisallowStartInRegions = Amon_Sul Angmar Arnor Barrow_Downs Belfalas Buckland Cair_Andros Cardolan CarnDum Carrock Celduin Dagorlad Dol_Guldur Dunland Enedwaith Erebor Ettenmoors Forlindon Fornost Forodwaith Gap_Of_Rohan Grey_Havens Harad Harlindon Helms_Deep High_Pass Isengard Ithilien Lostriand Lothlorien Minas_Morgul Minhiriath Mirkwood Mordor MountGundabad Osgiliath Redhorn_Pass Rhudaur Rhun Rivendell Rohan The_Black_Gate The_Brown_Lands The_Dead_Marshes Tower_Hills Umbar
        DefaultStartSpots = The_Shire Minas_Tirith Mount_Doom Iron_Hills Fangorn Anfalas

        PlayerDefeatCondition
            Teams = 1 2
            LoseIfCapitalLost = No
            NumControlledRegionsLessOrEqualTo = -1
        End

        TeamDefeatCondition
            Teams = 1 2
            NumControlledRegionsLessOrEqualTo = -1
        End

        StartingRestriction
            Factions = FactionMen FactionElves
            Regions = The_Shire
            Teams = 1
        End

        StartingRestriction
            Factions = FactionMen FactionElves
            Regions = Minas_Tirith
            Teams = 1
        End

        StartingRestriction
            Factions = FactionMordor FactionDwarves FactionIsengard FactionAngmar FactionWild
            Regions = Mount_Doom
            Teams = 2
        End

        StartingRestriction
            Factions = FactionMordor FactionDwarves FactionIsengard FactionAngmar FactionWild
            Regions = Iron_Hills
            Teams = 2
        End

        StartingRestriction
            Factions = FactionMordor FactionDwarves FactionIsengard FactionAngmar FactionWild
            Regions = Fangorn
            Teams = 2
        End

        StartingRestriction
            Factions = FactionMordor FactionDwarves FactionIsengard FactionAngmar FactionWild
            Regions = Anfalas
            Teams = 2
        End

        ; Player One
        OwnershipSet
            Regions = Dol_Guldur Fornost Helms_Deep Minas_Morgul Rivendell The_Shire
            StartRegion = The_Shire

            SpawnArmies
                Armies = HeroArmy1 HeroArmy2 HeroArmy3 HeroArmy4 HeroArmy5 GarrisonArmy1 GarrisonArmy1
                Region = The_Shire
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Amon_Sul
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Dol_Guldur
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Helms_Deep
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Minas_Morgul
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Rivendell
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = CarnDum
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Erebor
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Fornost
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Isengard
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Minas_Tirith
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Dol_Guldur
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Helms_Deep
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Minas_Morgul
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Rivendell
            End

            SpawnBuildings
                Buildings = LW_FARM LW_FARM
                Region = The_Shire
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Fornost
            End
        End

        ; Player Two
        OwnershipSet
            Regions = Amon_Sul CarnDum Erebor Isengard Minas_Tirith
            StartRegion = Minas_Tirith

            SpawnArmies
                Armies = HeroArmy1 HeroArmy2 HeroArmy3 HeroArmy4 HeroArmy5 GarrisonArmy1 GarrisonArmy1
                Region = The_Shire
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Amon_Sul
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Dol_Guldur
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Helms_Deep
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Minas_Morgul
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Rivendell
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = CarnDum
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Erebor
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Fornost
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Isengard
            End

            SpawnArmies
                Armies = FortressDefenseArmy
                Region = Minas_Tirith
            End

            SpawnBuildings
                Buildings = LW_FORT LW_SUPER_FARM
                Region = Amon_Sul
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = CarnDum
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Erebor
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Isengard
            End

            SpawnBuildings
                Buildings = LW_SUPER_FARM
                Region = Minas_Tirith
            End
        End

        ; Computer 1
        OwnershipSet
            Regions = Angmar Cair_Andros Barrow_Downs Celduin Ettenmoors High_Pass Mirkwood Mount_Doom Redhorn_Pass Rhun
            StartRegion = Mount_Doom

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Mount_Doom
            End

            SpawnArmies
                Armies = HeroArmy2 FortressAttackArmy
                Region = Gap_Of_Rohan
            End

            SpawnArmies
                Armies = HeroArmy3 FortressAttackArmy
                Region = Rhudaur
            End

            SpawnArmies
                Armies = HeroArmy4 FortressAttackArmy
                Region = Osgiliath
            End

            SpawnArmies
                Armies = HeroArmy5 FortressAttackArmy
                Region = Rohan
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Angmar
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Cair_Andros
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Barrow_Downs
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Celduin
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Ettenmoors
            End

            SpawnBuildings
                Buildings = LW_FORT
                Region = High_Pass
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Mirkwood
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Mount_Doom
            End

            SpawnBuildings
                Buildings = LW_FORT
                Region = Redhorn_Pass
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Rhun
            End
        End

        ; Computer 2
        OwnershipSet
            Regions = Belfalas The_Black_Gate Arnor Buckland Dagorlad Harad Lostriand Mordor Iron_Hills Umbar
            StartRegion = Iron_Hills

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Buckland
            End

            SpawnArmies
                Armies = HeroArmy2 FortressAttackArmy
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy3 FortressAttackArmy
                Region = Fangorn
            End

            SpawnArmies
                Armies = HeroArmy4 FortressAttackArmy
                Region = Forodwaith
            End

            SpawnArmies
                Armies = HeroArmy5 FortressAttackArmy
                Region = Osgiliath
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Belfalas
            End

            SpawnBuildings
                Buildings = LW_FORT
                Region = The_Black_Gate
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Arnor
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Buckland
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Dagorlad
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Harad
            End

            SpawnBuildings
                Buildings = LW_FORT
                Region = Lostriand
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Mordor
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Iron_Hills
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Umbar
            End
        End

        ; Computer 3
        OwnershipSet
            Regions = Fangorn The_Brown_Lands Forlindon Cardolan Dunland Harlindon Lothlorien MountGundabad Rohan Rhudaur
            StartRegion = Fangorn

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Fangorn
            End

            SpawnArmies
                Armies = HeroArmy2 FortressAttackArmy
                Region = Mirkwood
            End

            SpawnArmies
                Armies = HeroArmy3 FortressAttackArmy
                Region = Forodwaith
            End

            SpawnArmies
                Armies = HeroArmy4 FortressAttackArmy
                Region = Rhudaur
            End

            SpawnArmies
                Armies = HeroArmy5 FortressAttackArmy
                Region = Dagorlad
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Fangorn
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = The_Brown_Lands
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Rhun
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Forlindon
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Cardolan
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Dunland
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Harlindon
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Lothlorien
            End

            SpawnBuildings
                Buildings = LW_FORT
                Region = MountGundabad
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Rohan
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM LW_BARRACKS
                Region = Rhudaur
            End
        End

        ; Computer 4
        OwnershipSet
            Regions = Gap_Of_Rohan The_Dead_Marshes Grey_Havens Carrock Forodwaith Enedwaith Ithilien Minhiriath Osgiliath Tower_Hills Anfalas
            StartRegion = Anfalas

            SpawnArmies
                Armies = HeroArmy1 FortressAttackArmy
                Region = Buckland
            End

            SpawnArmies
                Armies = HeroArmy2 FortressAttackArmy
                Region = Mirkwood
            End

            SpawnArmies
                Armies = HeroArmy3 FortressAttackArmy
                Region = Fangorn
            End

            SpawnArmies
                Armies = HeroArmy4 FortressAttackArmy
                Region = Osgiliath
            End

            SpawnArmies
                Armies = HeroArmy5 FortressAttackArmy
                Region = Forodwaith
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Gap_Of_Rohan
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = The_Dead_Marshes
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Grey_Havens
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Carrock
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Forodwaith
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Enedwaith
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Ithilien
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Minhiriath
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Osgiliath
            End

            SpawnBuildings
                Buildings = LW_FORT
                Region = Tower_Hills
            End

            SpawnBuildings
                Buildings = LW_FORT LW_FARM
                Region = Anfalas
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
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
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
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
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
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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

    Act Four
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
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
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = Isengard_FortressAttackArmy
            Icon = IsengardArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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

    Act Five
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
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
    End

    Act Six
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
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
    End

    Act Seven
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
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
    End

    Act Eight
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
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
    End

    Act Nine
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
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
    End

    Act Ten
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
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
            SpawnAtActStart = Yes
        End

        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerWild
            PlayerArmy = CorruptedWild_FortressAttackArmy
            Icon = WildArmyIcon
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
    End
End
