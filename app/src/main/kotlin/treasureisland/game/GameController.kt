package treasureisland.game

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
            // if ... isGameOver = true

        }

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