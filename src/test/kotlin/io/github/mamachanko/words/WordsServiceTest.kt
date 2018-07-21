package io.github.mamachanko.words

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class WordsServiceTest {

    @Test
    fun `should return words`() {
        assertThat(WordsService().words()).containsExactly("word", "salad")
    }
}