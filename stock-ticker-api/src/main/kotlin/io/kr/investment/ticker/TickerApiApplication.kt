package io.kr.investment.ticker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TickerApiApplication

fun main(args: Array<String>) {
	runApplication<TickerApiApplication>(*args)
}
