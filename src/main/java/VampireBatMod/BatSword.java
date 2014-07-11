package VampireBatMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by minecraft on 7/11/14.
 */
public class BatSword extends ItemSword {
    public BatSword(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("batSword");
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    @Override
    public boolean hitEntity(ItemStack batSwordStack, EntityLivingBase target, EntityLivingBase user) {
        target.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
        return (true);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister i) {
        this.itemIcon = i.registerIcon("vampirebatmod:BatSword");
    }

}
