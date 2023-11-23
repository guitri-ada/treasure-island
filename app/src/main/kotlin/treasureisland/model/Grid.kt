package treasureisland.model

import treasureisland.util.GameConstants as GC

abstract class Grid{

    // initialise a new grid
    fun init() {

        // define the grid (array of arrays)
        val grid = Array(8) { MutableList(8) {GC.BLUE + " ■ " + GC.COLOR_RESET} }

        // print column names
        println("   A  B  C  D  E  F  G  H  ")

        // define row number
        var rowNo = 1

        // print rows
        for (row in grid) {

            print("${rowNo++} ")

            for (cell in row) {
                print(cell)
            }

            println()
        }

    }
}
