package io.cersetwallet.dashkit.messages

import io.cersetwallet.bitcoincore.extensions.toReversedHex
import io.cersetwallet.bitcoincore.io.BitcoinOutput
import io.cersetwallet.bitcoincore.network.messages.IMessage
import io.cersetwallet.bitcoincore.network.messages.IMessageSerializer

class GetMasternodeListDiffMessage(val baseBlockHash: ByteArray, val blockHash: ByteArray) : IMessage {
    override fun toString(): String {
        return "GetMasternodeListDiffMessage(baseBlockHash=${baseBlockHash.toReversedHex()}, blockHash=${blockHash.toReversedHex()})"
    }
}

class GetMasternodeListDiffMessageSerializer : IMessageSerializer {
    override val command: String = "getmnlistd"

    override fun serialize(message: IMessage): ByteArray? {
        if (message !is GetMasternodeListDiffMessage) {
            return null
        }

        return BitcoinOutput()
                .write(message.baseBlockHash)
                .write(message.blockHash)
                .toByteArray()
    }
}
