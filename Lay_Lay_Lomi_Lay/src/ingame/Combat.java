package ingame;

import java.util.Scanner;
import char_information.*;
import char_information.Inventory;
import ingame.Mobs_Consts.MOB_METIN;
import main.General_Functions;

public class Combat extends Character_Stats implements General_Consts {

	General_Functions gnrObject = new General_Functions();
	public Inventory invObject = new Inventory(); 
	Drop dropObject = new Drop();
	Scanner scan = new Scanner(System.in);

	final double fifteenPercent = 15.0 / 100.0, threeFourths = 3.0 / 4.0, half = 1.0 / 2.0, oneFourths = 1.0 / 4.0;

	static boolean isMm1Spawned, isMm2Spawned, isMm3Spawned, isMm4Spawned;
	static int mmHpPhase1, mmHpPhase2, mmHpPhase3, mmHpPhase4, mmAttPhase1, mmAttPhase2, mmAttPhase3, mmAttPhase4,
			menuOptionSelection, enemyTempHP, mobAttack, mobCounter, killCounter1, killCounter2, killCounter3, killCounter4,
			metinDetector, mmAtt, charHpCopy;
	public static String threadInput = "bait";
	public static int newThreadOnOff=0;
	static double startMonsterTime, endMonsterTime, startUserTime, endUserTime, currentTimeMilisecond;
	
	static Mobs_Consts[] metinMobList;

