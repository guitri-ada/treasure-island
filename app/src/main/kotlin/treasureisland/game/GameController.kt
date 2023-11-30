package treasureisland.game

class GameController(
    private val game: Game = Game(),
    private var isGameOver: Boolean = false
) {

    fun run() {
        game.start()

        while (!isGameOver) {

            val userInput = getUserInput()
            game.update(userInput)

            // if ... isGameOver = true

        }

    }



    private fun getUserInput(): Pair<Int, Int> {

        while (true) {

            try {
                print("ROW: ")
                val rowInput: Int = readln().toInt()

                print("COLUMN: ")
                val colInput: Int = colToInt(readln())

                return Pair(rowInput, colInput)

            } catch (e: NumberFormatException) {
                println("Invalid row. Please enter a valid integer.")
            }

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