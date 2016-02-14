package net.minecraft.client.renderer.texture;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SideOnly(Side.CLIENT)
public class LayeredColorMaskTexture extends AbstractTexture
{
    private static final Logger field_174947_f = LogManager.getLogger();
    /** The location of the texture. */
    private final ResourceLocation textureLocation;
    private final List field_174949_h;
    private final List field_174950_i;
    private static final String __OBFID = "CL_00002404";

    public LayeredColorMaskTexture(ResourceLocation textureLocationIn, List p_i46101_2_, List p_i46101_3_)
    {
        this.textureLocation = textureLocationIn;
        this.field_174949_h = p_i46101_2_;
        this.field_174950_i = p_i46101_3_;
    }

    public void loadTexture(IResourceManager resourceManager) throws IOException
    {
        this.deleteGlTexture();
        BufferedImage bufferedimage;

        try
        {
            BufferedImage bufferedimage1 = TextureUtil.readBufferedImage(resourceManager.getResource(this.textureLocation).getInputStream());
            int i = bufferedimage1.getType();

            if (i == 0)
            {
                i = 6;
            }

            bufferedimage = new BufferedImage(bufferedimage1.getWidth(), bufferedimage1.getHeight(), i);
            Graphics graphics = bufferedimage.getGraphics();
            graphics.drawImage(bufferedimage1, 0, 0, (ImageObserver)null);

            for (int j = 0; j < this.field_174949_h.size() && j < this.field_174950_i.size(); ++j)
            {
                String s = (String)this.field_174949_h.get(j);
                MapColor mapcolor = ((EnumDyeColor)this.field_174950_i.get(j)).getMapColor();

                if (s != null)
                {
                    InputStream inputstream = resourceManager.getResource(new ResourceLocation(s)).getInputStream();
                    BufferedImage bufferedimage2 = TextureUtil.readBufferedImage(inputstream);

                    if (bufferedimage2.getWidth() == bufferedimage.getWidth() && bufferedimage2.getHeight() == bufferedimage.getHeight() && bufferedimage2.getType() == 6)
                    {
                        for (int k = 0; k < bufferedimage2.getHeight(); ++k)
                        {
                            for (int l = 0; l < bufferedimage2.getWidth(); ++l)
                            {
                                int i1 = bufferedimage2.getRGB(l, k);

                                if ((i1 & -16777216) != 0)
                                {
                                    int j1 = (i1 & 16711680) << 8 & -16777216;
                                    int k1 = bufferedimage1.getRGB(l, k);
                                    int l1 = MathHelper.func_180188_d(k1, mapcolor.colorValue) & 16777215;
                                    bufferedimage2.setRGB(l, k, j1 | l1);
                                }
                            }
                        }

                        bufferedimage.getGraphics().drawImage(bufferedimage2, 0, 0, (ImageObserver)null);
                    }
                }
            }
        }
        catch (IOException ioexception)
        {
            field_174947_f.error("Couldn\'t load layered image", ioexception);
            return;
        }

        TextureUtil.uploadTextureImage(this.getGlTextureId(), bufferedimage);
    }
}