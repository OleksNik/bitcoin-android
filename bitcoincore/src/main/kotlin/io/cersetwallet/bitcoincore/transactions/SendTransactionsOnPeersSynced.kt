package io.cersetwallet.bitcoincore.transactions

import io.cersetwallet.bitcoincore.blocks.IPeerSyncListener

class SendTransactionsOnPeersSynced(var transactionSender: TransactionSender) : IPeerSyncListener {

    override fun onAllPeersSynced() {
        transactionSender.sendPendingTransactions()
    }

}

