package net.minecraft.src;

import java.io.File;
import java.util.Map;

import net.minecraft.client.Minecraft;

public class mod_humanNPC2 extends BaseMod
{
        
        public void load()
        {   
        	Minecraft mc = ModLoader.getMinecraftInstance();
                ModLoader.registerEntityID(ian.class, "troll", ModLoader.getUniqueEntityId());
                ModLoader.addSpawn(troll.class, 12, 14, 18, EnumCreatureType.creature);
                mc.installResource("newsound/random/troll.ogg", new File(mc.mcDataDir,"resources/newsound/random/troll.ogg"));
                mc.installResource("newsound/random/troll2.ogg", new File(mc.mcDataDir,"resources/newsound/random/troll2.ogg"));
                mc.installResource("newsound/random/troll3.ogg", new File(mc.mcDataDir,"resources/newsound/random/troll3.ogg"));
                mc.installResource("newsound/random/troll4.ogg", new File(mc.mcDataDir,"resources/newsound/random/troll4.ogg"));
                mc.installResource("newsound/random/trollhurt.ogg", new File(mc.mcDataDir,"resources/newsound/random/trollhurt.ogg"));
                mc.installResource("newsound/random/trollhurt2.ogg", new File(mc.mcDataDir,"resources/newsound/random/trollhurt2.ogg"));
                mc.installResource("newsound/random/trollhurt3.ogg", new File(mc.mcDataDir,"resources/newsound/random/trollhurt3.ogg"));
                mc.installResource("newsound/random/trollhurt4.ogg", new File(mc.mcDataDir,"resources/newsound/random/trollhurt4.ogg"));
                mc.installResource("newsound/random/trollhurt5.ogg", new File(mc.mcDataDir,"resources/newsound/random/trollhurt5.ogg"));
                mc.installResource("newsound/random/trolldie.ogg", new File(mc.mcDataDir,"resources/newsound/random/trolldie.ogg"));
                mc.installResource("newsound/random/trolldie2.ogg", new File(mc.mcDataDir,"resources/newsound/random/trolldie2.ogg"));
                mc.installResource("newsound/random/trolldie3.ogg", new File(mc.mcDataDir,"resources/newsound/random/trolldie3.ogg"));
        }
        
        public void addRenderer(Map map)
        {
                map.put(troll.class, new RenderBiped(new ModelBiped(), 0.5F));
        }
        
        public String getVersion()
        {
                return "1.2.5";
        }

}
