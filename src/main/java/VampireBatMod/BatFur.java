package VampireBatMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by minecraft on 7/7/14.
 */
public class BatFur extends Item {

    public BatFur() {
        super();
        this.setUnlocalizedName("batFur");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister i) {
        this.itemIcon = i.registerIcon("vampirebatmod:BatHide");
    }
}