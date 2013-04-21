package net.minecraft.src;

public class Itemrawbluepan extends ItemFood
{
public Itemrawbluepan(int i, int j, boolean B)
{
super(i, j, B);
}
public ItemStack onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
{
entityPlayer.getFoodStats().addStats(this);
                world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
itemStack.stackSize--;
        
entityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 20 * 40, 12));

return itemStack;
}
}