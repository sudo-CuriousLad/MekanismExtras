package com.curiouslad.mekanismextras.util

import com.curiouslad.mekanismextras.MekanismExtras
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.KotlinModLoadingContext.Companion.get

object Registration {
    val BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MekanismExtras.MOD_ID)
    val ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MekanismExtras.MOD_ID)
    fun register() {
        val eventBus: IEventBus = get().getKEventBus()
        BLOCKS.register(eventBus)
        ITEMS.register(eventBus)
    }
}