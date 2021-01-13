package day5

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringDetectorTest {
    lateinit var detector: StringDetector

    @BeforeTest fun before() {
        detector = StringDetector()
    }

    @Test fun testHasThreeVowels() {
        assertFalse(detector.hasThreeVowels(""))
        assertFalse(detector.hasThreeVowels("abc"))
        assertFalse(detector.hasThreeVowels("ae"))
        assertTrue(detector.hasThreeVowels("aei"))
        assertTrue(detector.hasThreeVowels("iou"))
        assertTrue(detector.hasThreeVowels("aeiou"))
    }

    @Test fun testHasDoubleLetter() {
        assertFalse(detector.hasDoubleLetter(""))
        assertTrue(detector.hasDoubleLetter("aa"))
        assertTrue(detector.hasDoubleLetter("abbc"))
        assertTrue(detector.hasDoubleLetter("aabbccdd"))
        assertFalse(detector.hasDoubleLetter("abcde"))
    }

    @Test fun testForbiddenStrings() {
        assertFalse(detector.hasForbiddenString(""))
        assertTrue(detector.hasForbiddenString("ab"))
        assertTrue(detector.hasForbiddenString("cd"))
        assertTrue(detector.hasForbiddenString("pq"))
        assertTrue(detector.hasForbiddenString("xy"))
        assertFalse(detector.hasForbiddenString("acbdpxqy"))
    }

    @Test fun testIntegration() {
        assertFalse(detector.isNice(""))
        assertTrue(detector.isNice("ugknbfddgicrmopn"))
        assertTrue(detector.isNice("aaa"))
        assertFalse(detector.isNice("jchzalrnumimnmhp"))
        assertFalse(detector.isNice("haegwjzuvuyypxyu"))
        assertFalse(detector.isNice("dvszwmarrgswjxmb"))
    }

    @Test fun testInput() {
        val content = StringDetectorTest::class.java.classLoader.getResource("input").readText()
        val count = content.lines().filter { detector.isNice(it) }.count()
        println(count)
    }
}
