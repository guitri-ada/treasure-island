package treasureisland.util

object Coordinates {

    // generate a pool of coordinates to pick from
    val coordinatesPool: MutableSet<Pair<Int, Int>> =
        (0 until 8).flatMap { x ->
            (0 until 8).map { y -> Pair(x, y) }
        }.toMutableSet()

    // get unique coordinates from pool and update pool
    @Synchronized
    fun getUniqueCoordinates(): Pair<Int, Int>? {

        // if pool not empty select random,
        // remove from pool and return coordinates
        return if (coordinatesPool.isNotEmpty()) {
            val selectedCoordinate = coordinatesPool.elementAt(coordinatesPool.indices.random())
            coordinatesPool.remove(selectedCoordinate)
            return selectedCoordinate
        } else null
    }
}
