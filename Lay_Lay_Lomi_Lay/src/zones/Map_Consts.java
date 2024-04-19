package zones;

import java.util.ArrayList;
import java.util.List;

public enum Map_Consts {
	
//	PYUNGMOO
	PYUNGMOO,
	EOC,		// Entrance of city
	BCT,		// Biologist Chaegirab's Tent
	OF,			// Open Field
	NF,			// Nameless Flowers
	WM,			// Weol Monument
//	BAKRA
	BAKRA,
	NEG,		// North-East Gate
	BD,			// Bandit Den
	NV,			// Nakajima's Viewpoint
	HD,			// Hasun Dong
//	VALLEY OF SEUNGRYONG
	VOS,
	TP,			// Trembling Prairie
	DT,			// Devil's Triangle
	HM,			// Hanged Man
	IOG,		// In front of Grotto
//	YONGBI DESERT
	YD,
	EOD,		// Edge of the desert
	O,			// Oasis
	JD,			// Jungsun Dong
	SD,			// Sangsun Dong
//	KD,
//	COMMON REGIONS (CITY, SAFE ZONE)
	CITY, 
	SZ;
	
	public enum MAP_AREA_LOCATION {
		PYUNGMOO(EOC, BCT, OF, NF, WM, CITY),
		BAKRA(NEG, BD, NV, HD, CITY),
		VOS(TP, DT, HM, IOG, SZ),
		YD(EOD, O, JD, SD, SZ);

		Map_Consts location1, location2, location3, location4, location5, location6;
		List<Map_Consts> list = new ArrayList<>();
		
		MAP_AREA_LOCATION(Map_Consts location1, Map_Consts location2, Map_Consts location3) {
			this.location1 = location1;
			this.location2 = location2;
			this.location3 = location3;
		}
		
		MAP_AREA_LOCATION(Map_Consts location1, Map_Consts location2, Map_Consts location3, Map_Consts location4, Map_Consts location5) {
			this.location1 = location1;
			this.location2 = location2;
			this.location3 = location3;
			this.location4 = location4;
			this.location5 = location5;
		}

		MAP_AREA_LOCATION(Map_Consts location1, Map_Consts location2, Map_Consts location3, Map_Consts location4, Map_Consts location5, Map_Consts location6) {
			this.location1 = location1;
			this.location2 = location2;
			this.location3 = location3;
			this.location4 = location4;
			this.location5 = location5;
			this.location6 = location6;
		}

		public Map_Consts getlocation1() {
			return location1;
		}

		public Map_Consts getlocation2() {
			return location2;
		}

		public Map_Consts getlocation3() {
			return location3;
		}

		public Map_Consts getlocation4() {
			return location4;
		}

		public Map_Consts getlocation5() {
			return location5;
		}

		public Map_Consts getlocation6() {
			return location6;
		}
		
		public List<Map_Consts> getlocations(){
			list.clear();
			list.add(location1);
			list.add(location2);
			list.add(location3);
			list.add(location4);
			list.add(location5);
			list.add(location6);
			return list;
		}
	}
	
	public enum MAP_DISTANCE {
//		PYUNGMO
		CITYANDBCT(6),BCTANDCITY(6),
		CITYANDEOC(2),EOCANDCITY(2),
		CITYANDNF(25),NFANDCITY(25),
		CITYANDOF(15),OFANDCITY(15),
		CITYANDWM(25),WMANDCITY(25),
		EOCANDBCT(4),BCTANDEOC(4),
		EOCANDNF(23),NFANDEOC(23),
		EOCANDOF(17),OFANDEOC(17),
		EOCANDWM(27),WMANDEOC(27),
		BCTANDNF(19),NFANDBCT(19),
		BCTANDOF(21),OFANDBCT(21),
		BCTANDWM(29),WMANDBCT(29),
		OFANDNF(40),NFANDOF(40),
		OFANDWM(17),WMANDOF(17),
		NFANDWM(50),WMANDNF(50),
//		BAKRA
		CITYANDBD(7),BDANDCITY(7),
		CITYANDHD(8),HDANDCITY(8),
		CITYANDNEG(10),NEGANDCITY(10),
		CITYANDNV(15),NVANDCITY(15),
		NEGANDBD(3),BDANDNEG(3),
		NEGANDHD(2),HDANDNEG(2),
		NEGANDNV(25),NVANDNEG(25),
		BDANDHD(15),HDANDBD(15),
		BDANDNV(8),NVANDBD(8),
		NVANDHD(23),HDANDNV(23),
//		VALLEY OF SEUNGRYONG
		SZANDTP(5),TPANDSZ(5),
		SZANDDT(4),DTANDSZ(4),
		SZANDHM(3),HMANDSZ(3),
		SZANDIOG(3),IOGANDSZ(3),
		TPANDDT(5),DTANDTP(5),
		TPANDHM(4),HMANDTP(4),
		TPANDIOG(3),IOGANDTP(3),
		DTANDHM(4),HMANDDT(4),
		DTANDIOG(3),IOGANDDT(3),
		HMANDIOG(4),IOGANDHM(4),
//		YONGBI DESERT
		SZANDO(3),OANDSZ(3),
		SZANDEOD(2),EODANDSZ(2),
		SZANDJD(3),JDANDSZ(3),
		SZANDSD(4),SDANDSZ(4),
		SZANNKD(5),KDANDSZ(5),
		OANDEOD(3),EODANDO(3),
		OANDJD(2),JDANDO(2),
		OANDSD(3),SDANDO(3),
		OANDKD(4),KDANDO(4),
		EODANDJD(5),JDANDEOD(5),
		EODANDSD(3),SDANDEOD(3),
		EODANDKD(2),KDANDEOD(2),
		JDANDSD(3),SDANDJD(3),
		JDANDKD(4),KDANDJD(4),
		SDANDKD(5),KDANDSD(5);
		
		private int distance;
		MAP_DISTANCE(int distance) {
			this.distance = distance;
		}
		
		public int getDistance() {
			return distance;
		}
	}
}