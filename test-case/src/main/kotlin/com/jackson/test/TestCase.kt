package com.jackson.test

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URLDecoder

class TestCase(
    private val objectMapper: ObjectMapper
) {
    private val reader = ObjectMapper(
        JsonFactory()
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
    ).reader(Any::class.java)

    fun getSerializedObject(): String {
        val s = "%7B%22innerWidth%22%3Anull%7D"
        val any = reader.readValue<Any>(URLDecoder.decode(s, "UTF-8"))

        return objectMapper.writeValueAsString(any)
    }

    fun getSerializedMap(): String {
        val m = mapOf("innerWidth" to null)

        return objectMapper.writeValueAsString(m)
    }
}
