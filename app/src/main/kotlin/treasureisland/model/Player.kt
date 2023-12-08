package treasureisland.model


class Player(
    val name: String,
    var score: Int = 0,
    private var leaderboard: MutableList<Int> = mutableListOf()
) {


    // print leaderboard
    fun printLeaderboard() {
        var position = 1
        leaderboard.forEach() {
                score ->
            println("${position}. ${score}")
            position += 1
        }
    }

    // add score to leaderboard
    fun addScoreToLeaderboard(gameScore: Int) {
        leaderboard.add(gameScore)
    }

    // score re-setter
    fun resetScore() {
        score = 0
    }


}
