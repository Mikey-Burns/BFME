package bfme.scenarios

import bfme.domain.Army.*
import bfme.domain.Building.*
import bfme.domain.Territory
import bfme.domain.Territory.*
import bfme.dsl.livingWorldCampaign

/**
 * Generate the 2 Corner Chaos scenario.
 */
fun twoCornerChaos(): String = livingWorldCampaign {
    name = "2 Corner Chaos"
    description =
        "This is a 6 player game with preset starting locations where two humans are split between the north-east and south-west"
    number = 101

    scenario {
        name = "LWScenario:WOTRScenario101"
        description = "LWScenario:WOTRScenario101Description"
        gameType = "LWScenario:WOTRGameType003"
        objectives = "LWScenario:WOTRObjectives005"
        fiction = "LWScenario:WOTRScenarioFiction003"
        victoriousText = "LWScenario:WOTRScenarioWin101"
        defeatedText = "LWScenario:WOTRScenarioLose101"
        minPlayers = 6
        maxPlayers = 6

        val defaultStarts = listOf(IRON_HILLS, BELFALAS, FANGORN, GAP_OF_ROHAN, HIGH_PASS, DUNLAND)
        (Territory.entries - defaultStarts.toSet()).forEach { disallowStart(it) }
        defaultStarts.forEach { defaultStart(it) }

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
            region(IRON_HILLS)
            teams = 1
        }

        startingRestriction {
            region(BELFALAS)
            teams = 1
        }

        startingRestriction {
            region(FANGORN)
            teams = 2
        }

        startingRestriction {
            region(GAP_OF_ROHAN)
            teams = 2
        }

        startingRestriction {
            region(HIGH_PASS)
            teams = 2
        }

        startingRestriction {
            region(DUNLAND)
            teams = 2
        }

        ownershipSet {
            label = "Player One"
            startRegion = IRON_HILLS
            region(IRON_HILLS)
            region(ANFALAS)

            spawnArmies {
                army(HERO_ARMY_1)
                army(GARRISON_ARMY_1)
                region = IRON_HILLS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = IRON_HILLS
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(GARRISON_ARMY_1)
                region = BELFALAS
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = BELFALAS
            }

            spawnBuildings {
                building(FORTRESS)
                building(ARMORY)
                building(BARRACKS)
                region = IRON_HILLS
            }

            spawnBuildings {
                building(FORTRESS)
                building(BARRACKS)
                region = ANFALAS
            }
        }

        ownershipSet {
            label = "Player Two"
            startRegion = BELFALAS
            region(BELFALAS)
            region(RHUN)

            spawnArmies {
                army(HERO_ARMY_1)
                army(GARRISON_ARMY_1)
                region = BELFALAS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = BELFALAS
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(GARRISON_ARMY_1)
                region = IRON_HILLS
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = IRON_HILLS
            }

            spawnBuildings {
                building(FORTRESS)
                building(ARMORY)
                building(BARRACKS)
                region = BELFALAS
            }

            spawnBuildings {
                building(FORTRESS)
                building(ARMORY)
                building(BARRACKS)
                region = RHUN
            }
        }

        ownershipSet {
            label = "Computer 1"
            startRegion = FANGORN
            region(FANGORN)
            region(FORLINDON)

            spawnArmies {
                army(HERO_ARMY_1)
                army(GARRISON_ARMY_1)
                region = FANGORN
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = FORLINDON
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = HIGH_PASS
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = DUNLAND
            }

            spawnBuildings {
                building(FARM)
                building(FARM)
                region = FANGORN
            }

            spawnBuildings {
                building(FORTRESS)
                building(BARRACKS)
                region = FORLINDON
            }
        }

        ownershipSet {
            label = "Computer 2"
            startRegion = GAP_OF_ROHAN
            region(GAP_OF_ROHAN)
            region(HARLINDON)

            spawnArmies {
                army(HERO_ARMY_1)
                region = HARLINDON
            }

            spawnArmies {
                army(HERO_ARMY_2)
                army(GARRISON_ARMY_1)
                region = GAP_OF_ROHAN
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = HIGH_PASS
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = DUNLAND
            }

            spawnBuildings {
                building(FARM)
                building(FARM)
                region = GAP_OF_ROHAN
            }

            spawnBuildings {
                building(FORTRESS)
                building(BARRACKS)
                region = HARLINDON
            }
        }

        ownershipSet {
            label = "Computer 3"
            startRegion = HIGH_PASS
            region(HIGH_PASS)
            region(FORODWAITH)

            spawnArmies {
                army(HERO_ARMY_1)
                region = FANGORN
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = GAP_OF_ROHAN
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(GARRISON_ARMY_1)
                region = HIGH_PASS
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = FORODWAITH
            }

            spawnBuildings {
                building(FARM)
                building(FARM)
                region = HIGH_PASS
            }

            spawnBuildings {
                building(FORTRESS)
                building(BARRACKS)
                region = FORODWAITH
            }
        }

        ownershipSet {
            label = "Computer 4"
            startRegion = DUNLAND
            region(DUNLAND)
            region(ARTHEDAIN)

            spawnArmies {
                army(HERO_ARMY_1)
                region = FANGORN
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = GAP_OF_ROHAN
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = ARTHEDAIN
            }

            spawnArmies {
                army(HERO_ARMY_4)
                army(GARRISON_ARMY_1)
                region = DUNLAND
            }

            spawnBuildings {
                building(FARM)
                building(FARM)
                region = DUNLAND
            }

            spawnBuildings {
                building(FORTRESS)
                building(BARRACKS)
                region = ARTHEDAIN
            }
        }
    }
}
    .render()
