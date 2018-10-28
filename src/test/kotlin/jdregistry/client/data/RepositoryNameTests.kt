package jdregistry.client.data

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class RepositoryNameTests : TestBase<RepositoryName>() {

    override fun stringToObject(input: String): RepositoryName = RepositoryName.from(input)

    override fun objectToString(obj: RepositoryName): String = obj.repr

    override val validStrings: Iterable<String> = listOf(
            "library/python",
            "foo/bar/baz",
            "alpine",
            "test-image",
            "namespace/repo1",
            "repo2",
            "a".repeat(255)
    )

    override val invalidStrings: Iterable<String> = listOf(
            "",
            " ",
            "//",
            "/ /asf",
            "a".repeat(256)
    )

    override val clazz: Class<RepositoryName> = RepositoryName::class.java

    /*
     *  Equality:  String-Object transformations
     */
    @Test
    fun `invalid Strings will raise an IllegalArgumentException`() {

        this.`each invalid String will raise an IllegalArgumentException`()
    }

    @Test
    fun `valid Strings can be turned into RepositoryNames`() {

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
    fun `all valid Repository Names can be serialized as JSON`() {

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
     * List representation
     */
    @Test
    fun `List representation of RepositoryName is consistent with the manually constructed list`() {

        assertEquals(listOf(PathComponent.from("foo")), RepositoryName.from("foo").list)
        assertEquals(
                listOf(PathComponent.from("foo"), PathComponent.from("bar")),
                RepositoryName.from("foo/bar").list)
    }

    @Test
    fun `empty repositories are not allowed`() {

        assertThrows<IllegalArgumentException> { RepositoryName.from("") }
    }

    /*
     * Resolve Tags
     */
    @Test
    fun resolve_tag() {

        assertEquals("foo:latest", RepositoryName.from("foo").resolve(Tag.LATEST))
        assertEquals("foo:bar", RepositoryName.from("foo").resolve(Tag.from("bar")))
        assertEquals("docker.io/foo:bar", RepositoryName.from("foo").resolve(Tag.from("bar"),
                host = "docker.io"))
        assertEquals("docker.io/foo:bar", RepositoryName.from("foo").resolve(Tag.from("bar"),
                host = "docker.io/"))
        assertEquals("docker.io:3000/foo:bar", RepositoryName.from("foo").resolve(Tag.from("bar"),
                host = "docker.io:3000"))
        assertEquals("docker.io:3000/foo:bar", RepositoryName.from("foo").resolve(Tag.from("bar"),
                host = "docker.io:3000/"))
        assertEquals("namespace/foo:latest",
                RepositoryName.from("namespace/foo").resolve(Tag.LATEST))
        assertEquals("namespace/foo:bar",
                RepositoryName.from("namespace/foo").resolve(Tag.from("bar")))
        assertEquals("docker.io/namespace/foo:bar",
                RepositoryName.from("namespace/foo").resolve(Tag.from("bar"),
                host = "docker.io"))
        assertEquals("docker.io/namespace/foo:bar",
                RepositoryName.from("namespace/foo").resolve(Tag.from("bar"),
                host = "docker.io/"))
        assertEquals("docker.io:3000/namespace/foo:bar",
                RepositoryName.from("namespace/foo").resolve(Tag.from("bar"),
                host = "docker.io:3000"))
        assertEquals("docker.io:3000/namespace/foo:bar",
                RepositoryName.from("namespace/foo").resolve(Tag.from("bar"),
                host = "docker.io:3000/"))
    }
}
