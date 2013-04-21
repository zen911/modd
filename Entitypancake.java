package net.minecraft.src;

import java.util.Random;

public class Entitypancake extends EntityAnimal
{
	private int randomTickDivider;
    Village villageObj;
    
	 public Entitypancake(World par1World)
	    {
	        super(par1World);
                texture = "/mods/pancake.png";
                moveSpeed = 0.5F;
                setSize(0.6F, 0.8F);
                isImmuneToFire = false;
                getNavigator().setAvoidsWater(true);
                getNavigator().setBreakDoors(true);
                float f = 0.25F;
                tasks.addTask(0, new EntityAISwimming(this));
                tasks.addTask(1, new EntityAIPanic(this, 0.38F));
                tasks.addTask(2, new EntityAIMate(this, f));
                tasks.addTask(3, new EntityAITempt(this, 0.25F, Item.wheat.shiftedIndex, false));
                tasks.addTask(4, new EntityAIFollowParent(this, 0.28F));
                tasks.addTask(5, new EntityAIWander(this, moveSpeed));
                tasks.addTask(6, new EntityAILookIdle(this));
                tasks.addTask(7, new EntityAIAvoidEntity(this, net.minecraft.src.Entitypancakezombie.class, 8F, 0.3F, 0.35F));
                tasks.addTask(8, new EntityAIMoveIndoors(this));
                tasks.addTask(9, new EntityAIRestrictOpenDoor(this));
                tasks.addTask(10, new EntityAIOpenDoor(this, true));
                tasks.addTask(11, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
                tasks.addTask(12, new EntityAIMoveThroughVillage(this, moveSpeed, false));
                tasks.addTask(13, new EntityAILookIdle(this));
                tasks.addTask(14, new EntityAIRestrictOpenGate(this));
                tasks.addTask(15, new EntityAIOpenFenceGate(this, true));
	    }
            /**
             * Returns true if the newer Entity AI code should be run
             */
            public boolean isAIEnabled()
            {
                return true;
            }
            
            public int getMaxHealth()
            {
                return 10;
            }

            
         
            public EntityAnimal spawnBabyAnimal1(EntityAnimal par1EntityAnimal)
            {
                Entitypancake entitypancake = new Entitypancake(worldObj);
                return entitypancake;
            }


        protected String getLivingSound()
        {
                return "random.pancake";
        }

        protected String getHurtSound()
        {
                return "random.pancakehurt";
        }

        protected String getDeathSound()
        {
                return "mob.villager.defaultdeath";
        }
        public int quantityDropped(Random random)
        {
            return random.nextInt(0) != 0 ? 0 : 1;
        }

        protected int getDropItemId()
        {
                return mod_CustomNPC.rawpancake.shiftedIndex;
        }
        /**
         * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
         */
        public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
        {
            return new Entitypancake(worldObj);
        }
    }
