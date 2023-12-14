package treasureisland.util

object GameConstants {

    // ANSI color constants
    const val COLOR_RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val BLUE = "\u001B[34m"
    const val YELLOW = "\u001B[33m"
    const val MAGENTA = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val CLEAR_SCREEN = "\u001b[H\u001b[2J"

    // Cell entities constants
    const val TREASURE_CELL = "$GREEN T $COLOR_RESET"
    const val PIRATE_CELL = "$RED X $COLOR_RESET"
    const val EMPTY_CELL = "$BLUE □ $COLOR_RESET"

    // Treasure constants
    val TREASURE_VALUES = listOf(100, 200, 500, 1000)

    // Pirate constants
    val PIRATE_PERCENT_OFF = listOf(10, 10, 20, 20, 50)
}
