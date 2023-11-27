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


}