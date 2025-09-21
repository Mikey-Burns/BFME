package bfme.scenarios

import bfme.domain.Army.*
import bfme.domain.Building.*
import bfme.domain.Faction
import bfme.domain.Faction.DWARVES
import bfme.domain.Territory
import bfme.domain.Territory.*
import bfme.dsl.livingWorldCampaign

/**
 * Generate the Fortress Defense scenario.
 */
fun fortressDefenseEscalation(): String = livingWorldCampaign {
    name = "Fortress Defense - Escalation"
    description =
        "This is a 6 player game with preset starting locations where the humans control the fortresses, and the AI control the rest." +
                "\n// The AI spawns increasingly large armies every turn in their home bases for 10 turns, even if the territory has been captured."
    number = 104

    scenario {
        name = "LWScenario:WOTRScenario104"
        description = "LWScenario:WOTRScenario104Description"
        gameType = "LWScenario:WOTRGameType003"
        objectives = "LWScenario:WOTRObjectives005"
        fiction = "LWScenario:WOTRScenarioFiction003"
        victoriousText = "LWScenario:WOTRScenarioWin101"
        defeatedText = "LWScenario:WOTRScenarioLose101"
        minPlayers = 6
        maxPlayers = 6

        val defaultStarts = listOf(THE_SHIRE, MINAS_TIRITH, MOUNT_DOOM, IRON_HILLS, FANGORN, ANFALAS)
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
            teams = 1
            faction(Faction.MEN)
            faction(Faction.ELVES)
        }

        startingRestriction {
            region(MINAS_TIRITH)
            teams = 1
            faction(Faction.MEN)
            faction(Faction.ELVES)
        }

        startingRestriction {
            region(MOUNT_DOOM)
            teams = 2
            faction(Faction.MORDOR)
            faction(DWARVES)
            faction(Faction.ISENGARD)
            faction(Faction.ANGMAR)
            faction(Faction.GOBLINS)
        }

        startingRestriction {
            region(IRON_HILLS)
            teams = 2
            faction(Faction.MORDOR)
            faction(DWARVES)
            faction(Faction.ISENGARD)
            faction(Faction.ANGMAR)
            faction(Faction.GOBLINS)
        }

        startingRestriction {
            region(FANGORN)
            teams = 2
            faction(Faction.MORDOR)
            faction(DWARVES)
            faction(Faction.ISENGARD)
            faction(Faction.ANGMAR)
            faction(Faction.GOBLINS)
        }

        startingRestriction {
            region(ANFALAS)
            teams = 2
            faction(Faction.MORDOR)
            faction(DWARVES)
            faction(Faction.ISENGARD)
            faction(Faction.ANGMAR)
            faction(Faction.GOBLINS)
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
                building(SUPER_FARM)
                region = DOL_GULDUR
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = HELMS_DEEP
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = MINAS_MORGUL
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = RIVENDELL
            }

            spawnBuildings {
                building(FARM)
                building(FARM)
                region = THE_SHIRE
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = FORNOST
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
                building(SUPER_FARM)
                region = AMON_SUL
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = CARN_DUM
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = EREBOR
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = ISENGARD
            }

            spawnBuildings {
                building(SUPER_FARM)
                region = MINAS_TIRITH
            }
        }

        ownershipSet {
            label = "Computer 1"
            startRegion = MOUNT_DOOM
            region(ANGMAR)
            region(CAIR_ANDROS)
            region(BARROW_DOWNS)
            region(CELDUIN)
            region(ETTENMOORS)
            region(HIGH_PASS)
            region(MIRKWOOD)
            region(MOUNT_DOOM)
            region(REDHORN_PASS)
            region(RHUN)

            spawnArmies {
                army(HERO_ARMY_1)
                army(FORTRESS_ATTACK_ARMY)
                region = MOUNT_DOOM
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
                region = ROHAN
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
                building(FARM)
                region = MOUNT_DOOM
            }

            spawnBuildings {
                building(FORTRESS)
                region = REDHORN_PASS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = RHUN
            }
        }

        ownershipSet {
            label = "Computer 2"
            startRegion = IRON_HILLS
            region(BELFALAS)
            region(THE_BLACK_GATE)
            region(ARTHEDAIN)
            region(NORTH_DOWNS)
            region(DAGORLAD)
            region(HARAD)
            region(LOSTRIAND)
            region(MORDOR)
            region(IRON_HILLS)
            region(UMBAR)

            spawnArmies {
                army(HERO_ARMY_1)
                army(FORTRESS_ATTACK_ARMY)
                region = NORTH_DOWNS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                army(FORTRESS_ATTACK_ARMY)
                region = IRON_HILLS
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
                building(BARRACKS)
                region = IRON_HILLS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = UMBAR
            }
        }

        ownershipSet {
            label = "Computer 3"
            startRegion = FANGORN
            region(FANGORN)
            region(THE_BROWN_LANDS)
            region(FORLINDON)
            region(CARDOLAN)
            region(DUNLAND)
            region(HARLINDON)
            region(LORIEN)
            region(MOUNT_GUNDABAD)
            region(ROHAN)
            region(RHUDAUR)

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
                region = DAGORLAD
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
                building(BARRACKS)
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
                building(BARRACKS)
                region = ROHAN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = RHUDAUR
            }
        }

        ownershipSet {
            label = "Computer 4"
            startRegion = ANFALAS
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
            region(ANFALAS)

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
                region = FORODWAITH
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
                region = ANFALAS
            }
        }
    }

    val teamTwoFactions = (Faction.entries - Faction.ELVES - Faction.MEN)

    listOf(
        listOf("Two", "Three", "Four"),
        listOf("Five", "Six", "Seven"),
        listOf("Eight", "Nine", "Ten")
    )
        .forEachIndexed { index, turns ->
            turns.forEach { turnNumber ->
                act {
                    number = turnNumber
                    teamTwoFactions.forEach { myFaction ->
                        repeat(index + 1) {
                            armyEntry {
                                name = "ExtraArmy"
                                faction = myFaction
                                army = FORTRESS_ATTACK_ARMY
                            }
                        }
                    }
                }
            }
        }
}
    .render()
