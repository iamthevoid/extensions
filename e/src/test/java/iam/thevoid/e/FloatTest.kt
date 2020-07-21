package iam.thevoid.e

import org.junit.Assert
import org.junit.Test

class FloatTest {
    @Test
    fun formatFloatTest() {
        Assert.assertEquals("1.1", 1.12234f.format(precision = 1))
        Assert.assertEquals("1.12234", 1.12234f.format())
        Assert.assertEquals("1.1", 1.10034f.format(precision = 3))
        Assert.assertEquals("1.100", 1.10034f.format(precision = 3, endingZeroes = true))

        Assert.assertEquals("1", 1f.format())
        Assert.assertEquals("1", 1f.format(precision = 1))
        Assert.assertEquals("1.0", 1f.format(precision = 1, endingZeroes = true))
    }
}