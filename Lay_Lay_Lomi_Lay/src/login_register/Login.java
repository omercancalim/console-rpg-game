package login_register;

import java.util.*;
import char_information.Character_Stats;
import connect.Database_Connection;
import ingame.General_Consts;
import main.User_Information;

public class Login extends Database_Connection implements General_Consts {

	Scanner optionSc = new Scanner(System.in);
	Character_Stats chrObject = new Character_Stats();

	public boolean trackerLoginUsername, trackerLoginPassword;
	static String usernameSelec, passwordSelec, regUNSelec, regPASSelec;
	static int charKeyOrig;

	public void loginUsername() {
		trackerLoginUsername = false;
		trackerLoginPassword = false;

		while (true) {
			System.out.println(logUsername);

			usernameSelec = optionSc.next();

			if (usernameSelec.equals(fetchLoginUsername(usernameSelec))) {
				trackerLoginUsername = true;
				User_Information.username = usernameSelec;
				break;
			} else if (usernameSelec.equals("b") || usernameSelec.equals("B")) {
				break;
			} else {
				System.out.println(usernameDNexist);
			}
		}
	}

	public void loginPassword() throws InterruptedException {
		while (true) {
			System.out.println(logPassword);

			passwordSelec = optionSc.next();

			if (passwordSelec.equals(fetchLoginPassword(usernameSelec))) {
				System.out.println(accessGrant);
				trackerLoginPassword = true;
				Thread.sleep(500);
				break;
			} else if (passwordSelec.equals("b") || passwordSelec.equals("B")) {
				break;
			} else {
				System.out.println(wrongPass);
			}
		}
	}
}