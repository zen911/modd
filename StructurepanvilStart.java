package net.minecraft.src;

import java.util.*;

class StructurepanvilStart extends StructureStart
{
    /** well ... thats what it does */
    private boolean hasMoreThanTwoComponents;

    public StructurepanvilStart(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        hasMoreThanTwoComponents = false;
        int i = par5;
        ArrayList arraylist = StructurepanvilPieces.getStructurepanvilWeightedPieceList(par2Random, i);
        ComponentpanvilStart componentpanvilstart = new ComponentpanvilStart(par1World.getWorldChunkManager(), 0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2, arraylist, i);
        components.add(componentpanvilstart);
        componentpanvilstart.buildComponent(componentpanvilstart, components, par2Random);
        ArrayList arraylist1 = componentpanvilstart.field_35106_f;

        for (ArrayList arraylist2 = componentpanvilstart.field_35108_e; !arraylist1.isEmpty() || !arraylist2.isEmpty();)
        {
            if (!arraylist1.isEmpty())
            {
                int j = par2Random.nextInt(arraylist1.size());
                StructureComponent structurecomponent = (StructureComponent)arraylist1.remove(j);
                structurecomponent.buildComponent(componentpanvilstart, components, par2Random);
            }
            else
            {
                int k = par2Random.nextInt(arraylist2.size());
                StructureComponent structurecomponent1 = (StructureComponent)arraylist2.remove(k);
                structurecomponent1.buildComponent(componentpanvilstart, components, par2Random);
            }
        }

        updateBoundingBox();
        int l = 0;
        Iterator iterator = components.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            StructureComponent structurecomponent2 = (StructureComponent)iterator.next();

            if (!(structurecomponent2 instanceof ComponentVillageRoadPiece))
            {
                l++;
            }
        }
        while (true);

        hasMoreThanTwoComponents = l > 2;
    }

    /**
     * currently only defined for Villages, returns true if Village has more than 2 non-road components
     */
    public boolean isSizeableStructure()
    {
        return hasMoreThanTwoComponents;
    }
}
