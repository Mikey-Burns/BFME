package bfme.domain

/**
 * Enumeration of the different buildings we can spawn at the start of a scenario.
 * When adding a new building, it must also be added to data/ini/campaigns/riskcampaign.inc
 */
enum class Building(val codeName: String) {
    FORTRESS("LW_FORT"),
    BARRACKS("LW_BARRACKS"),
    ARMORY("LW_ARMORY"),
    FARM("LW_FARM"),
}
