package main;

import char_information.*;
import connect.Database_Connection;
import login_register.*;
import npc.Teleporter;
import zones.Area_Changing;
import zones.Area;

public class Main_Connector {
	static Login logObject = new Login();
	static Register regObject = new Register();
	static Character_Stats charObject = new Character_Stats();
	static Area areObject = new Area();
	static General_Functions gnrObject = new General_Functions();
	static Inventory invObject = new Inventory();
	static Teleporter tlpObject = new Teleporter();
	static Area_Changing acObject = new Area_Changing();
	static Database_Connection db = new Database_Connection();
}
