package net.minecraft.src;

import java.io.File;
import java.util.Map;

import net.minecraft.client.Minecraft;

public class mod_HumanNPC extends BaseMod
{
	public static final Item shit = new Itemshit(5001, -4, true).setItemName("Shit");
        
        public void load()
        {   
        	shit.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/shit.png");
            ModLoader.addName(shit, "Shit");
            ModLoader.addRecipe(new ItemStack(shit, 1), new Object [] {"#", Character.valueOf('#'), Block.dirt});
        	Minecraft mc = ModLoader.getMinecraftInstance();
            ModLoader.registerEntityID(ian.class, "Ian", ModLoader.getUniqueEntityId());
            ModLoader.addSpawn(ian.class, 12, 14, 18, EnumCreatureType.creature);
            mc.installResource("newsound/random/iandie.ogg", new File(mc.mcDataDir,"resources/newsound/random/iandie.ogg"));
        }
        
        public void addRenderer(Map map)
        {
                map.put(ian.class, new RenderBiped(new ModelBiped(), 0.5F));
        }
        
        public String getVersion()
        {
                return "1.2.5";
        }

}
