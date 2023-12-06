package treasureisland.game

import treasureisland.util.GameConstants as GC

class GameController(
    private val game: Game = Game(),
    private val userInputHandler: UserInputHandler = UserInputHandler()
) {

    fun run() {
        game.start()

        while (true) {

            var userInput: Pair<Int, Int>

            while (true) {
                userInput = userInputHandler.getUserInput()

                // check if cell has already been revealed
                if (!game.island.revealedCells.contains(userInput)) break
                println("Cell already revealed, try again!")

            }

            // update the game state
            game.update(userInput)

            // break if game is over
            if (game.isGameOver) {
                break
            }

            // check surrounding cells and print clues
            println("${GC.MAGENTA}${generateClues(userInput)}${GC.COLOR_RESET}\n")

        }

    }

    private fun generateClues(cell: Pair<Int, Int>): String {
        val treasureMessage = isTreasureNearby(cell)
        val pirateMessage = isPirateNearby(cell)

        return when {
            treasureMessage != null && pirateMessage != null -> "$treasureMessage\n$pirateMessage"
            treasureMessage != null -> treasureMessage
            pirateMessage != null -> pirateMessage
            else -> "\uD83D\uDD0E No treasures or pirates detected around."
        }
    }

    private fun isTreasureNearby(cell: Pair<Int, Int>): String? {

        val treasureClue = "\uD83D\uDD0E ${GC.GREEN}T${GC.MAGENTA} You sense a treasure nearby!"

        for (currentRow in cell.first - 1..cell.first + 1) {
            for (currentCol in cell.second - 1..cell.second + 1) {

                if (currentRow == cell.first && currentCol == cell.second) {
                    continue  // Skip the revealed cell
                }

                if (game.island.treasures.any { it.coordinates == Pair(currentRow, currentCol) }) {
                    return treasureClue
                }
            }
        }

        return null
    }

    private fun isPirateNearby(cell: Pair<Int, Int>): String? {

        val pirateClue = "\uD83D\uDD0E ${GC.RED}X${GC.MAGENTA} Pirates are lurking around here."

        for (currentRow in cell.first - 1..cell.first + 1) {
            for (currentCol in cell.second - 1..cell.second + 1) {

                if (currentRow == cell.first && currentCol == cell.second) {
                    continue  // Skip the revealed cell
                }

                if (game.island.pirates.any { it.coordinates == Pair(currentRow, currentCol) }) {
                    return pirateClue
                }
            }
        }
        return null
    }

}
