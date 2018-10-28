package jdregistry.client.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

/**
 * Unifies routines to test objects that are generally representable by a String
 * and will be serialized to a String by jackson
 *
 * @author Lukas Zimmermann
 * @since 0.0.7
 *
 */
abstract class TestBase<T> {

    protected abstract fun stringToObject(input: String): T
    protected abstract fun objectToString(obj: T): String

    protected abstract val validStrings: Iterable<String>
    protected abstract val invalidStrings: Iterable<String>

    protected abstract val clazz: Class<T>

    private fun forEachValidString(run: (String) -> Unit) {

        validStrings.forEach(run)
    }

    private fun forEachValidStringAsObject(run: (T) -> Unit) {

        forEachValidString {
            run(stringToObject(it))
        }
    }

    private fun String.quoted() = "\"$this\""
    private fun String.unquoted() = this.substring(1, this.length - 1)

    private fun T.toJSON() = jacksonObjectMapper().writeValueAsString(this)

    /*
     *  Isomorphie between String and Objects wrt '=='
     */
    // 1
    fun `each invalid String will raise an IllegalArgumentException`() {

        invalidStrings.forEach { assertThrows<IllegalArgumentException> { stringToObject(it) } }
    }

    // 2
    fun `valid Strings can be turned to Objects`() {

        forEachValidString {
            assertDoesNotThrow { stringToObject(it) }
        }
    }

    // 3
    fun `stringToObject and ObjectToString are inverse`() {

        forEachValidString {
            assertEquals(it, objectToString(stringToObject(it)))
        }
    }

    /*
     *  Serialization
     */
    // 4
    fun `all Objects can be written as JSON`() {

        forEachValidStringAsObject { it.toJSON() }
    }

    fun `Writing as JSON String is same as objectToString with Quotes`() {

        forEachValidStringAsObject {
            val serialized = it.toJSON()
            assertEquals(serialized, objectToString(it).quoted())
        }
    }

    fun `Reading from JSON String is the same as stringToObject without Quotes`() {

        forEachValidStringAsObject {
            val unquotedJSON = it.toJSON().unquoted()
            assertEquals(it, stringToObject(unquotedJSON))
        }
    }

    fun `Consecutive Writing and Reading of objects preserves equality`() {

        forEachValidStringAsObject {
            val reReadObject: T = jacksonObjectMapper().readValue(it.toJSON(), clazz)
            Assertions.assertEquals(reReadObject, it)
        }
    }
}

//
// internal fun <T> Iterable<T>.serializedSameAs(transform: (T) -> String) {
//
//    forEach {
//
//        val serialized = jacksonObjectMapper().writeValueAsString(it)
//        Assertions.assertEquals(serialized, transform(it).quoted())
//    }
// }
