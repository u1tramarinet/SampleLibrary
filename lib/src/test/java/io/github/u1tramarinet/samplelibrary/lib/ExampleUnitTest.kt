package io.github.u1tramarinet.samplelibrary.lib

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Rule
    @JvmField
    val testRule = SampleTestRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}