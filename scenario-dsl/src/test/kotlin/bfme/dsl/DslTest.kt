package bfme.dsl

import bfme.domain.Army.*
import bfme.domain.Building.*
import bfme.domain.Faction.ELVES
import bfme.domain.Faction.GOBLINS
import bfme.domain.Faction.MEN
import bfme.domain.Territory.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DslTest {

    // region Validation tests
    @Test
    fun `LivingWorldCampaign must populate fields with real values`() {
        val validationErrors = livingWorldCampaign { }.validate()
        assertTrue(validationErrors.isNotEmpty())
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        val errorMessages = errorsByClass.getValue(LivingWorldCampaign::class.java).map(Violation::error)
        errorMessages.expectMessage("'name' must not be empty")
        errorMessages.expectMessage("'description' must not be empty")
        errorMessages.expectMessage("'number' must be greater than 0")
        errorMessages.expectMessage("'scenario' must not be null")
    }

    @Test
    fun `Scenario must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                minPlayers = 7
                maxPlayers = 1
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        val errorMessages = errorsByClass.getValue(Scenario::class.java).map(Violation::error)
        errorMessages.expectMessage("'name' must not be empty")
        errorMessages.expectMessage("'description' must not be empty")
        errorMessages.expectMessage("'gameType' must not be empty")
        errorMessages.expectMessage("'objectives' must not be empty")
        errorMessages.expectMessage("'fiction' must not be empty")
        errorMessages.expectMessage("'victoriousText' must not be empty")
        errorMessages.expectMessage("'defeatedText' must not be empty")
        errorMessages.expectMessage("'minPlayers' must be between 2 and 6")
        errorMessages.expectMessage("'maxPlayers' must be between 2 and 6")
        errorMessages.expectMessage("'maxPlayers' must be greater than or equal to minPlayers")
    }

    @Test
    fun `PlayerDefeatCondition must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                playerDefeatCondition { }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(PlayerDefeatCondition::class.java) }
        val errorMessages = errorsByClass.getValue(PlayerDefeatCondition::class.java).map(Violation::error)
        errorMessages.expectMessage("'teams' must not be empty")
    }

    @Test
    fun `TeamDefeatCondition must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                teamDefeatCondition { }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(TeamDefeatCondition::class.java) }
        val errorMessages = errorsByClass.getValue(TeamDefeatCondition::class.java).map(Violation::error)
        errorMessages.expectMessage("'teams' must not be empty")
    }

    @Test
    fun `TeamVictoryCondition must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                teamVictoryCondition {
                    numTurns = 0
                }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(TeamVictoryCondition::class.java) }
        val errorMessages = errorsByClass.getValue(TeamVictoryCondition::class.java).map(Violation::error)
        errorMessages.expectMessage("'teams' must not be empty")
        errorMessages.expectMessage("'regions' must not be empty")
        errorMessages.expectMessage("'numTurns' must be greater than 0")
    }

    @Test
    fun `OwnershipSet must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                ownershipSet { }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(OwnershipSet::class.java) }
        val errorMessages = errorsByClass.getValue(OwnershipSet::class.java).map(Violation::error)
        errorMessages.expectMessage("'startRegion' must not be empty")
        errorMessages.expectMessage("'regions' must not be empty")
    }

    @Test
    fun `SpawnArmies must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                ownershipSet {
                    spawnArmies {}
                }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(OwnershipSet::class.java) }
        assertTrue { errorsByClass.contains(SpawnArmies::class.java) }
        val errorMessages = errorsByClass.getValue(SpawnArmies::class.java).map(Violation::error)
        errorMessages.expectMessage("'region' must not be empty")
        errorMessages.expectMessage("'armies' must not be empty")
    }

    @Test
    fun `SpawnBuildings must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                ownershipSet {
                    spawnBuildings {}
                }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(OwnershipSet::class.java) }
        assertTrue { errorsByClass.contains(SpawnBuildings::class.java) }
        val errorMessages = errorsByClass.getValue(SpawnBuildings::class.java).map(Violation::error)
        errorMessages.expectMessage("'region' must not be empty")
        errorMessages.expectMessage("'buildings' must not be empty")
    }

    @Test
    fun `StartingRestriction must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                startingRestriction { }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        assertTrue { errorsByClass.contains(StartingRestriction::class.java) }
        val errorMessages = errorsByClass.getValue(StartingRestriction::class.java).map(Violation::error)
        errorMessages.expectMessage("'team' must be 1 or 2")
        errorMessages.expectMessage("'factions' and 'regions' must not both be empty")
    }

    @Test
    fun `Act must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            act {}
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Act::class.java) }
        val errorMessages = errorsByClass.getValue(Act::class.java).map(Violation::error)
        errorMessages.expectMessage("'number' must not be empty")
    }

    @Test
    fun `ArmyEntry must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            act {
                armyEntry {

                }
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(ArmyEntry::class.java) }
        val errorMessages = errorsByClass.getValue(ArmyEntry::class.java).map(Violation::error)
        errorMessages.expectMessage("'name' must not be empty")
        errorMessages.expectMessage("'faction' must not be empty")
        errorMessages.expectMessage("'army' must not be empty")
    }

    @Test
    fun `Start spots cannot be disabled or disallowed`() {
        val validationErrors = livingWorldCampaign {
            scenario {
                disable(ANGMAR)
                disable(CELDUIN)
                disallowStart(CELDUIN)
                disallowStart(FANGORN)
                defaultStart(ANGMAR)
                defaultStart(FANGORN)
                defaultStart(CELDUIN)
            }
        }.validate()
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldCampaign::class.java) }
        assertTrue { errorsByClass.contains(Scenario::class.java) }
        val errorMessages = errorsByClass.getValue(Scenario::class.java).map(Violation::error)
        errorMessages.expectMessage("'Angmar' cannot be a default start spot if it is disabled")
        errorMessages.expectMessage("'Celduin' cannot be a default start spot if it is disabled")
        errorMessages.expectMessage("'Celduin' cannot be a default start spot if it is disallowed")
        errorMessages.expectMessage("'Fangorn' cannot be a default start spot if it is disallowed")
    }

    @Test
    fun `LivingWorldRegionCampaign must be named`() {
        val validationErrors = livingWorldCampaign {
            livingWorldRegionCampaign { }
        }.validate()
        assertTrue(validationErrors.isNotEmpty())
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(LivingWorldRegionCampaign::class.java) }
        val errorMessages = errorsByClass.getValue(LivingWorldRegionCampaign::class.java).map(Violation::error)
        errorMessages.expectMessage("'name' must not be empty")
    }

    @Test
    fun `ConcurrentRegionBonus must populate fields with real values`() {
        val validationErrors = livingWorldCampaign {
            livingWorldRegionCampaign {
                concurrentRegionBonus {
                    armyBonus = -1
                    resourceBonus = -1
                    legendaryBonus = -1
                    attackBonus = -1
                    defenseBonus = -1
                    experienceBonus = -1
                    freeInnUnitsBonus = -1
                    freeBuilderBonus = -1
                }
            }
        }.validate()
        assertTrue(validationErrors.isNotEmpty())
        val errorsByClass = validationErrors.groupBy { it.source }
        assertTrue { errorsByClass.contains(ConcurrentRegionBonus::class.java) }
        val errorMessages = errorsByClass.getValue(ConcurrentRegionBonus::class.java).map(Violation::error)
        errorMessages.expectMessage("'armyBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'resourceBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'legendaryBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'attackBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'defenseBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'experienceBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'freeInnUnitsBonus' must be greater than or equal to 0")
        errorMessages.expectMessage("'freeBuilderBonus' must be greater than or equal to 0")
    }
    // endregion

    // region Render tests
    @Test
    fun `An invalid campaign cannot be rendered`() {
        val campaign = livingWorldCampaign { }
        assertThrows(WotrException::class.java) { campaign.render() }
    }

    @Test
    fun `Basic campaign can be rendered`() {
        val expectedRendering = """
            //-------------------------------------------------------------------------------------------------
            // Scenario Name: Basic Name
            // Scenario Description: Basic Description
            //-------------------------------------------------------------------------------------------------

            LivingWorldCampaign WOTRScenario001

                IsEvilCampaign = No

                ;////////////// RTS Settings /////////////
                #include "..\Common\LivingWorldDefaultRTSSettings.inc"

                Scenario
                    DisplayName = LWScenario:WOTRScenario001
                    DisplayDescription = LWScenario:WOTRScenario001Description
                    DisplayGameType = LWScenario:WOTRGameType001
                    DisplayObjectives = LWScenario:WOTRObjectives001
                    DisplayFiction = LWScenario:WOTRScenarioFiction001
                    DisplayVictoriousText = LWScenario:WOTRScenarioWin001
                    DisplayDefeatedText = LWScenario:WOTRScenarioLose001

                    RegionCampaign = DefaultCampaign

                    UseMpRulesVictoryCondition = Yes
                    MinPlayers = 6
                    MaxPlayers = 6

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
            End
            
        """.trimIndent()
        val campaign = livingWorldCampaign {
            name = "Basic Name"
            description = "Basic Description"
            number = 1

            scenario {
                name = "LWScenario:WOTRScenario001"
                description = "LWScenario:WOTRScenario001Description"
                gameType = "LWScenario:WOTRGameType001"
                objectives = "LWScenario:WOTRObjectives001"
                fiction = "LWScenario:WOTRScenarioFiction001"
                victoriousText = "LWScenario:WOTRScenarioWin001"
                defeatedText = "LWScenario:WOTRScenarioLose001"

                minPlayers = 6
                maxPlayers = 6

                playerDefeatCondition {
                    team(1)
                    team(2)
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    team(1)
                    team(2)
                    numControlledRegionsLessOrEqualTo = -1
                }
            }
        }
        assertEquals(expectedRendering, campaign.render())
    }

    @Test
    fun `Campaign with region fields can be rendered`() {
        val expectedRendering = """
            //-------------------------------------------------------------------------------------------------
            // Scenario Name: Regions Name
            // Scenario Description: Regions Description
            //-------------------------------------------------------------------------------------------------

            LivingWorldCampaign WOTRScenario002

                IsEvilCampaign = No

                ;////////////// RTS Settings /////////////
                #include "..\Common\LivingWorldDefaultRTSSettings.inc"

                Scenario
                    DisplayName = LWScenario:WOTRScenario002
                    DisplayDescription = LWScenario:WOTRScenario002Description
                    DisplayGameType = LWScenario:WOTRGameType002
                    DisplayObjectives = LWScenario:WOTRObjectives002
                    DisplayFiction = LWScenario:WOTRScenarioFiction002
                    DisplayVictoriousText = LWScenario:WOTRScenarioWin002
                    DisplayDefeatedText = LWScenario:WOTRScenarioLose002

                    RegionCampaign = DefaultCampaign

                    UseMpRulesVictoryCondition = Yes
                    MinPlayers = 6
                    MaxPlayers = 6

                    DisallowStartInRegions = Amon_Sul Angmar Arnor Barrow_Downs Buckland Cair_Andros Cardolan CarnDum Carrock Celduin Dagorlad Dol_Guldur Dunland Enedwaith Erebor Ettenmoors Forlindon Fornost Forodwaith Grey_Havens Harad Harlindon Helms_Deep High_Pass Iron_Hills Isengard Ithilien Lostriand Lothlorien Minas_Morgul Minhiriath Mirkwood Mordor MountGundabad Mount_Doom Osgiliath Redhorn_Pass Rhudaur Rhun Rivendell Rohan The_Black_Gate The_Brown_Lands The_Dead_Marshes Tower_Hills Umbar
                    DefaultStartSpots = The_Shire Minas_Tirith Anfalas Belfalas Fangorn Gap_Of_Rohan

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
                        Regions = The_Shire Minas_Tirith
                        Teams = 1
                    End

                    ; Player One
                    OwnershipSet
                        Regions = The_Shire Buckland Arnor
                        StartRegion = The_Shire

                        SpawnArmies
                            Armies = HeroArmy1 HeroArmy2 HeroArmy3
                            Region = The_Shire
                        End

                        SpawnArmies
                            Armies = HeroArmy4 HeroArmy5
                            Region = Buckland
                        End

                        SpawnBuildings
                            Buildings = LW_FORT LW_FARM
                            Region = The_Shire
                        End

                        SpawnBuildings
                            Buildings = LW_BARRACKS LW_ARMORY
                            Region = Buckland
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
            End
            
        """.trimIndent()
        val campaign = livingWorldCampaign {
            name = "Regions Name"
            description = "Regions Description"
            number = 2

            scenario {
                name = "LWScenario:WOTRScenario002"
                description = "LWScenario:WOTRScenario002Description"
                gameType = "LWScenario:WOTRGameType002"
                objectives = "LWScenario:WOTRObjectives002"
                fiction = "LWScenario:WOTRScenarioFiction002"
                victoriousText = "LWScenario:WOTRScenarioWin002"
                defeatedText = "LWScenario:WOTRScenarioLose002"

                minPlayers = 6
                maxPlayers = 6

                // These will get alphabetized
                disallowStart(UMBAR)
                disallowStart(TOWER_HILLS)
                disallowStart(THE_DEAD_MARSHES)
                disallowStart(THE_BROWN_LANDS)
                disallowStart(THE_BLACK_GATE)
                disallowStart(ROHAN)
                disallowStart(RIVENDELL)
                disallowStart(RHUN)
                disallowStart(RHUDAUR)
                disallowStart(REDHORN_PASS)
                disallowStart(OSGILIATH)
                disallowStart(NORTH_DOWNS)
                disallowStart(MOUNT_GUNDABAD)
                disallowStart(MOUNT_DOOM)
                disallowStart(MORDOR)
                disallowStart(MIRKWOOD)
                disallowStart(MINHIRIATH)
                disallowStart(MINAS_MORGUL)
                disallowStart(LORIEN)
                disallowStart(LOSTRIAND)
                disallowStart(ITHILIEN)
                disallowStart(ISENGARD)
                disallowStart(IRON_HILLS)
                disallowStart(HIGH_PASS)
                disallowStart(HELMS_DEEP)
                disallowStart(HARLINDON)
                disallowStart(HARAD)
                disallowStart(GREY_HAVENS)
                disallowStart(FORODWAITH)
                disallowStart(FORNOST)
                disallowStart(FORLINDON)
                disallowStart(ETTENMOORS)
                disallowStart(EREBOR)
                disallowStart(ENEDWAITH)
                disallowStart(DUNLAND)
                disallowStart(DOL_GULDUR)
                disallowStart(DAGORLAD)
                disallowStart(CELDUIN)
                disallowStart(CARROCK)
                disallowStart(CARN_DUM)
                disallowStart(CARDOLAN)
                disallowStart(CAIR_ANDROS)
                disallowStart(BARROW_DOWNS)
                disallowStart(ARTHEDAIN)
                disallowStart(ANGMAR)
                disallowStart(AMON_SUL)

                // These do not get alphabetized
                defaultStart(THE_SHIRE)
                defaultStart(MINAS_TIRITH)
                defaultStart(ANFALAS)
                defaultStart(BELFALAS)
                defaultStart(FANGORN)
                defaultStart(GAP_OF_ROHAN)

                playerDefeatCondition {
                    team(1)
                    team(2)
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    team(1)
                    team(2)
                    numControlledRegionsLessOrEqualTo = -1
                }

                startingRestriction {
                    region(THE_SHIRE)
                    region(MINAS_TIRITH)
                    teams = 1
                }

                ownershipSet {
                    label = "Player One"
                    startRegion = THE_SHIRE
                    region(THE_SHIRE)
                    region(NORTH_DOWNS)
                    region(ARTHEDAIN)

                    spawnArmies {
                        region = THE_SHIRE
                        army(HERO_ARMY_1)
                        army(HERO_ARMY_2)
                        army(HERO_ARMY_3)
                    }

                    spawnArmies {
                        region = NORTH_DOWNS
                        army(HERO_ARMY_4)
                        army(HERO_ARMY_5)
                    }

                    spawnBuildings {
                        region = THE_SHIRE
                        building(FORTRESS)
                        building(FARM)
                    }

                    spawnBuildings {
                        region = NORTH_DOWNS
                        building(BARRACKS)
                        building(ARMORY)
                    }
                }
            }
        }
        assertEquals(expectedRendering, campaign.render())
    }

    @Test
    fun `Campaign with multiple acts can be rendered`() {
        val expectedRendering = """
            //-------------------------------------------------------------------------------------------------
            // Scenario Name: Acts Name
            // Scenario Description: Acts Description
            //-------------------------------------------------------------------------------------------------

            LivingWorldCampaign WOTRScenario003

                IsEvilCampaign = No

                ;////////////// RTS Settings /////////////
                #include "..\Common\LivingWorldDefaultRTSSettings.inc"

                Scenario
                    DisplayName = LWScenario:WOTRScenario003
                    DisplayDescription = LWScenario:WOTRScenario003Description
                    DisplayGameType = LWScenario:WOTRGameType003
                    DisplayObjectives = LWScenario:WOTRObjectives003
                    DisplayFiction = LWScenario:WOTRScenarioFiction003
                    DisplayVictoriousText = LWScenario:WOTRScenarioWin003
                    DisplayDefeatedText = LWScenario:WOTRScenarioLose003

                    RegionCampaign = DefaultCampaign

                    UseMpRulesVictoryCondition = Yes
                    MinPlayers = 6
                    MaxPlayers = 6

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
                End

                Act Three
                    SpawnArmy
                        ScriptingName = ExtraArmy
                        SpawnForTemplates = PlayerElves
                        PlayerArmy = Elven_FortressAttackArmy
                        Icon = ElfArmyIcon
                        SpawnAtActStart = Yes
                    End

                    SpawnArmy
                        ScriptingName = ExtraArmy
                        SpawnForTemplates = PlayerWild
                        PlayerArmy = CorruptedWild_FortressAttackArmy
                        Icon = WildArmyIcon
                        SpawnAtActStart = Yes
                    End
                End
            End
            
        """.trimIndent()
        val campaign = livingWorldCampaign {
            name = "Acts Name"
            description = "Acts Description"
            number = 3

            scenario {
                name = "LWScenario:WOTRScenario003"
                description = "LWScenario:WOTRScenario003Description"
                gameType = "LWScenario:WOTRGameType003"
                objectives = "LWScenario:WOTRObjectives003"
                fiction = "LWScenario:WOTRScenarioFiction003"
                victoriousText = "LWScenario:WOTRScenarioWin003"
                defeatedText = "LWScenario:WOTRScenarioLose003"

                minPlayers = 6
                maxPlayers = 6

                playerDefeatCondition {
                    team(1)
                    team(2)
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    team(1)
                    team(2)
                    numControlledRegionsLessOrEqualTo = -1
                }
            }

            act {
                number = "Two"
                armyEntry {
                    name = "ExtraArmy"
                    faction = MEN
                    army = FORTRESS_ATTACK_ARMY
                }
            }

            act {
                number = "Three"
                armyEntry {
                    name = "ExtraArmy"
                    faction = ELVES
                    army = FORTRESS_ATTACK_ARMY
                }
                armyEntry {
                    name = "ExtraArmy"
                    faction = GOBLINS
                    army = FORTRESS_ATTACK_ARMY
                }
            }
        }
        assertEquals(expectedRendering, campaign.render())
    }

    @Test
    fun `Campaign with disabled territories can be rendered`() {
        val expectedRendering = """
            //-------------------------------------------------------------------------------------------------
            // Scenario Name: Disable Name
            // Scenario Description: Disable Description
            //-------------------------------------------------------------------------------------------------

            LivingWorldCampaign WOTRScenario004

                IsEvilCampaign = No

                ;////////////// RTS Settings /////////////
                #include "..\Common\LivingWorldDefaultRTSSettings.inc"

                Scenario
                    DisplayName = LWScenario:WOTRScenario004
                    DisplayDescription = LWScenario:WOTRScenario004Description
                    DisplayGameType = LWScenario:WOTRGameType004
                    DisplayObjectives = LWScenario:WOTRObjectives004
                    DisplayFiction = LWScenario:WOTRScenarioFiction004
                    DisplayVictoriousText = LWScenario:WOTRScenarioWin004
                    DisplayDefeatedText = LWScenario:WOTRScenarioLose004

                    RegionCampaign = DefaultCampaign

                    UseMpRulesVictoryCondition = Yes
                    MinPlayers = 6
                    MaxPlayers = 6

                    DisableRegions = Celduin Fangorn
                    DisallowStartInRegions = Amon_Sul Angmar
                    DefaultStartSpots = The_Shire Minas_Tirith

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
            End
            
        """.trimIndent()
        val campaign = livingWorldCampaign {
            name = "Disable Name"
            description = "Disable Description"
            number = 4

            scenario {
                name = "LWScenario:WOTRScenario004"
                description = "LWScenario:WOTRScenario004Description"
                gameType = "LWScenario:WOTRGameType004"
                objectives = "LWScenario:WOTRObjectives004"
                fiction = "LWScenario:WOTRScenarioFiction004"
                victoriousText = "LWScenario:WOTRScenarioWin004"
                defeatedText = "LWScenario:WOTRScenarioLose004"

                minPlayers = 6
                maxPlayers = 6

                disable(CELDUIN)
                disable(FANGORN)
                disallowStart(AMON_SUL)
                disallowStart(ANGMAR)
                defaultStart(THE_SHIRE)
                defaultStart(MINAS_TIRITH)

                playerDefeatCondition {
                    team(1)
                    team(2)
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    team(1)
                    team(2)
                    numControlledRegionsLessOrEqualTo = -1
                }
            }
        }
        assertEquals(expectedRendering, campaign.render())
    }

    @Test
    fun `Campaign can set victory conditions`() {
        val expectedRendering = """
            //-------------------------------------------------------------------------------------------------
            // Scenario Name: Victory Name
            // Scenario Description: Victory Description
            //-------------------------------------------------------------------------------------------------

            LivingWorldCampaign WOTRScenario005

                IsEvilCampaign = No

                ;////////////// RTS Settings /////////////
                #include "..\Common\LivingWorldDefaultRTSSettings.inc"

                Scenario
                    DisplayName = LWScenario:WOTRScenario005
                    DisplayDescription = LWScenario:WOTRScenario005Description
                    DisplayGameType = LWScenario:WOTRGameType005
                    DisplayObjectives = LWScenario:WOTRObjectives005
                    DisplayFiction = LWScenario:WOTRScenarioFiction005
                    DisplayVictoriousText = LWScenario:WOTRScenarioWin005
                    DisplayDefeatedText = LWScenario:WOTRScenarioLose005

                    RegionCampaign = DefaultCampaign

                    UseMpRulesVictoryCondition = Yes
                    MinPlayers = 6
                    MaxPlayers = 6

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
                        Teams = 1 2
                        ControlledRegions = Erebor Helms_Deep
                        ControlledRegionsHeldForTurns = 3
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
            End
            
        """.trimIndent()
        val campaign = livingWorldCampaign {
            name = "Victory Name"
            description = "Victory Description"
            number = 5

            scenario {
                name = "LWScenario:WOTRScenario005"
                description = "LWScenario:WOTRScenario005Description"
                gameType = "LWScenario:WOTRGameType005"
                objectives = "LWScenario:WOTRObjectives005"
                fiction = "LWScenario:WOTRScenarioFiction005"
                victoriousText = "LWScenario:WOTRScenarioWin005"
                defeatedText = "LWScenario:WOTRScenarioLose005"

                minPlayers = 6
                maxPlayers = 6

                playerDefeatCondition {
                    team(1)
                    team(2)
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    team(1)
                    team(2)
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamVictoryCondition {
                    team(1)
                    team(2)
                    region(EREBOR)
                    region(HELMS_DEEP)
                    numTurns = 3
                }
            }
        }
        assertEquals(expectedRendering, campaign.render())
    }

    @Test
    fun `Campaign can set custom region definitions`() {
        val expectedRendering = """
            //-------------------------------------------------------------------------------------------------
            // Scenario Name: Regions Name
            // Scenario Description: Regions Description
            //-------------------------------------------------------------------------------------------------

            LivingWorldCampaign WOTRScenario006

                IsEvilCampaign = No

                ;////////////// RTS Settings /////////////
                #include "..\Common\LivingWorldDefaultRTSSettings.inc"

                Scenario
                    DisplayName = LWScenario:WOTRScenario006
                    DisplayDescription = LWScenario:WOTRScenario006Description
                    DisplayGameType = LWScenario:WOTRGameType006
                    DisplayObjectives = LWScenario:WOTRObjectives006
                    DisplayFiction = LWScenario:WOTRScenarioFiction006
                    DisplayVictoriousText = LWScenario:WOTRScenarioWin006
                    DisplayDefeatedText = LWScenario:WOTRScenarioLose006

                    RegionCampaign = CustomRegion

                    UseMpRulesVictoryCondition = Yes
                    MinPlayers = 6
                    MaxPlayers = 6

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
            End

            LivingWorldRegionCampaign CustomRegion
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
                    ArmyBonus = 1
                    ResourceBonus = 2
                    LegendaryBonus = 3
                    AttackBonus = 4
                    DefenseBonus = 5
                    ExperienceBonus = 6
                    FreeInnUnitsBonus = 7
                    FreeBuilderBonus = 8
                    UnifiedEvaEvent = WorldUnifyNorthernWastes
                    LostEvaEvent = WorldLostNorthernWastes
                    LookAtCenter = X:-65 Y:2085
                    LookAtHeading = 0
                    LookAtZoom = 0.71
                End
            End
            
        """.trimIndent()
        val campaign = livingWorldCampaign {
            name = "Regions Name"
            description = "Regions Description"
            number = 6

            scenario {
                name = "LWScenario:WOTRScenario006"
                description = "LWScenario:WOTRScenario006Description"
                gameType = "LWScenario:WOTRGameType006"
                objectives = "LWScenario:WOTRObjectives006"
                fiction = "LWScenario:WOTRScenarioFiction006"
                victoriousText = "LWScenario:WOTRScenarioWin006"
                defeatedText = "LWScenario:WOTRScenarioLose006"

                minPlayers = 6
                maxPlayers = 6

                playerDefeatCondition {
                    team(1)
                    team(2)
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    team(1)
                    team(2)
                    numControlledRegionsLessOrEqualTo = -1
                }
            }

            livingWorldRegionCampaign {
                name = "CustomRegion"

                concurrentRegionBonus {
                    armyBonus = 1
                    resourceBonus = 2
                    legendaryBonus = 3
                    attackBonus = 4
                    defenseBonus = 5
                    experienceBonus = 6
                    freeInnUnitsBonus = 7
                    freeBuilderBonus = 8

                    region(EREBOR)
                    region(DOL_GULDUR)
                }
            }
        }
        assertEquals(expectedRendering, campaign.render())
    }
    // endregion

    fun List<String>.expectMessage(message: String) {
        assertTrue(message in this, "Expected to find <$message> in $this")
    }
}
