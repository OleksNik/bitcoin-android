package io.cersetwallet.bitcoincore.blocks.validators

import io.cersetwallet.bitcoincore.models.Block

class BlockValidatorSet : IBlockValidator {
    private var validators = mutableListOf<IBlockValidator>()

    override fun validate(block: Block, previousBlock: Block) {
        validators.forEach {
            it.validate(block, previousBlock)
        }
    }

    fun addBlockValidator(blockValidator: IBlockValidator) {
        validators.add(blockValidator)
    }

}
