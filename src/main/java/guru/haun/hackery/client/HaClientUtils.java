package guru.haun.hackery.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import guru.haun.hackery.HackeryMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;

public class HaClientUtils {

	@SideOnly(Side.CLIENT)
	public static void setShader(ResourceLocation sha){
		Minecraft mc = Minecraft.getMinecraft();
        try {
            mc.entityRenderer.theShaderGroup = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), sha);
        } catch (Exception e) {
            HackeryMod.logger.error("Something bad happened while swapping shaders");
            e.printStackTrace();
        }
        mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
	}
	
}
