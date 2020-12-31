package com.curiouslad.qioextras.items;


import com.curiouslad.qioextras.QioExtras;
import com.curiouslad.qioextras.util.Registration;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(QioExtras.CREATIVE_TAB)));
    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire", () -> new Item(new Item.Properties().group(QioExtras.CREATIVE_TAB)));

    public static final RegistryObject<Item> CUPRIC_APPLE =
            Registration.ITEMS.register("cupric_apple", () -> new CupricApple());
    public static void register() {

    }

}
