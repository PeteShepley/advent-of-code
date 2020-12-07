package aoc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AppTest {
    @Test
    fun convertToBinary() {
        assertEquals("0", convert("F"))
        assertEquals("1", convert("B"))
        assertEquals("0", convert("L"))
        assertEquals("1", convert("R"))
        assertEquals("10101010", convert("BFBFRLRL"))
    }

    @Test
    fun parseIdString() {
        assertEquals(7, parseBinaryId("0000000111"))
    }

    @Test
    fun parseFullBoardingPassId() {
        assertEquals(357, parseBoardingPassId("FBFBBFFRLR"))
        assertEquals(567, parseBoardingPassId("BFFFBBFRRR"))
        assertEquals(119, parseBoardingPassId("FFFBBBFRRR"))
        assertEquals(820, parseBoardingPassId("BBFFBBFRLL"))
    }
}
