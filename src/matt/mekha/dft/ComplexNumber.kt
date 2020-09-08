package matt.mekha.dft

import kotlin.math.pow
import kotlin.math.sqrt

data class ComplexNumber(var r: Double, var i: Double) {

    operator fun plus(n: ComplexNumber): ComplexNumber {
        return ComplexNumber(r + n.r, i + n.i)
    }

    operator fun times(n: Double): ComplexNumber {
        return ComplexNumber(r * n, i * n)
    }

    operator fun div(n: Double): ComplexNumber {
        return ComplexNumber(r / n, i / n)
    }

    fun magnitude(): Double {
        return sqrt(r.pow(2) + i.pow(2))
    }

}

val zero
    get() = ComplexNumber(0.0, 0.0)

fun ePow(n: ComplexNumber): ComplexNumber {
    return ComplexNumber(kotlin.math.cos(n.i), kotlin.math.sin(n.i))
}