	public void combat(Mobs_Consts mob) throws InterruptedException {
		
		currentTimeMilisecond = System.currentTimeMillis();
		
		endMonsterTime = currentTimeMilisecond;
		endUserTime = currentTimeMilisecond;
		
		Thread inputThread = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            while (!(threadInput.equals("2")) && newThreadOnOff==1) {
	                threadInput = scan.next();
	                if ((threadInput.equals("q") || threadInput.equals("Q")) && newThreadOnOff==1) {
	                	invObject.useHealthPotion();
	                	
					}
	            }
	            newThreadOnOff=0;
	        }
	    });

		menuOptionSelection = 0;
		metinDetector = 0;

		isMetin(mob);
		
		charHpCopy = charHP;
		enemyTempHP = mob.getMobHp();
		mobAttack = mob.getMobAtt();

		while (menuOptionSelection != 2) {

			System.out.println(battleMenu);
			menuOptionSelection = gnrObject.inputController();
			switch (menuOptionSelection) {
			case 1: {
				newThreadOnOff=1;
				threadInput = "bait";
				inputThread.start();
				while(!threadInput.equals("2")) {
					switch (metinDetector) {
					case 0: {
						currentTimeMilisecond = System.currentTimeMillis();
						if (currentTimeMilisecond > endMonsterTime) {
							startMonsterTime = System.currentTimeMillis();
							endMonsterTime = startMonsterTime + 1.96 * 1000;
							charHP -= mobAttack;
							if (charHP<0) {
								charHP=0;
							}
							hpBar(mob);
						}
						
						if (currentTimeMilisecond > endUserTime) {
							startUserTime = System.currentTimeMillis();
							endUserTime = startUserTime + charAttSpd * 1000;
							enemyTempHP -= charAtt;
							if (enemyTempHP<0) {
								enemyTempHP=0;
							}
							hpBar(mob);
						}
						break;
					}
					case 1: {
						battleMm(mob);
						isMmDied(mob);
						break;
					}
					}

					if (charHP <= 0) {
						System.out.println(deathMessage);
						double newExpValue = (double) Exp * fifteenPercent;
						Exp -= (int) newExpValue;
						charHP = 20;
						break;
					} else if (enemyTempHP <= 0) {
						System.out.println(enemyDeathMessage + mob.getMobName());
						Character_Stats.Exp += mob.getMobExp();
						dropObject.mobDrop(mob);
						levelCheck();
						break;
					}
				}
				if (threadInput.equals("2")) {
					switch (metinDetector) {
					case 0:
						charHP -= mobAttack;
						System.out.println("-"+mobAttack+" hp");
						break;
					case 1:
						charHP -= mmAtt;
						System.out.println("-"+mmAtt+" hp");
						break;
					}
					if (charHP <= 0) {
						System.out.println(deathMessage);
						double newExpValue = (double) Exp * fifteenPercent;
						Exp -= (int) newExpValue;
						charHP = 20;
						break;
					}
				}
			}
			}
			break;
		}
		runningCombatAtSpecificLocation();
		threadInput="bait";
		mmAtt = 0;
	}
	
	public void hpBar(Mobs_Consts mob) {
		System.out.println(healthbarTitle);
		System.out.println(gnrObject.healthBar(charHP, charHPmain, 30) + "\s".repeat(7)
				+ gnrObject.healthBar(enemyTempHP, mob.getMobHp(), 30));
	}

	public void isMetin(Mobs_Consts mob) {

		if (mob.getMobName().contains("Metin")) {
			isMm1Spawned = false;
			isMm2Spawned = false;
			isMm3Spawned = false;
			isMm4Spawned = false;

			metinDetector = 1;
			mobCounter = 1;
			killCounter1 = 0;
			killCounter2 = 0;
			killCounter3 = 0;
			killCounter4 = 0;

			metinMobList = MOB_METIN.valueOf(mob.name()).metinMobList();
		}
	}

	public void battleMm(Mobs_Consts mob) {

		if ((enemyTempHP <= mob.getMobHp() && enemyTempHP > mob.getMobHp() * threeFourths) && mobCounter == 1) {
			mmHpPhase1 = metinMobList[0].getMobHp();
			isMm1Spawned= true;
			mmAttPhase1 = 3 * metinMobList[0].getMobAtt();
			mmAtt += mmAttPhase1;
			mobCounter = 2;

		} else if ((enemyTempHP <= mob.getMobHp() * threeFourths && enemyTempHP > mob.getMobHp() * half)
				&& mobCounter == 2) {
			mmHpPhase2 = metinMobList[1].getMobHp();
			isMm2Spawned= true;
			mmAttPhase2 = 2 * metinMobList[1].getMobAtt();
			mmAtt += mmAttPhase2;
			mobCounter = 3;
		}

		else if ((enemyTempHP <= mob.getMobHp() * half && enemyTempHP > mob.getMobHp() * oneFourths)
				&& mobCounter == 3) {
			mmHpPhase3 = metinMobList[2].getMobHp();
			isMm3Spawned= true;
			mmAttPhase3 = 2 * metinMobList[2].getMobAtt();
			mmAtt += mmAttPhase3;
			mobCounter = 4;

		} else if (enemyTempHP <= mob.getMobHp() * oneFourths && mobCounter == 4) {
			mmHpPhase4 = metinMobList[3].getMobHp();
			isMm4Spawned= true;
			mmAttPhase4 = 4 * metinMobList[3].getMobAtt();
			mmAtt += mmAttPhase4;
			mobCounter = 5;
		}
	}

	public void isMmDied(Mobs_Consts mob) {
		
		currentTimeMilisecond = System.currentTimeMillis();
		if (currentTimeMilisecond > endUserTime) {
			startUserTime = System.currentTimeMillis();
			endUserTime = startUserTime + charAttSpd * 1000;
			enemyTempHP -= charAtt;
			mmHpPhase1 -= charAtt;
			mmHpPhase2 -= charAtt;
			mmHpPhase3 -= charAtt;
			mmHpPhase4 -= charAtt;
			if (enemyTempHP<0) {
				enemyTempHP=0;
			}
			hpBar(mob);
			printMmHPbar(mmHpPhase1, mmHpPhase2, mmHpPhase3, mmHpPhase4);
		}

		if (mmHpPhase1 <= 0 && killCounter1 == 0) {
			mmAtt -= mmAttPhase1;
			isMm1Spawned=false;
			Character_Stats.Exp += 3 * metinMobList[0].getMobExp();
			killCounter1 = 1;
		}

		if (mmHpPhase2 <= 0 && killCounter2 == 0) {
			mmAtt -= mmAttPhase2;
			isMm2Spawned=false;
			Character_Stats.Exp += 2 * metinMobList[1].getMobExp();
			killCounter2 = 1;
		}

		if (mmHpPhase3 <= 0 && killCounter3 == 0) {
			mmAtt -= mmAttPhase3;
			isMm3Spawned=false;
			Character_Stats.Exp += 2 * metinMobList[2].getMobExp();
			killCounter3 = 1;
		}

		if (mmHpPhase4 <= 0 && killCounter4 == 0) {
			mmAtt -= mmAttPhase4;
			isMm4Spawned=false;
			Character_Stats.Exp += 4 * metinMobList[3].getMobExp();
			killCounter4 = 1;
		}
		if (currentTimeMilisecond > endMonsterTime) {
			startMonsterTime = System.currentTimeMillis();
			endMonsterTime = startMonsterTime + 1.96 * 1000;
			charHP -= mmAtt;
			if (charHP<0) {
				charHP=0;
			}
			hpBar(mob);
			printMmHPbar(mmHpPhase1, mmHpPhase2, mmHpPhase3, mmHpPhase4);
		}
	}

	public void printMmHPbar(int PHS1, int PHS2, int PHS3, int PHS4) {
		if (isMm1Spawned && PHS1 > 0) {
			System.out.println("\s".repeat(39) + gnrObject.healthBar(PHS1, metinMobList[0].getMobHp(), 30) + " "
					+ metinMobList[0].getMobName() + " x3");
		}
		if (isMm2Spawned && PHS2 > 0) {
			System.out.println("\s".repeat(39) + gnrObject.healthBar(PHS2, metinMobList[1].getMobHp(), 30) + " "
					+ metinMobList[1].getMobName() + " x2");
		}
		if (isMm3Spawned && PHS3 > 0) {
			System.out.println("\s".repeat(39) + gnrObject.healthBar(PHS3, metinMobList[2].getMobHp(), 30) + " "
					+ metinMobList[2].getMobName() + " x2");
		}
		if (isMm4Spawned && PHS4 > 0) {
			System.out.println("\s".repeat(39) + gnrObject.healthBar(PHS4, metinMobList[3].getMobHp(), 30) + " "
					+ metinMobList[3].getMobName() + " x4");
		}
	}
	
	public void runningCombatAtSpecificLocation() {
		if ((currentLocation.equals("HD") || currentLocation.equals("JD") || currentLocation.equals("SD")) && menuOptionSelection==2) {
			charHP -= mobAttack;
			System.out.println("-"+mobAttack+" hp");
		}
	}
}
