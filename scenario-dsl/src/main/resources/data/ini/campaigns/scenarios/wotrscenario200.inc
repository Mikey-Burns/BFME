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
                Armies = ExtraHeroOneArmy HeroArmy5 FortressAttackArmy FortressDefenseArmy FortressAttackArmy
                Region = Dol_Guldur
            End

            SpawnArmies
                Armies = ExtraHeroTwoArmy FortressAttackArmy FortressDefenseArmy FortressAttackArmy
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
                Armies = ExtraHeroOneArmy HeroArmy5 FortressAttackArmy FortressDefenseArmy FortressAttackArmy
                Region = Erebor
            End

            SpawnArmies
                Armies = ExtraHeroTwoArmy FortressAttackArmy FortressDefenseArmy FortressAttackArmy
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
                Armies = HeroArmy1
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
                Armies = HeroArmy1
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
                Armies = HeroArmy1
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
                Armies = HeroArmy1
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
            SpawnForTemplates = PlayerMen
            PlayerArmy = GaladrielArmy
            Icon = MoWArmyIcon
            SpawnAtActStart = Yes
        End
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerIsengard
            PlayerArmy = SauronArmy
            Icon = IsengardIcon
            SpawnAtActStart = Yes
        End
    End

    Act Three
        SpawnArmy
            ScriptingName = ExtraArmy
            SpawnForTemplates = PlayerElves
            PlayerArmy = ThranduilPlayerArmy
            Icon = ElfArmyIcon
            SpawnAtActStart = Yes
            Banner = BannerElves
        End
    End
End