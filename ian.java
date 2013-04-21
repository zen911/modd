package net.minecraft.src;

import java.util.Random;

public class ian extends EntityCreature
{
        public ian(World world)
        {
                super(world);
                texture = "/mods/Ian irl v2.png";
                moveSpeed = 0.5F;
        }

        public int getMaxHealth()
        {
                return 20;
        }

        protected String getLivingSound()
        {
                return "mob.villager.default";
        }

        protected String getHurtSound()
        {
                return "mob.villager.defaulthurt";
        }

        protected String getDeathSound()
        {
                return "random.iandie";
        }

        protected int getDropItemId()
        {
                return mod_HumanNPC.shit.shiftedIndex;
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
                defaultHeldItem = new ItemStack(mod_HumanNPC.shit, 1);
        }
                
        private static final ItemStack defaultHeldItem;

}
