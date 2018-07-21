package io.github.mamachanko.words

import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class WordsControllerTest {

    private lateinit var mockMvc: MockMvc
    private lateinit var wordsService: WordsService
    private lateinit var subject: WordsController

    @Before
    fun setUp() {
        wordsService = mock(WordsService::class.java)
        subject = WordsController(wordsService)
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build()
    }

    @Test
    fun `should return words`() {
        given(wordsService.words()).willReturn(listOf("these", "are", "the", "words"))

        mockMvc.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML_VALUE))
                .andExpect(xpath("/html/body/div[@id=\"words\"]").string("these are the words"))
    }
}