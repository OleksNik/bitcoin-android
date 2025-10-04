package io.cersetwallet.bitcoincore.apisync

import io.cersetwallet.bitcoincore.apisync.model.TransactionItem
import io.cersetwallet.bitcoincore.core.IApiTransactionProvider
import io.cersetwallet.bitcoincore.managers.ApiSyncStateManager

class BiApiTransactionProvider(
    private val restoreProvider: IApiTransactionProvider,
    private val syncProvider: IApiTransactionProvider,
    private val syncStateManager: ApiSyncStateManager
) : IApiTransactionProvider {

    override fun transactions(addresses: List<String>, stopHeight: Int?): List<TransactionItem> =
        if (syncStateManager.restored) {
            syncProvider.transactions(addresses, stopHeight)
        } else {
            restoreProvider.transactions(addresses, stopHeight)
        }
}
