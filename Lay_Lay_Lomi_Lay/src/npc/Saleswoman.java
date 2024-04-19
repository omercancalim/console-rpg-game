package npc;

import java.util.Scanner;

import char_information.Equipped;
import char_information.Inventory;
import ingame.General_Consts;
import ingame.Item_Consts;
import ingame.Item_Consts.MARKET_LIST;
import main.General_Functions;

public class Saleswoman implements General_Consts {

	General_Functions gnrObject = new General_Functions();
	Scanner sellItem = new Scanner(System.in);
	Inventory invObject = new Inventory();
	Equipped eqpObject = new Equipped();

	private static int ingameOption, chooseItem, choosenItemPrice, choosenItemQuantity, gINT1;
	private static String choosenItemName, gSTR1, gSTR2;

	public void market() throws InterruptedException {

		ingameOption = 0;

		while (ingameOption != 3) {
			System.out.println(saleswomanMenu);
			ingameOption = gnrObject.inputController();
			switch (ingameOption) {

			case 1: {

				System.out.println(marketTitleTop);
				for (int i = 0; i < MARKET_LIST.values().length; i++) {
					System.out.printf("%d- " + gnrObject.saleswomanInventory(
							MARKET_LIST.values()[i].getItemName(), MARKET_LIST.values()[i].getPurchasePrice()),
							i + 10);
					if ((i + 1) % 2 == 0) {
						System.out.println("");
					}
				}
				System.out.println(marketTitleBottom);

				chooseItem = 1;
				while (chooseItem != 0) {
					System.out.println("\nChoose item from the list, '0' to exit");
					chooseItem = gnrObject.inputController();
					try {

						choosenItemName = MARKET_LIST.values()[chooseItem - 10].name();
						choosenItemPrice = MARKET_LIST.values()[chooseItem - 10].getPurchasePrice();
						choosenItemQuantity = MARKET_LIST.values()[chooseItem - 10].getQuantity();

						if (invObject.getItemQuantity("YANG") != -1
								&& invObject.getItemQuantity("YANG") >= choosenItemPrice) {
							invObject.addItem(choosenItemName, choosenItemQuantity);
							invObject.addItem("YANG", -choosenItemPrice);
							System.out.println("Purchased item: " + choosenItemQuantity + "x " + MARKET_LIST.valueOf(choosenItemName).getItemName());
						} else {
							System.out.println("You don't have enough Yang");
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
				break;
			}

			case 2: {
				
				System.out.println(sellToMarketTop + "\n");
				for (String item : Inventory.getInventory().keySet()) {
					if (item.equals("YANG")) {
						continue;
					}
					if (item.equals(eqpObject.equippedWeaponName())) {
						if (Inventory.getInventory().get(item)-1==0) {
							continue;
						}
						System.out.println(gnrObject.userMarketInventory(Item_Consts.valueOf(item).getItemName(),
								Inventory.getInventory().get(item)-1, Item_Consts.valueOf(item).getSalePrice()));
						continue;
					}
					System.out.println(gnrObject.userMarketInventory(Item_Consts.valueOf(item).getItemName(),
							Inventory.getInventory().get(item), Item_Consts.valueOf(item).getSalePrice()));
				}
				System.out.println(sellToMarketBottom);
				gSTR1 = "";

				System.out.println(
						"\nEnter all letters in uppercase, remove punctuations and concatenate all words\nthen leave a space and enter number of item that you want to sell\n"
						+ "(i.e REDPOTIONXXL 20),  (Q/q)uit");

				while (!(gSTR1.equals("q") || gSTR1.equals("Q"))) {
					System.out.print("Entry: ");
					try {
						gSTR1 = sellItem.nextLine();
						gSTR2 = gSTR1.split(" ")[0];
						gINT1 = Integer.parseInt(gSTR1.split(" ")[1]);

						if (Inventory.getInventory().keySet().contains(gSTR2)
								&& invObject.getItemQuantity(gSTR2) >= gINT1) {
							if (gSTR2.equals("YANG") || (gSTR2.equals(eqpObject.equippedWeaponName()) && invObject.getItemQuantity(gSTR2) == gINT1)) {
								continue;
							}
							invObject.addItem(gSTR2, -gINT1);
							invObject.addItem("YANG",
									gINT1 * Item_Consts.valueOf(gSTR2).getSalePrice());
							System.out.println(gINT1 + "x " + Item_Consts.valueOf(gSTR2).getItemName() + " sold for " + gINT1 * Item_Consts.valueOf(gSTR2).getSalePrice() + "Y");
						} else {
							System.out.println("\nSeems that you either do not have this item or the amount specified.\n"
									+ "\nAlso you can't sell equipped items:\nFor instance, suppose you have 3 same weapons and "
									+ "you've already equipped one of them,\nthen you should enter 2 while you specifying amount.");
						}
					} catch (NumberFormatException e) {
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}

				break;
			}
			}
		}
	}
}
