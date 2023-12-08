package treasureisland.model


class Pirate(
    private val coordinates: Pair<Int, Int>?,
    private val percentOffTreasureVal: Int
) {

    // getters
    val getCoordinates: Pair<Int, Int>?
        get() = coordinates

    val getPercentOffTreasureVal: Int
        get() = percentOffTreasureVal

}
