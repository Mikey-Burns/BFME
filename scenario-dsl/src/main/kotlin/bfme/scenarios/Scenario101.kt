package bfme.scenarios

import bfme.domain.Army
import bfme.domain.Building
import bfme.domain.Territory
import bfme.dsl.livingWorldCampaign

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

        disallowStart(Territory.AMON_SUL)
        disallowStart(Territory.ANFALAS)
        disallowStart(Territory.ANGMAR)
        disallowStart(Territory.ARTHEDAIN)
        disallowStart(Territory.BARROW_DOWNS)
        disallowStart(Territory.CAIR_ANDROS)
        disallowStart(Territory.CARDOLAN)
        disallowStart(Territory.CARN_DUM)
        disallowStart(Territory.CARROCK)
        disallowStart(Territory.CELDUIN)
        disallowStart(Territory.DAGORLAD)
        disallowStart(Territory.DOL_GULDUR)
        disallowStart(Territory.ENEDWAITH)
        disallowStart(Territory.EREBOR)
        disallowStart(Territory.ETTENMOORS)
        disallowStart(Territory.FORLINDON)
        disallowStart(Territory.FORNOST)
        disallowStart(Territory.FORODWAITH)
        disallowStart(Territory.GREY_HAVENS)
        disallowStart(Territory.HARAD)
        disallowStart(Territory.HARLINDON)
        disallowStart(Territory.HELMS_DEEP)
        disallowStart(Territory.ISENGARD)
        disallowStart(Territory.ITHILIEN)
        disallowStart(Territory.LOSTRIAND)
        disallowStart(Territory.LORIEN)
        disallowStart(Territory.MINAS_MORGUL)
        disallowStart(Territory.MINAS_TIRITH)
        disallowStart(Territory.MINHIRIATH)
        disallowStart(Territory.MIRKWOOD)
        disallowStart(Territory.MORDOR)
        disallowStart(Territory.MOUNT_DOOM)
        disallowStart(Territory.MOUNT_GUNDABAD)
        disallowStart(Territory.NORTH_DOWNS)
        disallowStart(Territory.OSGILIATH)
        disallowStart(Territory.REDHORN_PASS)
        disallowStart(Territory.RHUDAUR)
        disallowStart(Territory.RHUN)
        disallowStart(Territory.RIVENDELL)
        disallowStart(Territory.ROHAN)
        disallowStart(Territory.THE_BLACK_GATE)
        disallowStart(Territory.THE_BROWN_LANDS)
        disallowStart(Territory.THE_DEAD_MARSHES)
        disallowStart(Territory.THE_SHIRE)
        disallowStart(Territory.TOWER_HILLS)
        disallowStart(Territory.UMBAR)

        defaultStart(Territory.IRON_HILLS)
        defaultStart(Territory.BELFALAS)
        defaultStart(Territory.FANGORN)
        defaultStart(Territory.GAP_OF_ROHAN)
        defaultStart(Territory.HIGH_PASS)
        defaultStart(Territory.DUNLAND)

        playerDefeatCondition {
            teams(listOf(1, 2))
            loseIfCapitalLost = false
            numControlledRegionsLessOrEqualTo = -1
        }

        teamDefeatCondition {
            teams(listOf(1, 2))
            numControlledRegionsLessOrEqualTo = -1
        }

        startingRestriction {
            region(Territory.IRON_HILLS)
            teams = 1
        }

        startingRestriction {
            region(Territory.BELFALAS)
            teams = 1
        }

        startingRestriction {
            region(Territory.FANGORN)
            teams = 2
        }

        startingRestriction {
            region(Territory.GAP_OF_ROHAN)
            teams = 2
        }

        startingRestriction {
            region(Territory.HIGH_PASS)
            teams = 2
        }

        startingRestriction {
            region(Territory.DUNLAND)
            teams = 2
        }

        ownershipSet {
            label = "Player One"
            startRegion = Territory.IRON_HILLS
            region(Territory.IRON_HILLS)
            region(Territory.ANFALAS)

            spawnArmies {
                army(Army.HERO_ARMY_1)
                army(Army.GARRISON_ARMY_1)
                region = Territory.IRON_HILLS
            }

            spawnArmies {
                army(Army.HERO_ARMY_2)
                region = Territory.IRON_HILLS
            }

            spawnArmies {
                army(Army.HERO_ARMY_3)
                army(Army.GARRISON_ARMY_1)
                region = Territory.BELFALAS
            }

            spawnArmies {
                army(Army.HERO_ARMY_4)
                region = Territory.BELFALAS
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.ARMORY)
                building(Building.BARRACKS)
                region = Territory.IRON_HILLS
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.BARRACKS)
                region = Territory.ANFALAS
            }
        }

        ownershipSet {
            label = "Player Two"
            startRegion = Territory.BELFALAS
            region(Territory.BELFALAS)
            region(Territory.RHUN)

            spawnArmies {
                army(Army.HERO_ARMY_1)
                army(Army.GARRISON_ARMY_1)
                region = Territory.BELFALAS
            }

            spawnArmies {
                army(Army.HERO_ARMY_2)
                region = Territory.BELFALAS
            }

            spawnArmies {
                army(Army.HERO_ARMY_3)
                army(Army.GARRISON_ARMY_1)
                region = Territory.IRON_HILLS
            }

            spawnArmies {
                army(Army.HERO_ARMY_4)
                region = Territory.IRON_HILLS
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.ARMORY)
                building(Building.BARRACKS)
                region = Territory.BELFALAS
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.ARMORY)
                building(Building.BARRACKS)
                region = Territory.RHUN
            }
        }

        ownershipSet {
            label = "Computer 1"
            startRegion = Territory.FANGORN
            region(Territory.FANGORN)
            region(Territory.FORLINDON)

            spawnArmies {
                army(Army.HERO_ARMY_1)
                army(Army.GARRISON_ARMY_1)
                region = Territory.FANGORN
            }

            spawnArmies {
                army(Army.HERO_ARMY_2)
                region = Territory.FORLINDON
            }

            spawnArmies {
                army(Army.HERO_ARMY_3)
                region = Territory.HIGH_PASS
            }

            spawnArmies {
                army(Army.HERO_ARMY_4)
                region = Territory.DUNLAND
            }

            spawnBuildings {
                building(Building.FARM)
                building(Building.FARM)
                region = Territory.FANGORN
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.BARRACKS)
                region = Territory.FORLINDON
            }
        }

        ownershipSet {
            label = "Computer 2"
            startRegion = Territory.GAP_OF_ROHAN
            region(Territory.GAP_OF_ROHAN)
            region(Territory.HARLINDON)

            spawnArmies {
                army(Army.HERO_ARMY_1)
                region = Territory.HARLINDON
            }

            spawnArmies {
                army(Army.HERO_ARMY_2)
                army(Army.GARRISON_ARMY_1)
                region = Territory.GAP_OF_ROHAN
            }

            spawnArmies {
                army(Army.HERO_ARMY_3)
                region = Territory.HIGH_PASS
            }

            spawnArmies {
                army(Army.HERO_ARMY_4)
                region = Territory.DUNLAND
            }

            spawnBuildings {
                building(Building.FARM)
                building(Building.FARM)
                region = Territory.GAP_OF_ROHAN
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.BARRACKS)
                region = Territory.HARLINDON
            }
        }

        ownershipSet {
            label = "Computer 3"
            startRegion = Territory.HIGH_PASS
            region(Territory.HIGH_PASS)
            region(Territory.FORODWAITH)

            spawnArmies {
                army(Army.HERO_ARMY_1)
                region = Territory.FANGORN
            }

            spawnArmies {
                army(Army.HERO_ARMY_2)
                region = Territory.GAP_OF_ROHAN
            }

            spawnArmies {
                army(Army.HERO_ARMY_3)
                army(Army.GARRISON_ARMY_1)
                region = Territory.HIGH_PASS
            }

            spawnArmies {
                army(Army.HERO_ARMY_4)
                region = Territory.FORODWAITH
            }

            spawnBuildings {
                building(Building.FARM)
                building(Building.FARM)
                region = Territory.HIGH_PASS
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.BARRACKS)
                region = Territory.FORODWAITH
            }
        }

        ownershipSet {
            label = "Computer 4"
            startRegion = Territory.DUNLAND
            region(Territory.DUNLAND)
            region(Territory.ARTHEDAIN)

            spawnArmies {
                army(Army.HERO_ARMY_1)
                region = Territory.FANGORN
            }

            spawnArmies {
                army(Army.HERO_ARMY_2)
                region = Territory.GAP_OF_ROHAN
            }

            spawnArmies {
                army(Army.HERO_ARMY_3)
                region = Territory.ARTHEDAIN
            }

            spawnArmies {
                army(Army.HERO_ARMY_4)
                army(Army.GARRISON_ARMY_1)
                region = Territory.DUNLAND
            }

            spawnBuildings {
                building(Building.FARM)
                building(Building.FARM)
                region = Territory.DUNLAND
            }

            spawnBuildings {
                building(Building.FORTRESS)
                building(Building.BARRACKS)
                region = Territory.ARTHEDAIN
            }
        }
    }
}
    .render()
    .also(::println)