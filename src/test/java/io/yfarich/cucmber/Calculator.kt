package io.yfarich.cucmber

import java.lang.IllegalArgumentException

object Calculator {

    fun plusOperation(ope1 : Int,ope2: Int) : Int = ope1 + ope2

    fun minusOperation(ope1 : Int,ope2: Int) : Int = ope1 - ope2

    fun multiplyOperation(ope1 : Int,ope2: Int) : Int = ope1 * ope2

    fun divideOperation(ope1: Int, ope2: Int): Int =
        if (ope2 != 0)
            ope1 / ope2
        else
            throw IllegalArgumentException("Denominator should not be null")
}