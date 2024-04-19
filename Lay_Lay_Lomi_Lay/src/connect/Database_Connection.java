package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database_Connection implements Connect_Interface {

	Connection connectionLay = null;
	Statement myStatement;
	String myURL, query;
	static String generalString;
	static double generalDouble;
	static boolean generalBoolean;
	static List<Integer> statList = new ArrayList<>(5);
	static List<String> equippedList = new ArrayList<>(4);

	@Override
	public Connection mainConnection() {
		while (true) {
			try {
				// System.out.println(responseWaiting);
				myURL = "jdbc:sqlserver://" + IP + ";databaseName=" + DB + ";user=" + USNA + ";password=" + PASS
						+ ";encrypt=true;trustServerCertificate=true";
				connectionLay = DriverManager.getConnection(myURL);
				// System.out.println(successfulCon);
				break;
			} catch (SQLException e) {
				System.out.println(failCon);
			}
		}
		return connectionLay;
	}

	@Override
	public void insertRegister(String defUserID, String defPass, String defCharType) {
		query = "INSERT INTO Userinf (Username, Password, ChrType) VALUES ('" + defUserID + "','" + defPass + "','"
				+ defCharType + "')";
		try {
			myStatement = mainConnection().createStatement();
			myStatement.executeUpdate(query);
			System.out.println("Account has been succesfully created!");
		} catch (Exception e) {
			System.out.println("An error occurred while creating account!");
		}
		query = "INSERT INTO Equipped (ID) SELECT ID FROM Userinf WHERE Username='" + defUserID
				+ "'; UPDATE Equipped SET Weapon='', Armour='', Helmet='', Shoe=''"
				+ " WHERE Equipped.ID IN (SELECT ID FROM Userinf where Username='" + defUserID + "')";
		try {
			myStatement = mainConnection().createStatement();
			myStatement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("An error occurred while creating account!");
		}
	}
	
	public boolean checkIfIDCreated (String defUserID) {
		query = "IF EXISTS(SELECT Username FROM Userinf WHERE Username = '" + defUserID + "') "
				+ "BEGIN SELECT Condition from Condition where Condition='true' END "
				+ " ELSE BEGIN SELECT Condition from Condition where Condition='false' END;";
		try {
			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while(ras.next()) {
				generalBoolean = ras.getBoolean(1);
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return generalBoolean;
	}

	@Override
	public void insertStats(int defAtt, int defHp, int defLevel, int defExp, int defHpMain, double defAttSpd,
			int defMvtSpd, String defUserID) {
		query = "UPDATE Userinf SET ATT=" + defAtt + ", HP=" + defHp + ", Lvl=" + defLevel + ", Exp=" + defExp
				+ ", HpMain=" + defHpMain + ", ATTSPD=" + defAttSpd + ", ExtraMVTSPD=" + defMvtSpd + " where Username='"
				+ defUserID + "'";
		try {
			myStatement = mainConnection().createStatement();
			myStatement.executeUpdate(query);
			System.out.println("\nSaved!");
		} catch (Exception e) {
			System.out.println("An error occurred while saving the changes (Stats)");
		}
	}

	@Override
	public String fetchLoginUsername(String information) {
		query = "SELECT Username FROM Userinf where Username='" + information + "'";
		try {

			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				generalString = ras.getString(1);
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return generalString;
	}

	@Override
	public String fetchLoginPassword(String information) {
		query = "SELECT Password FROM Userinf where Username='" + information + "'";
		try {

			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				generalString = ras.getString(1);
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return generalString;
	}
	
	@Override
	public String fetchCharType(String information) {
		query = "SELECT ChrType FROM Userinf WHERE Username='" + information + "'";
		try {

			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				generalString = ras.getString(1);
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return generalString;
	}
	
	@Override
	public double fetchAttackSpeed(String information) {
		query = "SELECT ATTSPD FROM Userinf where Username='" + information + "'";
		try {
			
			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				generalDouble = ras.getDouble(1);
			}
			
		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return generalDouble;
	}

	@Override
	public List<Integer> fetchStat(String information) {
		query = "SELECT ATT, HP, Lvl, Exp, HpMain, ExtraMVTSPD FROM Userinf where Username='" + information + "'";
		try {

			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				statList.add(0, ras.getInt(1));
				statList.add(1, ras.getInt(2));
				statList.add(2, ras.getInt(3));
				statList.add(3, ras.getInt(4));
				statList.add(4, ras.getInt(5));
				statList.add(5, ras.getInt(6));
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return statList;
	}
	
	@Override
	public void insertInventory(List<String> defInventory, String defUserID) {
		query = "UPDATE Userinf SET Inventory='" + defInventory.get(0) + "!" + defInventory.get(1)
				+ "' where Username='" + defUserID + "'";
		try {
			myStatement = mainConnection().createStatement();
			myStatement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("An error occurred while saving the changes (Inventory)");
		}
	}

	@Override
	public String fetchInventory(String defUserID) {
		query = "SELECT Inventory FROM Userinf where Username='" + defUserID + "'";
		try {
			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				generalString = ras.getString(1);
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return generalString;
	}
	
	@Override
	public void insertEquippedOnes(String defEqpWeapon, String defEqpArmour, String defEqpHelmet, String defEqpShoe,
			String defUserID) {
		query = "UPDATE Equipped SET Weapon='" + defEqpWeapon + "', Armour='" + defEqpArmour + "', Helmet='"
				+ defEqpHelmet + "', Shoe='" + defEqpShoe
				+ "' WHERE Equipped.ID IN (SELECT ID FROM Userinf WHERE Username='" + defUserID + "')";
		try {
			myStatement = mainConnection().createStatement();
			myStatement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("An error occurred while saving the changes (Inventory)");
		}
	}
	
	@Override
	public List<String> fetchEquippedOnes(String defUserID) {
		query = "SELECT Weapon, Armour, Helmet, Shoe FROM Equipped WHERE Equipped.ID IN (SELECT ID FROM Userinf WHERE Username='" + defUserID + "')";
		try {
			myStatement = mainConnection().createStatement();
			ResultSet ras = myStatement.executeQuery(query);
			while (ras.next()) {
				equippedList.add(0, ras.getString(1));
				equippedList.add(1, ras.getString(2));
				equippedList.add(2, ras.getString(3));
				equippedList.add(3, ras.getString(4));
			}

		} catch (SQLException e) {
			System.out.print(sqlException);
		}
		return equippedList;
	}
}
