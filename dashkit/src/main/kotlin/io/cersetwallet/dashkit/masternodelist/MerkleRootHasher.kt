package io.cersetwallet.dashkit.masternodelist

import io.cersetwallet.bitcoincore.core.IHasher
import io.cersetwallet.bitcoincore.utils.HashUtils
import io.cersetwallet.dashkit.IMerkleHasher

class MerkleRootHasher: IHasher, IMerkleHasher {

    override fun hash(data: ByteArray): ByteArray {
        return HashUtils.doubleSha256(data)
    }

    override fun hash(first: ByteArray, second: ByteArray): ByteArray {
        return HashUtils.doubleSha256(first + second)
    }
}
