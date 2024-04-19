package npc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import char_information.Equipped;
import char_information.Inventory;
import ingame.General_Consts;
import ingame.Item_Consts;
import ingame.Item_Consts.ARMOUR_LIST;
import ingame.Item_Consts.HELMET_LIST;
import ingame.Item_Consts.SHOES_LIST;
import ingame.Item_Consts.UPGRADEARMOUR;
import ingame.Item_Consts.UPGRADEARMOUR.ARMOUR;
import ingame.Item_Consts.UPGRADEHELMET;
import ingame.Item_Consts.UPGRADEHELMET.HELMET;
import ingame.Item_Consts.UPGRADESHOE;
import ingame.Item_Consts.UPGRADESHOE.SHOE;
import ingame.Item_Consts.UPGRADEWEAPON;
import ingame.Item_Consts.UPGRADEWEAPON.DAGGER;
import ingame.Item_Consts.UPGRADEWEAPON.SWORD;
import ingame.Item_Consts.UPGRADEWEAPON.TWOHANDED;
import ingame.Item_Consts.WEAPON_LIST;
import main.General_Functions;

public class Blacksmith implements General_Consts {

	Equipped eqpObject = new Equipped();
	Random random = new Random();
	Inventory invObject = new Inventory();
	General_Functions gnrObject = new General_Functions();
	Scanner input = new Scanner(System.in);
	List<String> itemList = new ArrayList<>();

	int selectMenuOption, counter, itemLevelHolder, dice;
	String itemName, plusDegree, itemEnumName;

	int requiredYangQuantity, requiredFirstItemQuantity, requiredSecondItemQuantity;
	String requiredFirstItemName, requiredSecondItemName;

	boolean upgradeFirstItemExist, upgradeSecondItemExist, isSuccess;

	public void forge() throws InterruptedException {
		selectMenuOption = 0;

		while (selectMenuOption != 5) {
			requiredFirstItemName = emptyString;
			requiredSecondItemName = emptyString;
			upgradeFirstItemExist = false;
			upgradeSecondItemExist = false;

			System.out.println("\n" + blacksmithMenu);
			selectMenuOption = gnrObject.inputController();
			if (selectMenuOption == 5) {
				continue;
			}
			printItemList(selectMenuOption);

			selectMenuOption = 0;
			while (selectMenuOption != 1 && selectMenuOption != 2) {
				System.out.println("\nDo you want to upgrade this item?\n1-Yes\n2-Not yet");
				selectMenuOption = gnrObject.inputController();
			}

			switch (selectMenuOption) {
			case 1:
				if (upgradeFirstItemExist && upgradeSecondItemExist) {
					if (!(invObject.getItemQuantity("YANG") != -1
							&& invObject.getItemQuantity("YANG") > requiredYangQuantity)) {
						System.out.println("You don't have enough material");
						break;
					}
					if (!(invObject.getItemQuantity(requiredFirstItemName) != -1
							&& invObject.getItemQuantity(requiredFirstItemName) >= requiredFirstItemQuantity)) {
						System.out.println("You don't have enough material");
						break;
					}
					if (!(invObject.getItemQuantity(requiredSecondItemName) != -1
							&& invObject.getItemQuantity(requiredSecondItemName) >= requiredSecondItemQuantity)) {
						System.out.println("You don't have enough material");
						break;
					}

					if (isUpgradingSuccessful(plusDegree)) {
						invObject.addItem("YANG", -requiredYangQuantity);
						invObject.addItem(requiredFirstItemName, -requiredFirstItemQuantity);
						invObject.addItem(requiredSecondItemName, -requiredSecondItemQuantity);
						invObject.addItem(itemEnumName, -1);
						invObject.addItem(Item_Consts.values()[Item_Consts.valueOf(itemEnumName).ordinal() + 1].name(),
								1);
						System.out.println("Upgrading is successful");
					} else {
						invObject.addItem("YANG", -requiredYangQuantity);
						invObject.addItem(requiredFirstItemName, -requiredFirstItemQuantity);
						invObject.addItem(requiredSecondItemName, -requiredSecondItemQuantity);
						invObject.addItem(itemEnumName, -1);
						System.out.println("Failed");
					}
				} else if (upgradeFirstItemExist) {
					if (!(invObject.getItemQuantity("YANG") != -1
							&& invObject.getItemQuantity("YANG") > requiredYangQuantity)) {
						System.out.println("You don't have enough material");
						break;
					}
					if (!(invObject.getItemQuantity(requiredFirstItemName) != -1
							&& invObject.getItemQuantity(requiredFirstItemName) >= requiredFirstItemQuantity)) {
						System.out.println("You don't have enough material");
						break;
					}

					if (isUpgradingSuccessful(plusDegree)) {
						invObject.addItem("YANG", -requiredYangQuantity);
						invObject.addItem(requiredFirstItemName, -requiredFirstItemQuantity);
						invObject.addItem(itemEnumName, -1);
						invObject.addItem(Item_Consts.values()[Item_Consts.valueOf(itemEnumName).ordinal() + 1].name(),
								1);
						System.out.println("Upgrading is successful");
					} else {
						invObject.addItem("YANG", -requiredYangQuantity);
						invObject.addItem(requiredFirstItemName, -requiredFirstItemQuantity);
						invObject.addItem(itemEnumName, -1);
						System.out.println("Failed");
					}
				} else {
					if (!(invObject.getItemQuantity("YANG") != -1
							&& invObject.getItemQuantity("YANG") > requiredYangQuantity)) {
						System.out.println("You don't have enough material");
						break;
					}

					if (isUpgradingSuccessful(plusDegree)) {
						invObject.addItem("YANG", -requiredYangQuantity);
						invObject.addItem(itemEnumName, -1);
						invObject.addItem(Item_Consts.values()[Item_Consts.valueOf(itemEnumName).ordinal() + 1].name(),
								1);
						System.out.println("Upgrading is successful");
					} else {
						invObject.addItem("YANG", -requiredYangQuantity);
						invObject.addItem(itemEnumName, -1);
						System.out.println("Failed");
					}
				}
				break;
			}
		}
	}

