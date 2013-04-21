package net.minecraft.src;

public class mod_Tutorial extends BaseMod {
	
	public static final Block tutorialBlock = new BlockTutorialBlock(179, Material.iron).setBlockName("Ianizer");

	@Override
	public String getVersion() {
		return "1.2.5";
	}

	@Override
	public void load() {
		ModLoader.registerBlock(tutorialBlock);
	    ModLoader.addName(tutorialBlock, "Ianizer");
		tutorialBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "summon.png");
		ModLoader.addRecipe(new ItemStack(tutorialBlock, 1), new Object[]{
			"YYY", "YBY", "YYY",
			'Y', Block.cloth,
			'B', Item.record11,
		});
		
	}

}
