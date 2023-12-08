package treasureisland.model


class Player(
    var score: Int = 0,
    private var leaderboard: MutableList<Int> = mutableListOf()
) {

    // get leaderboard
    val getLeaderboard: MutableList<Int>
        get() = leaderboard

    // add score to leaderboard
    fun addScoreToLeaderboard(gameScore: Int) {
        leaderboard.add(gameScore)
    }

    // score re-setter
    fun resetScore() {
        score = 0
    }


}
