package bfme.dsl

/**
 * Custom exception class to track violation objects and print them
 * in a readable format.
 */
class WotrException(violations: List<Violation>) : Exception(
    violations.joinToString("\n"))
