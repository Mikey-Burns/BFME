//-------------------------------------------------------------------------------------------------
// Scenario Name: Testing
// Scenario Description: Act Testing
//-------------------------------------------------------------------------------------------------

LivingWorldCampaign WOTRScenario200

    IsEvilCampaign = No

    ;////////////// RTS Settings /////////////
    #include "..\Common\LivingWorldDefaultRTSSettings.inc"

    Scenario
        DisplayName = LWScenario:WOTRScenario200
        DisplayDescription = LWScenario:WOTRScenario200Description
        DisplayGameType = LWScenario:WOTRGameType003
        DisplayObjectives = LWScenario:WOTRObjectives005
        DisplayFiction = LWScenario:WOTRScenarioFiction003
        DisplayVictoriousText = LWScenario:WOTRScenarioWin101
        DisplayDefeatedText = LWScenario:WOTRScenarioLose101

        RegionCampaign = DefaultCampaign

        MinPlayers = 6
        MaxPlayers = 6

        DisallowStartInRegions = Amon_Sul Anfalas Angmar Arnor Barrow_Downs Buckland Cair_Andros Cardolan CarnDum Carrock Celduin Dagorlad Dol_Guldur Enedwaith Erebor Ettenmoors Forlindon Fornost Forodwaith Grey_Havens Harad Harlindon Helms_Deep Isengard Ithilien Lostriand Lothlorien Minas_Morgul Minas_Tirith Minhiriath Mirkwood Mordor MountGundabad Mount_Doom Osgiliath Redhorn_Pass Rhudaur Rhun Rivendell Rohan The_Black_Gate The_Brown_Lands The_Dead_Marshes The_Shire Tower_Hills Umbar
        DefaultStartSpots = Iron_Hills Belfalas Fangorn Gap_Of_Rohan High_Pass Dunland

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
            Regions = Iron_Hills
            Teams = 1
        End

        StartingRestriction
            Regions = Belfalas
            Teams = 1
        End

        StartingRestriction
            Regions = Fangorn
            Teams = 2
        End

        StartingRestriction
            Regions = Gap_Of_Rohan
            Teams = 2
        End

        StartingRestriction
            Regions = High_Pass
            Teams = 2
        End

        StartingRestriction
            Regions = Dunland
            Teams = 2
        End

        ; Player One
        OwnershipSet
            Regions = Iron_Hills Anfalas
            StartRegion = Iron_Hills

            SpawnArmies
                Armies = HeroArmy1 GarrisonArmy1
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy3 GarrisonArmy1
                Region = Belfalas
            End

            SpawnArmies
                Armies = HeroArmy5
                Region = Belfalas
            End

            SpawnBuildings
                Buildings = LW_BARRACKS LW_SUPER_FARM
                Region = Iron_Hills
            End

            SpawnBuildings
                Buildings = LW_FORT LW_SUPER_FARM
                Region = Anfalas
            End
        End

        ; Player Two
        OwnershipSet
            Regions = Belfalas Rhun
            StartRegion = Belfalas

            SpawnArmies
                Armies = HeroArmy1 GarrisonArmy1
                Region = Belfalas
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Belfalas
            End

            SpawnArmies
                Armies = HeroArmy3 GarrisonArmy1
                Region = Iron_Hills
            End

            SpawnArmies
                Armies = HeroArmy5
                Region = Iron_Hills
            End

            SpawnBuildings
                Buildings = LW_BARRACKS LW_SUPER_FARM
                Region = Belfalas
            End

            SpawnBuildings
                Buildings = LW_BARRACKS LW_SUPER_FARM
                Region = Rhun
            End
        End

        ; Computer 1
        OwnershipSet
            Regions = Fangorn Forlindon
            StartRegion = Fangorn

            SpawnArmies
                Armies = HeroArmy1 GarrisonArmy1
                Region = Fangorn
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Forlindon
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = High_Pass
            End

            SpawnArmies
                Armies = HeroArmy5
                Region = Dunland
            End

            SpawnBuildings
                Buildings = LW_FARM LW_SUPER_FARM
                Region = Fangorn
            End

            SpawnBuildings
                Buildings = LW_FORT LW_BARRACKS
                Region = Forlindon
            End
        End

        ; Computer 2
        OwnershipSet
            Regions = Gap_Of_Rohan Harlindon
            StartRegion = Gap_Of_Rohan

            SpawnArmies
                Armies = HeroArmy1
                Region = Harlindon
            End

            SpawnArmies
                Armies = HeroArmy2 GarrisonArmy1
                Region = Gap_Of_Rohan
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = High_Pass
            End

            SpawnArmies
                Armies = HeroArmy5
                Region = Dunland
            End

            SpawnBuildings
                Buildings = LW_FARM LW_SUPER_FARM
                Region = Gap_Of_Rohan
            End

            SpawnBuildings
                Buildings = LW_FORT LW_BARRACKS
                Region = Harlindon
            End
        End

        ; Computer 3
        OwnershipSet
            Regions = High_Pass Forodwaith
            StartRegion = High_Pass

            SpawnArmies
                Armies = HeroArmy1
                Region = Fangorn
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Gap_Of_Rohan
            End

            SpawnArmies
                Armies = HeroArmy3 GarrisonArmy1
                Region = High_Pass
            End

            SpawnArmies
                Armies = HeroArmy5
                Region = Forodwaith
            End

            SpawnBuildings
                Buildings = LW_FARM LW_SUPER_FARM
                Region = High_Pass
            End

            SpawnBuildings
                Buildings = LW_FORT LW_BARRACKS
                Region = Forodwaith
            End
        End

        ; Computer 4
        OwnershipSet
            Regions = Dunland Arnor
            StartRegion = Dunland

            SpawnArmies
                Armies = HeroArmy1
                Region = Fangorn
            End

            SpawnArmies
                Armies = HeroArmy2
                Region = Gap_Of_Rohan
            End

            SpawnArmies
                Armies = HeroArmy3
                Region = Arnor
            End

            SpawnArmies
                Armies = HeroArmy5 GarrisonArmy1
                Region = Dunland
            End

            SpawnBuildings
                Buildings = LW_FARM LW_SUPER_FARM
                Region = Dunland
            End

            SpawnBuildings
                Buildings = LW_FORT LW_BARRACKS
                Region = Arnor
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
            SpawnForTemplates = PlayerMen
            PlayerArmy = MenOfTheWest_FortressAttackArmy
            Icon = MoWArmyIcon
            SpawnAtActStart = Yes
        End
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerElves
            PlayerArmy = Elven_FortressAttackArmy
            Icon = ElfArmyIcon
            SpawnAtActStart = Yes
        End
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerDwarves
            PlayerArmy = Dwarven_FortressAttackArmy
            Icon = DwarfArmyIcon
            SpawnAtActStart = Yes
        End
    End
    Act Three
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerElves
            PlayerArmy = Elven_FortressAttackArmy
            Icon = ElfArmyIcon
            SpawnAtActStart = Yes
        End
    End
End
