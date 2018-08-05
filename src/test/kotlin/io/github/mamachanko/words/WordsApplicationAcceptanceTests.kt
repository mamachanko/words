package io.github.mamachanko.words

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test


class WordsApplicationAcceptanceTests : ChromeTest() {

    @Before
    fun setUp() {
        goTo("http://localhost:$port")
    }

    @Test
    fun `user can see words`() {
        assertThat(find("#words").first().text()).isEqualTo("word salad")
    }
}