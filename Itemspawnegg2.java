package net.minecraft.src;

import java.util.Random;

public class Itemspawnegg2 extends Item
{
        public Itemspawnegg2(int i)
        {
                super(i);
                maxStackSize = 64;
                setMaxDamage(200);
        }
   private World worldObj;

   public boolean onItemUse (ItemStack itemstack, EntityPlayer entityplayer, World world, int i ,int j, int k, int l){
	   if(!world.isRemote)
	   {
		   EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName("pancakezombie", entityplayer.worldObj);
		   
		   entityliving.setLocationAndAngles(i, j + 1, k, 0F, 0F);
		   entityplayer.worldObj.spawnEntityInWorld(entityliving);
		   entityplayer.swingItem();
	   }
   
	   return true;
   
   
   }
}