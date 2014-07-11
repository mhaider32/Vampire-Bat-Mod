package VampireBatMod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

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
    public static BatSword batSword;
    public static Batarang batarang;
    public static BatHelmet batHelmet;

    @Mod.EventHandler
    public void load(FMLInitializationEvent e) {
       batarang = new Batarang();
        batTooth = new BatTooth();
        batFur = new BatFur();
        rawBatMeat = new RawBatMeat();
        Item.ToolMaterial batToothMaterial = EnumHelper.addToolMaterial("batTooth", 0, 300, 6, 5.0f, 18);
        batSword = new BatSword(batToothMaterial);
        vampireBlood = new VampireBlood();
        batHelmet = new BatHelmet(batToothArmorMaterial);
        cookedBatMeat = new CookedBatMeat();
        GameRegistry.registerItem(batarang,"batarang");
        GameRegistry.registerItem(batTooth, "batTooth");
        GameRegistry.registerItem(batHelmet,"batHelmet");

        GameRegistry.registerItem(batFur, "batFur");
        RenderingRegistry.registerEntityRenderingHandler(BatarangEntity.class, new RenderBatarang(batarang));

       GameRegistry.registerItem(batSword, "batSword");
        GameRegistry.addShapedRecipe(new ItemStack(BatItems.batSword),
                "TDT",
                "TDT",
                " S ",
                'T',batTooth,'D',Items.diamond,'S',Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(BatItems.batHelmet),
                "DDD",
                "DBD",
                "BBB",
                'D',Items.diamond,'B',batFur);


        GameRegistry.registerItem(vampireBlood, "vampireBlood");
        GameRegistry.addShapelessRecipe(new ItemStack(BatItems.vampireBlood),
                Items.rotten_flesh, Items.spider_eye, batTooth, net.minecraft.init.Items.rotten_flesh,
                net.minecraft.init.Items.spider_eye, batTooth, net.minecraft.init.Items.rotten_flesh,
                net.minecraft.init.Items.spider_eye, batTooth);

        GameRegistry.registerItem(rawBatMeat, "rawBatMeat");

        GameRegistry.registerItem(cookedBatMeat, "cookedBatMeat");
        EntityList.addMapping(VampireBat.class, "vampireBat", 108, 0x000000, 0xFFFFFF);
        EntityRegistry.addSpawn(VampireBat.class, 1, 1, 1, EnumCreatureType.ambient);
        EntityRegistry.registerModEntity(BatarangEntity.class, "batarang",110, this, 30, 1, true);
        MinecraftForge.EVENT_BUS.register(this);

        GameRegistry.addShapelessRecipe(new ItemStack(net.minecraft.init.Items.leather),
                batFur, batFur, batFur, batFur, batFur, batFur, batFur, batFur, batFur);

        {MinecraftForge.EVENT_BUS.register(vampireBlood);}
        GameRegistry.addShapedRecipe(new ItemStack(BatItems.batarang),
                "BBB",
                "TIT",
                "III",
                'B', batFur,'T',batTooth,'I',Items.iron_ingot);
    }
}
