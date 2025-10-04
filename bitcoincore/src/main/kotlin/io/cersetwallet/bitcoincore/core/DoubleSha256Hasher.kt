package io.cersetwallet.bitcoincore.core

import io.cersetwallet.bitcoincore.utils.HashUtils

class DoubleSha256Hasher : IHasher {
    override fun hash(data: ByteArray): ByteArray {
        return HashUtils.doubleSha256(data)
    }
}
