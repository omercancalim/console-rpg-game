package zones;

import char_information.Character_Stats;
import char_information.Inventory;
import ingame.General_Consts;
import main.*;
import npc.*;

public class Area_Changing implements General_Consts {

	General_Functions gnrObject = new General_Functions();
	Area areaObject = new Area();
	Teleporter tlpObject = new Teleporter();
	Saleswoman swObject = new Saleswoman();
	Blacksmith bsObject = new Blacksmith();
	Inventory invObject = new Inventory();
	Character_Stats charObject = new Character_Stats();
	private static int ingameOption;

	public void chooseArea(int areaSelectorr) throws InterruptedException {
		switch (areaSelectorr) {
		case 1:
			Character_Stats.currentArea = Map_Consts.PYUNGMOO.name();
			Character_Stats.currentLocation = Map_Consts.CITY.name();
			pyungmoo(areaSelectorr);
			break;
		case 2:
			Character_Stats.currentArea = Map_Consts.BAKRA.name();
			Character_Stats.currentLocation = Map_Consts.CITY.name();
			bakra(areaSelectorr);
			break;
		case 3:
			Character_Stats.currentArea = Map_Consts.VOS.name();
			Character_Stats.currentLocation = Map_Consts.SZ.name();
			valleyOfSeungryong(areaSelectorr);
			break;
		case 4:
			Character_Stats.currentArea = Map_Consts.YD.name();
			Character_Stats.currentLocation = Map_Consts.SZ.name();
			yongbiDesert(areaSelectorr);
			break;
		}
	}

	private void pyungmoo(int areaSelectorr) throws InterruptedException {

		ingameOption = 0;

		while (ingameOption != 2) {
			System.out.println(pyungmooMenu);
			ingameOption = gnrObject.inputController();

			switch (ingameOption) {
			case 1:
				swObject.market();
				break;
			case 2:
				// Here must be left empty cause of we calling teleporter at main class
				break;
			case 3:
				bsObject.forge();
				break;
			case 4:
				areaObject.pyungmooLocations(areaSelectorr);
				break;
			case 5:
				invObject.openInventory();
				break;
			case 6:
				charObject.showStat();
				break;
			case 7:
				charObject.insertStat();
				invObject.insertInventory();
				break;
			}
		}
	}

	private void bakra(int areaSelectorr) throws InterruptedException {

		ingameOption = 0;

		while (ingameOption != 2) {
			System.out.println(bakraMenu);
			ingameOption = gnrObject.inputController();

			switch (ingameOption) {
			case 1:
				swObject.market();
				break;
			case 2:
				// Here must be left empty cause of we calling teleporter at main class
				break;
			case 3:
				bsObject.forge();
				break;
			case 4:
				areaObject.bakraLocations(areaSelectorr);
				break;
			case 5:
				invObject.openInventory();
				break;
			case 6:
				charObject.showStat();
				break;
			case 7:
				charObject.insertStat();
				invObject.insertInventory();
				break;
			}
		}
	}
	
	private void valleyOfSeungryong(int areaSelectorr) throws InterruptedException {

		ingameOption = 0;

		while (ingameOption != 1) {
			System.out.println(seungryongMenu);
			ingameOption = gnrObject.inputController();

			switch (ingameOption) {
			case 1:
				// Here must be left empty cause of we calling teleporter at main class
				break;
			case 2:
				areaObject.seungryongLocations(areaSelectorr);
				break;
			case 3:
				invObject.openInventory();
				break;
			case 4:
				charObject.showStat();
				break;
			case 5:
				charObject.insertStat();
				invObject.insertInventory();
				break;
			}
		}
	}
	
	private void yongbiDesert(int areaSelectorr) throws InterruptedException {

		ingameOption = 0;

		while (ingameOption != 1) {
			System.out.println(yongbiMenu);

			ingameOption = gnrObject.inputController();

			switch (ingameOption) {
			case 1:
				// Here must be left empty cause of we calling teleporter at main class
				break;
			case 2:
				areaObject.yongbiLocations(areaSelectorr);
				break;
			case 3:
				invObject.openInventory();
				break;
			case 4:
				charObject.showStat();
				break;
			case 5:
				charObject.insertStat();
				invObject.insertInventory();
				break;
			}
		}
	}
}
