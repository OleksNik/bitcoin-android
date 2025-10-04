package io.cersetwallet.ecash

import io.cersetwallet.bitcoincore.core.scriptType
import io.cersetwallet.bitcoincore.extensions.toHexString
import io.cersetwallet.bitcoincore.managers.IRestoreKeyConverter
import io.cersetwallet.bitcoincore.models.PublicKey
import io.cersetwallet.bitcoincore.utils.IAddressConverter
import io.horizontalsystems.hdwalletkit.HDWallet

class ECashRestoreKeyConverter(
    private val addressConverter: IAddressConverter,
    private val purpose: HDWallet.Purpose
) : IRestoreKeyConverter {
    override fun keysForApiRestore(publicKey: PublicKey): List<String> {
        return listOf(
            publicKey.publicKeyHash.toHexString(),
            addressConverter.convert(publicKey, purpose.scriptType).stringValue
        )
    }

    override fun bloomFilterElements(publicKey: PublicKey): List<ByteArray> {
        return listOf(publicKey.publicKeyHash, publicKey.publicKey)
    }
}
