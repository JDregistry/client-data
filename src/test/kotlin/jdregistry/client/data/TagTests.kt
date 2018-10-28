package jdregistry.client.data

import org.junit.jupiter.api.Test

class TagTests : TestBase<Tag>() {

    override fun stringToObject(input: String): Tag = Tag.from(input)
    override fun objectToString(obj: Tag): String = obj.repr

    override val invalidStrings: List<String> = listOf("  ", "", "?", " af", "af ad", "a".repeat(300), "\t")
    override val validStrings: List<String> = listOf(
            "latest",
            "foo",
            "bar",
            "A",
            "Latest",
            "3.8",
            "python2.7",
            "python2.7-alpine",
            "python2.6-alpine3.8")

    override val clazz: Class<Tag> = Tag::class.java

    /*
     *  Tests Isomorphie between Strings and Objects
     */
    // 1
    @Test
    fun `invalid Strings will raise an IllegalArgumentException`() {

        this.`each invalid String will raise an IllegalArgumentException`()
    }

    // 2
    @Test
    fun `valid Strings can be turned into Tags`() {

        this.`valid Strings can be turned to Objects`()
    }

    // 3
    @Test
    fun `from and repr are inverse operations`() {

        this.`stringToObject and ObjectToString are inverse`()
    }

    /*
     * (De-)Serialization
     */
    // 4
    @Test
    fun `all valid  Tags can be serialized as JSON`() {

        this.`all Objects can be written as JSON`()
    }


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
