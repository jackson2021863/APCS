
public class Item {
	String type;
	int baseMod;
	int itemMod;
	public int mod;
	String name;
	
	Item(String type, int itemMod) {
		this.type = type;
		this.itemMod = itemMod;
		if (type.equals("longsword")) {
			baseMod = 4;
		} else if (type.equals("shortsword")) {
			baseMod = 2;
		}
		
		if (type.equals("Strength Amulet")) {
			baseMod = 0;
		}
		mod = baseMod + itemMod;
	}
}
