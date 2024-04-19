package ingame;

import java.util.Random;
import char_information.Inventory;
import ingame.Mobs_Consts.MOB_DROP;

public class Drop {
	
	Random thousand = new Random();
	Inventory invObject = new Inventory();
	private static int selectItem, yang;
	public static String itemName, itemNameOriginal;
	static MOB_DROP mobDrop;
	static boolean willDrop;

	public void mobDrop(Mobs_Consts mob) {
		
		selectItem = (thousand.nextInt(1000)+1);
		itemNameOriginal="Nothing";
		itemName=null;
		yang=0;
		
		try {
			mobDrop = MOB_DROP.valueOf(mob.name());
			if (selectItem<15) {
				itemName = mobDrop.getItem1().name();
			} else if (15<=selectItem && selectItem<30) {
				itemName = mobDrop.getItem2().name();
			} else if (30<=selectItem && selectItem<110) {
				itemName = mobDrop.getItem3().name();
			} else if (110<=selectItem && selectItem<190) {
				itemName = mobDrop.getItem4().name();
			} else if (190<=selectItem && selectItem<270) {
				itemName = mobDrop.getItem5().name();
			} else if (270<=selectItem && selectItem<416) {
				itemName = mobDrop.getItem6().name();
			} else if (416<=selectItem && selectItem<562) {
				itemName = mobDrop.getItem6().name();
			} else if (562<=selectItem && selectItem<708) {
				itemName = mobDrop.getItem6().name();
			} else if (708<=selectItem && selectItem<854) {
				itemName = mobDrop.getItem6().name();
			} else if (854<=selectItem && selectItem<=1000) {
				itemName = mobDrop.getItem6().name();
			}
		} 
		catch (IllegalArgumentException e) {} 
		catch (NullPointerException e) {}
		
		yang = MOB_DROP.valueOf(mob.name()).getYang();
		invObject.addItem("YANG", yang);
		
		if (itemName!=null) {
			invObject.addItem(itemName, 1);
			itemNameOriginal=Item_Consts.valueOf(itemName).getItemName();
		}
		System.out.println("Found: " + itemNameOriginal +"\nYang: " + yang);
	}
}
