package kr.camp.youtube

import com.google.gson.Gson
import org.junit.Test
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder
import java.io.ByteArrayOutputStream
import java.util.zip.Deflater
import java.util.zip.Inflater

class GsonTest {

    data class Person(
        val name: String,
        val age: Int,
        val money: Double
    )

    @Test
    fun gson_test() {
        val gson = Gson()
        val person = Person("홍길동", 25, 1525.9)
        val json = gson.toJson(person)
        println("JSON String: $json")

        val newPerson = gson.fromJson(json, Person::class.java)
        println("Person: $newPerson")
    }

    @Test
    fun gson_base64coder_test() {
        val gson = Gson()
        val person = Person("홍길동", 25, 1525.9)
        val json = gson.toJson(person)
        val byteArray = json.toByteArray()
        val compressedByteArray = byteArray.toCompressedByteArray()
        val compressedString = Base64Coder.encodeLines(compressedByteArray)

        println()
        println("JSON String: $json")
        println("ByteArray: ${byteArray.joinToString(" ")}")
        println("Compressed ByteArray: ${compressedByteArray.joinToString(" ")}")
        println("Compressed String: $compressedString")
        println()

        val newCompressedByteArray = Base64Coder.decodeLines(compressedString)
        val decompressedByteArray = newCompressedByteArray.toDecompressedByteArray()
        val newJson = String(decompressedByteArray)
        val newPerson = gson.fromJson(newJson, Person::class.java)
        println()
        println("Compressed ByteArray: ${newCompressedByteArray.joinToString(" ")}")
        println("Decompressed ByteArray: ${decompressedByteArray.joinToString(" ")}")
        println("JSON String: $newJson")
        println("Person: $newPerson")
        println()
    }

    private fun ByteArray.toCompressedByteArray(): ByteArray {
        val deflater = Deflater()
        deflater.setLevel(Deflater.BEST_COMPRESSION)
        deflater.setInput(this)
        deflater.finish()
        val out = ByteArrayOutputStream(this.size)
        val buffer = ByteArray(1024)
        while (!deflater.finished()) {
            val count = deflater.deflate(buffer)
            out.write(buffer, 0, count)
        }
        out.close()
        return out.toByteArray()
    }

    private fun ByteArray.toDecompressedByteArray(): ByteArray {
        val inflater = Inflater()
        inflater.setInput(this)
        val out = ByteArrayOutputStream(this.size)
        val buffer = ByteArray(1024)
        while (!inflater.finished()) {
            val count = inflater.inflate(buffer)
            out.write(buffer, 0, count)
        }
        out.close()
        return out.toByteArray()
    }
}