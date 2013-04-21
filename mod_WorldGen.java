package net.minecraft.src;

import java.util.Random;

public class mod_WorldGen extends BaseMod
{

        public void load()
        {
        	
        }
        
        public void generateSurface(World world, Random random, int chunkX, int chunkZ)
        {
                         for(int k = 0; k < 10; k++)
                         {
                                int RandPosX = chunkX + random.nextInt(5);
                                int RandPosY = random.nextInt(80);
                                int RandPosZ = chunkZ + random.nextInt(5);
                                (new WorldGenBush()).generate(world, random, RandPosX, RandPosY, RandPosZ);
                         }
                        
                         		
                         { 
                         }
        }
        public String getVersion()
        {
                return "1.2.5";
        } 
}