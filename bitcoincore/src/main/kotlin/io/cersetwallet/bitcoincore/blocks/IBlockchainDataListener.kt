package io.cersetwallet.bitcoincore.blocks

import io.cersetwallet.bitcoincore.models.Block
import io.cersetwallet.bitcoincore.models.Transaction

interface IBlockchainDataListener {
    fun onBlockInsert(block: Block)
    fun onTransactionsUpdate(inserted: List<Transaction>, updated: List<Transaction>, block: Block?)
    fun onTransactionsDelete(hashes: List<String>)
}
