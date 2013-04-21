
package net.minecraft.src;
import java.util.Random;
public class WorldGenBush extends WorldGenerator
{
    public WorldGenBush()
    {
    }
    public boolean generate(World world, Random rand, int i, int j, int k)
    {
int bID = 2;  /*2 is the block id for grass, so the structure going to spawn on grass*/
        if(world.getBlockId(i, j, k) != bID || world.getBlockId(i, j + 1, k) != 0 || world.getBlockId(i + 7, j, k) != bID || world.getBlockId(i + 7, j, k + 7) != bID || world.getBlockId(i, j, k + 7) != bID || world.getBlockId(i + 7, j + 1, k) != 0 || world.getBlockId(i + 7, j + 1, k + 7) != 0 || world.getBlockId(i, j + 1, k + 7) != 0)
        {
            return false;
        }
            world.setBlock(i + 2, j + 0, k + 3, 17);
            world.setBlock(i + 2, j + 0, k + 2, 17);
            world.setBlock(i + 3, j + 0, k + 3, 17);
            world.setBlock(i + 3, j + 0, k + 2, 17);
            world.setBlock(i + 0, j + 1, k + 4, 200);
            world.setBlock(i + 0, j + 1, k + 3, 200);
            world.setBlock(i + 0, j + 1, k + 2, 200);
            world.setBlock(i + 1, j + 1, k + 5, 200);
            world.setBlock(i + 1, j + 1, k + 4, 200);
            world.setBlock(i + 1, j + 1, k + 3, 200);
            world.setBlock(i + 1, j + 1, k + 2, 200);
            world.setBlock(i + 1, j + 1, k + 1, 200);
            world.setBlock(i + 2, j + 1, k + 5, 200);
            world.setBlock(i + 2, j + 1, k + 4, 200);
            world.setBlock(i + 2, j + 1, k + 3, 17);
            world.setBlock(i + 2, j + 1, k + 2, 17);
            world.setBlock(i + 2, j + 1, k + 1, 200);
            world.setBlock(i + 2, j + 1, k + 0, 200);
            world.setBlock(i + 3, j + 1, k + 5, 200);
            world.setBlock(i + 3, j + 1, k + 4, 200);
            world.setBlock(i + 3, j + 1, k + 3, 17);
            world.setBlock(i + 3, j + 1, k + 2, 17);
            world.setBlock(i + 3, j + 1, k + 1, 200);
            world.setBlock(i + 3, j + 1, k + 0, 200);
            world.setBlock(i + 4, j + 1, k + 4, 200);
            world.setBlock(i + 4, j + 1, k + 3, 200);
            world.setBlock(i + 4, j + 1, k + 2, 200);
            world.setBlock(i + 4, j + 1, k + 1, 200);
            world.setBlock(i + 4, j + 1, k + 0, 200);
            world.setBlock(i + 5, j + 1, k + 3, 200);
            world.setBlock(i + 5, j + 1, k + 2, 200);
            world.setBlock(i + 5, j + 1, k + 1, 200);
            world.setBlock(i + 1, j + 2, k + 4, 200);
            world.setBlock(i + 1, j + 2, k + 3, 200);
            world.setBlock(i + 1, j + 2, k + 2, 200);
            world.setBlock(i + 2, j + 2, k + 4, 200);
            world.setBlock(i + 2, j + 2, k + 3, 200);
            world.setBlock(i + 2, j + 2, k + 2, 200);
            world.setBlock(i + 2, j + 2, k + 1, 200);
            world.setBlock(i + 3, j + 2, k + 4, 200);
            world.setBlock(i + 3, j + 2, k + 3, 200);
            world.setBlock(i + 3, j + 2, k + 2, 200);
            world.setBlock(i + 3, j + 2, k + 1, 200);
            world.setBlock(i + 4, j + 2, k + 3, 200);
            world.setBlock(i + 4, j + 2, k + 2, 200);
            world.setBlock(i + 4, j + 2, k + 1, 200);

  return true;
  }
} /*=====End of Code=====*/
