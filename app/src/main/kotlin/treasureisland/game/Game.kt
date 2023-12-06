package treasureisland.game

import treasureisland.util.GameConstants as GC
import treasureisland.model.Island
import treasureisland.model.Pirate
import treasureisland.model.Player
import treasureisland.model.Treasure

class Game(
    val island: Island = Island(),
    val player: Player = Player(),
    var treasureCount: Int = 0,
    var isGameOver: Boolean = false
) {


    fun start() {
        println("\n \uD83C\uDFDD\uFE0F WELCOME TO TREASURE ISLAND \uD83C\uDFDD\uFE0F \n")
        island.print()
    }

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
                "They're stealing ${revealedCellObject.percentOffTreasureVal}% off your gold!${GC.COLOR_RESET}\n"

                player.score -= (player.score * revealedCellObject.percentOffTreasureVal / 100)
            }

            is Treasure -> {
                usersActionResult =
                    "${GC.GREEN}You found $${revealedCellObject.value} of gold!${GC.COLOR_RESET}\n"

                player.score += revealedCellObject.value

                // if 5 treasures have been found, game is over
                isGameOver = (++treasureCount == 5)
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


    fun end() {
        println("You found all the treasures! Congratulations!")
        println("\nYour score is ${player.score}!")

    }

}