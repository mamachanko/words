package io.github.mamachanko.words

import org.intellij.lang.annotations.Language
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WordsController(val wordsService: WordsService) {

    @Language("HTML")
    @GetMapping(value = ["/"], produces = [(MediaType.TEXT_HTML_VALUE)])
    fun words() = """
        <html>
        <body>
        <div id="words">${wordsService.words().joinToString(" ")}</div>
        </body>
        </html>
        """
}