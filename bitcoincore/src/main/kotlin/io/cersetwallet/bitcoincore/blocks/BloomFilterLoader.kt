package io.cersetwallet.bitcoincore.blocks

import io.cersetwallet.bitcoincore.crypto.BloomFilter
import io.cersetwallet.bitcoincore.managers.BloomFilterManager
import io.cersetwallet.bitcoincore.network.peer.Peer
import io.cersetwallet.bitcoincore.network.peer.PeerGroup
import io.cersetwallet.bitcoincore.network.peer.PeerManager

class BloomFilterLoader(private val bloomFilterManager: BloomFilterManager, private val peerManager: PeerManager)
    : PeerGroup.Listener, BloomFilterManager.Listener {

    override fun onPeerConnect(peer: Peer) {
        bloomFilterManager.bloomFilter?.let {
            peer.filterLoad(it)
        }
    }

    override fun onFilterUpdated(bloomFilter: BloomFilter) {
        peerManager.connected().forEach {
            it.filterLoad(bloomFilter)
        }
    }
}
