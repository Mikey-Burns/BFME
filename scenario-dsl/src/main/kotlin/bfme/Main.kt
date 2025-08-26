package bfme

import bfme.domain.Army.*
import bfme.domain.Building.*
import bfme.domain.Territory.*
import bfme.dsl.livingWorldCampaign

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    livingWorldCampaign {
        name = "Fortress Defense"
        description =
            "This is a 6 player game with preset starting locations where the humans control the fortresses, and the AI control the rest."
        number = 103

        scenario {
            name = "LWScenario:WOTRScenario103"

            playerDefeatCondition {
                teams(listOf(1, 2))
                loseIfCapitalLost = false
                numControlledRegionsLessOrEqualTo = -1
            }

            teamDefeatCondition {
                teams(listOf(1, 2))
                numControlledRegionsLessOrEqualTo = -1
            }

            ownershipSet {
                startRegion = THE_SHIRE
                region(AMON_SUL)
                region(DOL_GULDUR)

                spawnArmies {
                    army(HERO_ARMY_1)
                    region = THE_SHIRE
                }

                spawnBuildings {
                    building(FORTRESS)
                    region = AMON_SUL
                }
            }
        }
    }
        .render()
        .let(::println)
}