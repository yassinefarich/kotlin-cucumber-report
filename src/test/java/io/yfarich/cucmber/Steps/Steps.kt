package io.yfarich.cucmber.Steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.vavr.control.Either
import io.vavr.control.Try
import io.yfarich.cucmber.Calculator
import java.lang.RuntimeException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Steps {

    private var result: Either<Throwable, Int> = Either.left(RuntimeException("No result Yet"))
    private var firstOperand: Int = 0
    private var secondOperand: Int = 0

    @Given("The first operand is {int}")
    fun setTheFirstNumber(firstOperand: Int) {
        this.firstOperand = firstOperand
    }

    @Given("The second operand is {int}")
    fun setTheSecondNumber(secondOperand: Int) {
        this.secondOperand = secondOperand
    }

    @When("Add the first operand to the second")
    fun doSum() {
        this.result = toEither { Calculator.plusOperation(firstOperand, secondOperand) }
    }

    @When("Subtract second operand from the first")
    fun doSubtraction() {
        this.result = toEither { Calculator.minusOperation(firstOperand, secondOperand) }
    }

    @When("Multiply the operands")
    fun doMultiplication() {
        this.result = toEither { Calculator.multiplyOperation(firstOperand, secondOperand) }
    }

    @When("Divide the first by the second")
    fun doDivision() {
        this.result = toEither { Calculator.divideOperation(firstOperand, secondOperand) }
    }

    @Then("No exception has been thrown")
    fun noException() {
        assertFalse { result.isLeft }
    }

    @Then("An exception of type {string} has been thrown")
    fun exceptionThrown(exceptionType : String) {
        assertTrue { result.isLeft }
        assertEquals(result.left.javaClass.name , exceptionType)
    }

    @Then("Result equals to {int}")
    fun getResult(expectedResult: Int) {
        assertEquals(expectedResult, result.get())
    }

    fun toEither(behavior: () -> Int): Either<Throwable, Int> = Try.of(behavior).toEither()


}
