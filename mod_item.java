package net.minecraft.src;

public class mod_item extends BaseMod
{
	public static final Item shit = new Itemshit(5001, -4, true).setItemName("Shit");
	public static final Item rawpancake = new Itemrawpancake(5002, 2, true).setItemName("RawPancake");
	public static final Item cookedpancake = new Itemcookedpancake(5003, 4, true).setItemName("CookedPancake");  
	public static final Item blueberry = new Itemblueberry(5004, 0, true).setItemName("BlueBerrys");   
	public static final Item spawnegg = new Itemspawnegg(5005).setItemName("spawnegg");
	public static final Item spawnegg2 = new Itemspawnegg2(5006).setItemName("spawnegg2");
	public static final Item rottenpancake = new Itemrottenpancake(5007, 3, true).setItemName("Rotten Pancake");  
	public static final Item dooritem = (new ItemDoor(5008,Material.wood)).setItemName("Pancake Door");
	public static final Item rawbluepan = new Itemrawbluepan(5009, 2, true).setItemName("RawBlueBerryPancake");
	public static final Item cookbluepan = new Itemcookbluepan(5010, 5, true).setItemName("Cooked-BlueBerryPancake");
	public static final Item rawchocpan = new Itemrawchocpan(5011, 2, true).setItemName("RawBChoclatePancake");
	public static final Item cookchocpan = new Itemcookchocpan(5012, 5, true).setItemName("Cooked-ChoclateChipPancake");
	public static final Item goldpan = new Itemgoldpan(5013, 10, true).setItemName("Goldpancake");  
        public void load()
        {

        	
                shit.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/shit.png");
                ModLoader.addName(shit, "Shit");
                ModLoader.addRecipe(new ItemStack(shit, 1), new Object [] {"#", Character.valueOf('#'), Block.dirt});
                
                rawpancake.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/rawpancake.png");
                ModLoader.addName(rawpancake, "RawPancake");
                
                cookedpancake.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/Cookedpancake.png");
                ModLoader.addName(cookedpancake, "Pancakes" +
                		"");
                ModLoader.addSmelting(mod_item.rawpancake.shiftedIndex, new ItemStack(mod_item.cookedpancake, 1));
                
                blueberry.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/blueberry.png");
                ModLoader.addName(blueberry, "blueberrys");
                
                spawnegg.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/spawnegg.png");
                ModLoader.addName(spawnegg, "Spawn Pancake");
                
                spawnegg2.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/spawnegg2.png");
                ModLoader.addName(spawnegg2, "Spawn ZombiePancake");
                
               rottenpancake.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/rottenpancake.png");
                ModLoader.addName(rottenpancake, "Rotten Pancake");
                
                dooritem.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/pancakedoor.png");
                ModLoader.addName(dooritem, "Pancake door");
                
                rawbluepan.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/rawbluepan.png");
                ModLoader.addName(rawbluepan, "BlueBerry Pancakes" +
                		"§3§o Raw");
                ModLoader.addShapelessRecipe(new ItemStack(rawbluepan, 1) ,new Object[] { 
                    blueberry, rawpancake});
                
                cookbluepan.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/cookbluepan.png");
                ModLoader.addName(cookbluepan, "BlueBerry Pancakes" +
                	"§4§o Cooked");
                ModLoader.addSmelting(rawbluepan.shiftedIndex, new ItemStack(cookbluepan, 1));
                
                rawchocpan.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/rawchocpan.png");
                ModLoader.addName(rawchocpan, "ChoclateChip Pancakes" +
                		"§3§o Raw");
                ModLoader.addShapelessRecipe(new ItemStack(rawbluepan, 1) ,new Object[] {
                	
                Item.appleRed, rawpancake});
                
                cookchocpan.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/cookchocpan.png");
                ModLoader.addName(cookchocpan, "ChoclateChip Pancakes" +
                	"§4§o Cooked");
                ModLoader.addSmelting(rawchocpan.shiftedIndex, new ItemStack(cookchocpan, 1));
                
                goldpan.iconIndex = ModLoader.addOverride("/gui/items.png", "/mods/goldpan.png");
                ModLoader.addName(goldpan, "Gold Pancake");
                ModLoader.addRecipe(new ItemStack(goldpan), new Object[]{
        			"YYY", "YBY", "YYY",
        			'Y', Item.goldNugget,
        			'B', rawpancake,
        		});
        }
        public String getVersion()
        {
                return "1.2.5";
        }
}
