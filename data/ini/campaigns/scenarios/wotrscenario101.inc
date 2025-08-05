//-------------------------------------------------------------------------------------------------
// Scenario Name:		2 Corner Chaos
// Scenario Description:	This is a 6 player game with preset starting locations where two humans are split between the north-east and south-west
// Unavailable Territories:	None
// # of Players:		6
//-------------------------------------------------------------------------------------------------

LivingWorldCampaign WOTRScenario101

	IsEvilCampaign = No

	;////////////// RTS Settings /////////////
	#include "..\Common\LivingWorldDefaultRTSSettings.inc"

	Scenario
		DisplayName 		= 2 Corner Chaos
		DisplayDescription 	= Chaotic war of two corners
		DisplayGameType 	= LWScenario:WOTRGameType001
		DisplayObjectives 	= LWScenario:WOTRObjectives001
		DisplayFiction 		= LWScenario:WOTRScenarioFiction003
		DisplayVictoriousText	= LWScenario:WOTRCapitalAssaultWin001
		DisplayDefeatedText	= LWScenario:WOTRCapitalAssaultLose001

		RegionCampaign = DefaultCampaign

		MaxPlayers = 6

		;DisallowStartInRegions = Buckland Celduin Dagorlad Dol_Guldur Erebor Forlindon Anfalas Grey_Havens Harad Harlindon Helms_Deep Isengard Ithilien Minas_Morgul Minas_Tirith Minhiriath Mirkwood Osgiliath Redhorn_Pass Rivendell The_Black_Gate The_Dead_Marshes The_Shire Tower_Hills Umbar Angmar Carrock The_Brown_Lands Fornost Amon_Sul Lostriand Rhudaur Barrow_Downs CarnDum Forodwaith MountGundabad Enedwaith Mount_Doom Ettenmoors Cair_Andros Mordor Iron_Hills Rohan Lothlorien Cardolan Arnor
		DefaultStartSpots = Rhun Belfalas Fangorn Gap_Of_Rohan High_Pass Dunland
		;

		PlayerDefeatCondition
			Teams = 1 2
			LoseIfCapitalLost = No
			NumControlledRegionsLessOrEqualTo = -1
		End

		TeamDefeatCondition
			Teams = 1 2
			NumControlledRegionsLessOrEqualTo = -1
		End
	End

    ;///////////////////
    ; OwnershipSets
    ;///////////////////
    ; Player One
    OwnershipSet
        Regions = Rhun
        StartRegion = Rhun

        SpawnArmies
            Armies = HeroArmy1
            Region = Rhun
        End
        SpawnArmies
            Armies = HeroArmy2
            Region = Belfalas
        End
        SpawnBuildings
            Buildings = LW_FORT LW_ARMORY
            Region = Rhun
        End
    End

    ; Player Two
    OwnershipSet
        Regions = Belfalas
        StartRegion = Belfalas

        SpawnArmies
            Armies = HeroArmy1
            Region = Belfalas
        End
        SpawnArmies
            Armies = HeroArmy2
            Region = Rhun
        End
        SpawnBuildings
            Buildings = LW_FORT LW_ARMORY
            Region = Belfalas
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