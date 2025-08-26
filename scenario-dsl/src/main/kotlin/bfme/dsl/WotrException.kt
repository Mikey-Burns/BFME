package bfme.dsl

class WotrException(val violations: List<Violation>) : Exception(
    violations.joinToString("\n"))