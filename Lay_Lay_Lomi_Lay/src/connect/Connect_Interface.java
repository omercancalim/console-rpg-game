package connect;

import java.sql.Connection;
import java.util.List;

public interface Connect_Interface {

	String successfulCon = "Connection Successful!", sqlException = "SQL Exception occured",
			failCon = "Connection Failed!", responseWaiting = "Connecting to the server...";

	Connection mainConnection();

	void insertRegister(String defUserID, String defPass, String defCharType);

	String fetchLoginUsername(String information);

	String fetchLoginPassword(String information);
	
	String fetchCharType(String information);

	List<Integer> fetchStat(String information);

	void insertInventory(List<String> defInventory, String defUserID);

	String fetchInventory(String information);

	String IP = "LAPTOP-MNLEKBIB", DB = "ThisIsDataBaseName", USNA = "sa", PASS = "omertest";

	double fetchAttackSpeed(String information);

	void insertStats(int defAtt, int defHp, int defLevel, int defExp, int defHpMain, double defAttSpd, int defMvtSpd,
			String defUserID);

	void insertEquippedOnes(String defEqpWeapon, String defEqpArmour, String defEqpHelmet, String defEqpShoe,
			String defUserID);

	List<String> fetchEquippedOnes(String defUserID);
}
