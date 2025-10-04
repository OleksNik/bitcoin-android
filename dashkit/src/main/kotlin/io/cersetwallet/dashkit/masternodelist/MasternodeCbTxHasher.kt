package io.cersetwallet.dashkit.masternodelist

import io.cersetwallet.bitcoincore.core.HashBytes
import io.cersetwallet.bitcoincore.core.IHasher
import io.cersetwallet.dashkit.models.CoinbaseTransaction
import io.cersetwallet.dashkit.models.CoinbaseTransactionSerializer

class MasternodeCbTxHasher(private val coinbaseTransactionSerializer: CoinbaseTransactionSerializer, private val hasher: IHasher) {

    fun hash(coinbaseTransaction: CoinbaseTransaction): HashBytes {
        val serialized = coinbaseTransactionSerializer.serialize(coinbaseTransaction)

        return HashBytes(hasher.hash(serialized))
    }

}
