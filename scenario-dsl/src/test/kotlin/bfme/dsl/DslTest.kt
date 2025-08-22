package bfme.dsl

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.max

class DslTest {

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

    fun List<String>.expectMessage(message: String) {
        assertTrue(message in this, "Expected to find <$message> in $this")
    }
}