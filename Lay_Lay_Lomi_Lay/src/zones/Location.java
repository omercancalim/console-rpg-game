package zones;

import ingame.Combat;
import ingame.General_Consts;
import ingame.Mobs_Consts;
import java.util.Random;
import char_information.Inventory;
import main.General_Functions;

public class Location extends Combat implements General_Consts {

	Inventory invObject = new Inventory();
	Random hundredSidedDice = new Random();
	General_Functions gnrObject = new General_Functions();
	Mobs_Consts mob;
	String threadInputCopy;

	public void location(int locationNumber, int area) throws InterruptedException {
		int optionSelection = 0;
		while (optionSelection != 6) {

//			User input
			threadInputCopy = threadInput;
			switch (newThreadOnOff) {
			case 0:
				System.out.println(locationMenu);
				optionSelection = gnrObject.inputController();
				break;
			case 1:
				System.out.println(locationMenu);
				while (true) {
					Thread.sleep(100);
					System.out.print("");
					newThreadOnOff = 0;
					if (threadInputCopy != threadInput) {
						try {
							optionSelection = Integer.parseInt(threadInput);
						} catch (IllegalArgumentException e) {
							System.out.println(locationMenu);
							optionSelection = gnrObject.inputController();
						}
						break;
					}
				}
				break;
			}
			
//			Menu selection
			switch (optionSelection) {
			case 1:
				combat(searchMob(locationNumber, area));
				break;
			case 2:
				invObject.useHealthPotion();
				break;
			case 3:
				invObject.openInventory();
				break;
			case 4:
				showStat();
				break;
			case 5:
				insertStat();
				invObject.insertInventory();
				break;
			}
		}
	}

