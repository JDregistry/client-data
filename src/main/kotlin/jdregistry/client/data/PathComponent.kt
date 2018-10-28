package jdregistry.client.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import jdregistry.client.data.internal.PathComponentDeserializer
import jdregistry.client.data.internal.PathComponentSerializer

/**
 * Represents a PathComponent of a Docker Registry
 *
 * @author Lukas Zimmermann
 * @since 0.0.7
 *
 */
@JsonSerialize(using = PathComponentSerializer::class)
@JsonDeserialize(using = PathComponentDeserializer::class)
interface PathComponent {

    /**
     * The [String] representation of a Docker Registry Path Component
     */
    val repr: String

    private data class Generic(override val repr: String) : PathComponent {

        init {
            require(repr.matches(pathComponentRegex)) {

                "Not a valid DockerPath Component"
            }
        }
        private companion object {

            val pathComponentRegex = Regex("[a-z0-9]+(?:[._-][a-z0-9]+)*")
        }
    }

    companion object {

        /**
         * Creates a [PathComponent] from the input [String]
         *
         * @param input The input [String] from which the [PathComponent] should be created from
         * @return The [PathComponent] representing the input [String]
         * @throws IllegalArgumentException if the input [String] does not represent a valid [PathComponent]
         */
        fun from(input: String): PathComponent = Generic(input)
    }
}
