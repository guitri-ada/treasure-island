package treasureisland.model

import treasureisland.game.CoordinateHolder


class Treasure(
    private val coordinates: Pair<Int, Int>?,
    private val value: Int
) : CoordinateHolder {

    // getters
    override fun getCoordinates() = coordinates

    val getValue: Int
        get() = value


}
