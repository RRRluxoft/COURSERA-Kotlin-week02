package mastermind

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class EvaluationKtTest

val result = Evaluation2(rightPosition = 1, wrongPosition = 1)
@Test fun test01() = Assert.assertEquals(evaluateGuess2("BCDF", "ACEB"), result)
@Test fun test02() = Assert.assertEquals(evaluateGuess2("AAAF", "ABCA"), result)
@Test fun test03() = Assert.assertEquals(evaluateGuess2("ABCA", "AAAF"), result)
