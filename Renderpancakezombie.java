package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class Renderpancakezombie extends RenderLiving
{
        protected Modelpancakezombie modelpancakezombieMain;
        protected float field_40296_d;

        public Renderpancakezombie(Modelpancakezombie par1Modelpancakezombie, float par2)
        {
                this(par1Modelpancakezombie, par2, 1.0F);
                modelpancakezombieMain = par1Modelpancakezombie;
        }

        public Renderpancakezombie(Modelpancakezombie par1Modelpancakezombie, float par2, float par3)
        {
                super(par1Modelpancakezombie, par2);
                modelpancakezombieMain = par1Modelpancakezombie;
                field_40296_d = par3;
        }
}
