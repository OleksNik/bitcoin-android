package io.cersetwallet.bitcoincore.apisync.blockchair

import io.cersetwallet.bitcoincore.apisync.model.BlockHeaderItem

class BlockchairLastBlockProvider(
    private val blockchairApi: BlockchairApi
) {
    fun lastBlockHeader(): BlockHeaderItem {
        return blockchairApi.lastBlockHeader()
    }
}
