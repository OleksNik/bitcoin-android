package io.cersetwallet.bitcoincore.blocks

import io.cersetwallet.bitcoincore.core.HashBytes
import io.cersetwallet.bitcoincore.models.MerkleBlock
import io.cersetwallet.bitcoincore.network.messages.MerkleBlockMessage
import io.cersetwallet.bitcoincore.utils.MerkleBranch

class MerkleBlockExtractor(private val maxBlockSize: Int) {

    fun extract(message: MerkleBlockMessage): MerkleBlock {
        val matchedHashes = mutableMapOf<HashBytes, Boolean>()
        val merkleRoot = MerkleBranch().calculateMerkleRoot(message.txCount, message.hashes, message.flags, matchedHashes)

        message.apply {
            if (txCount < 1 || txCount > maxBlockSize / 60) {
                throw InvalidMerkleBlockException(String.format("Transaction count %d is not valid", txCount))
            }

            if (hashCount < 0 || hashCount > txCount) {
                throw InvalidMerkleBlockException(String.format("Hash count %d is not valid", hashCount))
            }

            if (flagsCount < 1) {
                throw InvalidMerkleBlockException(String.format("Flag count %d is not valid", flagsCount))
            }

            if (!header.merkleRoot.contentEquals(merkleRoot)) {
                throw InvalidMerkleBlockException("Merkle root is not valid")
            }
        }

        return MerkleBlock(message.header, matchedHashes)
    }
}

class InvalidMerkleBlockException(message: String) : Exception(message)
