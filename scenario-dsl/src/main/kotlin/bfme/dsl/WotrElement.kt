package bfme.dsl

/**
 * Annotation class to mark our DSL classes as such.
 */
@DslMarker
annotation class WotrDsl

/**
 * Interface for common methods that all elements of the DSL must implement.
 */
interface WotrElement {

    /**
     * Validates if a DSL element has all the fields properly configured.
     * Adds all errors to the returned list.
     * Returns an empty list for a valid element.
     */
    fun validate(): List<Violation>

    /**
     * Renders a DSL element as a printable String to be used in a scenario file.
     * Internally this should call validate() to ensure we write valid files.
     */
    fun render(): String

    /**
     * Field for the implementing class.
     * This is used to make violations easy to group.
     */
    val clazz: Class<out WotrElement>

    /**
     * Helper to log a violation in an invalid scenario setup.
     */
    fun violation(error: String): Violation = Violation(clazz, error)
}

/**
 * Helper class to represent an invalid field in our DSL.
 */
data class Violation(val source: Class<out WotrElement>, val error: String) {
    override fun toString(): String = "${source.name}: $error"
}

/**
 * Helper to render elements with the correct indentation for human-readable scenario files.
 */
fun StringBuilder.appendLine(indentDepth: Int, line: String): StringBuilder =
    appendLine("    ".repeat(indentDepth) + line)
