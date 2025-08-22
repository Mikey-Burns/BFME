package bfme.dsl

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

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

    fun List<String>.expectMessage(message: String) {
        assertTrue(message in this, "Expected to find <$message> in $this")
    }
}