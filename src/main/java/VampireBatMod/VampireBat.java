package VampireBatMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;


/**
 * Created by minecraft on 7/7/14.
 */
public class VampireBat extends EntityBat {

    public VampireBat(World world) {
        super(world);
    }

    protected Item getDropItem() {
        return BatItems.batFur;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        int k;

        for (k = 0; k < j; ++k) {
            this.dropItem(BatItems.batTooth, 1);
            this.dropItem(BatItems.rawBatMeat, 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

        for (k = 0; k < j; ++k) {
            if (this.isBurning()) {
                this.dropItem(BatItems.cookedBatMeat, 1);
            } else {
                this.dropItem(BatItems.batFur, 1);
            }
        }
    }

    @Mod.EventHandler
    public void registerHandler(FMLPostInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public void spawnhandler(LivingSpawnEvent event) {
        if (event instanceof LivingSpawnEvent.SpecialSpawn) {
            if (event.entityLiving instanceof EntityBat) {
                event.setCanceled(true);
            }
            VampireBat b = new VampireBat(event.world);
            b.posX = event.x;
            b.posY = event.y;
            b.posZ = event.z;

            event.world.spawnEntityInWorld(b);
        }
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        EntityList.addMapping(VampireBat.class, "vampireBat", 108, 0x000000, 0xFFFFFF);
        EntityRegistry.addSpawn(VampireBat.class, 1, 1, 1, EnumCreatureType.ambient);


    }

}