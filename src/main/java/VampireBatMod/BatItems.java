package VampireBatMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by minecraft on 7/9/14.
 */
@Mod(modid = "VampireBatMod", name = "ItemsMod")
public class BatItems {
    public static BatFur batFur;
    public static BatTooth batTooth;
    public static VampireBlood vampireBlood;
    public static RawBatMeat rawBatMeat;
    public static CookedBatMeat cookedBatMeat;

    @Mod.EventHandler
    public void load(FMLInitializationEvent e) {
        batTooth = new BatTooth();
        GameRegistry.registerItem(batTooth, "batTooth");
        batFur = new BatFur();
        GameRegistry.registerItem(batFur, "batFur");
        GameRegistry.addShapelessRecipe(new ItemStack(net.minecraft.init.Items.leather),
                batFur, batFur, batFur, batFur, batFur, batFur, batFur, batFur, batFur);
        vampireBlood = new VampireBlood();
        GameRegistry.registerItem(vampireBlood, "vampireBlood");
        GameRegistry.addShapelessRecipe(new ItemStack(BatItems.vampireBlood),
                Items.rotten_flesh, Items.spider_eye, batTooth, net.minecraft.init.Items.rotten_flesh,
                net.minecraft.init.Items.spider_eye, batTooth, net.minecraft.init.Items.rotten_flesh,
                net.minecraft.init.Items.spider_eye, batTooth);
        rawBatMeat = new RawBatMeat();
        GameRegistry.registerItem(rawBatMeat, "rawBatMeat");
        cookedBatMeat = new CookedBatMeat();
        GameRegistry.registerItem(cookedBatMeat, "cookedBatMeat");
        EntityList.addMapping(VampireBat.class, "vampireBat", 108, 0x000000, 0xFFFFFF);
        EntityRegistry.addSpawn(VampireBat.class, 1, 1, 1, EnumCreatureType.ambient);
        {MinecraftForge.EVENT_BUS.register(this);
        }

        {MinecraftForge.EVENT_BUS.register(vampireBlood);}
    }
}
