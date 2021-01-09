package com.curiouslad.mekanismextras.items;


import com.curiouslad.mekanismextras.MekanismExtras;
import com.curiouslad.mekanismextras.util.Registration;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(MekanismExtras.CREATIVE_TAB)));
    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire", () -> new Item(new Item.Properties().group(MekanismExtras.CREATIVE_TAB)));

    public static final RegistryObject<Item> CUPRIC_APPLE =
            Registration.ITEMS.register("cupric_apple", () -> new CupricApple());

    public static final RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel", () -> new ShovelItem(ModItemTier.COPPER, 0f, 0f,
                    new Item.Properties()
            .defaultMaxDamage(150)
            .addToolType(ToolType.SHOVEL, 2)
            .group(MekanismExtras.CREATIVE_TAB))
            );
    public static void register() {

    }

    public enum ModItemTier implements IItemTier{
        COPPER(2, 1024, 2.5f, 0f, 25, Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantibility;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantibility, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantibility = enchantibility;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantibility;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }

}
