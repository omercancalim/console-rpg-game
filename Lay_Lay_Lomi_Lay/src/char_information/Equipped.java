package char_information;

import ingame.General_Consts;
import ingame.Item_Consts;
import ingame.Item_Consts.ARMOUR_LIST;
import ingame.Item_Consts.HELMET_LIST;
import ingame.Item_Consts.SHOES_LIST;
import ingame.Item_Consts.WEAPON_LIST;

public class Equipped extends Character_Stats implements General_Consts {

	public static boolean isWeaponEquipped = notEquipped,
			isArmourEquipped = notEquipped,
			isHelmetEquipped = notEquipped,
			isShoeEquipped = notEquipped,
			isHorseEquipped = notEquipped;
	
	public static String equippedWeapon = emptyString,
			equippedArmour = emptyString,
			equippedHelmet = emptyString,
			equippedShoe = emptyString,
			helmetSocket = emptySocket, 
			armourSocket = emptySocket, 
			shoeSocket = emptySocket, 
			firstWeaponSocket = emptySocket, 
			secondWeaponSocket = emptySocket, 
			thirdWeaponSocket = emptySocket;
	
//	============================================ WEAPON ============================================
	
	public String equipWeapon(String itemName) {
		
		switch (charType){
		case warrior:
			if (WEAPON_LIST.valueOf(itemName).getSocketSize() == 1) {
				return "Your character can not equip this type of item";
			}
			break;
		case ninja:
			if (WEAPON_LIST.valueOf(itemName).getSocketSize() == 3) {
				return "Your character can not equip this type of item";
			}
			break;
		case sura:
			if (WEAPON_LIST.valueOf(itemName).getSocketSize() == 1 || WEAPON_LIST.valueOf(itemName).getSocketSize() == 3) {
				return "Your character can not equip this type of item";
			}
			break;
		}
		
		switch (WEAPON_LIST.valueOf(itemName).getSocketSize()) {
		case 1:
			firstWeaponSocket = fullSocket;
			break;
		case 2:
			firstWeaponSocket = fullSocket;
			secondWeaponSocket = fullSocket;
			break;
		case 3:
			firstWeaponSocket = fullSocket;
			secondWeaponSocket = fullSocket;
			thirdWeaponSocket = fullSocket;
			break;
		}
		
		if (isWeaponEquipped) {
			charAtt -= WEAPON_LIST.valueOf(equippedWeapon).getAttValue();
			charAttSpd = generalAttackSpd;
		}
	
		equippedWeapon = itemName;
		isWeaponEquipped = equipped;
		charAtt += WEAPON_LIST.valueOf(itemName).getAttValue();
		charAttSpd -= charAttSpd*WEAPON_LIST.valueOf(itemName).getAttSpeed()/100;
		return Item_Consts.valueOf(itemName).getItemName() + " equipped!";
	}
	
	public void unequipWeapon() {
		firstWeaponSocket = emptySocket;
		secondWeaponSocket = emptySocket;
		thirdWeaponSocket = emptySocket;
		
		charAtt -= WEAPON_LIST.valueOf(equippedWeapon).getAttValue();
		charAttSpd = generalAttackSpd;
		equippedWeapon = "";
		isWeaponEquipped = notEquipped;
	}
	
	public String equippedWeaponName() {
		return equippedWeapon;
	}
	
//	============================================ ARMOUR ============================================
	
	public String equipArmour(String itemName) {
		
		switch (charType){
		case warrior:
			if (!ARMOUR_LIST.valueOf(itemName).getCharType().equals(charType)) {
				return "Your character can not equip this type of item";
			}
			break;
		case ninja:
			if (!ARMOUR_LIST.valueOf(itemName).getCharType().equals(charType)) {
				return "Your character can not equip this type of item";
			}
			break;
		case sura:
			if (!ARMOUR_LIST.valueOf(itemName).getCharType().equals(charType)) {
				return "Your character can not equip this type of item";
			}
			break;
		}
		
		armourSocket = fullSocket;
		
		if (isArmourEquipped) {
			charHPmain -= ARMOUR_LIST.valueOf(itemName).getExtraHealth();
		}
	
		equippedArmour = itemName;
		isArmourEquipped = equipped;
		charHPmain += ARMOUR_LIST.valueOf(itemName).getExtraHealth();
		return Item_Consts.valueOf(itemName).getItemName() + " equipped!";
	}
	
