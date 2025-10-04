package io.cersetwallet.dashkit.core

import io.cersetwallet.bitcoincore.core.IHasher
import io.cersetwallet.bitcoincore.utils.HashUtils

class SingleSha256Hasher : IHasher {
    override fun hash(data: ByteArray): ByteArray {
        return HashUtils.sha256(data)
    }
}