package jdregistry.client.data.internal

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import jdregistry.client.data.PathComponent
import jdregistry.client.data.RepositoryName
import jdregistry.client.data.Tag
import java.io.IOException

internal sealed class DockerSerializer<T>(t: Class<T>? = null) : StdSerializer<T>(t) {

    abstract fun objectToText(obj: T): String

    @Throws(IOException::class, JsonProcessingException::class)
    final override fun serialize(
        value: T,
        jgen: JsonGenerator,
        provider: SerializerProvider
    ) {
        jgen.writeString(objectToText(value))
    }
}

internal class TagSerializer
@JvmOverloads constructor(t: Class<Tag>? = null) : DockerSerializer<Tag>(t) {

    override fun objectToText(obj: Tag) = obj.repr
}

internal class PathComponentSerializer
@JvmOverloads constructor(t: Class<PathComponent>? = null) : DockerSerializer<PathComponent>(t) {

    override fun objectToText(obj: PathComponent) = obj.repr
}

internal class RepositoryNameSerializer
@JvmOverloads constructor(t: Class<RepositoryName>? = null) : DockerSerializer<RepositoryName>(t) {

    override fun objectToText(obj: RepositoryName) = obj.repr
}
