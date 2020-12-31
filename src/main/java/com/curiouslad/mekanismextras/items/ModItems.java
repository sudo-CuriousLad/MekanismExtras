package com.curiouslad.mekanismextras.items;


import com.curiouslad.mekanismextras.MekanismExtras;
import com.curiouslad.mekanismextras.util.Registration;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(MekanismExtras.CREATIVE_TAB)));
    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire", () -> new Item(new Item.Properties().group(MekanismExtras.CREATIVE_TAB)));

    public static final RegistryObject<Item> CUPRIC_APPLE =
            Registration.ITEMS.register("cupric_apple", () -> new CupricApple());
    public static void register() {

    }

}
