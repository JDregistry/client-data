package jdregistry.client.data

import org.junit.jupiter.api.Test

class TagTests : TestBase<Tag>() {

    override fun stringToObject(input: String): Tag = Tag.from(input)
    override fun objectToString(obj: Tag): String = obj.repr

    override val invalidStrings: List<String> = listOf("  ", "", "?", " af", "af ad", "a".repeat(300), "\t")
    override val validStrings: List<String> = listOf("latest", "foo", "bar", "A", "Latest")

    override val clazz: Class<Tag> = Tag::class.java

    /*
     *  Tests Isomorphie between Strings and Objects
     */
    @Test // 1
    fun `invalid Strings will raise an IllegalArgumentException`() {

        this.`each invalid String will raise an IllegalArgumentException`()
    }


    @Test
    fun `valid Strings can be turned into tags`() {

        this.`valid Strings can be turned to Objects`()
    }

    @Test
    fun `from and repr are inverse operations`() {

        this.`stringToObject and ObjectToString are inverse`()
    }

    /*
     * (De-)Serialization
     */
    @Test
    fun `JSON serialized form is equal to repr with quotes`() {

        this.`Writing as JSON String is same as objectToString with Quotes`()
    }

    @Test
    fun `JSON serialized form without quotes can be read with from`() {

        this.`Reading from JSON String is the same as stringToObject without Quotes`()
    }

    @Test
    fun `reading and writing JSON preserves equality`() {

        this.`Consecutive Writing and Reading of objects preserves equality`()
    }


//    @Test
//    fun `latest tag is correctly read from the string latest`() {
//
//        val tag = Tag.from("latest")
//        assertEquals(Tag.LATEST, tag)
//        assertSame(Tag.LATEST, tag)
//    }
//
//    @Test
//    fun `short wiring the LATEST tag works as expected`() {
//
//        assertEquals(Tag.LATEST, Tag.Common.LATEST)
//        assertSame(Tag.LATEST, Tag.Common.LATEST)
//    }
//
//    @Test
//    fun `the latest tag can only be created from one String literal`() {
//
//        val latest = "latest"
//        assertNotEqualTags(
//                latest to "LATEST",
//                latest to "Latest",
//                latest to "LaTest"
//        )
//    }
//
//    @Test
//    fun `Docker tags are case sensitive`() {
//
//        assertNotEqualTags(
//                "foo" to "Foo",
//                "foo" to "FOO"
//        )
//    }
//

//

//
//    @Test
//    fun `Deserialization preserves identity of latest tag`() {
//
//        generateSequence { "latest" }.take(100).forEach {
//
//            assertSame(Tag.LATEST, Tag.from(it))
//        }
//    }
}
