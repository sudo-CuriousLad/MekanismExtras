package com.curiouslad.qioextras.blocks;

import com.curiouslad.qioextras.QioExtras;
import com.curiouslad.qioextras.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON
    ).hardnessAndResistance(3f, 10f ).sound(SoundType.NETHERITE)));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK
    ).hardnessAndResistance(3f, 10f ).sound(SoundType.NETHER_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().group(QioExtras.CREATIVE_TAB)));
        return toReturn;
    }

}
