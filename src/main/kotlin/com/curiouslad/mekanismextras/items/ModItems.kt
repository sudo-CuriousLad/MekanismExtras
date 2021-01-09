package com.curiouslad.mekanismextras.items

import com.curiouslad.mekanismextras.MekanismExtras
import com.curiouslad.mekanismextras.util.Registration
import net.minecraft.item.*
import net.minecraft.item.crafting.Ingredient
import net.minecraftforge.common.ToolType
import net.minecraftforge.fml.RegistryObject

object ModItems {
    val COPPER_INGOT = Registration.ITEMS.register("copper_ingot"
    ) { Item(Item.Properties().group(MekanismExtras.CREATIVE_TAB)) }
    val COPPER_WIRE = Registration.ITEMS.register("copper_wire") { Item(Item.Properties().group(MekanismExtras.CREATIVE_TAB)) }
    val CUPRIC_APPLE = Registration.ITEMS.register<Item>("cupric_apple") { CupricApple() }
    val COPPER_SHOVEL = Registration.ITEMS.register<Item>("copper_shovel"
    ) {
        ShovelItem(ModItemTier.COPPER, 0f, 0f,
                Item.Properties()
                        .defaultMaxDamage(150)
                        .addToolType(ToolType.SHOVEL, 2)
                        .group(MekanismExtras.CREATIVE_TAB))
    }
    val COPPER_PICKAXE = Registration.ITEMS.register<Item>("copper_pickaxe"
    ) {
        PickaxeItem(ModItemTier.COPPER, 0, 0f,
                Item.Properties()
                        .defaultMaxDamage(450)
                        .addToolType(ToolType.PICKAXE, 2)
                        .group(MekanismExtras.CREATIVE_TAB))
    }
    val COPPER_SWORD = Registration.ITEMS.register<Item>("copper_sword"
    ) {
        SwordItem(ModItemTier.COPPER, 9, 2f,
                Item.Properties()
                        .defaultMaxDamage(300)
                        .group(MekanismExtras.CREATIVE_TAB))
    }
    val COPPER_HOE = Registration.ITEMS.register<Item>("copper_hoe"
    ) {
        HoeItem(ModItemTier.COPPER, 0, 0f,
                Item.Properties()
                        .defaultMaxDamage(300)
                        .addToolType(ToolType.HOE, 2)
                        .group(MekanismExtras.CREATIVE_TAB))
    }
    val COPPER_AXE = Registration.ITEMS.register<Item>("copper_axe"
    ) {
        AxeItem(ModItemTier.COPPER, 12f, 1.5f,
                Item.Properties()
                        .defaultMaxDamage(450)
                        .addToolType(ToolType.AXE, 2)
                        .group(MekanismExtras.CREATIVE_TAB))
    }

    fun register() {}
    enum class ModItemTier(private val harvestLevel: Int, private val maxUses: Int, private val efficiency: Float, private val attackDamage: Float, private val enchantibility: Int, private val repairMaterial: Ingredient) : IItemTier {
        COPPER(2, 1024, 2.5f, 0f, 25, Ingredient.fromStacks(ItemStack(COPPER_INGOT.get())));

        override fun getMaxUses(): Int {
            return maxUses
        }

        override fun getEfficiency(): Float {
            return efficiency
        }

        override fun getAttackDamage(): Float {
            return attackDamage
        }

        override fun getHarvestLevel(): Int {
            return harvestLevel
        }

        override fun getEnchantability(): Int {
            return enchantibility
        }

        override fun getRepairMaterial(): Ingredient {
            return repairMaterial
        }
    }
}