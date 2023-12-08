package treasureisland.game

import treasureisland.model.Player

class GameLauncher(
    private val leaderboard: Leaderboard = Leaderboard()
) {

    // launch game
    fun launchGame() {

        // greet player
        println("\n \uD83C\uDFDD\uFE0F WELCOME TO TREASURE ISLAND \uD83C\uDFDD\uFE0F")

        // ask player for name and initialize new player
        var player = newPlayer()

        // initialise new session + controller
        val session = Session(player, leaderboard)
        val sessionController = SessionController(session)

        // run initial session
        sessionController.run()

        while (true) {

            printMenuOptions()

            val userChoice = readln()

            when (userChoice) {
                "1" -> newSession(player)
                "2" -> {
                    player = newPlayer()
                    newSession(player)
                }
                "3" -> leaderboard.display()
                "4" -> break
            }
        }

        endGame()
    }

    // print menu
    private fun printMenuOptions() {
        println("Select an option below:")
        println("1. Play again")
        println("2. New Player")
        println("3. Leaderboard")
        println("4. Exit")
    }

    // create new session
    private fun newSession(player: Player) {
        val newSession = Session(player, leaderboard)
        val newSessionController = SessionController(newSession)
        newSessionController.run()
    }

    // create new player
    private fun newPlayer(): Player {
        println("\n\nEnter you name to start a new game:")
        return Player(readln())
    }

    // end game
    private fun endGame() {
        println("\nTHANK YOU FOR PLAYING TREASURE ISLAND!!")
    }

}