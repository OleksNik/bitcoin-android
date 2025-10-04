package io.cersetwallet.bitcoincore.transactions.builder

import io.cersetwallet.bitcoincore.core.IStorage

class LockTimeSetter(private val storage: IStorage) {

    fun setLockTime(transaction: MutableTransaction) {
        transaction.transaction.lockTime = storage.lastBlock()?.height?.toLong() ?: 0
    }

}
