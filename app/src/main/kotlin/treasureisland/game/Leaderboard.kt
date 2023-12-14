package treasureisland.game

class Leaderboard(
    private val scores: MutableList<Pair<String, Int>> = mutableListOf()
) {

    // print leaderboard
    fun display() {
        println("\n\uD83C\uDFC6 ${"\u001B[4mLeaderboard\u001B[0m"} \uD83C\uDFC6\n")
        scores.withIndex().forEach { (rank, score) ->
            println("   ${rank + 1}. ${score.first}: ${score.second}")
        }
        println("\nPress ENTER to return to the menu.")
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