package net.minecraft.src;

import java.util.Random;

public class mod_Block extends BaseMod
{
public static Block bush = (BlockBush)(new BlockBush(200, 52)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("BlueBerryBush").setRequiresSelfNotify();
public static Block panone = (Blockpanone)(new Blockpanone(201,0,net.minecraft.src.TileEntitypanb.class)).setHardness(0.2F).setBlockName("panb").setStepSound(Block.soundWoodFootstep);
public static Block pancakedoor= (new Blockpancakedoor(203, Material.wood)).setHardness(3F).setBlockName("Pancake Door").disableStats().setRequiresSelfNotify();
public static Block shit = (Blockshit)(new Blockshit(202,0,net.minecraft.src.TileEntityshit.class)).setBlockName("blockshit");



public static final Item itemshit = (new ItemReed(159, shit)).setIconCoord(0, 0).setItemName("itemshit");

        public void load()
        {
                bush.blockIndexInTexture = ModLoader.addOverride("/terrain.png","/mods/bush.png");
                ModLoader.registerBlock(bush);
                ModLoader.addName(bush, "BlueBerryBush");
                
                pancakedoor.blockIndexInTexture = ModLoader.addOverride("/terrain.png","/mods/door.png");
                ModLoader.registerBlock(pancakedoor);
                ModLoader.addName(pancakedoor, "Pancake Door");
                ModLoader.addRecipe(new ItemStack(pancakedoor, 1), new Object[]{"#", Character.valueOf('#'), Item.doorWood});
                
                panone.blockIndexInTexture = ModLoader.addOverride("/terrain.png","/mods/panb.png");
                ModLoader.addName(panone, "pan1");
                ModLoader.registerBlock(panone);

                TileEntitypanbRenderer tileent2 = new TileEntitypanbRenderer();


                ModLoader.registerTileEntity(TileEntitypanb.class, "panb", tileent2);

                
                shit.blockIndexInTexture = ModLoader.addOverride("/terrain.png","/mods/New.png");
                ModLoader.addName(shit, "blockshit");
                ModLoader.addRecipe(new ItemStack(shit, 1), new Object[]{"#", Character.valueOf('#'), mod_item.shit});
                ModLoader.registerBlock(shit);
                
                TileEntityshitRenderer tileent1 = new TileEntityshitRenderer();


                ModLoader.registerTileEntity(TileEntityshit.class, "shit", tileent1);
                
                

             
     }
         {
        	modelID = ModLoader.getUniqueBlockModelID(this, true);
        	}


        	public void renderInvBlock(RenderBlocks var1, Block var2, int var3, int var4){
        	                if (var4 == panone.getRenderType())
        	                {
        	                 TileEntityRenderer.instance.renderTileEntityAt(new TileEntitypanb(), 0.0D, 0.0D, 0.0D, 0.0F);
        	                }
        	}

        	public static int modelID;
        public String getVersion()
        {
                return "1.2.5";
        }
}