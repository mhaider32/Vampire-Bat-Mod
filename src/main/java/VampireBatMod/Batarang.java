package VampireBatMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemSnowball;

/**
 * Created by minecraft on 7/11/14.
 */
public class Batarang extends ItemSnowball{
    public Batarang() {
        super ();
        this.setUnlocalizedName("batarang");
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister i) {
        this.itemIcon = i.registerIcon("vampirebatmod:Batarang");
    }


}
