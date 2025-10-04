package io.cersetwallet.bitcoincore.storage

import androidx.room.TypeConverter
import io.cersetwallet.bitcoincore.extensions.hexToByteArray
import io.cersetwallet.bitcoincore.extensions.toHexString

class WitnessConverter {

    @TypeConverter
    fun fromWitness(list: List<ByteArray>): String {
        return list.joinToString(", ") {
            it.toHexString()
        }
    }

    @TypeConverter
    fun toWitness(data: String): List<ByteArray> = when {
        data.isEmpty() -> listOf()
        else -> data.split(", ").map {
            it.hexToByteArray()
        }
    }
}
