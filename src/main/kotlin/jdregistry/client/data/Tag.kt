package jdregistry.client.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import jdregistry.client.data.internal.TagDeserializer
import jdregistry.client.data.internal.TagSerializer

/**
 * Represents a Docker Tag for the Docker Registry
 *
 * @author Lukas Zimmermann
 * @since 0.0.4
 *
 */
@JsonSerialize(using = TagSerializer::class)
@JsonDeserialize(using = TagDeserializer::class)
interface Tag {

    /**
     * The [String] representation of the Docker Tag.
     */
    val repr: String

    private data class Generic(override val repr: String) : Tag {

        init {
            require(repr.matches(tagRegex)) {

                "Failed to create Docker Tag. The String $repr is not a valid Docker Tag."
            }
        }
        private companion object {
            private val tagRegex = Regex("[a-zA-Z0-9_][a-zA-Z0-9_.-]{0,127}")
        }
    }

    /**
     * Represents commonly used Docker Tags. Essentially, this only 'latest'
     *
     * @author Lukas Zimmermann
     * @see Tag
     * @since 0.0.4
     *
     */
    enum class Common(override val repr: String) : Tag {

        /**
         * The commonly used 'latest' tag
         */
        LATEST("latest")
    }

    companion object {

        /**
         * Short-wire reference of the commonly used Docker Tag 'latest'
         */
        val LATEST: Tag = Common.LATEST

        /**
         * Creates a [Tag] from the provided [String] representation
         *
         * @param input From which [String] the [Tag] instance should be created from
         * @return The [Tag] representing the input [String]
         * @throws IllegalArgumentException if the input [String] is not a valid Docker tag.
         */
        fun from(input: String): Tag = if (LATEST.repr == input) LATEST else Generic(input)
    }
}
