package com.jackson.test

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class JacksonNewTest {

    @Nested
    inner class CustomMapper {
        private val mapperNonNull = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

        @Test
        fun `null fields in object not exists in json`() {
            val case = TestCase(mapperNonNull)

            assertEquals("{}", case.getSerializedObject())
        }

        @Test
        fun `null fields in map not exists in json`() {
            val case = TestCase(mapperNonNull)

            assertEquals("{}", case.getSerializedMap())
        }
    }

    @Nested
    inner class DefaultMapper {
        private val mapperDefault = ObjectMapper()

        @Test
        fun `null fields in object exists in json`() {
            val case = TestCase(mapperDefault)

            assertEquals("""{"innerWidth":null}""", case.getSerializedObject())
        }

        @Test
        fun `null fields in map exists in json`() {
            val case = TestCase(mapperDefault)

            assertEquals("""{"innerWidth":null}""", case.getSerializedMap())
        }
    }
}
