package com.curiouslad.mekanismextras

import com.curiouslad.mekanismextras.blocks.ModBlocks
import com.curiouslad.mekanismextras.items.ModItems
import com.curiouslad.mekanismextras.util.Registration
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent.Register
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.InterModComms
import net.minecraftforge.fml.InterModComms.IMCMessage
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent
import net.minecraftforge.fml.event.server.FMLServerStartingEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.KotlinModLoadingContext.Companion.get
import java.util.stream.Collectors

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MekanismExtras.MOD_ID)
class MekanismExtras {
    private fun setup() {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT")
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.registryName)
    }

    private fun doClientStuff(event: FMLClientSetupEvent) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.minecraftSupplier.get().gameSettings)
    }

    private fun enqueueIMC() {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld") {
            LOGGER.info("Hello world from the MDK")
            "Hello world"
        }
    }

    private fun processIMC(event: InterModProcessEvent) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.imcStream.map { m: IMCMessage -> m.getMessageSupplier<Any>().get() }.collect(Collectors.toList()))
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: FMLServerStartingEvent?) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting")
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
    object RegistryEvents {
        @SubscribeEvent
        fun onBlocksRegistry(blockRegistryEvent: Register<Block?>?) {
            // register a new block here
            LOGGER.info("HELLO from Register Block")
        }
    }

    companion object {
        const val MOD_ID = "mekanismextras"

        // Directly reference a log4j logger.
        private val LOGGER = LogManager.getLogger()
        val CREATIVE_TAB: ItemGroup = object : ItemGroup("creativeTab") {
            override fun createIcon(): ItemStack {
                return ItemStack(ModItems.COPPER_WIRE.get())
            }
        }
    }

    init {
        Registration.register()
        ModItems.register()
        ModBlocks.register()
        // Register the setup method for modloading
        get().getKEventBus().addListener { event: FMLCommonSetupEvent -> setup() }
        // Register the enqueueIMC method for modloading
        get().getKEventBus().addListener { event: InterModEnqueueEvent -> enqueueIMC() }
        // Register the processIMC method for modloading
        get().getKEventBus().addListener { event: InterModProcessEvent -> processIMC(event) }
        // Register the doClientStuff method for modloading
        get().getKEventBus().addListener { event: FMLClientSetupEvent -> doClientStuff(event) }

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this)
    }
}