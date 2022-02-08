package dev.tilbrook.proto3json

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.wire.WireJsonAdapterFactory

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalStdlibApi::class)
@RunWith(AndroidJUnit4::class)
class JsonReadTest {
    @Test
    fun canReadProto3Json() {
        val json = """
            {
              "name": "Mitchell",
              "contacts": ["Jim", "Julia"],
              "age": 90001,
              "height": 90002
            }
        """.trimIndent()
        val moshi = Moshi.Builder().add(WireJsonAdapterFactory()).build()
        val adapter = moshi.adapter<Person>()

        val person = adapter.fromJson(json)

        assertNotNull(person)
        assert(person?.name == "Mitchell")
    }

    @Test
    fun canReadDogProto3Json() {
        val json = """
            {
              "name": "Wolly",
              "bread": "kelpie",
              "age": 2,
              "height": 30
            }
        """.trimIndent()
        val moshi = Moshi.Builder().add(WireJsonAdapterFactory()).build()
        val adapter = moshi.adapter<Dog>()

        val person = adapter.fromJson(json)

        assertNotNull(person)
        assert(person?.name == "Wolly")
    }
}