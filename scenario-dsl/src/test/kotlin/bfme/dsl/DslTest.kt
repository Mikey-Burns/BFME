package bfme.dsl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
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
                    teams(listOf(1, 2))
                    loseIfCapitalLost = false
                    numControlledRegionsLessOrEqualTo = -1
                }

                teamDefeatCondition {
                    teams(listOf(1, 2))
                    numControlledRegionsLessOrEqualTo = -1
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