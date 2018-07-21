package io.github.mamachanko.words

import org.springframework.stereotype.Service

@Service
class WordsService {
    fun words(): List<String> = listOf("word", "salad")
}
