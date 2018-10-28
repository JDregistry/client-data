package jdregistry.client.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import jdregistry.client.data.internal.RepositoryNameDeserializer
import jdregistry.client.data.internal.RepositoryNameSerializer

/**
 * Represents a Docker [RepositoryName] as it is defined by the official Docker Registry V2 API
 * specification
 *
 * @author Lukas Zimmermann
 * @since 0.0.7
 *
 */
@JsonSerialize(using = RepositoryNameSerializer::class)
@JsonDeserialize(using = RepositoryNameDeserializer::class)
interface RepositoryName {

    /**
     * The canonical representation of a Docker Path Component
     */
    val repr: String

    /**
     * Representation of this [RepositoryName] as List of [PathComponent]
     */
    val list: List<PathComponent>

    /**
     * Resolves this [RepositoryName] against a provided Docker [Tag] and
     * returns the normal [String] representation of a Docker [RepositoryName] with
     * a [Tag].
     *
     * @param tag The Docker [Tag] to which resolve against
     * @param host The optional host [String] that is going to be appended to the Docker [RepositoryName]
     * @return The [String] representation that results from combining this [RepositoryName], the [Tag] and the host
     */
    fun resolve(tag: Tag, host: String? = null): String

    private data class Generic(override val list: List<PathComponent>) : RepositoryName {

        override val repr = list.joinToString(separator = SEP) { it.repr }

        override fun resolve(tag: Tag, host: String?): String {

            // Ensures that if the host is not null that the string will be terminated by one single /
            val hostPrefix = host?.let { if (it.endsWith(SEP)) it else "$it$SEP" }.orEmpty()
            return "$hostPrefix${this.repr}:${tag.repr}"
        }
    }

    companion object {

        private const val SEP = "/"
        private const val LENGTH_BOUND = 256

        fun from(input: String): RepositoryName {

            val inputLength = input.length

            // Check that the input String is not too long
            require(inputLength < LENGTH_BOUND) {

                "String Representation of input $input too long. Have $inputLength, but length must be less than $LENGTH_BOUND"
            }

            val components = input.split(SEP).map { PathComponent.from(it) }

            // There needs to be at least one path component
            require(components.isNotEmpty()) {

                "There needs to be at least one Path Component in the input string $input"
            }
            return Generic(components)
        }
    }
}
