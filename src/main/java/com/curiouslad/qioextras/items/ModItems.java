package com.curiouslad.qioextras.items;


import com.curiouslad.qioextras.util.Registration;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static void register() {

    }

}
