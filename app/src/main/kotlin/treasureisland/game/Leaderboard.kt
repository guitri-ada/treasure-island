package treasureisland.game

class Leaderboard(
    private val scores: MutableList<Pair<String, Int>> = mutableListOf()
) {

    // print leaderboard
    fun display() {
        scores.withIndex().forEach { (rank, score) ->
            println("${rank + 1}. ${score.first}: ${score.second}")
        }
        println("Press ENTER to return to the menu.")
        readln()
    }

    // add a new score to the leaderboard
    fun addScore(playerName: String, score: Int) {
        scores.add(playerName to score)
        updateRankings()
    }

    // update rankings based on scores
    private fun updateRankings() {
        scores.sortByDescending { it.second } // Sort by scores in descending order
    }
}