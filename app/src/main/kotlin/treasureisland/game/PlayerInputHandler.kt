package treasureisland.game

class PlayerInputHandler {

    // all methods below are static (called 'companion object' in kotlin)
    companion object {

        fun getPlayerInput(): Pair<Int, Int> {
            val rowInput = getValidRow()
            val colInput = getValidColumn()
            return Pair(rowInput, colInput)
        }

        // get valid row input
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

        // get valid column input
        private fun getValidColumn(): Int {
            while (true) {
                print("COLUMN: ")
                val colInput = colToInt(readln())
                if (colInput in 0..7) return colInput
                println("Invalid column. Please enter a letter between A and H.")
            }
        }

        // convert column letters into integer (index)
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
}
