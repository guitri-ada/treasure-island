package treasureisland.game

import treasureisland.util.GameConstants as GC
import treasureisland.model.Island
import treasureisland.model.Pirate
import treasureisland.model.Player
import treasureisland.model.Treasure

class Session(
    private val player: Player,
    private val leaderboard: Leaderboard,
    private val island: Island = Island(),
    private var treasureCount: Int = 0,
    private var sessionOver: Boolean = false
) {


    // game start
    fun start() {

        // print island
        island.print()
    }


    // game update
    fun update(userInput: Pair<Int, Int>) {

        // reveal cell corresponding to user input
        val revealedCellObject = island.revealCell(userInput)

        // initialise userActionResult string to keep in scope
        var usersActionResult = ""

        // assert cell type (Treasure, Pirate or Empty),
        // update player score and define action result string
        when (revealedCellObject) {

            is Pirate -> {

                usersActionResult =
                "${GC.RED}Oh no! It's a pirate!\n" +
                "They're stealing ${revealedCellObject.getPercentOffTreasureVal}% off your gold!${GC.COLOR_RESET}\n"

                player.score -= (player.score * revealedCellObject.getPercentOffTreasureVal / 100)
            }

            is Treasure -> {
                usersActionResult =
                    "${GC.GREEN}You found $${revealedCellObject.getValue} of gold!${GC.COLOR_RESET}\n"

                player.score += revealedCellObject.getValue

                // if 4 treasures have been found, game is over
                sessionOver = (++treasureCount >= 4)
            }

            null -> {
                usersActionResult = "${GC.YELLOW}Nothing there...${GC.COLOR_RESET}\n"
            }

        }

        // print updated island
        island.print()

        // print player updated score
        println("\n\uD83D\uDCB0 (SCORE): $${player.score}")

        // print user action result (pirate, treasure or empty)
        println("\n${usersActionResult}")
    }


    // game ending
    fun end() {
        // add player score to leaderboard
        leaderboard.addScore(player.name, player.score)

        // print end message and player's score
        println("Congratulations! You found all the treasures!")
        println("Your score is ${GC.YELLOW}${player.score}${GC.COLOR_RESET}!")

        // reset player score to 0
        player.resetScore()
    }


    // getters
    val isSessionOver: Boolean
        get() = sessionOver

    val getIsland: Island
        get() = island

}