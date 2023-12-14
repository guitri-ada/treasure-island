package treasureisland.model

import treasureisland.util.Coordinates
import treasureisland.util.GameConstants as GC


class Island(
    private var grid: Array<MutableList<String>> = arrayOf(),
    private val pirates: MutableList<Pirate> = mutableListOf(),
    private val treasures: MutableList<Treasure> = mutableListOf(),
    private var revealedCells: MutableSet<Pair<Int, Int>> = mutableSetOf()
) {

    init {

        // define the starting grid (array of arrays)
        grid = Array(8) { MutableList(8) {GC.BLUE + " ■ " + GC.COLOR_RESET} }

        // populate pirates list with constants and coordinates
        for (percent in GC.PIRATE_PERCENT_OFF) {
            pirates.add(Pirate(Coordinates.getUniqueCoordinates(), percent))
        }

        // populate treasures list with constants and coordinates
        for (value in GC.TREASURE_VALUES) {
            treasures.add(Treasure(Coordinates.getUniqueCoordinates(), value))
        }
    }

    fun print() {

        // print column names
        println("\n   A  B  C  D  E  F  G  H  ")

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


    fun revealCell(cell: Pair<Int, Int>): Any? {

        // check valid cell input against pirate/treasure coordinates
        val pirate = pirates.find { it.getCoordinates() == cell }
        val treasure = treasures.find { it.getCoordinates() == cell }

        // define cellType to print accordingly
        val cellType = when {
            pirate != null -> GC.PIRATE_CELL
            treasure != null -> GC.TREASURE_CELL
            else -> GC.EMPTY_CELL
        }

        // reveal cell and assign it to corresponding type
        this.grid[cell.first][cell.second] = cellType

        // add revealed cell in list to keep track
        revealedCells.add(cell)

        // return pirate or treasure or null
        return pirate ?: treasure
    }

    // getters
    val getPirates: MutableList<Pirate>
        get() = pirates

    val getTreasures: MutableList<Treasure>
        get() = treasures

    val getRevealedCells: MutableSet<Pair<Int, Int>>
        get() = revealedCells

}
