package iam.thevoid.e

import org.junit.Assert
import org.junit.Test

class StringTest {

    @Test
    fun testCapitalizer() {
        val str1 = "bear"
        val str2 = "Bear"
        Assert.assertEquals(str1, str1.decapitalizeFirst())
        Assert.assertEquals(str2, str2.capitalizeFirst())
        Assert.assertEquals(str1, str2.decapitalizeFirst())
        Assert.assertEquals(str2, str1.capitalizeFirst())
    }

}