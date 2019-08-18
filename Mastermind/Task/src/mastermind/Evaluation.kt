package mastermind

data class Evaluation2(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess2(secret: String, guess: String): Evaluation2 {

    val rightPositions = secret.zip(guess).count { pair: Pair<Char, Char> -> pair.first == pair.second }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { secret.contains(it) },
                guess.count { guess.contains(it) }
        )
    }
    return Evaluation2(rightPositions, commonLetters - rightPositions)
}

fun main(args: Array<String>) {
    println("Function kotlin ..")
    val result = Evaluation2(rightPosition = 1, wrongPosition = 1)
    evaluateGuess2("BCDF", "ACEB") eq ( result)
    evaluateGuess2("AAAF", "ABCA") eq ( result)
    evaluateGuess2("ABCA", "AAAF") eq ( result)
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}