package com.molybdenum.alloyed;

import com.molybdenum.alloyed.registry.ModBlocks;
import com.molybdenum.alloyed.registry.ModCompatItems;
import com.molybdenum.alloyed.registry.ModItems;
import com.molybdenum.alloyed.registry.ModSounds;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.NonNullLazyValue;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Alloyed.MOD_ID)
public class Alloyed {

    public static final String MOD_ID = "alloyed";
    public static final Logger LOGGER = LogManager.getLogger();

    // Compat
    public static boolean isFarmersDelightLoaded = false;

    private static final NonNullLazyValue<CreateRegistrate> REGISTRATE = CreateRegistrate.lazy(MOD_ID);

    public Alloyed() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        isFarmersDelightLoaded = ModList.get().isLoaded("farmersdelight");

        ModItems.register();
        ModCompatItems.register();
        ModBlocks.register();
        ModSounds.register(eventBus);

        LOGGER.debug("Finished registering items, blocks, and sounds!");
    }

    public static CreateRegistrate getRegistrate() {
        return REGISTRATE.get();
    }

}
