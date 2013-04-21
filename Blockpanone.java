package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class Blockpanone extends BlockContainer {

public Blockpanone(int i, int j, Class class1) {
  super(i, j, Material.pumpkin);
  anEntityClass = class1;
}

public int idDropped(int par1, Random par2Random, int par3)
{
return mod_item.rawpancake.shiftedIndex;
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

public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
{
    setBlockBounds(-4F, -4F, 0F, 8F, 8F, 1F);
    // width height length width2 height2 length2
}
public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
{
        setBlockBounds(-0.4F, -0.4F, 0F, -0.8F, -0.8F, -0.2F);
        super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        
        
        //setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
        //super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        //setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        //super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
}


public TileEntity getBlockEntity() {
  return new TileEntitypanb();
}
private Class anEntityClass;
}