package io.cersetwallet.bitcoincore.network.peer.task

import io.cersetwallet.bitcoincore.network.messages.GetHeadersMessage
import io.cersetwallet.bitcoincore.network.messages.HeadersMessage
import io.cersetwallet.bitcoincore.network.messages.IMessage
import io.cersetwallet.bitcoincore.storage.BlockHeader

class GetBlockHeadersTask(private val blockLocatorHashes: List<ByteArray>) : PeerTask() {

    var blockHeaders = arrayOf<BlockHeader>()

    override fun start() {
        requester?.let { it.send(GetHeadersMessage(it.protocolVersion, blockLocatorHashes, ByteArray(32))) }
        resetTimer()
    }

    override fun handleMessage(message: IMessage): Boolean {
        if (message !is HeadersMessage) {
            return false
        }

        blockHeaders = message.headers
        listener?.onTaskCompleted(this)

        return true
    }

    override fun handleTimeout() {
        listener?.onTaskCompleted(this)
    }
}