	private boolean isUpgradingSuccessful(String plusDegree) {
		isSuccess = false;
		dice = (random.nextInt(100) + 1);

		switch (plusDegree) {
		case "ZERO":
			if (dice < 61) {
				isSuccess = true;
			}
			break;
		case "ONE":
			if (dice < 51) {
				isSuccess = true;
			}
			break;
		case "TWO":
			if (dice < 41) {
				isSuccess = true;
			}
			break;
		case "THREE":
			if (dice < 31) {
				isSuccess = true;
			}
			break;
		case "FOUR":
			if (dice < 21) {
				isSuccess = true;
			}
			break;
		case "FIVE":
			if (dice < 11) {
				isSuccess = true;
			}
			break;
		case "SIX":
			if (dice < 9) {
				isSuccess = true;
			}
			break;
		case "SEVEN":
			if (dice < 6) {
				isSuccess = true;
			}
			break;
		case "EIGHT":
			if (dice < 4) {
				isSuccess = true;
			}
			break;
		}
		return isSuccess;
	}

	private void printItemList(int selectedOption) throws InterruptedException {
		String title = "";
		String equippedItem = "";
		itemList.clear();
		counter = 0;

		switch (selectedOption) {
		case 1:
			title = weaponsTitle;
			equippedItem = Equipped.equippedWeapon;
			break;
		case 2:
			title = armoursTitle;
			equippedItem = Equipped.equippedArmour;
			break;
		case 3:
			title = helmetsTitle;
			equippedItem = Equipped.equippedHelmet;
			break;
		case 4:
			title = shoesTitle;
			equippedItem = Equipped.equippedShoe;
			break;
		}

		System.out.println(title);
		for (String item : Inventory.getInventory().keySet()) {
			try {

				switch (selectedOption) {
				case 1:
					WEAPON_LIST.valueOf(item);
					break;
				case 2:
					ARMOUR_LIST.valueOf(item);
					break;
				case 3:
					HELMET_LIST.valueOf(item);
					break;
				case 4:
					SHOES_LIST.valueOf(item);
					break;
				}

				for (int itemCounter = 0; itemCounter < Inventory.getInventory().get(item); itemCounter++) {
					if (itemCounter == 0 && equippedItem.equals(item)) {
						continue;
					}
					if (item.contains("PLUSNINE")) {
						continue;
					}
					itemList.add(item);
					System.out.println(++counter + "-" + Item_Consts.valueOf(item).getItemName());
				}
			} catch (IllegalArgumentException e) {
			}
		}

		System.out.println(
				"\n(Equipped items are not showed on the list)\nEnter the number associated with the item next to it: ");
		selectMenuOption = gnrObject.inputController();

		switch (selectedOption) {
		case 1:
			itemLevelHolder = WEAPON_LIST.valueOf(itemList.get(selectMenuOption - 1)).getLevel();
			break;
		case 2:
			itemLevelHolder = ARMOUR_LIST.valueOf(itemList.get(selectMenuOption - 1)).getLevel();
			break;
		case 3:
			itemLevelHolder = HELMET_LIST.valueOf(itemList.get(selectMenuOption - 1)).getLevel();
			break;
		case 4:
			itemLevelHolder = SHOES_LIST.valueOf(itemList.get(selectMenuOption - 1)).getLevel();
			break;
		}

		itemName = Item_Consts.valueOf(itemList.get(selectMenuOption - 1)).getItemName();
		itemEnumName = Item_Consts.valueOf(itemList.get(selectMenuOption - 1)).name();
		plusDegree = itemList.get(selectMenuOption - 1).substring(
				itemList.get(selectMenuOption - 1).indexOf("PLUS") + 4, itemList.get(selectMenuOption - 1).length());
		System.out
				.println("\s\s\sSelected Item\t\t\tRequirements\n" + "-".repeat(19) + "\s".repeat(18) + "-".repeat(18));

		switch (selectedOption) {
		case 1:
			printWeaponsRequirements(WEAPON_LIST.valueOf(itemList.get(selectMenuOption - 1)).getSocketSize(),
					itemLevelHolder, itemName, plusDegree);
			break;
		case 2:
			printArmoursRequirements(itemLevelHolder, itemName, plusDegree);
			break;
		case 3:
			printHelmetsRequirements(itemLevelHolder, itemName, plusDegree);
			break;
		case 4:
			printShoesRequirements(itemLevelHolder, itemName, plusDegree);
			break;
		}
	}

