package jdregistry.client.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertSame

class TagTests : TestBase<Tag>() {

    override fun stringToObject(input: String): Tag = Tag.from(input)
    override fun objectToString(obj: Tag): String = obj.repr

    override val invalidStrings: List<String> = listOf(
            "  ",
            "",
            "?",
            " af",
            "af ad",
            "a".repeat(300),
            "\t",
            "a".repeat(129)) // Tag too long by one char

    override val validStrings: List<String> = listOf(
            "latest",
            "foo",
            "bar",
            "A",
            "Latest",
            "3.8",
            "python2.7",
            "python2.7-alpine",
            "python2.6-alpine3.8",
            "a",
            "a".repeat(128)) // Maximal length of a Docker Tag

    override val clazz: Class<Tag> = Tag::class.java

    /*
     *  Equality:  String-Object transformations
     */
    @Test
    fun `invalid Strings will raise an IllegalArgumentException`() {

        this.`each invalid String will raise an IllegalArgumentException`()
    }

    @Test
    fun `valid Strings can be turned into Tags`() {

        this.`valid Strings can be turned to Objects`()
    }

    @Test
    fun `from and repr are inverse operations`() {

        this.`stringToObject and ObjectToString are inverse`()
    }

    /*
     * JSON-Object Transformations
     */
    @Test
    fun `all valid Tags can be serialized as JSON`() {

        this.`all Objects can be written as JSON`()
    }

    @Test
    fun `reading and writing JSON preserves equality`() {

        this.`Consecutive Writing and Reading of objects preserves equality`()
    }

    /*
     * String-JSON Transformations
     */
    @Test
    fun `JSON and String representation of Tag can be transformed into each other by quoting`() {

        this.`quote and unquote transformations work as expected`()
    }

    /*
     * LATEST tag
     */

    // Identity
    @Test
    fun `Creating latest tag from String preserves identity`() {

        assertSame(Tag.LATEST, Tag.from("latest"))
    }

    @Test
    fun `Common LATEST and Tag LATEST refer to the same object`() {

        assertSame(Tag.LATEST, Tag.Common.LATEST)
    }

    @Test
    fun `Reading and writing the latest tag as String preserves identity`() {

        assertSame(Tag.LATEST, stringToObject(objectToString(Tag.LATEST)))
    }

    @Test
    fun `Reading and writing the latest tag as JSON preserved identity`() {

        val json = jacksonObjectMapper().writeValueAsString(Tag.LATEST)
        assertSame(Tag.LATEST, jacksonObjectMapper().readValue<Tag>(json))
    }

    // Representations
    @Test
    fun `The representations of the latest tag are as expected`() {

        assertEquals("latest", Tag.LATEST.repr)
        assertEquals("\"latest\"", jacksonObjectMapper().writeValueAsString(Tag.LATEST))
    }
}
