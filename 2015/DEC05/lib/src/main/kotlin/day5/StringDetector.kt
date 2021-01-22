package day5

class StringDetector {
    private val forbidden = listOf("ab", "cd", "pq", "xy")

    fun hasThreeVowels(value: String): Boolean {
        if (value.isNullOrEmpty()) return false
        return value.contains(Regex("""(.*[aeiou].*){3}"""))
    }

    fun hasDoubleLetter(value: String): Boolean {
        if (value.isNullOrEmpty()) return false
        return value.contains(Regex("""(\w)(\1+)"""))
    }

    fun hasForbiddenString(value: String): Boolean {
        if (value.isNullOrEmpty()) return false
        return forbidden.any { value.contains(it) }
    }

    fun isNice(value: String): Boolean {
        return !hasForbiddenString(value) && hasDoubleLetter(value) && hasThreeVowels(value)
    }
}
