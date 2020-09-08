package matt.mekha.dft.test

import matt.mekha.dft.DiscreteFourierTransform
import org.junit.Test
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.round

class TestClass {

    private fun cos2(x: Double) = cos(x * PI / 180)

    @Test
    fun test1() {
        val dft = DiscreteFourierTransform({ cos2(it * 8) + cos2(it * 12) }, 0.0, 360.0, 45, 1.0)
        for(i in 1 .. 15) {
            val y = round(dft.getFrequencyBin(i.toDouble()).magnitude() * 100.0) / 100.0
            println("$i Hz\t:\t$y")
        }
    }

}