package io.cersetwallet.bitcoincore.managers

import io.cersetwallet.bitcoincore.storage.UnspentOutput
import io.cersetwallet.bitcoincore.storage.UtxoFilters

interface IUnspentOutputProvider {
    fun getSpendableUtxo(filters: UtxoFilters): List<UnspentOutput>
}
