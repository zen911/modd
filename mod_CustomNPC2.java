package net.minecraft.src;

import java.util.Map;
import java.io.File;
import net.minecraft.client.Minecraft;


public class mod_CustomNPC2 extends BaseMod
{

public void load()
{
Minecraft mc = ModLoader.getMinecraftInstance();
mc.installResource("newsound/random/pancakehurt.ogg", new File(mc.mcDataDir,"resources/newsound/random/pancakehurt.ogg"));
mc.installResource("newsound/random/pancake.ogg", new File(mc.mcDataDir,"resources/newsound/random/pancake.ogg"));
mc.installResource("newsound/random/pancake2.ogg", new File(mc.mcDataDir,"resources/newsound/random/pancake2.ogg"));
ModLoader.registerEntityID(Entitypancakezombie.class, "pancakezombie", ModLoader.getUniqueEntityId());
ModLoader.addSpawn(Entitypancakezombie.class, 15, 5, 7, EnumCreatureType.monster);
}

public void addRenderer(Map map)
{
map.put(Entitypancakezombie.class, new Renderpancakezombie(new Modelpancakezombie(), 0.5F));
}

public String getVersion()
{
return "1.2.5";
}
}