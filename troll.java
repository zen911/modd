package net.minecraft.src;

import java.util.Random;

public class troll extends EntityMob
{
        public troll(World world)
        {
                super(world);
                texture = "/mods/troll.png";
                moveSpeed = 2.0F;
                attackStrength = 10; //take this line out if this class doesn't extend EntityMob.
        }

        public int getMaxHealth()
        {
                return 25;
        }

        protected String getLivingSound()
        {
                return "random.troll";
        }

        protected String getHurtSound()
        {
                return "mob.villager.default";
        }

        protected String getDeathSound()
        {
                return "random.trolldie";
        }
        protected boolean canDespawn()
        {
                return false;
        }
        public ItemStack getHeldItem()
        {
                return defaultHeldItem;
        }
                
                static
        {
                defaultHeldItem = new ItemStack(Block.tnt);
        }
                
        private static final ItemStack defaultHeldItem;

}
