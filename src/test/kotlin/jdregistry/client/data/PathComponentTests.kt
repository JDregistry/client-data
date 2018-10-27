package jdregistry.client.data

class PathComponentTests {
//
//    private val pathComponents = listOf("namespace", "jboss", "library").associate {
//
//
//    }
//
//    @Test
//    fun `constructor and repr are inverse`() {
//
//        pathComponents.forEach {
//
//            assertEquals(it, PathComponent.from(it).repr)
//        }
//    }
//
//
// /*
// * The below are tests for JSON serialization and deserialization
// */
//    @Test
//    fun `JSON serialized form is equal to repr with quotes`() {
//
//        dockerTags.forEach { (_, tag) ->
//
//            val serialized = jacksonObjectMapper().writeValueAsString(tag)
//            assertEquals(serialized, tag.repr.quoted())
//        }
//    }

//    @Test
//    fun `Deserializing String with Quotes is same as from method`() {
//
//        dockerTags.forEach { (str, tag) ->
//
//            val readTag: Tag = jacksonObjectMapper().readValue(str.quoted())
//            assertEquals(tag, readTag)
//        }
//    }
//
//    @Test
//    fun `Serialization and Deserialization results in equal objects`() {
//
//        dockerTags.forEach { (_, tag) ->
//
//            val serialized = jacksonObjectMapper().writeValueAsString(tag)
//            val readTag: Tag = jacksonObjectMapper().readValue(serialized)
//            assertEquals(tag, readTag)
//        }
//    }
//
//    @Test
//    fun `Deserialization preserves identity of latest tag`() {
//
//        generateSequence { "latest" }.take(100).forEach {
//
//            Assertions.assertSame(Tag.LATEST, Tag.from(it))
//        }
//    }
}
