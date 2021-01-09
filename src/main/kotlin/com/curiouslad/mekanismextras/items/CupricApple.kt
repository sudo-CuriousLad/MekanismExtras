package com.curiouslad.mekanismextras.items

import com.curiouslad.mekanismextras.MekanismExtras
import net.minecraft.item.Food
import net.minecraft.item.Item
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.Effects

class CupricApple : Item(Properties().group(MekanismExtras.CREATIVE_TAB)
        .food(Food.Builder()
                .hunger(5)
                .saturation(1.5f).effect({ EffectInstance(Effects.GLOWING, 300, 1) }, 0.5f)
                .build()))