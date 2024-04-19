package main;

import java.util.Scanner;

import ingame.General_Consts;

public class Main implements General_Consts {

	static Scanner optionSc = new Scanner(System.in);
	static int loadPart = 0, ingameOption;
	public static int areaSelector = 1;

	public static void main(String args[]) throws Exception {

		/*********************************************
		 * Beginning of the Program
		 *********************************************/
		
		while (true) {
			System.out.println(mainMenu);
			ingameOption = 0;

															/*********************************************
															 * Main menu
															 *********************************************/

			switch (Main_Connector.gnrObject.inputController()) {

			/*********************************************
			 * Login
			 *********************************************/

			case 1: {
				Main_Connector.logObject.loginUsername();
				if (Main_Connector.logObject.trackerLoginUsername) {
					Main_Connector.logObject.loginPassword();
				}
				break;
			}

			/*********************************************
			 * Register
			 *********************************************/

			case 2: {
				Main_Connector.regObject.register();
				break;
			}
			}

															/*********************************************
															 * In-game Menu
															 *********************************************/

			if (Main_Connector.logObject.trackerLoginPassword) {

				while (loadPart == 0) {
					System.out.println(loading);
					for (int i = 0; i < 58; i++) {
						System.out.print("#");
						Thread.sleep(25);
					}
					System.out.println("");
					--loadPart;
				}

				Main_Connector.charObject.setStat(); // Set all fetched statistics from database after login

				Main_Connector.invObject.setInventory();

				Main_Connector.acObject.chooseArea(1);

				while (true) {
					Main_Connector.acObject.chooseArea(Main_Connector.tlpObject.teleporterAreas());
				}
			}
		}
	}
}
