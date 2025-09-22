package bfme.scenarios

import bfme.domain.Army.*
import bfme.domain.Building.*
import bfme.domain.Territory
import bfme.domain.Territory.*
import bfme.dsl.livingWorldCampaign

/**
 * Generate the Fortress Defense scenario.
 */
fun fortressDefense(): String = livingWorldCampaign {
    name = "Fortress Defense"
    description =
        "This is a 6 player game with preset starting locations where the humans control the fortresses, and the AI control the rest."
    number = 103

    scenario {
        name = "LWScenario:WOTRScenario103"
        description = "LWScenario:WOTRScenario103Description"
        gameType = "LWScenario:WOTRGameType003"
        objectives = "LWScenario:WOTRObjectives005"
        fiction = "LWScenario:WOTRScenarioFiction003"
        victoriousText = "LWScenario:WOTRScenarioWin101"
        defeatedText = "LWScenario:WOTRScenarioLose101"
        customVictoryCondition = true
        minPlayers = 6
        maxPlayers = 6

        val defaultStarts = listOf(THE_SHIRE, MINAS_TIRITH, ANFALAS, BELFALAS, FANGORN, GAP_OF_ROHAN)
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
            region(THE_SHIRE)
            region(MINAS_TIRITH)
            teams = 1
        }

        startingRestriction {
            region(ANFALAS)
            region(BELFALAS)
            region(FANGORN)
            region(GAP_OF_ROHAN)
            teams = 2
        }

        ownershipSet {
            label = "Player One"
            startRegion = THE_SHIRE
            region(DOL_GULDUR)
            region(FORNOST)
            region(HELMS_DEEP)
            region(MINAS_MORGUL)
            region(RIVENDELL)
            region(THE_SHIRE)

            spawnArmies {
                army(HERO_ARMY_1)
                army(HERO_ARMY_2)
                army(HERO_ARMY_3)
                army(HERO_ARMY_4)
                army(HERO_ARMY_5)
                army(GARRISON_ARMY_1)
                army(GARRISON_ARMY_1)
                region = THE_SHIRE
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = AMON_SUL
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = DOL_GULDUR
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = HELMS_DEEP
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = MINAS_MORGUL
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = RIVENDELL
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = CARN_DUM
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = EREBOR
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = FORNOST
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = ISENGARD
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = MINAS_TIRITH
            }

            spawnBuildings {
                building(FARM)
                region = DOL_GULDUR
            }

            spawnBuildings {
                building(FARM)
                region = FORNOST
            }

            spawnBuildings {
                building(FARM)
                region = HELMS_DEEP
            }

            spawnBuildings {
                building(FARM)
                region = MINAS_MORGUL
            }

            spawnBuildings {
                building(FARM)
                region = RIVENDELL
            }

            spawnBuildings {
                building(FARM)
                building(FARM)
                region = THE_SHIRE
            }
        }

        ownershipSet {
            label = "Player Two"
            startRegion = MINAS_TIRITH
            region(AMON_SUL)
            region(CARN_DUM)
            region(EREBOR)
            region(ISENGARD)
            region(MINAS_TIRITH)

            spawnArmies {
                army(HERO_ARMY_1)
                army(HERO_ARMY_2)
                army(HERO_ARMY_3)
                army(HERO_ARMY_4)
                army(HERO_ARMY_5)
                army(GARRISON_ARMY_1)
                army(GARRISON_ARMY_1)
                region = THE_SHIRE
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = AMON_SUL
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = DOL_GULDUR
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = HELMS_DEEP
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = MINAS_MORGUL
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = RIVENDELL
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = CARN_DUM
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = EREBOR
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = FORNOST
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = ISENGARD
            }

            spawnArmies {
                army(FORTRESS_DEFENSE_ARMY)
                region = MINAS_TIRITH
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = AMON_SUL
            }

            spawnBuildings {
                building(FARM)
                region = CARN_DUM
            }

            spawnBuildings {
                building(FARM)
                region = EREBOR
            }

            spawnBuildings {
                building(FARM)
                region = ISENGARD
            }

            spawnBuildings {
                building(FARM)
                region = MINAS_TIRITH
            }
        }

        ownershipSet {
            label = "Computer 1"
            startRegion = ANFALAS
            region(ANFALAS)
            region(IRON_HILLS)
            region(ANGMAR)
            region(CAIR_ANDROS)
            region(BARROW_DOWNS)
            region(CELDUIN)
            region(ETTENMOORS)
            region(HIGH_PASS)
            region(MIRKWOOD)
            region(REDHORN_PASS)

            spawnArmies {
                army(HERO_ARMY_1)
                army(FORTRESS_ATTACK_ARMY)
                region = NORTH_DOWNS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                army(FORTRESS_ATTACK_ARMY)
                region = GAP_OF_ROHAN
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(FORTRESS_ATTACK_ARMY)
                region = RHUDAUR
            }

            spawnArmies {
                army(HERO_ARMY_4)
                army(FORTRESS_ATTACK_ARMY)
                region = OSGILIATH
            }

            spawnArmies {
                army(HERO_ARMY_5)
                army(FORTRESS_ATTACK_ARMY)
                region = THE_DEAD_MARSHES
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = ANFALAS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = IRON_HILLS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = ANGMAR
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = CAIR_ANDROS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = BARROW_DOWNS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = CELDUIN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = ETTENMOORS
            }

            spawnBuildings {
                building(FORTRESS)
                region = HIGH_PASS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = MIRKWOOD
            }

            spawnBuildings {
                building(FORTRESS)
                region = REDHORN_PASS
            }
        }

        ownershipSet {
            label = "Computer 2"
            startRegion = BELFALAS
            region(BELFALAS)
            region(THE_BLACK_GATE)
            region(MOUNT_DOOM)
            region(ARTHEDAIN)
            region(NORTH_DOWNS)
            region(DAGORLAD)
            region(HARAD)
            region(LOSTRIAND)
            region(MORDOR)
            region(RHUDAUR)

            spawnArmies {
                army(HERO_ARMY_1)
                army(FORTRESS_ATTACK_ARMY)
                region = NORTH_DOWNS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                army(FORTRESS_ATTACK_ARMY)
                region = MIRKWOOD
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(FORTRESS_ATTACK_ARMY)
                region = FANGORN
            }

            spawnArmies {
                army(HERO_ARMY_4)
                army(FORTRESS_ATTACK_ARMY)
                region = FORODWAITH
            }

            spawnArmies {
                army(HERO_ARMY_5)
                army(FORTRESS_ATTACK_ARMY)
                region = OSGILIATH
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = BELFALAS
            }

            spawnBuildings {
                building(FORTRESS)
                region = THE_BLACK_GATE
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = MOUNT_DOOM
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = ARTHEDAIN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = NORTH_DOWNS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = DAGORLAD
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = HARAD
            }

            spawnBuildings {
                building(FORTRESS)
                region = LOSTRIAND
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = MORDOR
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = RHUDAUR
            }
        }

        ownershipSet {
            label = "Computer 3"
            startRegion = FANGORN
            region(FANGORN)
            region(THE_BROWN_LANDS)
            region(RHUN)
            region(FORLINDON)
            region(CARDOLAN)
            region(DUNLAND)
            region(HARLINDON)
            region(LORIEN)
            region(MOUNT_GUNDABAD)
            region(ROHAN)

            spawnArmies {
                army(HERO_ARMY_1)
                army(FORTRESS_ATTACK_ARMY)
                region = FANGORN
            }

            spawnArmies {
                army(HERO_ARMY_2)
                army(FORTRESS_ATTACK_ARMY)
                region = MIRKWOOD
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(FORTRESS_ATTACK_ARMY)
                region = FORODWAITH
            }

            spawnArmies {
                army(HERO_ARMY_4)
                army(FORTRESS_ATTACK_ARMY)
                region = RHUDAUR
            }

            spawnArmies {
                army(HERO_ARMY_5)
                army(FORTRESS_ATTACK_ARMY)
                region = THE_DEAD_MARSHES
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = FANGORN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = THE_BROWN_LANDS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = RHUN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = FORLINDON
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = CARDOLAN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = DUNLAND
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = HARLINDON
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = LORIEN
            }

            spawnBuildings {
                building(FORTRESS)
                region = MOUNT_GUNDABAD
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = ROHAN
            }
        }

        ownershipSet {
            label = "Computer 4"
            startRegion = GAP_OF_ROHAN
            region(GAP_OF_ROHAN)
            region(THE_DEAD_MARSHES)
            region(GREY_HAVENS)
            region(CARROCK)
            region(FORODWAITH)
            region(ENEDWAITH)
            region(ITHILIEN)
            region(MINHIRIATH)
            region(OSGILIATH)
            region(TOWER_HILLS)
            region(UMBAR)

            spawnArmies {
                army(HERO_ARMY_1)
                army(FORTRESS_ATTACK_ARMY)
                region = NORTH_DOWNS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                army(FORTRESS_ATTACK_ARMY)
                region = MIRKWOOD
            }

            spawnArmies {
                army(HERO_ARMY_3)
                army(FORTRESS_ATTACK_ARMY)
                region = FANGORN
            }

            spawnArmies {
                army(HERO_ARMY_4)
                army(FORTRESS_ATTACK_ARMY)
                region = OSGILIATH
            }

            spawnArmies {
                army(HERO_ARMY_5)
                army(FORTRESS_ATTACK_ARMY)
                region = GAP_OF_ROHAN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = GAP_OF_ROHAN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = THE_DEAD_MARSHES
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = GREY_HAVENS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = CARROCK
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = FORODWAITH
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = ENEDWAITH
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = ITHILIEN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = MINHIRIATH
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = OSGILIATH
            }

            spawnBuildings {
                building(FORTRESS)
                region = TOWER_HILLS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = UMBAR
            }
        }
    }
}
    .render()
