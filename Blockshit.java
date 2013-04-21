package net.minecraft.src;

import java.util.Random;

public class Blockshit extends BlockContainer {

public Blockshit(int i, int j, Class class1) {
  super(i, j, Material.cloth);
  anEntityClass = class1;
}

public int idDropped(int par1, Random par2Random, int par3)
{
return mod_Block.itemshit.shiftedIndex;
}
public int quantityDropped(Random random) {
  return 1;
}
public boolean isOpaqueCube() {
  return false;
}
public boolean renderAsNormalBlock() {
  return false;
}
public int getRenderType() {
  return -1;
}

public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer){

   int p = MathHelper.floor_double((double)((par5EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3; //this is a smart equation

  byte byte0 = 3;
          
          
                if (p == 0)
                {
                        byte0 = 4;
                }
                if (p == 1)
                {
                        byte0 = 3;
                }
                if (p == 2)
                {
                        byte0 = 2;
                }
                if (p == 3)
                {
                        byte0 = 1;
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
          
  return true;
}
public TileEntity getBlockEntity() {
  return new TileEntityshit();
}
private Class anEntityClass;
}