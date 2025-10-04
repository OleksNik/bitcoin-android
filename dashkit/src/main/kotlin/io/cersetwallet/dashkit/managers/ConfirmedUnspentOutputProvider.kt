package io.cersetwallet.dashkit.managers

import io.cersetwallet.bitcoincore.core.IStorage
import io.cersetwallet.bitcoincore.managers.IUnspentOutputProvider
import io.cersetwallet.bitcoincore.storage.UnspentOutput
import io.cersetwallet.bitcoincore.storage.UtxoFilters

class ConfirmedUnspentOutputProvider(private val storage: IStorage, private val confirmationsThreshold: Int) : IUnspentOutputProvider {
    override fun getSpendableUtxo(filters: UtxoFilters): List<UnspentOutput> {
        val lastBlockHeight = storage.lastBlock()?.height ?: 0

        return storage.getUnspentOutputs().filter {
            isOutputConfirmed(it, lastBlockHeight) && filters.filterUtxo(it, storage)
        }
    }

    private fun isOutputConfirmed(unspentOutput: UnspentOutput, lastBlockHeight: Int): Boolean {
        val block = unspentOutput.block ?: return false

        return block.height <= lastBlockHeight - confirmationsThreshold + 1
    }
}
