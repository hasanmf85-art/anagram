package anagram

class Anagram(private val subject: String) {

    private val subjectLower = subject.lowercase()
    private val subjectSorted = sortedChars(subjectLower)

    fun match(candidates: Collection<String>): Set<String> {
        return candidates
            .filter { candidate ->
                val candidateLower = candidate.lowercase()
                candidateLower != subjectLower && sortedChars(candidateLower) == subjectSorted
            }
            .toSet()
    }

    private fun sortedChars(word: String): String =
        word.toCharArray().also { it.sort() }.concatToString()
}