	private void printWeaponsRequirements(int socketSize, int itemLevelHolder, String itemName, String plusDegree) {
		String gen = "";

		if (itemLevelHolder <= 20) {
			gen = "G1";
		} else if (21 <= itemLevelHolder && itemLevelHolder <= 40) {
			gen = "G2";
		} else if (41 <= itemLevelHolder && itemLevelHolder <= 69) {
			gen = "G3";
		} else if (70 <= itemLevelHolder && itemLevelHolder <= 75) {
			gen = "G4";
		}

		try {
			switch (socketSize) {
			case 1:
				System.out.println(itemName + "\s".repeat(37 - itemName.length())
						+ UPGRADEWEAPON.valueOf(gen + plusDegree).getRequiredYang() + " Yang");
				requiredYangQuantity = UPGRADEWEAPON.valueOf(gen + plusDegree).getRequiredYang();

				System.out.println("\s".repeat(37) + DAGGER.valueOf(gen + plusDegree).getFirstItemName().getItemName()
						+ " (x" + DAGGER.valueOf(gen + plusDegree).getFirstItemQuantity() + ")");
				requiredFirstItemName = DAGGER.valueOf(gen + plusDegree).getFirstItemName().name();
				requiredFirstItemQuantity = DAGGER.valueOf(gen + plusDegree).getFirstItemQuantity();
				upgradeFirstItemExist = true;

				System.out.println("\s".repeat(37) + DAGGER.valueOf(gen + plusDegree).getSecondItemName().getItemName()
						+ " (x" + DAGGER.valueOf(gen + plusDegree).getSecondItemQuantity() + ")");
				requiredSecondItemName = DAGGER.valueOf(gen + plusDegree).getSecondItemName().name();
				requiredSecondItemQuantity = DAGGER.valueOf(gen + plusDegree).getSecondItemQuantity();
				upgradeSecondItemExist = true;
				break;
			case 2:
				System.out.println(itemName + "\s".repeat(37 - itemName.length())
						+ UPGRADEWEAPON.valueOf(gen + plusDegree).getRequiredYang() + " Yang");
				requiredYangQuantity = UPGRADEWEAPON.valueOf(gen + plusDegree).getRequiredYang();

				System.out.println("\s".repeat(37) + SWORD.valueOf(gen + plusDegree).getFirstItemName().getItemName()
						+ " (x" + SWORD.valueOf(gen + plusDegree).getFirstItemQuantity() + ")");
				requiredFirstItemName = SWORD.valueOf(gen + plusDegree).getFirstItemName().name();
				requiredFirstItemQuantity = SWORD.valueOf(gen + plusDegree).getFirstItemQuantity();
				upgradeFirstItemExist = true;

				System.out.println("\s".repeat(37) + SWORD.valueOf(gen + plusDegree).getSecondItemName().getItemName()
						+ " (x" + SWORD.valueOf(gen + plusDegree).getSecondItemQuantity() + ")");
				requiredSecondItemName = SWORD.valueOf(gen + plusDegree).getSecondItemName().name();
				requiredSecondItemQuantity = SWORD.valueOf(gen + plusDegree).getSecondItemQuantity();
				upgradeSecondItemExist = true;
				break;
			case 3:
				System.out.println(itemName + "\s".repeat(37 - itemName.length())
						+ UPGRADEWEAPON.valueOf(gen + plusDegree).getRequiredYang() + " Yang");
				requiredYangQuantity = UPGRADEWEAPON.valueOf(gen + plusDegree).getRequiredYang();

				System.out
						.println("\s".repeat(37) + TWOHANDED.valueOf(gen + plusDegree).getFirstItemName().getItemName()
								+ " (x" + TWOHANDED.valueOf(gen + plusDegree).getFirstItemQuantity() + ")");
				requiredFirstItemName = TWOHANDED.valueOf(gen + plusDegree).getFirstItemName().name();
				requiredFirstItemQuantity = TWOHANDED.valueOf(gen + plusDegree).getFirstItemQuantity();
				upgradeFirstItemExist = true;

				System.out
						.println("\s".repeat(37) + TWOHANDED.valueOf(gen + plusDegree).getSecondItemName().getItemName()
								+ " (x" + TWOHANDED.valueOf(gen + plusDegree).getSecondItemQuantity() + ")");
				requiredSecondItemName = TWOHANDED.valueOf(gen + plusDegree).getSecondItemName().name();
				requiredSecondItemQuantity = TWOHANDED.valueOf(gen + plusDegree).getSecondItemQuantity();
				upgradeSecondItemExist = true;
				break;
			}
		} catch (IllegalArgumentException e) {
		} catch (NullPointerException e) {
		}
	}

