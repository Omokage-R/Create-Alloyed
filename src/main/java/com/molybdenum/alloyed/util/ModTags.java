package com.molybdenum.alloyed.util;

import com.molybdenum.alloyed.Alloyed;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Items {

        // Compat for other mods' ingots
        public static final Tags.IOptionalNamedTag<Item> BRONZE_INGOT = createForgeTag("ingots/bronze");
        public static final Tags.IOptionalNamedTag<Item> STEEL_INGOT = createForgeTag("ingots/steel");

        private static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(Alloyed.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }

}
