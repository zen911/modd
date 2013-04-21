package net.minecraft.src;
public class Itemrawpancake extends ItemFood
{
public Itemrawpancake(int i, int j, boolean B)
{
super(i, j, B);
}
public ItemStack onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
{
entityPlayer.getFoodStats().addStats(this);
                world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
itemStack.stackSize--;
        
entityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 10 * 20, 6));

return itemStack;
}
public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
{
        if(l == 0)
        {
                j--;
        }
        if(l == 1)
        {
                j++;
        }
        if(l == 2)
        {
                k--;
        }
        if(l == 3)
        {
                k++;
        }
        if(l == 4)
        {
                i--;
        }
        if(l == 5)
        {
                i++;
        }
        int i1 = world.getBlockId(i, j, k);
        if(i1 == 0)
        {
                world.setBlockWithNotify(i, j, k, mod_Block.panone.blockID);
        }
        itemstack.damageItem(1, entityplayer);
        return true;
}
}