package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class ComputerTest(private var computer: Computer) {

  @Test
  fun testComputerCanExecute() {
    computer = Computer(arrayOf(1, 0, 0, 0, 99))
    computer.execute()
    assertEquals("2 0 0 0 99", computer.toString())
  }

  @Test
  fun testVariousInputs() {
    computer = Computer(arrayOf(2, 3, 0, 3, 99))
    computer.execute()
    assertEquals("2 3 0 6 99", computer.toString())

    computer = Computer(arrayOf(2,4,4,5,99,0))
    computer.execute()
    assertEquals("2 4 4 5 99 9801", computer.toString())

    computer = Computer(arrayOf(1,1,1,4,99,5,6,0,99))
    computer.execute()
    assertEquals("30 1 1 4 2 5 6 0 99", computer.toString())
  }
}
