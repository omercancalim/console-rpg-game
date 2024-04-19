package main;

import java.text.DecimalFormat;
import java.util.*;
import char_information.Character_Stats;
import ingame.General_Consts;
import zones.Map_Consts;
import zones.Map_Consts.MAP_DISTANCE;

public class General_Functions extends Character_Stats implements General_Consts {

	static Scanner optionSc = new Scanner(System.in);
	static int optionSelection, displayValue;
	List <Map_Consts> locationList;

	public long hash(String s) {
		long hash = 5381;
		for (int i = 0; i < s.length(); ++i) {
			hash = ((hash << 5) + hash) + s.charAt(i);
		}
		return hash;
	}

	public String healthBar(int curHealth, int maxHealth, int barLength) {
		double curHealthD = (double) curHealth;
		double maxHealthD = (double) maxHealth;
		int curChars = (int) Math.ceil(curHealthD / maxHealthD * barLength);

		return "|" + "#".repeat(curChars) + "\s".repeat(barLength - curChars) + "|";
	}

	public String saleswomanInventory(String curItem, int curPrice) {
		int curLength = curItem.length();
		String intToString = String.valueOf(curPrice);
		int curlength2 = intToString.length();
		return curItem + " [x100]" + "\s".repeat(23 - curLength) + curPrice + "Y" + "\s".repeat(10 - curlength2);
	}

	public String userMarketInventory(String itemName, int quantity, int priceForOneX) {
		int curLength = itemName.length();
		String intToString = String.valueOf(quantity);
		int curlength2 = intToString.length();
		return itemName + "\s".repeat(35 - curLength) + quantity + "\s".repeat(27 - curlength2) + priceForOneX;
	}

	public int numberOfDigit(int number) {
		int length = String.valueOf(number).length();
		return length;
	}

	public int inputController() throws InterruptedException {
		while (true) {
			try {
				optionSc = new Scanner(System.in);
				optionSelection = optionSc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println(invalidEntry);
				Thread.sleep(500);
			}
		}
		return optionSelection;
	}
	
	public void estimatedTimeOFArrival(String currentArea, String currentLocation, String desiredLocation, int movementSpeed) throws InterruptedException {
		if (currentLocation.equals(desiredLocation)) {
			return;
		}
		
		String selectDistance = currentLocation + "AND" + desiredLocation;
		int distance = MAP_DISTANCE.valueOf(selectDistance).getDistance();
		double eta = (double)distance - (double)distance*movementSpeed/100;
		System.out.println("|\t\t" + "\s".repeat(7) + "ETA: " + (int)eta/60 + "m "
				+ doubleFormat(eta%60) + "s" + "\t\t" + "\s".repeat(9) + "|");
		long milis = ((long)eta)*1000/58;
		
		for(int i = 0; i<58; i++) {
			Thread.sleep(milis);
			System.out.print(">");
		}
	}
	
	public static String doubleFormat(Double cooldown) {
		DecimalFormat form = new DecimalFormat("#.#");
		return form.format(cooldown);
	}
}
