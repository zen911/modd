package net.minecraft.src;

import java.util.Random;

public class spawnegg extends Item
{
        public spawnegg(int i)
        {
                super(i);
                maxStackSize = 1;
                setMaxDamage(200);
        }
   private World worldObj;

   public boolean onItemUse (ItemStack itemstack, EntityPlayer entityplayer, World world, int i ,int j, int k, int l){
	   if(!world.isRemote)
	   {
		   ModLoader.getMinecraftInstance().thePlayer.addChatMessage("pancake");
		   EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("pancake", entityplayer.worldObj);
		   
		   entityliving.setLocationAndAngles(i, j + 1, k, 0F, 0F);
		   entityplayer.worldObj.spawnEntityInWorld(entityliving);
		   entityplayer.swingItem();
	   }
   
	   return true;
   
   
   }
}