	public Mobs_Consts searchMob(int locationNumber, int area) throws InterruptedException {
		int result = (hundredSidedDice.nextInt(100) + 1);

		switch (area) {
//		PYUNGMOO MOBS
		case 1:
			switch (locationNumber) {
			case 1:
				if (result < 9) {
					mob = Mobs_Consts.WILDDOG;
				} else if (9 <= result && result < 19) {
					mob = Mobs_Consts.HUNGRYSTRAYDOG;
				} else if (19 <= result && result < 28) {
					mob = Mobs_Consts.HUNGRYWOLF;
				} else if (28 <= result && result < 38) {
					mob = Mobs_Consts.WOLF;
				} else if (38 <= result && result < 47) {
					mob = Mobs_Consts.ALPHAWOLF;
				} else if (47 <= result && result < 57) {
					mob = Mobs_Consts.HUNGRYALPHAWOLF;
				} else if (57 <= result && result < 66) {
					mob = Mobs_Consts.HUNGRYBLUEWOLF;
				} else if (66 <= result && result < 76) {
					mob = Mobs_Consts.BLUEWOLF;
				} else if (76 <= result && result < 85) {
					mob = Mobs_Consts.WILDBOAR;
				} else if (85 <= result && result < 95) {
					mob = Mobs_Consts.HUNGRYWILDBOAR;
				} else {
					mob = Mobs_Consts.METINOFSARROW;
				}
				break;

			case 2:
				if (result < 9) {
					mob = Mobs_Consts.ALPHABLUEWOLF;
				} else if (9 <= result && result < 19) {
					mob = Mobs_Consts.HUNGRYALPHABLUEWOLF;
				} else if (19 <= result && result < 28) {
					mob = Mobs_Consts.REDWILDBOAR;
				} else if (28 <= result && result < 38) {
					mob = Mobs_Consts.HUNGRYREDBOAR;
				} else if (38 <= result && result < 47) {
					mob = Mobs_Consts.BEAR;
				} else if (47 <= result && result < 57) {
					mob = Mobs_Consts.HUNGRYBEAR;
				} else if (57 <= result && result < 66) {
					mob = Mobs_Consts.GREYWOLF;
				} else if (66 <= result && result < 76) {
					mob = Mobs_Consts.HUNGRYGREYWOLF;
				} else if (76 <= result && result < 85) {
					mob = Mobs_Consts.GRIZZLYBEAR;
				} else if (85 <= result && result < 95) {
					mob = Mobs_Consts.HUNGRYGRIZZLY;
				} else {
					mob = Mobs_Consts.METINOFCOMBAT;
				}
				break;

			case 3:
				if (result < 9) {
					mob = Mobs_Consts.HUNGRYALPHAGREYWOLF;
				} else if (9 <= result && result < 19) {
					mob = Mobs_Consts.ALPHAGREYWOLF;
				} else if (19 <= result && result < 28) {
					mob = Mobs_Consts.HUNGRYTIGER;
				} else if (28 <= result && result < 38) {
					mob = Mobs_Consts.TIGER;
				} else if (38 <= result && result < 47) {
					mob = Mobs_Consts.BLACKBEAR;
				} else if (47 <= result && result < 57) {
					mob = Mobs_Consts.HUNGRYBLACKBEAR;
				} else if (57 <= result && result < 66) {
					mob = Mobs_Consts.WHITETIGER;
				} else if (66 <= result && result < 76) {
					mob = Mobs_Consts.HUNGRYWHITETIGER;
				} else if (76 <= result && result < 85) {
					mob = Mobs_Consts.BROWNBEAR;
				} else if (85 <= result && result < 95) {
					mob = Mobs_Consts.HUNGRYBROWNBEAR;
				} else {
					mob = Mobs_Consts.METINOFBATTLE;
				}
				break;

			case 4:
				if (result < 9) {
					mob = Mobs_Consts.EUNJUNG;
				} else if (9 <= result && result < 19) {
					mob = Mobs_Consts.DISPIRITEDEUNJUNG;
				} else if (19 <= result && result < 28) {
					mob = Mobs_Consts.DISPIRITEDJINHEE;
				} else if (28 <= result && result < 38) {
					mob = Mobs_Consts.DISPIRITEDMIJUNG;
				} else if (38 <= result && result < 47) {
					mob = Mobs_Consts.DISPIRITEDSERANG;
				} else if (47 <= result && result < 57) {
					mob = Mobs_Consts.WHITEOATHCOMMANDER;
				} else if (57 <= result && result < 66) {
					mob = Mobs_Consts.WHITEOATHGENERAL;
				} else if (66 <= result && result < 76) {
					mob = Mobs_Consts.WHITEOATHSOLDIER;
				} else if (76 <= result && result < 85) {
					mob = Mobs_Consts.SERANG;
				} else if (85 <= result && result < 95) {
					mob = Mobs_Consts.JINHEE;
				} else {
					mob = Mobs_Consts.METINOFGREED;
				}
				break;

			case 5:
				if (result < 10) {
					mob = Mobs_Consts.BERA;
				} else if (10 <= result && result < 21) {
					mob = Mobs_Consts.CUNGMOK;
				} else if (21 <= result && result < 31) {
					mob = Mobs_Consts.JUGHYUL;
				} else if (31 <= result && result < 42) {
					mob = Mobs_Consts.MURANG;
				} else if (42 <= result && result < 52) {
					mob = Mobs_Consts.SCROFA;
				} else if (52 <= result && result < 63) {
					mob = Mobs_Consts.TIGRIS;
				} else if (63 <= result && result < 73) {
					mob = Mobs_Consts.YOUNGJI;
				} else if (73 <= result && result < 84) {
					mob = Mobs_Consts.CURSEDALPHAGREYWOLF;
				} else if (84 <= result && result < 94) {
					mob = Mobs_Consts.CURSEDBROWNBEAR;
				} else if (94 <= result && result < 97) {
					mob = Mobs_Consts.LYKOS;
				} else {
					mob = Mobs_Consts.METINOFBLACK;
				}
				break;
			}
			break;
//		BAKRA MOBS
		case 2:
			switch (locationNumber) {
			case 1:
				if (result < 9) {
					mob = Mobs_Consts.WHITEOATHSOLDIER;
				} else if (9 <= result && result < 19) {
					mob = Mobs_Consts.WHITEOATHGENERAL;
				} else if (19 <= result && result < 28) {
					mob = Mobs_Consts.WHITEOATHCOMMANDER;
				} else if (28 <= result && result < 38) {
					mob = Mobs_Consts.BLACKWINDSOLDIER;
				} else if (38 <= result && result < 47) {
					mob = Mobs_Consts.EVILBLACKSTORMSOLDIER;
				} else if (47 <= result && result < 57) {
					mob = Mobs_Consts.SAVAGEINFANTRYMAN;
				} else if (57 <= result && result < 66) {
					mob = Mobs_Consts.STRONGSAVAGEINFANTRY;
				} else if (66 <= result && result < 76) {
					mob = Mobs_Consts.BLACKWINDJAKTO;
				} else if (76 <= result && result < 85) {
					mob = Mobs_Consts.EVILBLACKSTORMJOHHWAN;
				} else if (85 <= result && result < 95) {
					mob = Mobs_Consts.BLACKSTORMSOLDIER;
				} else {
					mob = Mobs_Consts.METINOFBLACK;
				}
				break;
			case 2:
				if (result < 10) {
					mob = Mobs_Consts.SAVAGEMINION;
				} else if (10 <= result && result < 21) {
					mob = Mobs_Consts.STRONGSAVAGEMINION;
				} else if (21 <= result && result < 31) {
					mob = Mobs_Consts.MAHON;
				} else if (31 <= result && result < 42) {
					mob = Mobs_Consts.BLACKWINDTOSU;
				} else if (42 <= result && result < 52) {
					mob = Mobs_Consts.EVILBLACKSTORMKYUKJANG;
				} else if (52 <= result && result < 63) {
					mob = Mobs_Consts.BLACKSTORMMANIAC;
				} else if (63 <= result && result < 74) {
					mob = Mobs_Consts.BLACKWINDGURYUNG;
				} else if (74 <= result && result < 84) {
					mob = Mobs_Consts.EVILBLACKSTORMPHOHWA;
				} else if (84 <= result && result < 93) {
					mob = Mobs_Consts.SAVAGEGENERAL;
				} else if (93 <= result && result < 95) {
					mob = Mobs_Consts.BESTIALSOLDIER;
				} else if (95 <= result && result < 98) {
					mob = Mobs_Consts.METINOFDARKNESS;
				} else {
					mob = Mobs_Consts.METINOFJEALOUSLY;
				}
				break;
			case 3:
				if (result < 12) {
					mob = Mobs_Consts.STRONGSAVAGEGENERAL;
				} else if (12 <= result && result < 24) {
					mob = Mobs_Consts.BLACKSTORMJOHHWAN;
				} else if (24 <= result && result < 36) {
					mob = Mobs_Consts.BO;
				} else if (36 <= result && result < 48) {
					mob = Mobs_Consts.BLACKSTORMKYUKJANG;
				} else if (48 <= result && result < 60) {
					mob = Mobs_Consts.GOOPAE;
				} else if (60 <= result && result < 72) {
					mob = Mobs_Consts.BLACKSTORMPHOHWAN;
				} else if (72 <= result && result < 85) {
					mob = Mobs_Consts.CHUONG;
				} else if (85 <= result && result < 91) {
					mob = Mobs_Consts.BESTIALCAPTAIN;
				} else if (91 <= result && result < 93) {
					mob = Mobs_Consts.BESTIALSPECIALIST;
				} else if (93 <= result && result < 95) {
					mob = Mobs_Consts.BESTIALMANIAC;
				} else {
					mob = Mobs_Consts.METINOFJEALOUSLY;
				}
				break;
			}
			break;
//		SEUNGRYONG MOBS
		case 3:
			switch (locationNumber) {
			case 1:
				if (result < 9) {
					mob = Mobs_Consts.KINGSCORPION;
				} else if (9 <= result && result < 19) {
					mob = Mobs_Consts.ORC;
				} else if (19 <= result && result < 28) {
					mob = Mobs_Consts.ORCFIGHTER;
				} else if (28 <= result && result < 38) {
					mob = Mobs_Consts.ORCSCOUT;
				} else if (38 <= result && result < 47) {
					mob = Mobs_Consts.ORCSORCERER;
				} else if (47 <= result && result < 57) {
					mob = Mobs_Consts.ELITEORCSCOUT;
				} else if (57 <= result && result < 66) {
					mob = Mobs_Consts.ELITEORC;
				} else if (66 <= result && result < 76) {
					mob = Mobs_Consts.ELITEORCFIGHTER;
				} else if (76 <= result && result < 85) {
					mob = Mobs_Consts.ELITEORCSORCERER;
				} else if (85 <= result && result < 95) {
					mob = Mobs_Consts.ELITEORCGENERAL;
				} else {
					mob = Mobs_Consts.BESTIALMANIAC;
				}
				break;
			case 2:
				if (result < 10) {
					mob = Mobs_Consts.BLACKORC;
				} else if (10 <= result && result < 21) {
					mob = Mobs_Consts.BLACKORCGIANT;
				} else if (21 <= result && result < 31) {
					mob = Mobs_Consts.BOLDBIGORC;
				} else if (31 <= result && result < 42) {
					mob = Mobs_Consts.BOLDBIGORCFIGHTER;
				} else if (42 <= result && result < 52) {
					mob = Mobs_Consts.BOLDBIGORCGENERAL;
				} else if (52 <= result && result < 63) {
					mob = Mobs_Consts.BOLDBIGORCSCOUT;
				} else if (63 <= result && result < 74) {
					mob = Mobs_Consts.BOLDBIGORCSORCERER;
				} else if (74 <= result && result < 84) {
					mob = Mobs_Consts.BOLDBLACKGIANTORC;
				} else if (84 <= result && result < 93) {
					mob = Mobs_Consts.BOLDBLACKORC;
				} else if (93 <= result && result < 95) {
					mob = Mobs_Consts.CHIEFORC;
				} else if (95 <= result && result < 98) {
					mob = Mobs_Consts.BESTIALSOLDIER;
				} else {
					mob = Mobs_Consts.METINOFSHADOW;
				}
				break;
			case 3:
				if (result < 15) {
					mob = Mobs_Consts.HIGHTORMENTOR;
				} else if (15 <= result && result < 31) {
					mob = Mobs_Consts.HIGHEVOCATOR;
				} else if (31 <= result && result < 47) {
					mob = Mobs_Consts.HIGHDEATHSMAN;
				} else if (47 <= result && result < 62) {
					mob = Mobs_Consts.ESOTERICEXECUTIONER;
				} else if (62 <= result && result < 77) {
					mob = Mobs_Consts.DARKTORMENTOR;
				} else if (77 <= result && result < 93) {
					mob = Mobs_Consts.DARKSUMMONER;
				} else if (93 <= result && result < 95) {
					mob = Mobs_Consts.BESTIALSPECIALIST;
				} else {
					mob = Mobs_Consts.METINOFSHADOW;
				}
				break;
			case 4:
				if (result < 12) {
					mob = Mobs_Consts.CHIEFESOTERICARAHAN;
				} else if (12 <= result && result < 25) {
					mob = Mobs_Consts.DARKARAHAN;
				} else if (25 <= result && result < 37) {
					mob = Mobs_Consts.DARKFANATIC;
				} else if (37 <= result && result < 50) {
					mob = Mobs_Consts.ESOTERICARAHANFIGHTER;
				} else if (50 <= result && result < 62) {
					mob = Mobs_Consts.HIGHARAHAN;
				} else if (62 <= result && result < 75) {
					mob = Mobs_Consts.HIGHARAHANFIGHTER;
				} else if (75 <= result && result < 88) {
					mob = Mobs_Consts.HIGHELITEARAHAN;
				} else {
					mob = Mobs_Consts.HIGHFANATIC;
				}
				break;
			}
			break;
//		YONGBI MOBS
		case 4:
			switch (locationNumber) {
			case 1:
				if (result < 13) {
					mob = Mobs_Consts.BABYSPIDER;
				} else if (13 <= result && result < 26) {
					mob = Mobs_Consts.BESTIALSCORPIONMAN;
				} else if (26 <= result && result < 39) {
					mob = Mobs_Consts.DESERTFLYINGEYE;
				} else if (39 <= result && result < 52) {
					mob = Mobs_Consts.KINGSCORPION;
				} else if (52 <= result && result < 65) {
					mob = Mobs_Consts.MEANBABYPOISONSPIDER;
				} else if (65 <= result && result < 77) {
					mob = Mobs_Consts.POISONSPIDER;
				} else if (77 <= result && result < 93) {
					mob = Mobs_Consts.YOUNGSCORPIONMAN;
				} else if (93 <= result && result < 98) {
					mob = Mobs_Consts.METINOFSOUL;
				} else {
					mob = Mobs_Consts.METINOFSHADOW;
				}
				break;
			case 2:
				if (result < 10) {
					mob = Mobs_Consts.CLAWSPIDER;
				} else if (10 <= result && result < 21) {
					mob = Mobs_Consts.DESERTOUTLAW;
				} else if (21 <= result && result < 31) {
					mob = Mobs_Consts.STRONGDESERTOUTLAW;
				} else if (31 <= result && result < 42) {
					mob = Mobs_Consts.MEANCLAWPOISONSPIDER;
				} else if (42 <= result && result < 52) {
					mob = Mobs_Consts.MEANDEADPOISONSPIDER;
				} else if (52 <= result && result < 63) {
					mob = Mobs_Consts.MEANREDPOISONSPIDER;
				} else if (63 <= result && result < 74) {
					mob = Mobs_Consts.REDPOISONSPIDER;
				} else if (74 <= result && result < 84) {
					mob = Mobs_Consts.SNAKESWORDSMAN;
				} else if (84 <= result && result < 93) {
					mob = Mobs_Consts.SOLDIERSPIDER;
				} else if (93 <= result && result < 95) {
					mob = Mobs_Consts.GIANTTORTOISE;
				} else if (95 <= result && result < 98) {
					mob = Mobs_Consts.METINOFSOUL;
				} else {
					mob = Mobs_Consts.METINOFTOUGHNESS;
				}
				break;
			}
			break;
		}
		System.out.print(mob.getMobInstruction());
		return mob;
	}
}
