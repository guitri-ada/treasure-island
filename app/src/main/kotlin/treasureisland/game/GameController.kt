package treasureisland.game

import treasureisland.util.GameConstants as GC

class GameController(
    private val game: Game = Game(),
    private var isGameOver: Boolean = false
) {

    fun run() {
        game.start()

        while (!isGameOver) {

            var userInput: Pair<Int, Int>

            while (true) {
                userInput = getUserInput()

                if (!isAlreadyRevealed(userInput)) break
                println("Cell already revealed, try again!")

            }

            game.update(userInput)

            if (game.player.treasureCount == 5) {
                game.end()
                break
            }

            println("${GC.MAGENTA}${checkSurroundings(userInput)}${GC.COLOR_RESET}\n")

        }

    }

    private fun checkSurroundings(cell: Pair<Int, Int>): String {
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

    private fun isAlreadyRevealed(cell: Pair<Int, Int>): Boolean {
        return game.island.revealedCells.contains(cell)
    }

    private fun getUserInput(): Pair<Int, Int> {
        val rowInput = getValidRow()
        val colInput = getValidColumn()
        return Pair(rowInput, colInput)
    }

    private fun getValidRow(): Int {
        while (true) {
            try {
                print("ROW: ")
                val rowInput = readln().toInt() - 1
                if (rowInput in 0..7) return rowInput
                println("Invalid row. Please enter a number between 1 and 8.")
            } catch (e: NumberFormatException) {
                println("Invalid input. Please enter a valid integer for row.")
            }
        }
    }

    private fun getValidColumn(): Int {
        while (true) {
            print("COLUMN: ")
            val colInput = colToInt(readln())
            if (colInput in 0..7) return colInput
            println("Invalid column. Please enter a letter between A and H.")
        }
    }

    private fun colToInt(col: String): Int {

        return when (col.uppercase()) {
            "A" -> 0
            "B" -> 1
            "C" -> 2
            "D" -> 3
            "E" -> 4
            "F" -> 5
            "G" -> 6
            "H" -> 7
            else -> -1
        }

    }
}
