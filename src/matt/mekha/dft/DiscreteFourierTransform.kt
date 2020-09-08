package matt.mekha.dft

import kotlin.math.PI

typealias Function = (Double) -> Double

class DiscreteFourierTransform(val f: Function, x0: Double, x1: Double, private val numSamples: Int, private val duration: Double) {

    private val xStart = x0
    private val xInc = (x1 - x0) / numSamples

    private val samples: List<Double> = List(numSamples) { i : Int -> f(xStart + (i * xInc)) }

    fun getFrequencyBin(frequency: Double): ComplexNumber {
        val virtualFrequency = frequency * duration
        if(virtualFrequency > numSamples/2) return zero // Nyquist Theorem

        var sum = zero
        for((i, sample) in samples.withIndex()) {
            sum += ePow(ComplexNumber(0.0, -2 * PI * virtualFrequency * i / numSamples)) * sample
        }
        return sum / numSamples.toDouble() * 2.0
    }

}