	public void unequipArmour() {
		armourSocket = emptySocket;
		
		charHPmain -= ARMOUR_LIST.valueOf(equippedArmour).getExtraHealth();
		
		if (charHP>charHPmain) {
			charHP = charHPmain;
		}
		
		equippedArmour = "";
		isArmourEquipped = notEquipped;
	}
	
	public String equippedArmourName() {
		return equippedArmour;
	}
	
//	============================================ HELMET ============================================
	
	public String equipHelmet(String itemName) {
		
		switch (charType){
		case warrior:
			if (!HELMET_LIST.valueOf(itemName).getCharType().equals(charType)) {
				return "Your character can not equip this type of item";
			}
			break;
		case ninja:
			if (!HELMET_LIST.valueOf(itemName).getCharType().equals(charType)) {
				return "Your character can not equip this type of item";
			}
			break;
		case sura:
			if (!HELMET_LIST.valueOf(itemName).getCharType().equals(charType)) {
				return "Your character can not equip this type of item";
			}
			break;
		}
		
		helmetSocket = fullSocket;
		
		if (isHelmetEquipped) {
			charHPmain -= HELMET_LIST.valueOf(itemName).getExtraHealth();
		}
	
		equippedHelmet = itemName;
		isHelmetEquipped = equipped;
		charHPmain += HELMET_LIST.valueOf(itemName).getExtraHealth();
		return Item_Consts.valueOf(itemName).getItemName() + " equipped!";
	}
	
	public void unequipHelmet() {
		helmetSocket = emptySocket;
		
		charHPmain -= HELMET_LIST.valueOf(equippedHelmet).getExtraHealth();
		
		if (charHP>charHPmain) {
			charHP = charHPmain;
		}
		
		equippedHelmet = "";
		isHelmetEquipped = notEquipped;
	}
	
	public String equippedHelmetName() {
		return equippedHelmet;
	}
	
//	============================================ SHOE ============================================
	
	public String equipShoe(String itemName) {
		shoeSocket = fullSocket;
		
		if (isShoeEquipped) {
			charHPmain -= SHOES_LIST.valueOf(itemName).getExtraHealth();
			charMvtSpd = beginningMvtSpd;
		}
	
		equippedShoe = itemName;
		isShoeEquipped = equipped;
		charHPmain += SHOES_LIST.valueOf(itemName).getExtraHealth();
		charMvtSpd += SHOES_LIST.valueOf(itemName).getPercentOfMovementSpeed();
		return Item_Consts.valueOf(itemName).getItemName() + " equipped!";
	}
	
	public void unequipShoe() {
		shoeSocket = emptySocket;
		
		charHPmain -= SHOES_LIST.valueOf(equippedShoe).getExtraHealth();
		charMvtSpd = beginningMvtSpd;
		
		if (charHP>charHPmain) {
			charHP = charHPmain;
		}
		
		equippedShoe = "";
		isShoeEquipped = notEquipped;
	}
	
	public String equippedShoeName() {
		return equippedShoe;
	}
	
//	======================================================================================================
	
	
	
	public void displayEquipments() {
		System.out.println("\s".repeat(4) + "|" + thirdWeaponSocket + "|\n" + "\s".repeat(4) + "|" + secondWeaponSocket + "|\s\s\s\s|"
				+ helmetSocket + "|\n" + "\s".repeat(4) + "|" + firstWeaponSocket + "|\s|" + armourSocket + "||" + armourSocket + "||"
				+ armourSocket + "|\n" + "\s".repeat(11) + "|" + armourSocket + "|\n" + "\s".repeat(11) + "|" + shoeSocket
				+ "|");
	}
}
