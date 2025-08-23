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
        }
    }
        .render()
        .let(::println)
}