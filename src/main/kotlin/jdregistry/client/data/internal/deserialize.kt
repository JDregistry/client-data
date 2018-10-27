package jdregistry.client.data.internal

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import jdregistry.client.data.PathComponent
import jdregistry.client.data.Tag
import java.io.IOException

internal sealed class DockerDeserializer<T>(vc: Class<T>? = null) : StdDeserializer<T>(vc) {

    abstract fun textToObject(text: String): T

    @Throws(IOException::class, JsonProcessingException::class)
    final override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): T {

        val node: JsonNode = jp.codec.readTree(jp)
        return textToObject(node.asText())
    }
}

internal class TagDeserializer
@JvmOverloads constructor(vc: Class<Tag>? = null) : DockerDeserializer<Tag>(vc) {

    override fun textToObject(text: String) = Tag.from(text)
}

internal class PathComponentDeserializer
@JvmOverloads constructor(vc: Class<PathComponent>? = null) : DockerDeserializer<PathComponent>(vc) {

    override fun textToObject(text: String) = PathComponent.from(text)
}