	private void printArmoursRequirements(int itemLevelHolder, String itemName, String plusDegree) {
		String gen = "";

		if (itemLevelHolder <= 18) {
			gen = "G1";
		} else if (19 <= itemLevelHolder && itemLevelHolder <= 42) {
			gen = "G2";
		} else if (43 <= itemLevelHolder && itemLevelHolder <= 70) {
			gen = "G3";
		}

		try {
			System.out.println(itemName + "\s".repeat(37 - itemName.length())
					+ UPGRADEARMOUR.valueOf(gen + plusDegree).getRequiredYang() + " Yang");
			requiredYangQuantity = UPGRADEARMOUR.valueOf(gen + plusDegree).getRequiredYang();

			System.out.println("\s".repeat(37) + ARMOUR.valueOf(gen + plusDegree).getFirstItemName().getItemName()
					+ " (x" + ARMOUR.valueOf(gen + plusDegree).getFirstItemQuantity() + ")");
			requiredFirstItemName = ARMOUR.valueOf(gen + plusDegree).getFirstItemName().name();
			requiredFirstItemQuantity = ARMOUR.valueOf(gen + plusDegree).getFirstItemQuantity();
			upgradeFirstItemExist = true;

			System.out.println("\s".repeat(37) + ARMOUR.valueOf(gen + plusDegree).getSecondItemName().getItemName()
					+ " (x" + ARMOUR.valueOf(gen + plusDegree).getSecondItemQuantity() + ")");
			requiredSecondItemName = ARMOUR.valueOf(gen + plusDegree).getSecondItemName().name();
			requiredSecondItemQuantity = ARMOUR.valueOf(gen + plusDegree).getSecondItemQuantity();
			upgradeSecondItemExist = true;
		} catch (IllegalArgumentException e) {
		} catch (NullPointerException e) {
		}
	}

