package treasureisland.game

import treasureisland.util.GameConstants as GC

class SessionController(
    private val session: Session,
) {

    // session runner
    fun run() {

        // start a new session
        session.start()

        while (true) {

            var userInput: Pair<Int, Int>

            while (true) {

                // get player input
                userInput = PlayerInputHandler.getPlayerInput()

                // check if cell has already been revealed
                if (!session.getIsland.getRevealedCells.contains(userInput)) break
                println("Cell already revealed, try again!")
            }

            // update session state
            session.update(userInput)

            // break if session is over
            if (session.isSessionOver) {
                session.end()
                break
            }

            // check surrounding cells and print clues
            println("${GC.MAGENTA}${generateClues(userInput)}${GC.COLOR_RESET}\n")
        }

    }


    // generate clues based on revealed cell
    private fun generateClues(cell: Pair<Int, Int>): String {
        val isTreasureNearby = isTargetNearby(cell, session.getIsland.getTreasures)
        val isPirateNearby = isTargetNearby(cell, session.getIsland.getPirates)

        val treasureClue = "\uD83D\uDD0E ${GC.GREEN}T${GC.MAGENTA} You sense a treasure nearby!"
        val pirateClue = "\uD83D\uDD0E ${GC.RED}X${GC.MAGENTA} Pirates are lurking around here."

        return when {
            isTreasureNearby && isPirateNearby -> "$treasureClue\n$pirateClue"
            isTreasureNearby -> "\uD83D\uDD0E ${GC.GREEN}T${GC.MAGENTA} You sense a treasure nearby!"
            isPirateNearby -> "\uD83D\uDD0E ${GC.RED}X${GC.MAGENTA} Pirates are lurking around here."
            else -> "\uD83D\uDD0E No treasures or pirates detected around."
        }
    }


    // check if a target (pirate and/or treasure) are nearby
    private fun <T : CoordinateHolder> isTargetNearby(cell: Pair<Int, Int>, targets: MutableList<T>): Boolean {

        for (currentRow in cell.first - 1..cell.first + 1) {
            for (currentCol in cell.second - 1..cell.second + 1) {

                if (currentRow == cell.first && currentCol == cell.second) {
                    continue  // Skip the revealed cell
                }

                if (targets.any { it.getCoordinates() == Pair(currentRow, currentCol) }) {
                    return true
                }
            }
        }

        return false
    }
}
