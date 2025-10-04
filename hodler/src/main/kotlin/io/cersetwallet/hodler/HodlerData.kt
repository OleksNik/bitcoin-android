package io.cersetwallet.hodler

import io.cersetwallet.bitcoincore.core.IPluginData

data class HodlerData(val lockTimeInterval: LockTimeInterval) : IPluginData
