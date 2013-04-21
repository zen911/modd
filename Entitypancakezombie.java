package net.minecraft.src;

import java.util.Random;

public class Entitypancakezombie extends EntityMob
{
        public Entitypancakezombie(World world)
        {
                super(world);
                texture = "/mods/pancakezombie.png";
                moveSpeed = 0.23F;
                isImmuneToFire = false;
                attackStrength = 1;
                getNavigator().setBreakDoors(true);
                tasks.addTask(0, new EntityAISwimming(this));
                tasks.addTask(1, new EntityAIBreakDoor(this));
                tasks.addTask(2, new EntityAIAttackOnCollide(this, net.minecraft.src.EntityPlayer.class, moveSpeed, false));
                tasks.addTask(3, new EntityAIAttackOnCollide(this, net.minecraft.src.Entitypancake.class, moveSpeed, true));
                tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, moveSpeed));
                tasks.addTask(5, new EntityAIMoveThroughVillage(this, moveSpeed, false));
                tasks.addTask(6, new EntityAIWander(this, moveSpeed));
                tasks.addTask(7, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
                tasks.addTask(7, new EntityAILookIdle(this));
                targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
                targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
                targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityVillager.class, 16F, 0, false));
                targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.Entitypancake.class, 16F, 0, false));
            }

        public int getMaxHealth()
        {
                return 10;
        }
        /**
         * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
         */
        public int getTotalArmorValue()
        {
            return 2;
        }

        /**
         * Returns true if the newer Entity AI code should be run
         */
        protected boolean isAIEnabled()
        {
            return true;
        }

        /**
         * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
         * use this to react to sunlight and start to burn.
         */
        public void onLivingUpdate()
        {
            if (worldObj.isDaytime() && !worldObj.isRemote)
            {
                float f = getBrightness(1.0F);

                if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
                {
                    setFire(8);
                }
            }

            super.onLivingUpdate();
        }

        /**
         * Returns the sound this mob makes while it's alive.
         */

        protected String getLivingSound()
        {
                return "mob.zombie";
        }

        protected String getHurtSound()
        {
                return "mob.zombiehurt";
        }

        protected String getDeathSound()
        {
                return "mob.zombiedeath";
        }
        public int quantityDropped(Random random)
        {
            return random.nextInt(1) != 0 ? 0 : 1;
        }

        protected int getDropItemId()
        {
                return mod_item.rottenpancake.shiftedIndex;
        }

        /**
         * Get this Entity's EnumCreatureAttribute
         */
        public EnumCreatureAttribute getCreatureAttribute()
        {
            return EnumCreatureAttribute.UNDEAD;
        }
        protected void dropRareDrop(int par1)
        {
            switch (rand.nextInt(4))
            {
                case 0:
                    dropItem(Item.rottenFlesh.shiftedIndex, 1);
                    break;

                case 1:
                    dropItem(Item.helmetSteel.shiftedIndex, 1);
                    break;

                case 2:
                    dropItem(Item.ingotIron.shiftedIndex, 1);
                    break;

                case 3:
                    dropItem(Item.shovelSteel.shiftedIndex, 1);
                    break;
            }
        }
    }