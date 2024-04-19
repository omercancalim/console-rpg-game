package zones;

import java.util.*;
import ingame.General_Consts;
import main.General_Functions;
import zones.Map_Consts.MAP_AREA_LOCATION;
import zones.sub_maps.Monkey_Dungeons;

public class Area extends Location implements General_Consts {

	Scanner optionSc = new Scanner(System.in);
	Monkey_Dungeons monkeyObject = new Monkey_Dungeons();
	General_Functions gnrObject = new General_Functions();

	private static int selectLocation;

	public void pyungmooLocations(int areaNumber) throws InterruptedException {

		selectLocation = 0;

		while (selectLocation != 6) {
			try {
				System.out.println(pyungmooLocationMenu);
				selectLocation = gnrObject.inputController();
				desiredLocation = MAP_AREA_LOCATION.PYUNGMOO.getlocations().get(selectLocation - 1).name();
				gnrObject.estimatedTimeOFArrival(currentArea, currentLocation, desiredLocation, charMvtSpd);
				currentLocation = MAP_AREA_LOCATION.PYUNGMOO.getlocations().get(selectLocation - 1).name();

				switch (selectLocation) {
				case 1:
					location(selectLocation, areaNumber);
					break;
				case 2:
					location(selectLocation, areaNumber);
					break;
				case 3:
					location(selectLocation, areaNumber);
					break;
				case 4:
					location(selectLocation, areaNumber);
					break;
				case 5:
					location(selectLocation, areaNumber);
					break;
				}
			} catch (NullPointerException e) {
			} catch (IndexOutOfBoundsException e) {
			}
		}
	}

	public void bakraLocations(int areaNumber) throws InterruptedException {

		selectLocation = 0;

		while (selectLocation != 5) {
			try {
				System.out.println(bakraLocationMenu);
				selectLocation = gnrObject.inputController();
				desiredLocation = MAP_AREA_LOCATION.BAKRA.getlocations().get(selectLocation - 1).name();
				gnrObject.estimatedTimeOFArrival(currentArea, currentLocation, desiredLocation, charMvtSpd);
				currentLocation = MAP_AREA_LOCATION.BAKRA.getlocations().get(selectLocation - 1).name();

				switch (selectLocation) {
				case 1:
					location(selectLocation, areaNumber);
					break;
				case 2:
					location(selectLocation, areaNumber);
					break;
				case 3:
					location(selectLocation, areaNumber);
					break;
				case 4:
					monkeyObject.hasunDong();
					break;
				}
			} catch (NullPointerException e) {
			} catch (IndexOutOfBoundsException e) {
			}
		}
	}

	public void seungryongLocations(int areaNumber) throws InterruptedException {

		selectLocation = 0;

		while (selectLocation != 5) {
			try {
				System.out.println(seungryongLocationMenu);
				selectLocation = gnrObject.inputController();
				desiredLocation = MAP_AREA_LOCATION.VOS.getlocations().get(selectLocation - 1).name();
				gnrObject.estimatedTimeOFArrival(currentArea, currentLocation, desiredLocation, charMvtSpd);
				currentLocation = MAP_AREA_LOCATION.VOS.getlocations().get(selectLocation - 1).name();

				switch (selectLocation) {
				case 1:
					location(selectLocation, areaNumber);
					break;
				case 2:
					location(selectLocation, areaNumber);
					break;
				case 3:
					location(selectLocation, areaNumber);
					break;
				case 4:
					location(selectLocation, areaNumber);
					break;
				}
			} catch (NullPointerException e) {
			} catch (IndexOutOfBoundsException e) {
			}
		}
	}
	
	public void yongbiLocations(int areaNumber) throws InterruptedException {

		selectLocation = 0;

		while (selectLocation != 5) {
			try {
				System.out.println(yongbiLocationMenu);
				selectLocation = gnrObject.inputController();
				desiredLocation = MAP_AREA_LOCATION.YD.getlocations().get(selectLocation - 1).name();
				gnrObject.estimatedTimeOFArrival(currentArea, currentLocation, desiredLocation, charMvtSpd);
				currentLocation = MAP_AREA_LOCATION.YD.getlocations().get(selectLocation - 1).name();

				switch (selectLocation) {
				case 1:
					location(selectLocation, areaNumber);
					break;
				case 2:
					location(selectLocation, areaNumber);
					break;
				case 3:
					monkeyObject.jungsunDong();
					break;
				case 4:
					monkeyObject.sangsunDong();
					break;
				}
			} catch (NullPointerException e) {
			} catch (IndexOutOfBoundsException e) {
			}
		}
	}
}
