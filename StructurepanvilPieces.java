package net.minecraft.src;

import java.util.*;

public class StructurepanvilPieces
{
    public StructurepanvilPieces()
    {
    }

    public static ArrayList getStructurepanvilWeightedPieceList(Random par0Random, int par1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructurepanvilPieceWeight(net.minecraft.src.ComponenetWoodHut.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
        arraylist.add(new StructurepanvilPieceWeight(net.minecraft.src.Componentfield.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 1 + par1, 4 + par1)));
        Iterator iterator = arraylist.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            if (((StructurepanvilPieceWeight)iterator.next()).panvilPiecesLimit == 0)
            {
                iterator.remove();
            }
        }
        while (true);

        return arraylist;
    }

    private static int getAvailablePieceWeight(ArrayList par0ArrayList)
    {
        boolean flag = false;
        int i = 0;

        for (Iterator iterator = par0ArrayList.iterator(); iterator.hasNext();)
        {
            StructurepanvilPieceWeight structurepanvilpieceweight = (StructurepanvilPieceWeight)iterator.next();

            if (structurepanvilpieceweight.panvilPiecesLimit > 0 && structurepanvilpieceweight.panvilPiecesSpawned < structurepanvilpieceweight.panvilPiecesLimit)
            {
                flag = true;
            }

            i += structurepanvilpieceweight.panvilPieceWeight;
        }

        return flag ? i : -1;
    }
