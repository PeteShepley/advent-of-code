package day5

import org.junit.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringDetectorTooTest {
    private lateinit var detector: StringDetectorToo

    @BeforeTest fun before() {
        detector = StringDetectorToo()
    }

    @Test fun testHasNonOverlappingPair() {
        assertFalse(detector.hasTwoPair(""))
        assertTrue(detector.hasTwoPair("xyxy"))
        assertTrue(detector.hasTwoPair("xyxyxy"))
        assertTrue(detector.hasTwoPair("abcdefab"))
        assertFalse(detector.hasTwoPair("aaa"))
    }

    @Test fun testHasRepeatCharacterSandwich() {
        assertFalse(detector.hasRepeatSandwich(""))
        assertTrue(detector.hasRepeatSandwich("xyx"))
        assertTrue(detector.hasRepeatSandwich("efe"))
        assertTrue(detector.hasRepeatSandwich("aaa"))
    }

    @Test fun isNice() {
        assertFalse(detector.isNice(""))
        assertTrue(detector.isNice("qjhvhtzxzqqjkmpb"))
        assertTrue(detector.isNice("xxyxx"))
        assertFalse(detector.isNice("uurcxstgmygtbstg"))
        assertFalse(detector.isNice("ieodomkazucvgmuy"))
    }

    @Test fun testInput() {
        val content = StringDetectorTooTest::class.java.classLoader.getResource("input").readText()
        val count = content.lines().filter { detector.isNice(it) }.count()
        println(count)
    }
}