package ru.blackmirrror.receivingpayments.app.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class DoubleTypeAdapterFactory : JsonSerializer<Double?>, JsonDeserializer<Double?> {
    override fun serialize(src: Double?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return if (src == null) {
            JsonNull.INSTANCE
        } else {
            JsonPrimitive(src)
        }
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Double? {
        if (json?.isJsonPrimitive == true && json.asJsonPrimitive.isNumber) {
            return json.asJsonPrimitive.asDouble
        } else if (json?.isJsonPrimitive == true && json.asJsonPrimitive.isString) {
            return try {
                json.asJsonPrimitive.asString.toDouble()
            } catch (e: NumberFormatException) {
                null
            }
        }
        return null
    }
}
