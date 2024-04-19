package char_information;

import java.util.*;
import connect.Database_Connection;
import ingame.General_Consts;
import ingame.Item_Consts;
import ingame.Item_Consts.ARMOUR_LIST;
import ingame.Item_Consts.CONSUMABLES_LIST;
import ingame.Item_Consts.HELMET_LIST;
import ingame.Item_Consts.SHOES_LIST;
import ingame.Item_Consts.WEAPON_LIST;
import main.General_Functions;
import main.User_Information;

public class Inventory extends Database_Connection implements General_Consts {

	General_Functions gnrObject = new General_Functions();
	Equipped eqpObject = new Equipped();
	private static Map<String, Integer> inventory = new HashMap<>();
	static List<String> itemList = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	int selectMenuOption;
	String itemSelection;

	public static Map<String, Integer> getInventory() {
		return inventory;
	}
	
	public void addItem(String itemName, int quantity) {
		if (inventory.get(itemName) == null) {
			inventory.put(itemName, quantity);
		} else {
			inventory.put(itemName, inventory.get(itemName) + quantity);
		}
		if (inventory.get(itemName) <= 0) {
			inventory.remove(itemName);
		}
	}

	public void removeAllItem() {
		for (String item : inventory.keySet()) {
			inventory.remove(item);
		}
	}

