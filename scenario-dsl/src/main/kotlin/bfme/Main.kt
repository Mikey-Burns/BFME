package bfme

import bfme.scenarios.fortressDefense
import bfme.scenarios.twoCornerChaos
import bfme.scenarios.twoCornerChaosCreateAHero
import java.io.File

fun main() {
    val scenario101 = twoCornerChaos()
    File("scenario-dsl/src/main/resources/data/ini/campaigns/scenarios/wotrscenario101.inc")
        .writeText(scenario101)
    val scenario102 = twoCornerChaosCreateAHero()
    File("scenario-dsl/src/main/resources/data/ini/campaigns/scenarios/wotrscenario102.inc")
        .writeText(scenario102)
    val scenario103 = fortressDefense()
    File("scenario-dsl/src/main/resources/data/ini/campaigns/scenarios/wotrscenario103.inc")
        .writeText(scenario103)
}
