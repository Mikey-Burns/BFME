package bfme.dsl

@DslMarker
annotation class WotrDsl

interface WotrElement {

    /**
     * Validates if a DSL element has all the fields properly configured.
     * Adds all errors to the returned list.
     * Returns an empty list for a valid element.
     */
    fun validate(): List<Violation>

    fun render(): String

    val clazz: Class<out WotrElement>

    fun violation(error: String): Violation = Violation(clazz, error)
}

data class Violation(val source: Class<out WotrElement>, val error: String) {
    override fun toString(): String = "${source.name}: $error"
}