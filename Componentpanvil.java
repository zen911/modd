package net.minecraft.src;

import java.util.List;
import java.util.Random;

abstract class Componentpanvil extends StructureComponent
{
    /** The number of villagers that have been spawned in this component. */
    private int villagersSpawned;

    protected Componentpanvil(int par1)
    {
        super(par1);
    }

    /**
     * Gets the next village component, with the bounding box shifted -1 in the X and Z direction.
     */
    protected StructureComponent getNextComponentNN(ComponentpanvilStart par1ComponentpanvilStart, List par2List, Random par3Random, int par4, int par5)
    {
        switch (coordBaseMode)
        {
            case 2:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.minX - 1, boundingBox.minY + par4, boundingBox.minZ + par5, 1, getComponentType());

            case 0:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.minX - 1, boundingBox.minY + par4, boundingBox.minZ + par5, 1, getComponentType());

            case 1:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.minX + par5, boundingBox.minY + par4, boundingBox.minZ - 1, 2, getComponentType());

            case 3:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.minX + par5, boundingBox.minY + par4, boundingBox.minZ - 1, 2, getComponentType());
        }

        return null;
    }

    /**
     * Gets the next village component, with the bounding box shifted +1 in the X and Z direction.
     */
    protected StructureComponent getNextComponentPP(ComponentpanvilStart par1ComponentpanvilStart, List par2List, Random par3Random, int par4, int par5)
    {
        switch (coordBaseMode)
        {
            case 2:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.maxX + 1, boundingBox.minY + par4, boundingBox.minZ + par5, 3, getComponentType());

            case 0:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.maxX + 1, boundingBox.minY + par4, boundingBox.minZ + par5, 3, getComponentType());

            case 1:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.minX + par5, boundingBox.minY + par4, boundingBox.maxZ + 1, 0, getComponentType());

            case 3:
                return StructurepanvilPieces.getNextStructureComponent(par1ComponentpanvilStart, par2List, par3Random, boundingBox.minX + par5, boundingBox.minY + par4, boundingBox.maxZ + 1, 0, getComponentType());
        }

        return null;
    }

    /**
     * Discover the y coordinate that will serve as the ground level of the supplied BoundingBox. (A median of all the
     * levels in the BB's horizontal rectangle).
     */
    protected int getAverageGroundLevel(World par1World, StructureBoundingBox par2StructureBoundingBox)
    {
        int i = 0;
        int j = 0;

        for (int k = boundingBox.minZ; k <= boundingBox.maxZ; k++)
        {
            for (int l = boundingBox.minX; l <= boundingBox.maxX; l++)
            {
                if (par2StructureBoundingBox.isVecInside(l, 64, k))
                {
                    i += Math.max(par1World.getTopSolidOrLiquidBlock(l, k), par1World.worldProvider.getAverageGroundLevel());
                    j++;
                }
            }
        }

        if (j == 0)
        {
            return -1;
        }
        else
        {
            return i / j;
        }
    }

    protected static boolean canVillageGoDeeper(StructureBoundingBox par0StructureBoundingBox)
    {
        return par0StructureBoundingBox != null && par0StructureBoundingBox.minY > 10;
    }

    /**
     * Spawns a number of villagers in this component. Parameters: world, component bounding box, x offset, y offset, z
     * offset, number of villagers
     */
    protected void spawnpancakes(World par1World, StructureBoundingBox par2StructureBoundingBox, int par3, int par4, int par5, int par6)
    {
        if (villagersSpawned >= par6)
        {
            return;
        }

        int i = villagersSpawned;

        do
        {
            if (i >= par6)
            {
                break;
            }

            int j = getXWithOffset(par3 + i, par5);
            int k = getYWithOffset(par4);
            int l = getZWithOffset(par3 + i, par5);

            if (!par2StructureBoundingBox.isVecInside(j, k, l))
            {
                break;
            }

            villagersSpawned++;
            Entitypancake entitypancake = new Entitypancake(par1World);
            entitypancake.setLocationAndAngles((double)j + 0.5D, k, (double)l + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitypancake);
            i++;
        }
        while (true);
    }
    }
