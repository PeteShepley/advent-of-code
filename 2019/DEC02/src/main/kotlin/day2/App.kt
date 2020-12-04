package day2

class Computer(val program: Array<Int>) {
  private var pointer: Int = 0

  fun execute() {
    while (pointer < program.size) {
      when (program[pointer]) {
        1 -> {
          add()
          pointer += 4
        }
        2 -> {
          mult()
          pointer += 4
        }
        99 -> pointer = program.size
      }
    }
  }

  override fun toString(): String {
    return program.joinToString(" ")
  }

  private fun add() {
    val op1 = program[program[pointer + 1]]
    val op2 = program[program[pointer + 2]]
    val loc = program[pointer + 3]
    program[loc] = op1 + op2
  }

  private fun mult() {
    val op1 = program[program[pointer + 1]]
    val op2 = program[program[pointer + 2]]
    val loc = program[pointer + 3]
    program[loc] = op1 * op2
  }
}

fun copyOfProgram(): Array<Int> {
  return arrayOf(1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 10, 19, 1, 6, 19, 23, 2, 23, 6, 27, 2, 6, 27, 31, 2, 13, 31, 35, 1, 10, 35, 39, 2, 39, 13, 43, 1, 43, 13, 47, 1, 6, 47, 51, 1, 10, 51, 55, 2, 55, 6, 59, 1, 5, 59, 63, 2, 9, 63, 67, 1, 6, 67, 71, 2, 9, 71, 75, 1, 6, 75, 79, 2, 79, 13, 83, 1, 83, 10, 87, 1, 13, 87, 91, 1, 91, 10, 95, 2, 9, 95, 99, 1, 5, 99, 103, 2, 10, 103, 107, 1, 107, 2, 111, 1, 111, 5, 0, 99, 2, 14, 0, 0)
}

fun main(args: Array<String>) {
  for (noun in 0..99) {
    print('*')
    for (verb in 0..99) {
      print('.')
      val testProgram = copyOfProgram()
      testProgram[1] = noun
      testProgram[2] = verb

      val comp = Computer(testProgram)
      comp.execute()
      if (comp.program[0] == 19690720) {
        println("Noun: $noun Verb: $verb")
      }
    }
  }
}
