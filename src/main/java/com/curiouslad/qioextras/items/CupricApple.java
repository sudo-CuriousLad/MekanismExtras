package com.curiouslad.qioextras.items;

import com.curiouslad.qioextras.QioExtras;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CupricApple extends Item {

    public CupricApple(){
        super(new Properties().group(QioExtras.CREATIVE_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f).effect(() -> new EffectInstance(Effects.GLOWING, 300, 1), 0.5f)
                        .build()));
    }
}
