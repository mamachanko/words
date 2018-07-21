package io.github.mamachanko.words

import io.github.bonigarcia.wdm.WebDriverManager
import org.fluentlenium.adapter.junit.FluentTest
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner::class)
class ChromeTest : FluentTest() {

    @LocalServerPort
    var port: Int = -1

    companion object {

        @BeforeClass
        @JvmStatic
        fun setupClass() {
            WebDriverManager.chromedriver().setup()
        }
    }

    override fun getWebDriver(): String {
        return "chrome"
    }

    override fun getCapabilities() = ChromeOptions().apply {
        addArguments("--headless")
    }
}