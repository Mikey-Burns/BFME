package bfme.dsl

class WotrException(violations: List<Violation>) : Exception(
    violations.joinToString("\n"))