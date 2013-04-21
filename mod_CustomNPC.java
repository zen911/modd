package net.minecraft.src;

import java.util.Map;
import java.io.File;
import net.minecraft.client.Minecraft;


public class mod_CustomNPC extends BaseMod
{
	public static final Item rawpancake = new Itemrawpancake(5002, 2, true).setItemName("RawPancake");

public void load()
{
Minecraft mc = ModLoader.getMinecraftInstance();
mc.installResource("newsound/random/pancakehurt.ogg", new File(mc.mcDataDir,"resources/newsound/random/pancakehurt.ogg"));
mc.installResource("newsound/random/pancake.ogg", new File(mc.mcDataDir,"resources/newsound/random/pancake.ogg"));
mc.installResource("newsound/random/pancake2.ogg", new File(mc.mcDataDir,"resources/newsound/random/pancake2.ogg"));
ModLoader.registerEntityID(Entitypancake.class, "pancake", ModLoader.getUniqueEntityId());
ModLoader.addSpawn(Entitypancake.class, 15, 5, 7, EnumCreatureType.creature);
}

public void addRenderer(Map map)
{
map.put(Entitypancake.class, new Renderpancake(new Modelpancake(), 0.5F));
}

public String getVersion()
{
return "1.2.5";
}
}