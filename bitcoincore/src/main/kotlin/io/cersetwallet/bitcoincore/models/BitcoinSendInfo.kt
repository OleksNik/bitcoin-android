package io.cersetwallet.bitcoincore.models

import io.cersetwallet.bitcoincore.storage.UnspentOutput

data class BitcoinSendInfo(
    val unspentOutputs: List<UnspentOutput>,
    val fee: Long,
    val changeValue: Long?,
    val changeAddress: Address?
)