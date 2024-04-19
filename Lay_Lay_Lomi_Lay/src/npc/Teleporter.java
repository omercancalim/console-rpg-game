package npc;

import ingame.General_Consts;
import main.General_Functions;

public class Teleporter implements General_Consts {

	General_Functions gnrObject = new General_Functions();
	static private int ingameOption, areaNo;

	public int teleporterAreas() throws InterruptedException {

		ingameOption = 0;

		while (!(0 < ingameOption && ingameOption < 5)) {

			System.out.println(teleporterMenu);
			ingameOption = gnrObject.inputController();
			
			switch (ingameOption) {
			case 1:
				System.out.println("Teleported: Pyungmoo");
				areaNo = 1;
				break;
			case 2:
				System.out.println("Teleported: Bakra");
				areaNo = 2;
				break;
			case 3:
				System.out.println("Teleported: Valley of Seungryong");
				areaNo = 3;
				break;
			case 4:
				System.out.println("Teleported: Yongbi Desert");
				areaNo = 4;
				break;
			}
		}
		return areaNo;
	}
}
