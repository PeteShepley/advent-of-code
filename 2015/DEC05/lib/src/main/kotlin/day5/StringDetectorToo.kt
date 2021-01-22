package day5

class StringDetectorToo {
    fun hasTwoPair(value: String): Boolean {
        return value.contains(Regex("""([a-z][a-z]).*(\1)"""))
    }

    fun hasRepeatSandwich(value: String): Boolean {
        return value.contains(Regex("""([a-z]).(\1)"""))
    }

    fun isNice(value: String): Boolean {
        return hasTwoPair(value) && hasRepeatSandwich(value)
    }
}