package slimeknights.tconstruct.world.client.slime;

import net.minecraft.client.resources.ColorMapLoader;
import net.minecraft.client.resources.ReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.world.client.SlimeColorizer;

import java.io.IOException;

@OnlyIn(Dist.CLIENT)
public class PurpleColorReloadListener extends ReloadListener<int[]> {

  private static final ResourceLocation PURPLE_GRASS_LOCATION = Util.getResource("textures/colormap/purple_grass_color.png");

  /**
   * Performs any reloading that can be done off-thread, such as file IO
   */
  @Override
  protected int[] prepare(IResourceManager resourceManager, IProfiler profiler) {
    try {
      return ColorMapLoader.loadColors(resourceManager, PURPLE_GRASS_LOCATION);
    } catch (IOException ioexception) {
      throw new IllegalStateException("Failed to load purple grass color texture", ioexception);
    }
  }

  @Override
  protected void apply(int[] buffer, IResourceManager resourceManager, IProfiler profiler) {
    SlimeColorizer.setPurpleGrassBiomeColorizer(buffer);
  }

  //@Override //Forge: TODO: Filtered resource reloading
  public net.minecraftforge.resource.IResourceType getResourceType() {
    return net.minecraftforge.resource.VanillaResourceType.TEXTURES;
  }
}
