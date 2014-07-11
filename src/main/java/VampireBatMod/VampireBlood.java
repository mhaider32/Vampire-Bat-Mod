package VampireBatMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;

/**
 * Created by minecraft on 7/7/14.
 */
public class VampireBlood extends ItemFood {

    public VampireBlood() {
        // heal amount, saturation modifier, wolves like
        super(4, 12.8f, false);
        this.setMaxStackSize(1);
        this.setPotionEffect(Potion.jump.id, 100, 2, 1);
        this.setUnlocalizedName("vampireBlood");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister i) {
        this.itemIcon = i.registerIcon("vampirebatmod:VampireBlood");
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
        super.onEaten(itemStack, world, player);
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 2));
        player.addPotionEffect(new PotionEffect(Potion.blindness.id, 600, 1));
        return itemStack;

    }

    @SubscribeEvent
    public void BloodEffect(EntityViewRenderEvent.FogColors e) {
        e.red = 1;
        e.green = 1;
        e.blue = 1;
    }

}
