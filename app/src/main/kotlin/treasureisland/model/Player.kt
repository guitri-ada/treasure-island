package treasureisland.model


class Player(
    val name: String,
    var score: Int = 0
) {

    // score re-setter
    fun resetScore() {
        score = 0
    }

}
