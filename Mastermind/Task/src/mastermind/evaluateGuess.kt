package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var wrongPosition = 0
    var rightPosition = 0
    val rightIndexes = mutableListOf(-1, -1, -1, -1)
    val unsuccessfulChars = secret.toMutableList()

    fun isPlaced(index: Int): Boolean = secret[index] == guess[index]
    fun isExistsExceptOf(index: Int, ch: Char, chars: MutableList<Char>): Boolean =
            (ch in chars)
                    && rightIndexes[index] == -1

    for (i in 0..3) {
        if (isPlaced(i)) {
            rightPosition += 1
            rightIndexes.set(i, i)
            unsuccessfulChars[i] = '*'
        }
    }
    for (i in 0..3) {
        if (isExistsExceptOf(i, guess[i], unsuccessfulChars)) {
            val indx = unsuccessfulChars.indexOf(guess[i])
            unsuccessfulChars[indx] = '*'
            wrongPosition += 1
        }
    }
//    val except = rightIndexes.count { e -> e > -1 }
//    wrongPosition -= except

    return Evaluation(rightPosition, wrongPosition)
}
