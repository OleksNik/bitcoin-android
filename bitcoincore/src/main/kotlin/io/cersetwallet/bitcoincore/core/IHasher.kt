package io.cersetwallet.bitcoincore.core

interface IHasher {
    fun hash(data: ByteArray) : ByteArray
}
