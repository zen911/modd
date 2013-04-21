package net.minecraft.src;

public class StructurepanvilPieceWeight
{
    /** The Class object for the represantation of this village piece. */
    public Class panvilPieceClass;
    public final int panvilPieceWeight;
    public int panvilPiecesSpawned;
    public int panvilPiecesLimit;

    public StructurepanvilPieceWeight(Class par1Class, int par2, int par3)
    {
        panvilPieceClass = par1Class;
        panvilPieceWeight = par2;
        panvilPiecesLimit = par3;
    }

    public boolean canSpawnMorepanvilPiecesOfType(int par1)
    {
        return panvilPiecesLimit == 0 || panvilPiecesSpawned < panvilPiecesLimit;
    }

    public boolean canSpawnMoreVillagePieces()
    {
        return panvilPiecesLimit == 0 || panvilPiecesSpawned < panvilPiecesLimit;
    }
}
