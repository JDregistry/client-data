package jdregistry.client.data

import org.junit.jupiter.api.Test

class PathComponentTests : TestBase<PathComponent>() {

    override fun stringToObject(input: String): PathComponent = PathComponent.from(input)

    override fun objectToString(obj: PathComponent): String = obj.repr

    override val validStrings: Iterable<String> = listOf(
            "namespace",
            "jboss",
            "library",
            "personalhealthtrain"
    )

    override val invalidStrings: Iterable<String> = listOf(
            "",
            "  ",
            " a ",
            "aa a"
    )

    override val clazz: Class<PathComponent> = PathComponent::class.java

    @Test
    fun `invalid Strings will raise an IllegalArgumentException`() {

        this.`each invalid String will raise an IllegalArgumentException`()
    }

    @Test
    fun `valid Strings can be turned into a PathComponent`() {

        this.`valid Strings can be turned to Objects`()
    }

    @Test
    fun `from and repr are inverse operations`() {

        this.`stringToObject and ObjectToString are inverse`()
    }

    @Test
    fun `all valid PathComponents can be serialized as JSON`() {

        this.`all Objects can be written as JSON`()
    }

    @Test
    fun `reading and writing JSON preserves equality`() {

        this.`Consecutive Writing and Reading of objects preserves equality`()
    }

    @Test
    fun `JSON and String representation of a Path Component can be transformed into each other by quoting`() {

        this.`quote and unquote transformations work as expected`()
    }
}
