package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntityshitRenderer extends TileEntitySpecialRenderer {

public TileEntityshitRenderer() {
model = new Modelshit();
}

public void renderAModelAt(TileEntityshit tile, double d, double d1, double d2, float f) {
int i = tile.getBlockMetadata(); //this is for rotation
int j = 0;

                if (i == 0)
                {
                        j = 0;
                }

                if (i == 1)
                {
                        j = 90;
                }

                if (i == 2)
                {
                        j = 180;
                }

                if (i == 3)
                {
                        j = 270;
                }

                bindTextureByName("/mods/New.png"); //texture
                GL11.glPushMatrix(); //start
                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
                GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); //rotate based on metadata
                GL11.glScalef(1.0F, -1F, -1F); //if you read this comment out this line and you can see what happens
                model.renderModel(0.0625F); //renders and yes 0.0625 is a random number
                GL11.glPopMatrix(); //end

}

public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
renderAModelAt((TileEntityshit) tileentity, d, d1, d2, f); //where to render
}

private Modelshit model;
}