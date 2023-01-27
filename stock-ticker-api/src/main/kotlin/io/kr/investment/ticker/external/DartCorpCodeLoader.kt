package io.kr.investment.ticker.external

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.InputStream
import java.lang.IllegalArgumentException
import javax.xml.parsers.DocumentBuilderFactory

@Component
class DartCorpCodeLoader{

    fun ofInputStream(path: String): InputStream {
        if(path.isBlank() || path.isEmpty()) throw IllegalArgumentException()
        return ClassPathResource(path).inputStream
    }

    fun readTickerNodes(inputStream: InputStream) : NodeList {
        val documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val document = documentBuilder.parse(inputStream)
        inputStream.close()
        return document.getElementsByTagName("list")
    }

    fun readAllCorpCode(): List<DartCorpCodeDto> {
        val nodes = readTickerNodes(ofInputStream(DartCorpCodeEnvironment.PATH_DART_CORP_CODE_XML))

        return generateSequence (0){ it + 1 }
            .take(nodes.length)
            .map{nodes.item(it)}
            .filter {
                if(it.nodeType == Node.ELEMENT_NODE){
                    val stockCode = it.childNodes.item(5).textContent
                    stockCode != null && stockCode.isNotBlank() && stockCode.isNotEmpty()
                }
                else false
            }
            .map{
                val childNodes = it.childNodes
                val corpCode = childNodes.item(1)?.textContent ?: ""
                val corpName = childNodes.item(3)?.textContent ?: ""
                val stockCode = childNodes.item(5)?.textContent ?: ""
                DartCorpCodeDto(stockCode = stockCode, corpName = corpName, corpCode = corpCode)
            }
            .toList()

    }
}