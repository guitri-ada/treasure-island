package treasureisland.game

// interface to define contracts for Pirate and Treasure classes
// and allow use of type parameter in SessionController
interface CoordinateHolder {
    fun getCoordinates(): Pair<Int, Int>?
}
