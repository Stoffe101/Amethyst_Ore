package com.example.amethystore;

import com.example.amethystore.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AmethystOreMod.MOD_ID)
public class AmethystOreMod {
    public static final String MOD_ID = "amethystore";

    public AmethystOreMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register blocks
        ModBlocks.register(modEventBus);

        // Add creative mode tab contents
        modEventBus.addListener(this::addCreative);
        
        // Setup common initialization
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Any common setup code goes here
        event.enqueueWork(() -> {
            // This code is run on the main thread and can safely access registries
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS || 
            event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.AMETHYST_ORE);
            event.accept(ModBlocks.DEEPSLATE_AMETHYST_ORE);
        }
    }
}
