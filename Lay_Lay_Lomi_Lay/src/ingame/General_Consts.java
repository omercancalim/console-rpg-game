package ingame;

public interface General_Consts {

//	Menu
	String mainMenu = "\nWelcome\n\n1-Login\n2-Register\n",
			pyungmooMenu = "\n\t\t"+"\s".repeat(6)+"[ PYUNGMOO ]\n1-Saleswoman\n2-Teleporter\n3-Blacksmith\n4-Explore\n5-Open Inventory\n6-Stats\n7-Save",
			bakraMenu = "\n\t\t"+"\s".repeat(8)+"[ BAKRA ]\n1-Saleswoman\n2-Teleporter\n3-Blacksmith\n4-Explore\n5-Open Inventory\n6-Stats\n7-Save",
			seungryongMenu = "\n\t\t[ VALLEY OF SEUNGRYONG ]\n1-Teleporter\n2-Explore\n3-Open Inventory\n4-Stats\n5-Save",
			yongbiMenu = "\n\t\t"+"\s".repeat(4)+"[ YONGBI DESERT ]\n1-Teleporter\n2-Explore\n3-Open Inventory\n4-Stats\n5-Save",
			pyungmooLocationMenu = "\n1-Entrance of city\n2-Biologist Chaegirab's Tent\n3-Open Field\n"
					+ "4-Nameless Flowers\n5-Weol Monument\n6-Back to the city",
			bakraLocationMenu = "\n1-North-East Gate\n2-Bandit Den\n3-Nakajima's Viewpoint\n4-Hasun Dong\n5-Back to the city",
			seungryongLocationMenu = "\n1-Trembling Prairie\n2-Devil's Triangle\n3-Hanged Man\n4-In front of Grotto\n5-Back to the safe zone",
			yongbiLocationMenu = "\n1-Edge of the desert\n2-Oasis\n3-Jungsun Dong\n4-Sangsun Dong\n5-Back to the safe zone",
			locationMenu = "\n1-Look around for monster\n2-Heal\n3-Open inventory\n4-Stats\n5-Save\n6-Change location",
			battleMenu = "\n1-Attack\n2-Run", 
			teleporterMenu = "\n1-Pyungmoo\n2-Bakra\n3-Valley of Seungryong\n4-Yongbi Desert",
			saleswomanMenu = "\n1-Show me your wares\n2-Are you interested in my goods?\n3-Back",
			blacksmithMenu = "Welcome adventurer. What do you want me to upgrade?" + "\n1-Weapon\n2-Armour\n3-Helmet\n4-Shoe\n5-Back",
			mazeMenu = "\n1-Heal\n2-Open inventroy\n3-Stats\n4-Save",
			inventoryMenu = "\n1-Display weapons\n2-Display armours\n3-Display helmets\n4-Display shoes\n5-Display all items\n6-Back";

//	Title
	String marketTitleTop = "\n" + "=".repeat(35) + "[-- MARKET --]" + "=".repeat(35) + "\n",
			marketTitleBottom = "\n\n" + "=".repeat(84),
			sellToMarketTop = "\n--------[ Items ]--------|-------[ Quantity ]-------|-------[ 1x Price ]-------",
			sellToMarketBottom = "\n" + "-".repeat(79),
			healthbarTitle = "\n|+-----+[ Your Health ]+------+|+-----+|+-----+[ Enemy Health ]+-----+|",
			displayInventory = "\s\s\sItem name"+"\s".repeat(18)+"Quantity\n"+"-".repeat(15)+"\s".repeat(12)+"-".repeat(14),
			weaponsTitle = "\s\s\sWeapons\n"+"-".repeat(13),
			armoursTitle = "\s\s\sArmours\n"+"-".repeat(13),
			helmetsTitle = "\s\s\sHelmets\n"+"-".repeat(13),
			shoesTitle = "\s\s\sShoes\n"+"-".repeat(13);

//	Login - Register
	String logUsername = "\nEnter your username, to return main menu 'B/b'\nUsername: ",
			logPassword = "\nEnter your password, to return main menu 'B/b'\nPassword: ",
			usernameDNexist = "\nUsername does not exist", 
			wrongPass = "\nIncorrect password!",
			accessGrant = "\n\t\t\s\s\s\s\sAccess granted",
			usernameCreate = "\nUsername must be 5-21 characters (a-z A-Z 0-9)\nUsername?: ",
			passwordCreate = "\nPassword must be 5-40 characters (a-z A-Z 0-9)\nPassword?: ",
			registerPart = "\nHere is the part where you can create an account for yourself",
			selectClass = "\nChoose a class:\n1-Warrior\n2-Ninja\n3-Sura";

//	Warning - Information
	String loginFirst = "You should login first!", 
			invalidEntry = "Your entry was invalid!\nTry again: ",
			deathMessage = "\tYOU DIED", 
			enemyDeathMessage = "Monster killed: ",
			weaponInventory = "Type EQUIP ITEMNAME to equip an item, i.e. EQUIP SWORDPLUSZERO"
					+ "\nType UNEQUIP ITEMNAME to unequip an item, i.e. UNEQUIP SWORDPLUSZERO"
					+ "\nType 'back/BACK' to return inventory",
			armourInventory = "Type EQUIP ITEMNAME to equip an item, i.e. EQUIP AZURESUITPLUSEIGHT"
					+ "\nType UNEQUIP ITEMNAME to unequip an item, i.e. UNEQUIP AZURESUITPLUSEIGHT"
					+ "\nType 'back/BACK' to return inventory",
			helmetInventory = "Type EQUIP ITEMNAME to equip an item, i.e. EQUIP STEELHOODPLUSFIVE"
					+ "\nType UNEQUIP ITEMNAME to unequip an item, i.e. UNEQUIP STEELHOODPLUSFIVE"
					+ "\nType 'back/BACK' to return inventory",
			shoeInventory = "Type EQUIP ITEMNAME to equip an item, i.e. EQUIP PHOENIXSHOESPLUSNINE"
					+ "\nType UNEQUIP ITEMNAME to unequip an item, i.e. UNEQUIP PHOENIXSHOESPLUSNINE"
					+ "\nType 'back/BACK' to return inventory",
			wrongCommand = "Wrong command!", 
			requestWeaponName = "You have to type weapon name!",
			requestArmourName = "You have to type armour name!",
			requestHelmetName = "You have to type helmet name!",
			requestShoeName = "You have to type shoe name!",
			nonAvailabilityItem = "You don't have such an item!";

//	Cutscene
	String loading = "\t\t\tLOADING...";
	
//	Character Statistics
	int warriorBeginningHPmain = 100, 
			warriorBeginningAtt = 3,
			ninjaBeginningHPmain = 80, 
			ninjaBeginningAtt = 4, 
			suraBeginningHPmain = 60, 
			suraBeginningAtt = 6,
			beginningLevel = 1, 
			beginningExp = 0,
			beginningMvtSpd = 0;
	
	double generalAttackSpd = 3.0;
	
	String warrior = "Warrior", 
			ninja = "Ninja", 
			sura = "Sura";
	
	boolean equipped = true,
			notEquipped = false;
	
//	Inventory
	int healthPotionVariety = 4;
	
	String emptySocket = "-", 
			fullSocket = "X";

//	General
	String emptyString = "", 
			command = "Command: ";
}
