package treasureisland.model


class Treasure(
    private val coordinates: Pair<Int, Int>?,
    private val value: Int
) {

    // getters
    val getCoordinates: Pair<Int, Int>?
        get() = coordinates

    val getValue: Int
        get() = value


}
