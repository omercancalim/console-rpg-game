package zones.sub_maps;

import java.util.Random;
import java.util.Scanner;
import ingame.Combat;
import ingame.Mobs_Consts;
import zones.Maze_Formation;

public class Monkey_Dungeons extends Combat {
	Maze_Formation maze = new Maze_Formation();
	Random hundredSidedDice = new Random();
	Scanner input = new Scanner(System.in);
	
	Mobs_Consts mob;
	String userInput, threadInputCopy;
	static double currentTimeMilisecond, durable = 0;

	/*==========================================================================================================
	================================================ HASUN DONG ================================================
	==========================================================================================================*/
	
	public void hasunDong() throws InterruptedException {

		Maze_Formation currentCell = maze.hasunSetFirstMaze();
		Maze_Formation previousCell = new Maze_Formation();
		newThreadOnOff = 0;

		while (true) {

			if (shouldMobSpawn(currentCell) && currentCell != previousCell) {
				int result = (hundredSidedDice.nextInt(100) + 1);

				switch (maze.floorNumber) {
				case 1:
					if (result < 60) {
						mob = Mobs_Consts.WEAKAPESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				case 2:
					if (result < 55) {
						mob = Mobs_Consts.WEAKAPEFIGHTER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (55 <= result && result < 70) {
						mob = Mobs_Consts.WEAKAPESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				case 3:
					if (currentCell.cellNo == 24) {
						currentTimeMilisecond = System.currentTimeMillis();
						if (currentTimeMilisecond > durable) {
							currentTimeMilisecond = System.currentTimeMillis();
							durable = currentTimeMilisecond + 600 * 1000;
							mob = Mobs_Consts.ROCKAPE;
							System.out.print("\n" + mob.getMobInstruction() + "[BOSS]");
							combat(mob);
							break;
						}
					}
					
					if (result < 60) {
						mob = Mobs_Consts.WEAKAPEGENERAL;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (60 <= result && result < 80) {
						mob = Mobs_Consts.WEAKAPEFIGHTER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (80 <= result && result < 90) {
						mob = Mobs_Consts.WEAKAPESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				}

				portalFound(currentCell);
				availableDirections(currentCell);
			} else {
				portalFound(currentCell);
				availableDirections(currentCell);
			}

			/************************************************
			 * Take input from user *
			 ************************************************/

			threadInputCopy = threadInput;
			switch (newThreadOnOff) {
			case 0:
				userInput = input.next();
				break;
			case 1:
				while (true) {
					Thread.sleep(100);
					System.out.print("");
					newThreadOnOff = 0;
					if (threadInputCopy != threadInput) {
						userInput = threadInput;
						break;
					}
				}
				break;
			}

			/************************************************
			 * Process logic *
			 ************************************************/

			previousCell = currentCell;
			
			if (userInput.equals("1")) {
				invObject.useHealthPotion();
				continue;
			} else if (userInput.equals("2")) {
				invObject.openInventory();
				continue;
			} else if (userInput.equals("3")) {
				showStat();
				continue;
			} else if (userInput.equals("4")) {
				insertStat();
				invObject.insertInventory();
				continue;
			}

			if (maze.floorNumber == 1 && currentCell.cellNo == 0 && (userInput.equals("b") || userInput.equals("B"))) {
				break;
			} else if (maze.floorNumber == 1 && currentCell.cellNo == 16
					&& (userInput.equals("t") || userInput.equals("T"))) {
				maze.firstMazeLastCell = currentCell;
				currentCell = maze.hasunSetSecondMaze();
				continue;
			} else if (maze.floorNumber == 2 && currentCell.cellNo == 0 && (userInput.equals("t") || userInput.equals("T"))) {
				System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Hasun Dong - 1 ]");
				maze.floorNumber = 1;
				currentCell = maze.firstMazeLastCell;
				continue;
			} else if (maze.floorNumber == 2 && currentCell.cellNo == 37
					&& (userInput.equals("t") || userInput.equals("T"))) {
				maze.secondMazeLastCell = currentCell;
				currentCell = maze.hasunSetThirdMaze();
				continue;
			} else if (maze.floorNumber == 3 && currentCell.cellNo == 0 && (userInput.equals("t") || userInput.equals("T"))) {
				System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Hasun Dong - 2 ]");
				maze.floorNumber = 2;
				currentCell = maze.secondMazeLastCell;
				continue;
			}
			
			currentCell = move(currentCell, userInput);
		}
	}

	/*==========================================================================================================
	=============================================== JUNGSUN DONG ===============================================
	==========================================================================================================*/
	
	public void jungsunDong() throws InterruptedException {

		Maze_Formation currentCell = maze.jungsunSetFirstMaze();
		Maze_Formation previousCell = new Maze_Formation();
		newThreadOnOff
		= 0;

		while (true) {

			if (shouldMobSpawn(currentCell) && currentCell != previousCell) {
				int result = (hundredSidedDice.nextInt(100) + 1);

				switch (maze.floorNumber) {
				case 1:
					if (result < 60) {
						mob = Mobs_Consts.APEFIGHTER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				case 2:
					if (result < 55) {
						mob = Mobs_Consts.APESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (55 <= result && result < 70) {
						mob = Mobs_Consts.APEGENERAL;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				case 3:
					if (currentCell.cellNo == 26) {
						currentTimeMilisecond = System.currentTimeMillis();
						if (currentTimeMilisecond > durable) {
							currentTimeMilisecond = System.currentTimeMillis();
							durable = currentTimeMilisecond + 600 * 1000;
							mob = Mobs_Consts.WALKINGAPE;
							System.out.print("\n" + mob.getMobInstruction() + "[BOSS]");
							combat(mob);
							break;
						}
					}
					
					if (result < 60) {
						mob = Mobs_Consts.APESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (60 <= result && result < 80) {
						mob = Mobs_Consts.APEGENERAL;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (80 <= result && result < 90) {
						mob = Mobs_Consts.STONEAPE;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				}
				portalFound(currentCell);
				availableDirections(currentCell);
			} else {
				portalFound(currentCell);
				availableDirections(currentCell);
			}
			/************************************************
			 * Take input from user *
			 ************************************************/

			threadInputCopy = threadInput;
			switch (newThreadOnOff) {
			case 0:
				userInput = input.next();
				break;
			case 1:
				while (true) {
					Thread.sleep(100);
					System.out.print("");
					newThreadOnOff = 0;
					if (threadInputCopy != threadInput) {
						userInput = threadInput;
						break;
					}
				}
				break;
			}

			/************************************************
			 * Process logic *
			 ************************************************/

			previousCell = currentCell;
			
			if (userInput.equals("1")) {
				invObject.useHealthPotion();
				continue;
			} else if (userInput.equals("2")) {
				invObject.openInventory();
				continue;
			} else if (userInput.equals("3")) {
				showStat();
				continue;
			} else if (userInput.equals("4")) {
				insertStat();
				invObject.insertInventory();
				continue;
			}

			if (maze.floorNumber == 1 && currentCell.cellNo == 0 && (userInput.equals("b") || userInput.equals("B"))) {
				break;
			} else if (maze.floorNumber == 1 && currentCell.cellNo == 25
					&& (userInput.equals("t") || userInput.equals("T"))) {
				maze.firstMazeLastCell = currentCell;
				currentCell = maze.jungsunSetSecondMaze();
				continue;
			} else if (maze.floorNumber == 2 && currentCell.cellNo == 0 && (userInput.equals("t") || userInput.equals("T"))) {
				System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Jungsun Dong - 1 ]");
				maze.floorNumber = 1;
				currentCell = maze.firstMazeLastCell;
				continue;
			} else if (maze.floorNumber == 2 && currentCell.cellNo == 18
					&& (userInput.equals("t") || userInput.equals("T"))) {
				maze.secondMazeLastCell = currentCell;
				currentCell = maze.jungsunSetThirdMaze();
				continue;
			} else if (maze.floorNumber == 3 && currentCell.cellNo == 0 && (userInput.equals("t") || userInput.equals("T"))) {
				System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Jungsun Dong - 2 ]");
				maze.floorNumber = 2;
				currentCell = maze.secondMazeLastCell;
				continue;
			}
			
			currentCell = move(currentCell, userInput);
		}
	}
	
	/*==========================================================================================================
	=============================================== SANGSUN DONG ===============================================
	==========================================================================================================*/
	
	public void sangsunDong() throws InterruptedException {

		Maze_Formation currentCell = maze.sangsunSetFirstMaze();
		Maze_Formation previousCell = new Maze_Formation();
		newThreadOnOff = 0;

		while (true) {
			if (shouldMobSpawn(currentCell) && currentCell != previousCell) {
				int result = (hundredSidedDice.nextInt(100) + 1);

				switch (maze.floorNumber) {
				case 1:
					if (result < 25) {
						mob = Mobs_Consts.STRONGAPEFIGHTER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (25 <= result && result < 50) {
						mob = Mobs_Consts.STRONGAPESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (50 <= result && result < 75) {
						mob = Mobs_Consts.STRONGAPEGENERAL;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				case 2:
					if (result < 18) {
						mob = Mobs_Consts.EVILSTRONGAPEFIGHTER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (18 <= result && result < 36) {
						mob = Mobs_Consts.EVILSTRONGAPESOLDIER;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (36 <= result && result < 54) {
						mob = Mobs_Consts.EVILSTRONGAPEGENERAL;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (54 <= result && result < 72) {
						mob = Mobs_Consts.STRONGSTONEAPE;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				case 3:
					if (currentCell.cellNo == 24) {
						currentTimeMilisecond = System.currentTimeMillis();
						if (currentTimeMilisecond > durable) {
							currentTimeMilisecond = System.currentTimeMillis();
							durable = currentTimeMilisecond + 600 * 1000;
							mob = Mobs_Consts.APELORD;
							System.out.print("\n" + mob.getMobInstruction() + "\s\s[BOSS]");
							combat(mob);
							break;
						}
					}
					
					if (result < 25) {
						mob = Mobs_Consts.STRONGGOLDAPE;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (25 <= result && result < 50) {
						mob = Mobs_Consts.EVILSTRONGGOLDAPE;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					} else if (50 <= result && result < 75) {
						mob = Mobs_Consts.EVILSTRONGSTONEAPE;
						System.out.print("\n" + mob.getMobInstruction());
						combat(mob);
					}
					break;
				}

				portalFound(currentCell);
				availableDirections(currentCell);
			} else {
				portalFound(currentCell);
				availableDirections(currentCell);
			}
			/************************************************
			 * Take input from user *
			 ************************************************/

			threadInputCopy = threadInput;
			switch (newThreadOnOff) {
			case 0:
				userInput = input.next();
				break;
			case 1:
				while (true) {
					Thread.sleep(100);
					System.out.print("");
					newThreadOnOff = 0;
					if (threadInputCopy != threadInput) {
						userInput = threadInput;
						break;
					}
				}
				break;
			}

			/************************************************
			 * Process logic *
			 ************************************************/

			previousCell = currentCell;
			
			if (userInput.equals("1")) {
				invObject.useHealthPotion();
				continue;
			} else if (userInput.equals("2")) {
				invObject.openInventory();
				continue;
			} else if (userInput.equals("3")) {
				showStat();
				continue;
			} else if (userInput.equals("4")) {
				insertStat();
				invObject.insertInventory();
				continue;
			}

			if (maze.floorNumber == 1 && currentCell.cellNo == 0 && (userInput.equals("b") || userInput.equals("B"))) {
				break;
			} else if (maze.floorNumber == 1 && currentCell.cellNo == 21
					&& (userInput.equals("t") || userInput.equals("T"))) {
				maze.firstMazeLastCell = currentCell;
				currentCell = maze.sangsunSetSecondMaze();
				continue;
			} else if (maze.floorNumber == 2 && currentCell.cellNo == 0 && (userInput.equals("t") || userInput.equals("T"))) {
				System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Sangsun Dong - 1 ]");
				maze.floorNumber = 1;
				currentCell = maze.firstMazeLastCell;
				continue;
			} else if (maze.floorNumber == 2 && currentCell.cellNo == 11
					&& (userInput.equals("t") || userInput.equals("T"))) {
				maze.secondMazeLastCell = currentCell;
				currentCell = maze.sangsunSetThirdMaze();
				continue;
			} else if (maze.floorNumber == 3 && currentCell.cellNo == 0 && (userInput.equals("t") || userInput.equals("T"))) {
				System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Sangsun Dong - 2 ]");
				maze.floorNumber = 2;
				currentCell = maze.secondMazeLastCell;
				continue;
			}
			
			currentCell = move(currentCell, userInput);
		}
	}
	
	/*==========================================================================================================
	============================================ GENERAL FUNCTIONS =============================================
	==========================================================================================================*/

	private void availableDirections(Maze_Formation currCell) {
		System.out.print(mazeMenu + "\n\nAvailable directions: ");
		if (currCell.up != null)
			System.out.print("| Up ");
		if (currCell.down != null)
			System.out.print("| Down ");
		if (currCell.left != null)
			System.out.print("| Left ");
		if (currCell.right != null)
			System.out.print("| Right ");
		System.out.print("|\nCommand: ");
	}

	private void portalFound(Maze_Formation currentCell) {
		System.out.println("\n[Cell No: " + currentCell.cellNo + "]");
		
		switch (currentLocation){
		case "HD":
			switch (maze.floorNumber) {
			case 1:
				if (currentCell.cellNo == 16) {
					System.out.println("Portal found: Hasun Dong - 2 | If you want to teleport there, type 't/T'");
				} else if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Bakra | If you want to teleport there, type 'b/B'");
				}
				break;
			case 2:
				if (currentCell.cellNo == 37) {
					System.out.println("Portal found: Hasun Dong - 3 | If you want to teleport there, type 't/T'");
				} else if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Hasun Dong - 1 | If you want to teleport there, type 't/T'");
				}
				break;
			case 3:
				if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Hasun Dong - 2 | If you want to teleport there, type 't/T'");
				}
				break;
			}
			break;
		
		case "JD":
			switch (maze.floorNumber) {
			case 1:
				if (currentCell.cellNo == 25) {
					System.out.println("Portal found: Jungsun Dong - 2 | If you want to teleport there, type 't/T'");
				} else if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Yongbi Desert | If you want to teleport there, type 'b/B'");
				}
				break;
			case 2:
				if (currentCell.cellNo == 18) {
					System.out.println("Portal found: Jungsun Dong - 3 | If you want to teleport there, type 't/T'");
				} else if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Jungsun Dong - 1 | If you want to teleport there, type 't/T'");
				}
				break;
			case 3:
				if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Jungsun Dong - 2 | If you want to teleport there, type 't/T'");
				}
				break;
			}
			break;
		
		case "SD":
			switch (maze.floorNumber) {
			case 1:
				if (currentCell.cellNo == 21) {
					System.out.println("Portal found: Sangsun Dong - 2 | If you want to teleport there, type 't/T'");
				} else if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Yongbi Desert | If you want to teleport there, type 'b/B'");
				}
				break;
			case 2:
				if (currentCell.cellNo == 11) {
					System.out.println("Portal found: Sangsun Dong - 3 | If you want to teleport there, type 't/T'");
				} else if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Sangsun Dong - 1 | If you want to teleport there, type 't/T'");
				}
				break;
			case 3:
				if (currentCell.cellNo == 0) {
					System.out.println("Portal found: Sangsun Dong - 2 | If you want to teleport there, type 't/T'");
				}
				break;
			}
			break;
		}
	}

	private Maze_Formation move(Maze_Formation currentCell, String userInput) {
		if ((userInput.equals("up") || userInput.equals("UP")) && currentCell.up != null) {
			currentCell = currentCell.up;
		} else if ((userInput.equals("down") || userInput.equals("DOWN")) && currentCell.down != null) {
			currentCell = currentCell.down;
		} else if ((userInput.equals("left") || userInput.equals("LEFT")) && currentCell.left != null) {
			currentCell = currentCell.left;
		} else if ((userInput.equals("right") || userInput.equals("RIGHT")) && currentCell.right != null) {
			currentCell = currentCell.right;
		}
		return currentCell;
	}

	private boolean shouldMobSpawn(Maze_Formation currentCell) {
		boolean mobSpawn = true;
		
		switch (currentLocation){
		case "HD":
			switch (maze.floorNumber) {
			case 1:
				if (currentCell.cellNo != 0 && currentCell.cellNo != 16) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			case 2:
				if (currentCell.cellNo != 0 && currentCell.cellNo != 37) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			case 3:
				if (currentCell.cellNo != 0) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			}
			break;
		
		case "JD":
			switch (maze.floorNumber) {
			case 1:
				if (currentCell.cellNo != 0 && currentCell.cellNo != 25) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			case 2:
				if (currentCell.cellNo != 0 && currentCell.cellNo != 18) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			case 3:
				if (currentCell.cellNo != 0) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			}
			break;
		
		case "SD":
			switch (maze.floorNumber) {
			case 1:
				if (currentCell.cellNo != 0 && currentCell.cellNo != 21) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			case 2:
				if (currentCell.cellNo != 0 && currentCell.cellNo != 11) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			case 3:
				if (currentCell.cellNo != 0) {
					mobSpawn = true;
					break;
				}
				mobSpawn = false;
				break;
			}
			break;
		}
		return mobSpawn;
	}
}