	public void openInventory() throws InterruptedException {
		selectMenuOption = 0;

		while (selectMenuOption != 6) {
			eqpObject.displayEquipments();
			System.out.println(inventoryMenu);
			selectMenuOption = gnrObject.inputController();
			switch (selectMenuOption) {
			case 1:
				System.out.println(weaponsTitle);
				for (String item : inventory.keySet()) {
					try {
						for (int itemCounter = 0; itemCounter < inventory.get(item); itemCounter++) {
							WEAPON_LIST weapon = WEAPON_LIST.valueOf(item);
							if (itemCounter == 0 && Equipped.equippedWeapon.equals(item)) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+" + weapon.getAttValue() + " ATT, +%"
										+ weapon.getAttSpeed() + " ATTSPD, %" + weapon.getAvgDamage() + " AVGDMG" + "] " + " [EQUIPPED]");
								continue;
							}
							if (itemCounter == 0) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+" + weapon.getAttValue() + " ATT, +%"
										+ weapon.getAttSpeed() + " ATTSPD, %" + weapon.getAvgDamage() + " AVGDMG" + "]");
								continue;
							}
							System.out.println(Item_Consts.valueOf(item).getItemName());
						}
					} catch (IllegalArgumentException e) {}
				}
				
				System.out.println("\n" + weaponInventory + "\n");
				itemSelection = emptyString;
				
				while (true) {
					System.out.print(command);
					itemSelection = input.nextLine();
					
					if (itemSelection.equals("back") || itemSelection.equals("BACK")) {
						System.out.println(emptyString);
						break;
					}
					
					try {
						String command = itemSelection.split(" ")[0];
						String selectedItem = itemSelection.split(" ")[1];
						WEAPON_LIST.valueOf(selectedItem);
						
						if (getInventory().get(selectedItem) == null) {
							System.out.println(nonAvailabilityItem);
							continue;
						}
						
						if (command.equals("EQUIP") && !selectedItem.equals(Equipped.equippedWeapon)) {
							System.out.println(eqpObject.equipWeapon(selectedItem));
						} else if (command.equals("UNEQUIP") && selectedItem.equals(Equipped.equippedWeapon)) {
							eqpObject.unequipWeapon();
							System.out.println(Item_Consts.valueOf(selectedItem).getItemName() + " unequipped!");
						} else if (command.equals("UNEQUIP") && !selectedItem.equals(Equipped.equippedWeapon)) {
							System.out.println("You have not yet equipped this item");
						} else if (command.equals("EQUIP") && selectedItem.equals(Equipped.equippedWeapon)) {
							System.out.println("Selected item is already equipped");
						}
						
					} catch (NullPointerException e) {
						System.out.println(wrongCommand);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(wrongCommand);
					} catch (IllegalArgumentException e) {
						System.out.println(requestWeaponName);
					}
				}
				break;
			
			case 2:
				System.out.println(armoursTitle);
				for (String item : inventory.keySet()) {
					try {
						for (int itemCounter = 0; itemCounter < inventory.get(item); itemCounter++) {
							ARMOUR_LIST.valueOf(item);
							if (itemCounter == 0 && Equipped.equippedArmour.equals(item)) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+" + 
										ARMOUR_LIST.valueOf(item).getExtraHealth()+ " HP] " + " [EQUIPPED]");
								continue;
							}
							if (itemCounter == 0) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+" + 
										ARMOUR_LIST.valueOf(item).getExtraHealth()+ " HP]");
								continue;
							}
							System.out.println(Item_Consts.valueOf(item).getItemName());
						}
					} catch (IllegalArgumentException e) {}
				}
				
				System.out.println("\n" + armourInventory + "\n");
				itemSelection = emptyString;
				
				while (true) {
					System.out.print(command);
					itemSelection = input.nextLine();
					
					if (itemSelection.equals("back") || itemSelection.equals("BACK")) {
						System.out.println(emptyString);
						break;
					}
					
					try {
						String command = itemSelection.split(" ")[0];
						String selectedItem = itemSelection.split(" ")[1];
						ARMOUR_LIST.valueOf(selectedItem);
						
						if (getInventory().get(selectedItem) == null) {
							System.out.println(nonAvailabilityItem);
							continue;
						}
						
						if (command.equals("EQUIP") && !selectedItem.equals(Equipped.equippedArmour)) {
							System.out.println(eqpObject.equipArmour(selectedItem));
						} else if (command.equals("UNEQUIP") && selectedItem.equals(Equipped.equippedArmour)) {
							eqpObject.unequipArmour();
							System.out.println(Item_Consts.valueOf(selectedItem).getItemName() + " unequipped!");
						} else if (command.equals("UNEQUIP") && !selectedItem.equals(Equipped.equippedArmour)) {
							System.out.println("You have not yet equipped this item");
						} else if (command.equals("EQUIP") && selectedItem.equals(Equipped.equippedArmour)) {
							System.out.println("Selected item is already equipped");
						}
						
					} catch (NullPointerException e) {
						System.out.println(wrongCommand);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(wrongCommand);
					} catch (IllegalArgumentException e) {
						System.out.println(requestArmourName);
					}
				}
				break;
			
			case 3:
				System.out.println(helmetsTitle);
				for (String item : inventory.keySet()) {
					try {
						for (int itemCounter = 0; itemCounter < inventory.get(item); itemCounter++) {
							HELMET_LIST.valueOf(item);
							if (itemCounter == 0 && Equipped.equippedHelmet.equals(item)) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+" + 
										HELMET_LIST.valueOf(item).getExtraHealth()+ " HP] " + " [EQUIPPED]");
								continue;
							}
							if (itemCounter == 0) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+" + 
										HELMET_LIST.valueOf(item).getExtraHealth()+ " HP]");
								continue;
							}
							System.out.println(Item_Consts.valueOf(item).getItemName());
						}
					} catch (IllegalArgumentException e) {}
				}
				
				System.out.println("\n" + helmetInventory + "\n");
				itemSelection = emptyString;
				
				while (true) {
					System.out.print(command);
					itemSelection = input.nextLine();
					
					if (itemSelection.equals("back") || itemSelection.equals("BACK")) {
						System.out.println(emptyString);
						break;
					}
					
					try {
						String command = itemSelection.split(" ")[0];
						String selectedItem = itemSelection.split(" ")[1];
						HELMET_LIST.valueOf(selectedItem);
						
						if (getInventory().get(selectedItem) == null) {
							System.out.println(nonAvailabilityItem);
							continue;
						}
						
						if (command.equals("EQUIP") && !selectedItem.equals(Equipped.equippedHelmet)) {
							System.out.println(eqpObject.equipHelmet(selectedItem));
						} else if (command.equals("UNEQUIP") && selectedItem.equals(Equipped.equippedHelmet)) {
							eqpObject.unequipHelmet();
							System.out.println(Item_Consts.valueOf(selectedItem).getItemName() + " unequipped!");
						} else if (command.equals("UNEQUIP") && !selectedItem.equals(Equipped.equippedHelmet)) {
							System.out.println("You have not yet equipped this item");
						} else if (command.equals("EQUIP") && selectedItem.equals(Equipped.equippedHelmet)) {
							System.out.println("Selected item is already equipped");
						}
						
					} catch (NullPointerException e) {
						System.out.println(wrongCommand);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(wrongCommand);
					} catch (IllegalArgumentException e) {
						System.out.println(requestHelmetName);
					}
				}
				break;
			case 4:
				System.out.println(shoesTitle);
				for (String item : inventory.keySet()) {
					try {
						for (int itemCounter = 0; itemCounter < inventory.get(item); itemCounter++) {
							SHOES_LIST.valueOf(item);
							if (itemCounter == 0 && Equipped.equippedShoe.equals(item)) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+"
										+ SHOES_LIST.valueOf(item).getExtraHealth() + " HP, +%"
										+ SHOES_LIST.valueOf(item).getPercentOfMovementSpeed() + " MvtSpd] "
										+ " [EQUIPPED]");
								continue;
							}
							if (itemCounter == 0) {
								System.out.println(Item_Consts.valueOf(item).getItemName() + " [+"
										+ SHOES_LIST.valueOf(item).getExtraHealth() + " HP, +%"
										+ SHOES_LIST.valueOf(item).getPercentOfMovementSpeed() + " MvtSpd] ");
								continue;
							}
							System.out.println(Item_Consts.valueOf(item).getItemName());
						}
					} catch (IllegalArgumentException e) {}
				}
				
				System.out.println("\n" + shoeInventory + "\n");
				itemSelection = emptyString;
				
				while (true) {
					System.out.print(command);
					itemSelection = input.nextLine();
					
					if (itemSelection.equals("back") || itemSelection.equals("BACK")) {
						System.out.println(emptyString);
						break;
					}
					
					try {
						String command = itemSelection.split(" ")[0];
						String selectedItem = itemSelection.split(" ")[1];
						SHOES_LIST.valueOf(selectedItem);
						
						if (getInventory().get(selectedItem) == null) {
							System.out.println(nonAvailabilityItem);
							continue;
						}
						
						if (command.equals("EQUIP") && !selectedItem.equals(Equipped.equippedShoe)) {
							System.out.println(eqpObject.equipShoe(selectedItem));
						} else if (command.equals("UNEQUIP") && selectedItem.equals(Equipped.equippedShoe)) {
							eqpObject.unequipShoe();
							System.out.println(Item_Consts.valueOf(selectedItem).getItemName() + " unequipped!");
						} else if (command.equals("UNEQUIP") && !selectedItem.equals(Equipped.equippedShoe)) {
							System.out.println("You have not yet equipped this item");
						} else if (command.equals("EQUIP") && selectedItem.equals(Equipped.equippedShoe)) {
							System.out.println("Selected item is already equipped");
						}
						
					} catch (NullPointerException e) {
						System.out.println(wrongCommand);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(wrongCommand);
					} catch (IllegalArgumentException e) {
						System.out.println(requestShoeName);
					}
				}
				break;
			case 5:
				System.out.println(displayInventory);
				for (String item : inventory.keySet()) {
					int curLength = Item_Consts.valueOf(item).getItemName().length();
					System.out.println(Item_Consts.valueOf(item).getItemName() + "\s".repeat(30 - curLength) + inventory.get(item));
				}
				System.out.println("");
				break;
			}
		}
	}

	public void insertInventory() {
		itemList.clear();
		String wholeItems = "";
		String wholeItemQuantities = "";
		
		for (String selector : inventory.keySet()) {
			wholeItems += selector.toString() + "#";
			wholeItemQuantities += inventory.get(selector) + "#";
		}
		
		itemList.add(wholeItems);
		itemList.add(wholeItemQuantities);
		insertInventory(itemList, User_Information.username);
//		Equipped equipments
		insertEquippedOnes(Equipped.equippedWeapon, Equipped.equippedArmour, Equipped.equippedHelmet,
				Equipped.equippedShoe, User_Information.username);
	}

	public void setInventory() {
		try {
			String[] inventoryArray = fetchInventory(User_Information.username).split("!");
			String[] itemNameArray = inventoryArray[0].split("#");
			String[] quantityArray = inventoryArray[1].split("#");
			for (int i = 0; i < itemNameArray.length; i++) {
				addItem(itemNameArray[i], Integer.parseInt(quantityArray[i]));
			}

			itemList = fetchEquippedOnes(User_Information.username);
			Equipped.equippedWeapon = itemList.get(0);
			Equipped.equippedArmour = itemList.get(1);
			Equipped.equippedHelmet = itemList.get(2);
			Equipped.equippedShoe = itemList.get(3);
			
			for (String item : itemList) {
				if (!item.equals("")) {
					if (itemList.indexOf(item) == 0) {
						switch (WEAPON_LIST.valueOf(item).getSocketSize()) {
						case 1:
							Equipped.firstWeaponSocket = fullSocket;
							break;
						case 2:
							Equipped.firstWeaponSocket = fullSocket;
							Equipped.secondWeaponSocket = fullSocket;
							break;
						case 3:
							Equipped.firstWeaponSocket = fullSocket;
							Equipped.secondWeaponSocket = fullSocket;
							Equipped.thirdWeaponSocket = fullSocket;
							break;
						}

						Equipped.isWeaponEquipped = equipped;

					} else if (itemList.indexOf(item) == 1) {
						Equipped.armourSocket = fullSocket;
						Equipped.isArmourEquipped = equipped;
					} else if (itemList.indexOf(item) == 2) {
						Equipped.helmetSocket = fullSocket;
						Equipped.isHelmetEquipped = equipped;
					} else if (itemList.indexOf(item) == 3) {
						Equipped.shoeSocket = fullSocket;
						Equipped.isShoeEquipped = equipped;
					}
				}
			}
//			Catch blocks do not throw anything cause of they just here to prevent runtime error while 
//			setting empty inventory which is fetched.
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		} catch (NullPointerException e) {
			return;
		}
	}

	public int getItemQuantity(String itemName) {
		try {
			return inventory.get(itemName);
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		} catch (NullPointerException e) {
			return -1;
		}
	}
	
	double currentTimeMilisecond, durable = 0, interval;
	boolean healed;
	
	public void useHealthPotion() {
		healed = false;
		currentTimeMilisecond = System.currentTimeMillis();
		interval = (durable-currentTimeMilisecond)/1000;
		
		if (currentTimeMilisecond <= durable) {
			System.out.println("You need to wait " + General_Functions.doubleFormat(interval) + " second");
			return;
		}
		if (Character_Stats.charHP == Character_Stats.charHPmain) {
			System.out.println("Your health is full");
			return;
		}
		
		currentTimeMilisecond = System.currentTimeMillis();
		durable = currentTimeMilisecond + 0.7 * 1000;
		int index = 0;
		
		while (index < healthPotionVariety) {
			
			if (inventory.get(CONSUMABLES_LIST.values()[index].name()) != null) {
				Character_Stats.charHP += CONSUMABLES_LIST.values()[index].getRecover();
				
				if (Character_Stats.charHP > Character_Stats.charHPmain) {
					Character_Stats.charHP = Character_Stats.charHPmain;
				}
				
				addItem(CONSUMABLES_LIST.values()[index].name(), -1);
				System.out.println(CONSUMABLES_LIST.values()[index].getRecover() + " hp restored");
				healed = true;
				break;
			}
			index++;
		}
		
		if (!healed) {
			System.out.println("You don't have any item to restore your health");
		}
	}
}
