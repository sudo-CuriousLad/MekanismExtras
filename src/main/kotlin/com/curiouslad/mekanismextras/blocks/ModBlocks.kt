package com.curiouslad.mekanismextras.blocks

import com.curiouslad.mekanismextras.MekanismExtras
import com.curiouslad.mekanismextras.util.Registration
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.common.ToolType
import net.minecraftforge.fml.RegistryObject
import java.util.function.Supplier

object ModBlocks {
    val COPPER_BLOCK = register("copper_block") {
        Block(AbstractBlock.Properties.create(Material.IRON
        ).hardnessAndResistance(3f, 10f).sound(SoundType.NETHERITE))
    }
    val COPPER_ORE = register("copper_ore") {
        Block(AbstractBlock.Properties.create(Material.ROCK
        ).hardnessAndResistance(3f, 10f).sound(SoundType.STONE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2))
    }

    fun register() {}
    private fun <T : Block?> register(name: String, block: Supplier<T>): RegistryObject<T> {
        val toReturn = Registration.BLOCKS.register(name, block)
        Registration.ITEMS.register(name) { BlockItem(toReturn.get(), Item.Properties().group(MekanismExtras.CREATIVE_TAB)) }
        return toReturn
    }
}