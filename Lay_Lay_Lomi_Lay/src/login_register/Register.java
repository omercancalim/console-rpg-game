package login_register;

import java.util.Scanner;
import char_information.Character_Stats;
import connect.Database_Connection;
import ingame.General_Consts;
import main.General_Functions;
import main.User_Information;

public class Register extends Database_Connection implements General_Consts {

	Scanner optionSc = new Scanner(System.in);
	Character_Stats chrObject = new Character_Stats();
	General_Functions gnrObject = new General_Functions();

	static String usernameSelec, passwordSelec, regUNSelec, regPASSelec;
	static int charKeyOrig;

	public void register() throws InterruptedException {
		System.out.println(registerPart);
		System.out.println(usernameCreate);

		while (true) {
			regUNSelec = optionSc.next();
			if (checkIfIDCreated(regUNSelec)) {
				System.out.println("Username is already created. Try another: ");
				continue;
			}
			User_Information.username = regUNSelec;
			if (regUNSelec.length() > 4 && regUNSelec.length() < 22) {
				break;
			} else {
				System.out.println(usernameCreate);
			}
		}

		System.out.println(passwordCreate);

		while (true) {
			regPASSelec = optionSc.next();
			if (regPASSelec.length() > 4 && regPASSelec.length() < 41) {
				break;
			} else {
				System.out.println(passwordCreate);
			}
		}

		while (true) {
			System.out.println(selectClass);
			charKeyOrig = gnrObject.inputController();
			Character_Stats.charKeyCopy = charKeyOrig;
			if (charKeyOrig > 0 && charKeyOrig < 4) {
				break;
			}
		}

		switch (charKeyOrig) {
		case 1: {
			registerTail(regUNSelec, regPASSelec, "Warrior");
			break;
		}
		case 2: {
			registerTail(regUNSelec, regPASSelec, "Ninja");
			break;
		}
		case 3: {
			registerTail(regUNSelec, regPASSelec, "Sura");
			break;
		}
		}

		chrObject.defaultStat();
		chrObject.insertStat();

	}

	private void registerTail(String defUser, String defPass, String defCharType) {
		insertRegister(defUser, defPass, defCharType);
	}
}
