package net.minecraft.src;

public class mod_achievement extends BaseMod
{
        public static final Achievement boner = new Achievement(4560, "boner", 5, 7, Item.legsDiamond, null).registerAchievement();
        public static final Achievement balls = new Achievement(4561, "balls", 5, 8, Item.slimeBall, boner).registerAchievement();
        
        public void load()
        {
                ModLoader.addAchievementDesc(boner, "Get a Boner", "Craft Diamond Leggings");
                ModLoader.addAchievementDesc(balls, "Big Balls","Obtain Balls" );
        }
        
        public void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
                {
                if(itemstack.itemID == Item.legsDiamond.shiftedIndex)
                {
                        entityplayer.addStat(boner, 1);
                }
                }
        public void onItemPickup(EntityPlayer var1, ItemStack var2)
                {
                if(var2.itemID == Item.slimeBall.shiftedIndex)
                {
                		var1.addStat(balls, 1);
                }
                }
        public String getVersion()
        {
                return "1.2.5";
        }
}
