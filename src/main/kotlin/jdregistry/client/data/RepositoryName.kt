package jdregistry.client.data

/**
 * Represents a Docker Repository Name, as specified by the official V2 API from Docker Registry
 *
 * @author Lukas Zimmermann
 * @since 0.0.3
 */
data class RepositoryName(

    /**
    *  The first Path Component of a Docker Repository Name
    */
    val firstPathComponent: String,
    private val morePathComponents: List<String> = emptyList()
) {

    init {
        // First component must be a valid path component
        require(isValidPathComponent(firstPathComponent)) {

            "The first Path Component from the RepositoryName is not valid: $firstPathComponent"
        }
        require(morePathComponents.all(::isValidPathComponent)) {

            "One of the additional Path Components is not valid"
        }

        // The total length is determined by the length from the first component plus the total
        // length from the other comoponents plus the number from '/' signs, which is equal to the
        // number from morePathComponents (as each from those is prefixed by '/)'
        val totalLength = firstPathComponent.length + morePathComponents.sumBy { it.length } + morePathComponents.size

        require(totalLength < 256) {

            "The maximal length from the RepositoryName is exceeded. Allowed: 255, have: $totalLength"
        }
    }

    /**
     * The number of path components this Docker Repository name consists of
     */
    val numberOfPathComponents = 1 + morePathComponents.size

    /**
     *   Whether this Docker Repository has more than one Path component
     */
    val hasMorePathComponents = morePathComponents.isNotEmpty()

    /**
     * Returns the ith path component of this [RepositoryName]
     *
     * @param index The ith path component to return
     * @return [String] representing the n
     */
    operator fun get(index: Int) = if (index == 0) firstPathComponent else morePathComponents[index - 1]

    fun asString() = firstPathComponent +
            morePathComponents
                    .joinToString(SEP)
                    .let { if (it.isEmpty()) "" else "$SEP$it" } // append separator

    override fun toString() = asString()

    fun resolve(tag: Tag = Tag.LATEST, host: String? = null): String {

        // Ensures that if the host is not null that the string will be terminated by one single /
        val hostPrefix = host?.let { if (it.endsWith(SEP)) it else "$it$SEP" } ?: ""

        return "$hostPrefix${this.asString()}:${tag.repr}"
    }

    private companion object {

        const val SEP = "/"
        val pathComponentRegex = Regex("[a-z0-9]+(?:[._-][a-z0-9]+)*")
        fun isValidPathComponent(item: String) = item.matches(pathComponentRegex)
    }
}