	private void printHelmetsRequirements(int itemLevelHolder, String itemName, String plusDegree) {
		String gen = "";

		if (itemLevelHolder <= 20) {
			gen = "G1";
		} else if (21 <= itemLevelHolder && itemLevelHolder <= 40) {
			gen = "G2";
		} else if (41 <= itemLevelHolder && itemLevelHolder <= 60) {
			gen = "G3";
		}

		try {
			System.out.println(itemName + "\s".repeat(37 - itemName.length())
					+ UPGRADEHELMET.valueOf(gen + plusDegree).getRequiredYang() + " Yang");
			requiredYangQuantity = UPGRADEHELMET.valueOf(gen + plusDegree).getRequiredYang();

			System.out.println("\s".repeat(37) + HELMET.valueOf(gen + plusDegree).getFirstItemName().getItemName()
					+ " (x" + HELMET.valueOf(gen + plusDegree).getFirstItemQuantity() + ")");
			requiredFirstItemName = HELMET.valueOf(gen + plusDegree).getFirstItemName().name();
			requiredFirstItemQuantity = HELMET.valueOf(gen + plusDegree).getFirstItemQuantity();
			upgradeFirstItemExist = true;

			System.out.println("\s".repeat(37) + HELMET.valueOf(gen + plusDegree).getSecondItemName().getItemName()
					+ " (x" + HELMET.valueOf(gen + plusDegree).getSecondItemQuantity() + ")");
			requiredSecondItemName = HELMET.valueOf(gen + plusDegree).getSecondItemName().name();
			requiredSecondItemQuantity = HELMET.valueOf(gen + plusDegree).getSecondItemQuantity();
			upgradeSecondItemExist = true;
		} catch (IllegalArgumentException e) {
		} catch (NullPointerException e) {
		}
	}

	private void printShoesRequirements(int itemLevelHolder, String itemName, String plusDegree) {
		String gen = "";

		if (itemLevelHolder <= 23) {
			gen = "G1";
		} else if (24 <= itemLevelHolder && itemLevelHolder <= 43) {
			gen = "G2";
		} else if (44 <= itemLevelHolder && itemLevelHolder <= 59) {
			gen = "G3";
		}

		try {
			System.out.println(itemName + "\s".repeat(37 - itemName.length())
					+ UPGRADESHOE.valueOf(gen + plusDegree).getRequiredYang() + " Yang");
			requiredYangQuantity = UPGRADESHOE.valueOf(gen + plusDegree).getRequiredYang();

			System.out.println("\s".repeat(37) + SHOE.valueOf(gen + plusDegree).getFirstItemName().getItemName() + " (x"
					+ SHOE.valueOf(gen + plusDegree).getFirstItemQuantity() + ")");
			requiredFirstItemName = SHOE.valueOf(gen + plusDegree).getFirstItemName().name();
			requiredFirstItemQuantity = SHOE.valueOf(gen + plusDegree).getFirstItemQuantity();
			upgradeFirstItemExist = true;

			System.out.println("\s".repeat(37) + SHOE.valueOf(gen + plusDegree).getSecondItemName().getItemName()
					+ " (x" + SHOE.valueOf(gen + plusDegree).getSecondItemQuantity() + ")");
			requiredSecondItemName = SHOE.valueOf(gen + plusDegree).getSecondItemName().name();
			requiredSecondItemQuantity = SHOE.valueOf(gen + plusDegree).getSecondItemQuantity();
			upgradeSecondItemExist = true;
		} catch (IllegalArgumentException e) {
		} catch (NullPointerException e) {
		}
	}
}
