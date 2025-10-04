package io.cersetwallet.bitcoincore.rbf

import io.cersetwallet.bitcoincore.models.Address
import io.cersetwallet.bitcoincore.models.PublicKey

sealed class ReplacementType {
    object SpeedUp : ReplacementType()
    data class Cancel(val address: Address, val publicKey: PublicKey) : ReplacementType()
}
