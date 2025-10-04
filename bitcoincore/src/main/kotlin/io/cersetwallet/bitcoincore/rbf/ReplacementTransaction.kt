package io.cersetwallet.bitcoincore.rbf

import io.cersetwallet.bitcoincore.models.TransactionInfo
import io.cersetwallet.bitcoincore.transactions.builder.MutableTransaction

data class ReplacementTransaction(
    internal val mutableTransaction: MutableTransaction,
    val info: TransactionInfo,
    val replacedTransactionHashes: List<String>
)

data class ReplacementTransactionInfo(
    val replacementTxMinSize: Long,
    val feeRange: LongRange
)
