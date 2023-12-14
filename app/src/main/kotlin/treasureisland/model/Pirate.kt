package treasureisland.model

import treasureisland.game.CoordinateHolder


class Pirate(
    private val coordinates: Pair<Int, Int>?,
    private val percentOffTreasureVal: Int
) : CoordinateHolder {

    // getters
    override fun getCoordinates() = coordinates

    val getPercentOffTreasureVal: Int
        get() = percentOffTreasureVal

}
