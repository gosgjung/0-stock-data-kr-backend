package io.kr.investment.earning.crawling.wisereport.code

enum class ParameterCode (
    val parameterName: String
){
    // ticker
    TICKER("cmp_cd"),
    // 실적데이터|분기리스트|차트데이터
    DATA_TYPE("flag"),
    // 분기|연간
    PERIOD_TYPE("frq"),
    // 기준일자
    START_DATE("sDT");


    fun parameterName(parameterCode: ParameterCode):String{
        return parameterCode.parameterName
    }
}