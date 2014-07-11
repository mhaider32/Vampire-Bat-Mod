package VampireBatMod;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by minecraft on 7/11/14.
 */
public class RenderBatarang extends RenderSnowball {
    public RenderBatarang( Item i) {
        super(i);
    }

    public static ResourceLocation texture = new ResourceLocation("vampirebatmod","textures/items/Batarang.png");

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return texture;
    }

}
