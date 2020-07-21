package iam.thevoid.e

import org.junit.Assert
import org.junit.Test

class DoubleTest {
    @Test
    fun formatDoubleTest() {
        Assert.assertEquals("1.1", 1.12234.format(precision = 1))
        Assert.assertEquals("1.12234", 1.12234.format())
        Assert.assertEquals("1.1", 1.10034.format(precision = 3))
        Assert.assertEquals("1.100", 1.10034.format(precision = 3, endingZeroes = true))

        Assert.assertEquals("1", 1.0.format())
        Assert.assertEquals("1", 1.0.format(precision = 1))
        Assert.assertEquals("1.0", 1.0.format(precision = 1, endingZeroes = true))
    }
}