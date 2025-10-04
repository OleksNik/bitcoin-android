package io.cersetwallet.dashkit.messages

import io.cersetwallet.bitcoincore.extensions.toReversedHex
import io.cersetwallet.bitcoincore.io.BitcoinInputMarkable
import io.cersetwallet.bitcoincore.network.messages.IMessage
import io.cersetwallet.bitcoincore.network.messages.IMessageParser
import io.cersetwallet.bitcoincore.serializers.TransactionSerializer
import io.cersetwallet.bitcoincore.storage.FullTransaction

class TransactionLockMessage(var transaction: FullTransaction) : IMessage {
    override fun toString(): String {
        return "TransactionLockMessage(${transaction.header.hash.toReversedHex()})"
    }
}

class TransactionLockMessageParser : IMessageParser {
    override val command: String = "ix"

    override fun parseMessage(input: BitcoinInputMarkable): IMessage {
        val transaction = TransactionSerializer.deserialize(input)
        return TransactionLockMessage(transaction)
    }
}
