/**
 *  Basic Player vs Player Game
 */

fun main() {
    // introduction to game
    println("==========================")
    println("WELCOME TO THE PVP GAME!!!")
    println("==========================")
    println()
    val player1 = getString("Player 1, what is your name?: ")
    val player2 = getString("Player 2, what is your name?: ")
    println()
    println("Welcome to the PVP GAME! $player1 and $player2")
    println()
    println("Here are the rules: ")
    println()
    println("enter W to do a weak attack, it is easy to hit but only deals 10 damage")
    println("enter M to do a medium attack, it will hit half the time and deals 20 damage")
    println("enter S to do a strong attack, it is hard to hit but deals 30 damage")
    println("enter H to heal yourself for 5 hitpoints")
    println("enter R to recover 25 hitpoints, however this has a high chance of failing")
    println()
    var player1hp = 100
    var player2hp = 100

    while (true) {
        println()
        println("$player1, it is you're turn")
        val option1 = combat()
        when (option1) {
            'W' -> {
                val hit = (1..4).random()

                if (hit == 1) {
                    println("$player1 tried to do a weak attack but missed")
                } else {
                    println("$player1 did a weak attack and it hit $player2 dealing 10 damage")
                    player2hp -= 10
                    println("$player2 has $player2hp hitpoints remaining")
                }

            }

            'M' -> {
                val hit = (1..4).random()
                if (hit <= 2) {
                    println("$player1 tried to do a medium attack but missed")
                } else {
                    println("$player1 did a medium attack and it hit $player2 dealing 20 damage")
                    player2hp -= 20
                    println("$player2 has $player2hp hitpoints remaining")
                }

            }
            'S' -> {
                val hit = (1..4).random()
                if (hit <= 3) {
                    println("$player1 tried to do a strong attack but missed")
                } else {
                    println("$player1 did a strong attack and it hit $player2 dealing 30 damage")
                    player2hp -= 30
                    println("$player2 has $player2hp hitpoints remaining")
                }
            }

            'H' -> {
                println("$player1 healed 5 hitpoints")
                player1hp = (player1hp + 5).coerceAtMost(100)
                println("$player1 now has $player1hp hitpoints")
            }

            'R' -> {
                val hit = (1..4).random()
                if (hit <= 3) {
                    println("$player1 tried to recover some hitpoints but was unsuccessful")
                } else {
                    println("$player1 recovered 25 hitpoints")
                    player1hp = (player1hp + 25).coerceAtMost(100)
                    println("$player1 now has $player1hp hitpoints")
                }
            }

            else -> {
                continue
            }
        }

        if (player2hp < 1) {
            break
        }

        println()
        println("$player2, it is you're turn")
        val option2 = combat()
        when (option2) {
            'W' -> {

                val hit = (1..4).random()

                if (hit == 1) {
                    println("$player2 tried to do a weak attack but missed")
                } else {
                    println("$player2 did a weak attack and it hit $player1 dealing 10 damage")
                    player1hp -= 10
                    println("$player1 has $player1hp hitpoints remaining")
                }

            }

            'M' -> {
                val hit = (1..4).random()
                if (hit <= 2) {
                    println("$player2 tried to do a medium attack but missed")
                } else {
                    println("$player2 did a medium attack and it hit $player1 dealing 20 damage")
                    player1hp -= 20
                    println("$player1 has $player1hp hitpoints remaining")
                }
            }

            'S' -> {
                val hit = (1..4).random()
                if (hit <= 3) {
                    println("$player2 tried to do a strong attack but missed")
                } else {
                    println("$player2 did a strong attack and it hit $player1 dealing 30 damage")
                    player1hp -= 30
                    println("$player1 has $player1hp hitpoints remaining")
                }
            }

            'H' -> {
                println("$player2 healed 5 hitpoints")
                player2hp = (player2hp + 5).coerceAtMost(100)
                println("$player2 now has $player2hp hitpoints")
            }

            'R' -> {
                val hit = (1..4).random()
                if (hit <= 3) {
                    println("$player2 tried to recover some hitpoints but was unsuccessful")
                } else {
                    println("$player2 recovered 25 hitpoints")
                    player2hp = (player2hp + 25).coerceAtMost(100)
                    println("$player2 now has $player2hp hitpoints")
                }
            }

            else -> break
        }
        if (player1hp < 1) {
            break
        }
    }
    if (player1hp < 1) {
        println("$player2 wins thanks for playing")
    }
    if (player2hp < 1) {
        println("$player1 wins thanks for playing")
    }
}


fun combat(): Char {
    val validChoices = "WMSHRU"

    while (true) {
        println("What do you want to do?: ")
        val input = readln()
        // typed nothing? try again
        if (input.isBlank()) continue
        // grab the first letter
        val choice = input.uppercase().first()

        // check for a valid option
        if (validChoices.contains(choice)) return choice
    }
}

/**
 * Function to get a string from the user
 * parameters:
 * - prompt - text to show the user
 * returns:
 * - String that the user types
 */
fun getString(prompt: String): String {
    var userInput: String

    while(true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break
    }

    return userInput
}