//this is the place where you import all the different components :)// 
    private static Componentpanvil getpanvilComponentFromWeightedPiece(StructurepanvilPieceWeight par0StructurepanvilPieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        Class class1 = par0StructurepanvilPieceWeight.panvilPieceClass;
        Object obj = null;

        if (class1 == (net.minecraft.src.ComponentVillageHouse4_Garden.class))
        {
            obj = ComponentVillageHouse4_Garden.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.src.ComponentVillageChurch.class))
        {
            obj = ComponentVillageChurch.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.src.ComponentVillageHouse1.class))
        {
            obj = ComponentVillageHouse1.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.src.ComponenetWoodHut.class))
        {
            obj = ComponenetWoodHut.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.src.ComponentVillageHall.class))
        {
            obj = ComponentVillageHall.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.src.Componentfield.class))
        {
            obj = Componentfield.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
        }

        return ((Componentpanvil)(obj));
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static Componentpanvil getNextpanvilComponent(ComponentpanvilStart par0ComponentpanvilStart, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {                                                                //changing later to structurepanvilWeightedPieceList//
        int var8 = getAvailablePieceWeight(par0ComponentpanvilStart.structureVillageWeightedPieceList);

        if (var8 <= 0)
        {
            return null;
        }
        else
        {
            int var9 = 0;

            while (var9 < 5)
            {
                ++var9;
                int var10 = par2Random.nextInt(var8);    //and this one//
                Iterator var11 = par0ComponentpanvilStart.structureVillageWeightedPieceList.iterator();

                while (var11.hasNext())
                {
                    StructurepanvilPieceWeight var12 = (StructurepanvilPieceWeight)var11.next();
                    //change this later//
                    var10 -= var12.panvilPieceWeight;

                    if (var10 < 0)
                    {
                        if (!var12.canSpawnMorepanvilPiecesOfType(par7) || var12 == par0ComponentpanvilStart.structpanvilPieceWeight && par0ComponentpanvilStart.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        Componentpanvil var13 = getpanvilComponentFromWeightedPiece(var12, par1List, par2Random, par3, par4, par5, par6, par7);

                        if (var13 != null)
                        {
                            ++var12.panvilPiecesSpawned;
                            par0ComponentpanvilStart.structpanvilPieceWeight = var12;

                            if (!var12.canSpawnMoreVillagePieces())
                            {
                                par0ComponentpanvilStart.structureVillageWeightedPieceList.remove(var12);
                            }

                            return var13;
                        }
                    }
                }
            }

            StructureBoundingBox var14 = Componentlamp.findValidPlacement(par1List, par2Random, par3, par4, par5, par6);

            if (var14 != null)
            {
                return new Componentlamp(par7, par2Random, var14, par6);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextpanvilStructureComponent(ComponentpanvilStart par0ComponentpanvilStart, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 50)
        {
            return null;
        }

        if (Math.abs(par3 - par0ComponentpanvilStart.getBoundingBox().minX) > 112 || Math.abs(par5 - par0ComponentpanvilStart.getBoundingBox().minZ) > 112)
        {
            return null;
        }

        Componentpanvil componentpanvil = getNextpanvilComponent(par0ComponentpanvilStart, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

        if (componentpanvil != null)
        {
            int i = (((StructureComponent)(componentpanvil)).boundingBox.minX + ((StructureComponent)(componentpanvil)).boundingBox.maxX) / 2;
            int j = (((StructureComponent)(componentpanvil)).boundingBox.minZ + ((StructureComponent)(componentpanvil)).boundingBox.maxZ) / 2;
            int k = ((StructureComponent)(componentpanvil)).boundingBox.maxX - ((StructureComponent)(componentpanvil)).boundingBox.minX;
            int l = ((StructureComponent)(componentpanvil)).boundingBox.maxZ - ((StructureComponent)(componentpanvil)).boundingBox.minZ;
            int i1 = k <= l ? l : k;

            if (par0ComponentpanvilStart.getWorldChunkManager().areBiomesViable(i, j, i1 / 2 + 4, MapGenVillage.villageSpawnBiomes))
            {
                par1List.add(componentpanvil);
                par0ComponentpanvilStart.field_35108_e.add(componentpanvil);
                return componentpanvil;
            }
        }

        return null;
    }

    private static StructureComponent getNextComponentpanvilPath(ComponentpanvilStart par0ComponentpanvilStart, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 3 + par0ComponentpanvilStart.terrainType)
        {
            return null;
        }

        if (Math.abs(par3 - par0ComponentpanvilStart.getBoundingBox().minX) > 112 || Math.abs(par5 - par0ComponentpanvilStart.getBoundingBox().minZ) > 112)
        {
            return null;
        }

        StructureBoundingBox structureboundingbox = ComponentpanvilPathGen.func_35087_a(par0ComponentpanvilStart, par1List, par2Random, par3, par4, par5, par6);

        if (structureboundingbox != null && structureboundingbox.minY > 10)
        {
            ComponentpanvilPathGen componentpanvilpathgen = new ComponentpanvilPathGen(par7, par2Random, structureboundingbox, par6);
            int i = (((StructureComponent)(componentpanvilpathgen)).boundingBox.minX + ((StructureComponent)(componentpanvilpathgen)).boundingBox.maxX) / 2;
            int j = (((StructureComponent)(componentpanvilpathgen)).boundingBox.minZ + ((StructureComponent)(componentpanvilpathgen)).boundingBox.maxZ) / 2;
            int k = ((StructureComponent)(componentpanvilpathgen)).boundingBox.maxX - ((StructureComponent)(componentpanvilpathgen)).boundingBox.minX;
            int l = ((StructureComponent)(componentpanvilpathgen)).boundingBox.maxZ - ((StructureComponent)(componentpanvilpathgen)).boundingBox.minZ;
            int i1 = k <= l ? l : k;

            if (par0ComponentpanvilStart.getWorldChunkManager().areBiomesViable(i, j, i1 / 2 + 4, MapGenVillage.villageSpawnBiomes))
            {
                par1List.add(componentpanvilpathgen);
                par0ComponentpanvilStart.field_35106_f.add(componentpanvilpathgen);
                return componentpanvilpathgen;
            }
        }

        return null;
    }

    /**
     * attempts to find a next Structure Component to be spawned
     */
    static StructureComponent getNextStructureComponent(ComponentpanvilStart par0ComponentpanvilStart, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextpanvilStructureComponent(par0ComponentpanvilStart, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureComponent getNextStructureComponentpanvilPath(ComponentpanvilStart par0ComponentpanvilStart, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextComponentpanvilPath(par0ComponentpanvilStart, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}
