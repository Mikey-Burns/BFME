//-------------------------------------------------------------------------------------------------
// Scenario Name:        2 Corner Chaos
// Scenario Description:    This is a 6 player game with preset starting locations where two humans are split between the north-east and south-west
// Unavailable Territories:    None
// # of Players:        6
//-------------------------------------------------------------------------------------------------

LivingWorldCampaign WOTRScenario101

    IsEvilCampaign = No

    ;////////////// RTS Settings /////////////
    #include "..\Common\LivingWorldDefaultRTSSettings.inc"

    Scenario
        DisplayName         = LWScenario:WOTRScenario101
        DisplayDescription     = LWScenario:WOTRScenario101Description
        DisplayGameType     = LWScenario:WOTRGameType003
        DisplayObjectives     = LWScenario:WOTRObjectives005
        DisplayFiction         = LWScenario:WOTRScenarioFiction003
        DisplayVictoriousText    = LWScenario:WOTRScenarioWin101
        DisplayDefeatedText    = LWScenario:WOTRScenarioLose101

        RegionCampaign = DefaultCampaign

        MinPlayers = 6
        MaxPlayers = 6

        DisallowStartInRegions = Buckland Cair_Andros Celduin Dagorlad Dol_Guldur Enedwaith Erebor Ettenmoors Forlindon Anfalas Harad Harlindon Isengard Ithilien Minas_Morgul Minas_Tirith Minhiriath Mirkwood Mount_Doom Osgiliath Redhorn_Pass Rhun Rivendell The_Black_Gate The_Dead_Marshes The_Shire Tower_Hills Umbar Angmar Cardolan Carrock The_Brown_Lands Fornost Amon_Sul Lostriand Rhudaur Barrow_Downs CarnDum Forodwaith MountGundabad Grey_Havens Helms_Deep Arnor Mordor Rohan Lothlorien
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

        ;///////////////////
        ; OwnershipSets
        ;///////////////////
        ; Player One
        OwnershipSet
            Regions = Iron_Hills
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
                Armies = HeroArmy4
                Region = Belfalas
            End
            SpawnBuildings
                Buildings = LW_FORT LW_ARMORY LW_BARRACKS
                Region = Iron_Hills
            End
        End

        ; Player Two
        OwnershipSet
            Regions = Belfalas
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
                Armies = HeroArmy4
                Region = Iron_Hills
            End
            SpawnBuildings
                Buildings = LW_FORT LW_ARMORY LW_BARRACKS
                Region = Belfalas
            End
        End

        ; Computer 1
        OwnershipSet
            Regions = Fangorn
            StartRegion = Fangorn

            SpawnArmies
                Armies = HeroArmy1 GarrisonArmy1
                Region = Fangorn
            End
            SpawnArmies
                Armies = HeroArmy2
                Region = Gap_Of_Rohan
            End
            SpawnArmies
                Armies = HeroArmy3
                Region = High_Pass
            End
            SpawnArmies
                Armies = HeroArmy4
                Region = Dunland
            End
        End
        ; Computer 2
        OwnershipSet
            Regions = Gap_Of_Rohan
            StartRegion = Gap_Of_Rohan

            SpawnArmies
                Armies = HeroArmy1
                Region = Fangorn
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
                Armies = HeroArmy4
                Region = Dunland
            End
        End
        ; Computer 3
        OwnershipSet
            Regions = High_Pass
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
                Armies = HeroArmy4
                Region = Dunland
            End
        End
        ; Computer 4
        OwnershipSet
            Regions = Dunland
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
                Region = High_Pass
            End
            SpawnArmies
                Armies = HeroArmy4 GarrisonArmy1
                Region = Dunland
            End
        End
    End

    ;//////////////////////////////////////////////////
    Act One
    ;//////////////////////////////////////////////////

        ;///////////////// Armies ////////////////
        #include "..\Common\LivingWorldDefaultArmies.inc"


        ;//////////////// Cities (Yes, this is a hack for mouse over movies.) ////////////////
        //#include "..\Common\LivingWorldCities.inc"


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
End