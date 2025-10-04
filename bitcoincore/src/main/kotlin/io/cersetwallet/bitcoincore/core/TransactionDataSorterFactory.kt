package io.cersetwallet.bitcoincore.core

import io.cersetwallet.bitcoincore.models.TransactionDataSortType
import io.cersetwallet.bitcoincore.utils.Bip69Sorter
import io.cersetwallet.bitcoincore.utils.ShuffleSorter
import io.cersetwallet.bitcoincore.utils.StraightSorter

class TransactionDataSorterFactory : ITransactionDataSorterFactory {
    override fun sorter(type: TransactionDataSortType): ITransactionDataSorter {
        return when (type) {
            TransactionDataSortType.None -> StraightSorter()
            TransactionDataSortType.Shuffle -> ShuffleSorter()
            TransactionDataSortType.Bip69 -> Bip69Sorter()
        }
    }
}
