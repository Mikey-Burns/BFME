package bfme.scenarios

import bfme.domain.Army.*
import bfme.domain.Building.*
import bfme.domain.Faction
import bfme.domain.Faction.DWARVES
import bfme.domain.Territory
import bfme.domain.Territory.*
import bfme.dsl.livingWorldCampaign

/**
 * Generate the Erebor Madness scenario.
 */
fun ereborMadness(): String = livingWorldCampaign {
    name = "Erebor Madness"
    description =
        "This is a 6 player game with preset starting locations where the humans control Erebor and Dol Guldur.  The AI control the surrounding territories." +
                "\n// The AI spawns increasingly large armies every turn in their home bases for 10 turns, even if the territory has been captured." +
                "\n// To win, the humans must control at least one fortress for 10 turns.  If both fortress fall, they lose."
    number = 105

    scenario {
        name = "LWScenario:WOTRScenario105"
        description = "LWScenario:WOTRScenario105Description"
        gameType = "LWScenario:WOTRGameType003"
        objectives = "LWScenario:WOTRObjectives005"
        fiction = "LWScenario:WOTRScenarioFiction003"
        victoriousText = "LWScenario:WOTRScenarioWin101"
        defeatedText = "LWScenario:WOTRScenarioLose101"
        customVictoryCondition = true
        minPlayers = 6
        maxPlayers = 6

        val defaultStarts = listOf(DOL_GULDUR, EREBOR, CELDUIN, MIRKWOOD, IRON_HILLS, DAGORLAD)
        (Territory.entries - defaultStarts.toSet()).forEach { disable(it) }
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

        teamVictoryCondition {
            team(1)
            region(DOL_GULDUR)
            region(EREBOR)
            numTurns = 10
        }

        teamVictoryCondition {
            team(2)
            region(DOL_GULDUR)
            region(EREBOR)
            numTurns = 1
        }

        startingRestriction {
            region(DOL_GULDUR)
            teams = 1
            faction(Faction.ELVES)
        }

        startingRestriction {
            region(EREBOR)
            teams = 1
            faction(Faction.MEN)
        }

        startingRestriction {
            region(CELDUIN)
            teams = 2
            faction(Faction.MORDOR)
        }

        startingRestriction {
            region(MIRKWOOD)
            teams = 2
            faction(DWARVES)
        }

        startingRestriction {
            region(IRON_HILLS)
            teams = 2
            faction(Faction.ISENGARD)
        }

        startingRestriction {
            region(DAGORLAD)
            teams = 2
            faction(Faction.ANGMAR)
        }

        ownershipSet {
            label = "Player One"
            startRegion = DOL_GULDUR
            region(DOL_GULDUR)

            spawnArmies {
                army(HERO_ARMY_1)
                army(HERO_ARMY_2)
                army(HERO_ARMY_3)
                army(HERO_ARMY_5)
                region = DOL_GULDUR
            }

            spawnArmies {
                army(EXTRA_HERO_ONE_ARMY)
                army(EXTRA_HERO_TWO_ARMY)
                region = EREBOR
            }

            spawnBuildings {
                building(ARMORY)
                region = DOL_GULDUR
            }
        }

        ownershipSet {
            label = "Player Two"
            startRegion = EREBOR
            region(EREBOR)

            spawnArmies {
                army(HERO_ARMY_1)
                army(HERO_ARMY_2)
                army(HERO_ARMY_3)
                army(HERO_ARMY_5)
                region = EREBOR
            }

            spawnArmies {
                army(EXTRA_HERO_ONE_ARMY)
                army(EXTRA_HERO_TWO_ARMY)
                region = DOL_GULDUR
            }

            spawnBuildings {
                building(ARMORY)
                region = EREBOR
            }
        }

        ownershipSet {
            label = "Computer 1"
            startRegion = CELDUIN
            region(CELDUIN)


            spawnArmies {
                army(HERO_ARMY_1)
                region = CELDUIN
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = MIRKWOOD
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = IRON_HILLS
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = DAGORLAD
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = CELDUIN
            }
        }

        ownershipSet {
            label = "Computer 2"
            startRegion = MIRKWOOD
            region(MIRKWOOD)

            spawnArmies {
                army(HERO_ARMY_1)
                region = MIRKWOOD
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = IRON_HILLS
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = DAGORLAD
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = CELDUIN
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = MIRKWOOD
            }
        }

        ownershipSet {
            label = "Computer 3"
            startRegion = IRON_HILLS
            region(IRON_HILLS)

            spawnArmies {
                army(HERO_ARMY_1)
                region = IRON_HILLS
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = DAGORLAD
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = CELDUIN
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = MIRKWOOD
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                building(BARRACKS)
                region = IRON_HILLS
            }
        }

        ownershipSet {
            label = "Computer 4"
            startRegion = DAGORLAD
            region(DAGORLAD)

            spawnArmies {
                army(HERO_ARMY_1)
                region = DAGORLAD
            }

            spawnArmies {
                army(HERO_ARMY_2)
                region = CELDUIN
            }

            spawnArmies {
                army(HERO_ARMY_3)
                region = MIRKWOOD
            }

            spawnArmies {
                army(HERO_ARMY_4)
                region = IRON_HILLS
            }

            spawnBuildings {
                building(FORTRESS)
                building(FARM)
                region = DAGORLAD
            }
        }
    }

    // Act time
    val teamTwoFactions = listOf(Faction.MORDOR, DWARVES, Faction.ISENGARD, Faction.ANGMAR)
    val acts = listOf(
        "Two" to listOf(HERO_ARMY_5, FORTRESS_ATTACK_ARMY),
        "Three" to listOf(GARRISON_ARMY_1, GARRISON_ARMY_1),
        "Four" to listOf(FORTRESS_ATTACK_ARMY, FORTRESS_DEFENSE_ARMY),
        "Five" to listOf(GARRISON_ARMY_1, FORTRESS_ATTACK_ARMY, FORTRESS_DEFENSE_ARMY),
        "Six" to listOf(
            SPECIALTY_ONE_ARMY, SPECIALTY_ONE_ARMY, SPECIALTY_ONE_ARMY,
            GARRISON_ARMY_1, GARRISON_ARMY_1, GARRISON_ARMY_1
        ),
        "Seven" to listOf(
            SPECIALTY_TWO_ARMY, SPECIALTY_TWO_ARMY, SPECIALTY_TWO_ARMY,
            GARRISON_ARMY_1, GARRISON_ARMY_1, GARRISON_ARMY_1
        ),
        "Eight" to listOf(FORTRESS_ATTACK_ARMY, FORTRESS_ATTACK_ARMY, FORTRESS_ATTACK_ARMY, ELITE_ARMY),
        "Nine" to listOf(
            FORTRESS_ATTACK_ARMY, FORTRESS_ATTACK_ARMY, FORTRESS_ATTACK_ARMY, ELITE_ARMY,
            SPECIALTY_THREE_ARMY, SPECIALTY_THREE_ARMY, SPECIALTY_THREE_ARMY
        ),
        "Ten" to listOf(
            FORTRESS_ATTACK_ARMY, FORTRESS_ATTACK_ARMY, FORTRESS_ATTACK_ARMY, ELITE_ARMY,
            SPECIALTY_THREE_ARMY, SPECIALTY_THREE_ARMY, SPECIALTY_THREE_ARMY,
            SPECIALTY_ONE_ARMY, SPECIALTY_ONE_ARMY, SPECIALTY_ONE_ARMY,
            SPECIALTY_TWO_ARMY, SPECIALTY_TWO_ARMY, SPECIALTY_TWO_ARMY,
            RING_ARMY
        ),
    )

    acts.forEach { (actNumber, armiesToSpawn) ->
        act {
            number = actNumber
            teamTwoFactions.forEach { enemyFaction ->
                armiesToSpawn.forEach { armyToSpawn ->
                    armyEntry {
                        name = "ExtraArmy"
                        faction = enemyFaction
                        army = armyToSpawn
                    }
                }
            }
        }
    }

    livingWorldRegionCampaign {
        name = "FortressRegion"

        concurrentRegionBonus {
            armyBonus = 0
            resourceBonus = 30 * 2
            legendaryBonus = 55 * 2
            attackBonus = 0
            defenseBonus = 20 * 2
            experienceBonus = 20 * 2
            freeInnUnitsBonus = 0
            freeBuilderBonus = 0

            region(DOL_GULDUR)
            region(EREBOR)
        }
    }
}
    .render()
