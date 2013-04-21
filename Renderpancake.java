package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class Renderpancake extends RenderLiving
{
        protected Modelpancake modelpancakeMain;
        protected float field_40296_d;

        public Renderpancake(Modelpancake par1Modelpancake, float par2)
        {
                this(par1Modelpancake, par2, 1.0F);
                modelpancakeMain = par1Modelpancake;
        }

        public Renderpancake(Modelpancake par1Modelpancake, float par2, float par3)
        {
                super(par1Modelpancake, par2);
                modelpancakeMain = par1Modelpancake;
                field_40296_d = par3;
        }
}
