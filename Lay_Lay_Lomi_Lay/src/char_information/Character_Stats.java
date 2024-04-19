package char_information;

import java.util.List;
import connect.Database_Connection;
import ingame.General_Consts;
import main.General_Functions;
import main.User_Information;

public class Character_Stats extends Database_Connection implements General_Consts {

	public static int charLevel, charAtt, charHP, charHPmain, charMvtSpd, charKeyCopy, Exp, requiredExp;
	public static double charAttSpd;
	final double twoPowerOf = Math.pow(2.0, 1.0 / 7.0);
	static double copyReqExp, squaredExp, twoPowerOfExp;
	public static String charType, currentArea, currentLocation, desiredLocation;
	
	
	public void defaultStat() {

		charLevel = beginningLevel;
		Exp = beginningExp;
		setRequiredExp(charLevel);

		switch (charKeyCopy) {
		case 1:
			charAtt = warriorBeginningAtt;
			charHPmain = warriorBeginningHPmain;
			charHP = charHPmain;
			charType = warrior;
			break;
		case 2:
			charAtt = ninjaBeginningAtt;
			charHPmain = ninjaBeginningHPmain;
			charHP = charHPmain;
			charType = ninja;
			break;
		case 3:
			charAtt = suraBeginningAtt;
			charHPmain = suraBeginningHPmain;
			charHP = charHPmain;
			charType = sura;
			break;
		}
		
		charAttSpd = generalAttackSpd;
		charMvtSpd = beginningMvtSpd;
	}

	
	public void showStat() {
		System.out.println("\nAttack: " + charAtt + "\nHP: " + charHP + "/" + charHPmain + "\nLevel: " + charLevel
				+ "\nExp: " + Exp + "/" + requiredExp + "\nAttack Speed: Hits every "
				+ General_Functions.doubleFormat(charAttSpd) + " seconds" + "\nMovement speed: +%" + charMvtSpd);
	}

	public void setStat() {
		List<Integer> copyList = fetchStat(User_Information.username);
		charAtt = copyList.get(0);
		charHP = copyList.get(1);
		charLevel = copyList.get(2);
		Exp = copyList.get(3);
		charHPmain = copyList.get(4);
		charMvtSpd = copyList.get(5);
		setRequiredExp(charLevel);
		charType = fetchCharType(User_Information.username);
		charAttSpd = fetchAttackSpeed(User_Information.username);
	}

	public void insertStat() {
		insertStats(charAtt, charHP, charLevel, Exp, charHPmain, charAttSpd, charMvtSpd, User_Information.username);
	}

	private void setRequiredExp(int charLevel) {
		copyReqExp = (double) (charLevel + 1);
		squaredExp = Math.pow(copyReqExp, 2.0);
		twoPowerOfExp = Math.pow(2.0, copyReqExp / 7.0);
		copyReqExp = (1.0 / 8.0)
				* (squaredExp - copyReqExp + (1500.0 * (twoPowerOfExp - twoPowerOf) / (twoPowerOf - 1)));
		requiredExp = (int) copyReqExp;
	}

	public void levelCheck() {
		while (Exp >= requiredExp) {
			Exp -= requiredExp;
			charLevel++;
			charHPmain = charHPmain + 10;
			charHP = charHPmain;
			charAtt++;
			setRequiredExp(charLevel);
		}
	}
	
	public static int getCharLevel() {
		return charLevel;
	}

	public static int getCharAtt() {
		return charAtt;
	}

	public static int getCharHP() {
		return charHP;
	}

	public static int getCharHPmain() {
		return charHPmain;
	}

	public static int getCharMvtSpd() {
		return charMvtSpd;
	}

	public static int getCharKeyCopy() {
		return charKeyCopy;
	}

	public static int getExp() {
		return Exp;
	}

	public static double getCharAttSpd() {
		return charAttSpd;
	}

	public static String getCharType() {
		return charType;
	}

	public static String getCurrentArea() {
		return currentArea;
	}

	public static String getCurrentLocation() {
		return currentLocation;
	}

	public static String getDesiredLocation() {
		return desiredLocation;
	}
}
