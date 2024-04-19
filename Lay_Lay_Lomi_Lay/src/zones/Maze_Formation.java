package zones;

public class Maze_Formation {

	private int cellNumber;
	private Maze_Formation gTEMP, gTEMP2, gTEMP3;
	
	public Maze_Formation up, down, left, right;
	public Maze_Formation firstMazeLastCell, secondMazeLastCell, thirdMazeLastCell;
	public int cellNo;
	public int floorNumber;

	private Maze_Formation(int value) {
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
		this.cellNo = value;
	}

	public Maze_Formation() {};

	private void addCellUp(Maze_Formation currCell) {
		cellNumber++;
		Maze_Formation newCell = new Maze_Formation(cellNumber);
		currCell.up = newCell;
		newCell.down = currCell;
	}

	private void addCellDown(Maze_Formation currCell) {
		cellNumber++;
		Maze_Formation newCell = new Maze_Formation(cellNumber);
		currCell.down = newCell;
		newCell.up = currCell;
	}

	private void addCellLeft(Maze_Formation currCell) {
		cellNumber++;
		Maze_Formation newCell = new Maze_Formation(cellNumber);
		currCell.left = newCell;
		newCell.right = currCell;
	}

	private void addCellRight(Maze_Formation currCell) {
		cellNumber++;
		Maze_Formation newCell = new Maze_Formation(cellNumber);
		currCell.right = newCell;
		newCell.left = currCell;
	}

	private void addTwoCell(String g1, String g2, Maze_Formation currCell) {
		if (g1.equals("UP") && g2.equals("DOWN")) {
			cellNumber++;
			Maze_Formation newCell = new Maze_Formation(cellNumber);
			currCell.up = newCell;
			newCell.down = currCell;
			gTEMP2 = newCell;
			cellNumber++;
			newCell = new Maze_Formation(cellNumber);
			currCell.down = newCell;
			newCell.up = currCell;
			gTEMP3 = newCell;
		} else if (g1.equals("UP") && g2.equals("LEFT")) {
			cellNumber++;
			Maze_Formation newCell = new Maze_Formation(cellNumber);
			currCell.up = newCell;
			newCell.down = currCell;
			gTEMP2 = newCell;
			cellNumber++;
			newCell = new Maze_Formation(cellNumber);
			currCell.left = newCell;
			newCell.right = currCell;
			gTEMP3 = newCell;
		} else if (g1.equals("UP") && g2.equals("RIGHT")) {
			cellNumber++;
			Maze_Formation newCell = new Maze_Formation(cellNumber);
			currCell.up = newCell;
			newCell.down = currCell;
			gTEMP2 = newCell;
			cellNumber++;
			newCell = new Maze_Formation(cellNumber);
			currCell.right = newCell;
			newCell.left = currCell;
			gTEMP3 = newCell;
		} else if (g1.equals("DOWN") && g2.equals("LEFT")) {
			Maze_Formation newCell = new Maze_Formation(cellNumber);
			cellNumber++;
			currCell.down = newCell;
			newCell.up = currCell;
			gTEMP2 = newCell;
			cellNumber++;
			newCell = new Maze_Formation(cellNumber);
			currCell.left = newCell;
			newCell.right = currCell;
			gTEMP3 = newCell;
		} else if (g1.equals("DOWN") && g2.equals("RIGHT")) {
			cellNumber++;
			Maze_Formation newCell = new Maze_Formation(cellNumber);
			currCell.down = newCell;
			newCell.up = currCell;
			gTEMP2 = newCell;
			cellNumber++;
			newCell = new Maze_Formation(cellNumber);
			currCell.right = newCell;
			newCell.left = currCell;
			gTEMP3 = newCell;
		} else if (g1.equals("LEFT") && g2.equals("RIGHT")) {
			cellNumber++;
			Maze_Formation newCell = new Maze_Formation(cellNumber);
			currCell.left = newCell;
			newCell.right = currCell;
			gTEMP2 = newCell;
			cellNumber++;
			newCell = new Maze_Formation(cellNumber);
			currCell.right = newCell;
			newCell.left = currCell;
			gTEMP3 = newCell;
		}
	}
	
//	HASUN DONG		////////////////////////////////////////////////////////////////////////////////////
	public Maze_Formation hasunSetFirstMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Hasun Dong - 1 ]");
		floorNumber = 1;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		gTEMP = cellHead.down;
		addTwoCell("DOWN", "RIGHT", gTEMP);
		addCellDown(gTEMP2);
		addCellLeft(gTEMP2.down);
		addCellUp(gTEMP2.down.left);
		addTwoCell("UP", "LEFT", gTEMP2.down.left.up);
		gTEMP2.up = cellHead.left;
		cellHead.left.down = gTEMP2;
		addTwoCell("UP", "DOWN", gTEMP3);
		addCellLeft(gTEMP2);
		addCellLeft(gTEMP3);
		addCellDown(gTEMP2.left);
		gTEMP2.left.down.down = gTEMP3.left;
		gTEMP3.left.up = gTEMP2.left.down;
		gTEMP.right.up = cellHead.right;
		cellHead.right.down = gTEMP.right;
		gTEMP = cellHead.right;
		addTwoCell("UP", "RIGHT", gTEMP);
		addCellUp(gTEMP2);
		addCellUp(cellHead.up);
		gTEMP2.up.left = cellHead.up.up;
		cellHead.up.up.right = gTEMP2.up;
		addCellDown(gTEMP3);
		addTwoCell("DOWN", "RIGHT", gTEMP3.down);
		addCellLeft(cellHead.left);
		addCellUp(cellHead.left.left);
		addCellRight(cellHead.left.left.up);
		cellHead.left.left.up.right.right = cellHead.up;
		cellHead.up.left = cellHead.left.left.up.right;
		return cellHead;
	}

	public Maze_Formation hasunSetSecondMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Hasun Dong - 2 ]");
		floorNumber = 2;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addCellUp(cellHead.up);
		addCellLeft(cellHead.up.up);
		addCellUp(cellHead.up.up.left);
		addTwoCell("LEFT", "RIGHT", cellHead.up.up.left.up);
		addCellUp(cellHead.right);
		addCellUp(cellHead.right.up);
		addCellUp(cellHead.right.up.up);
		gTEMP3.right = cellHead.right.up.up.up;
		cellHead.right.up.up.up.left = gTEMP3;
		addTwoCell("UP", "RIGHT", cellHead.right.up.up.up);
		addCellDown(gTEMP3);
		addTwoCell("DOWN", "RIGHT", gTEMP3.down);
		addCellDown(gTEMP2);
		gTEMP2.down.left = cellHead.right;
		cellHead.right.right = gTEMP2.down;
		addTwoCell("DOWN", "RIGHT", gTEMP3);
		addTwoCell("UP", "RIGHT", gTEMP3);
		addTwoCell("LEFT", "RIGHT", cellHead.down);
		addCellDown(gTEMP2);
		addTwoCell("LEFT", "RIGHT", gTEMP2.down);
		addCellDown(gTEMP3);
		addCellUp(gTEMP2);
		addTwoCell("UP", "LEFT", gTEMP2.up);
		gTEMP2.right = cellHead.left;
		cellHead.left.left = gTEMP2;
		addCellDown(gTEMP3);
		addTwoCell("UP", "LEFT", gTEMP3);
		gTEMP = gTEMP3;
		addTwoCell("UP", "LEFT", gTEMP2);
		gTEMP3.down = gTEMP;
		gTEMP.up = gTEMP3;
		addCellLeft(gTEMP3);
		return cellHead;
	}

	public Maze_Formation hasunSetThirdMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Hasun Dong - 3 ]");
		floorNumber = 3;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addCellUp(cellHead.up);
		addTwoCell("LEFT", "RIGHT", cellHead.up.up);
		addCellUp(cellHead.up.up);
		addCellRight(cellHead.up.up.up);
		addTwoCell("UP", "RIGHT", cellHead.up.up.up.right);
		addCellRight(gTEMP2);
		gTEMP3.up = gTEMP2.right;
		gTEMP2.right.down = gTEMP3;
		addCellUp(cellHead.right);
		addCellRight(cellHead.right.up);
		addTwoCell("DOWN", "RIGHT", cellHead.right.up.right);
		addCellDown(gTEMP3);
		addTwoCell("DOWN", "RIGHT", gTEMP3.down);
		addCellLeft(gTEMP2);
		addCellRight(gTEMP2);
		gTEMP3.down = gTEMP2.right;
		gTEMP2.right.up = gTEMP3;
		addCellRight(gTEMP3);
		addCellUp(gTEMP3.right);
		addCellLeft(gTEMP3.right.up);
		addCellDown(cellHead.down);
		addCellLeft(cellHead.down.down);
		addTwoCell("DOWN", "LEFT", cellHead.down.down.left);
		addCellDown(gTEMP3);
		gTEMP3.down.right = gTEMP2;
		gTEMP2.left = gTEMP3.down;
		addTwoCell("UP", "LEFT", cellHead.left);
		addCellLeft(gTEMP3);
		addCellDown(gTEMP3.left);
		addCellLeft(gTEMP3.left.down);
		gTEMP = gTEMP2;
		addTwoCell("UP", "LEFT", gTEMP3.left.down.left);
		addCellUp(gTEMP2);
		addCellLeft(gTEMP);
		addCellLeft(gTEMP.left);
		addCellUp(gTEMP.left.left);
		gTEMP.left.left.left = gTEMP2.up;
		gTEMP2.up.right = gTEMP.left.left;
		addCellUp(gTEMP2.up);
		return cellHead;
	}
	
//	JUNGSUN DONG	////////////////////////////////////////////
	public Maze_Formation jungsunSetFirstMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Jungsun Dong - 1 ]");
		floorNumber = 1;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellLeft(cellHead);
		addCellDown(cellHead);
		addCellUp(cellHead.left);
		addCellRight(cellHead.left.up);
		addCellRight(cellHead.left.up.right);
		addCellDown(cellHead.left.up.right.right);
		addCellRight(cellHead.down);
		cellHead.down.right.up = cellHead.left.up.right.right.down;
		cellHead.left.up.right.right.down.down = cellHead.down.right;
		addCellLeft(cellHead.left);
		addCellDown(cellHead.left.left);
		addCellDown(cellHead.left.left.down);
		addTwoCell("DOWN", "LEFT", cellHead.left.left.down.down);
		addCellRight(gTEMP2);
		addTwoCell("DOWN", "RIGHT", gTEMP2.right);
		addCellUp(gTEMP3);
		gTEMP3.up.up = cellHead.down;
		cellHead.down.down = gTEMP3.up;
		addCellRight(cellHead.down.down);
		addCellRight(cellHead.down.down.right);
		addTwoCell("UP", "RIGHT", cellHead.down.down.right.right);
		addCellUp(gTEMP2);
		addTwoCell("UP", "RIGHT", gTEMP2.up);
		addCellRight(gTEMP3);
		addCellUp(gTEMP3.right);
		return cellHead;
	}
	
	public Maze_Formation jungsunSetSecondMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Jungsun Dong - 2 ]");
		floorNumber = 2;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addCellLeft(cellHead.left);
		addCellUp(cellHead.left.left);
		addTwoCell("UP", "RIGHT", cellHead.left.left.up);
		gTEMP3.right = cellHead.up;
		cellHead.up.left = gTEMP3;
		addCellDown(cellHead.down);
		addCellRight(cellHead.down.down);
		addTwoCell("UP", "RIGHT", cellHead.right);
		addTwoCell("DOWN", "RIGHT", gTEMP3);
		addCellLeft(gTEMP2);
		addCellUp(gTEMP3);
		addTwoCell("UP", "LEFT", gTEMP3.up);
		addCellUp(gTEMP2);
		addCellLeft(gTEMP2.up);
		addCellLeft(gTEMP2.up.left);
		addCellDown(gTEMP2.up.left.left);
		addCellUp(cellHead.up);
		cellHead.up.up.right = gTEMP2.up.left.left.down;
		gTEMP2.up.left.left.down.left = cellHead.up.up;
		return cellHead;
	}
	
	public Maze_Formation jungsunSetThirdMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Jungsun Dong - 3 ]");
		floorNumber = 3;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addCellRight(cellHead.right);
		addTwoCell("UP", "RIGHT", cellHead.right.right);
		addTwoCell("UP", "LEFT", gTEMP2);
		addCellLeft(gTEMP2);
		addCellRight(cellHead.down);
		addTwoCell("DOWN", "RIGHT", cellHead.down.right);
		addCellLeft(gTEMP2);
		addCellUp(cellHead.up);
		addTwoCell("UP", "LEFT", cellHead.up.up);
		addCellLeft(gTEMP3);
		addCellDown(gTEMP3.left);
		addTwoCell("DOWN", "LEFT", gTEMP3.left.down);
		addCellDown(cellHead.left);
		cellHead.left.left = gTEMP2;
		gTEMP2.right = cellHead.left;
		addCellDown(gTEMP2);
		addCellLeft(gTEMP2.down);
		addCellLeft(gTEMP2.down.left);
		addCellUp(gTEMP2.down.left.left);
		return cellHead;
	}
	
//	SANGSUN DONG		////////////////////////////////////////////////////////////////////////////////////
	public Maze_Formation sangsunSetFirstMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Sangsun Dong - 1 ]");
		floorNumber = 1;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addTwoCell("LEFT", "RIGHT", cellHead.up);
		addCellUp(cellHead.up);
		addCellUp(cellHead.up.up);
		addCellLeft(cellHead.left);
		addTwoCell("UP", "DOWN", cellHead.left.left);
		addCellLeft(gTEMP3);
		addCellUp(gTEMP3.left);
		gTEMP = gTEMP3;
		addTwoCell("LEFT", "RIGHT", cellHead.down);
		gTEMP.right = gTEMP2;
		gTEMP2.left = gTEMP;
		addCellDown(cellHead.down);
		addCellRight(cellHead.down.down);
		addCellRight(cellHead.down.down.right);
		addCellUp(cellHead.down.down.right.right);
		addTwoCell("UP", "RIGHT", cellHead.down.down.right.right.up);
		gTEMP2.left = cellHead.right;
		cellHead.right.right = gTEMP2;
		addTwoCell("UP", "RIGHT", gTEMP2);
		addCellRight(gTEMP2);
		gTEMP2.right.down = gTEMP3;
		gTEMP3.up = gTEMP2.right;
		return cellHead;
	}

	public Maze_Formation sangsunSetSecondMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Sangsun Dong - 2 ]");
		floorNumber = 2;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addTwoCell("UP", "DOWN", cellHead.left);
		gTEMP2.right = cellHead.up;
		cellHead.up.left = gTEMP2;
		gTEMP3.right = cellHead.down;
		cellHead.down.left = gTEMP3;
		addTwoCell("UP", "DOWN", cellHead.right);
		gTEMP2.left = cellHead.up;
		cellHead.up.right = gTEMP2;
		gTEMP3.left = cellHead.down;
		cellHead.down.right = gTEMP3;
		addCellUp(gTEMP2);
		addTwoCell("LEFT", "RIGHT", gTEMP2.up);
		return cellHead;
	}

	public Maze_Formation sangsunSetThirdMaze() {
		System.out.println("\n\n\t\t" + "\s".repeat(4) + "[ Sangsun Dong - 3 ]");
		floorNumber = 3;
		gTEMP = null;
		gTEMP2 = null;
		gTEMP3 = null;
		cellNumber = 0;
		Maze_Formation cellHead = new Maze_Formation(cellNumber);
		addCellDown(cellHead);
		addCellLeft(cellHead);
		addCellRight(cellHead);
		addCellUp(cellHead);
		addTwoCell("UP", "DOWN", cellHead.left);
		gTEMP2.right = cellHead.up;
		cellHead.up.left = gTEMP2;
		gTEMP3.right = cellHead.down;
		cellHead.down.left = gTEMP3;
		addTwoCell("UP", "DOWN", cellHead.right);
		gTEMP2.left = cellHead.up;
		cellHead.up.right = gTEMP2;
		gTEMP3.left = cellHead.down;
		cellHead.down.right = gTEMP3;
		addCellDown(cellHead.down);
		addTwoCell("LEFT", "RIGHT", cellHead.down.down);
		addCellLeft(gTEMP2);
		addCellRight(gTEMP3);
		addCellUp(gTEMP2.left);
		addCellUp(gTEMP3.right);
		addCellUp(gTEMP2.left.up);
		addCellUp(gTEMP3.right.up);
		gTEMP2.left.up.up.right = cellHead.left;
		cellHead.left.left = gTEMP2.left.up.up;
		gTEMP3.right.up.up.left = cellHead.right;
		cellHead.right.right = gTEMP3.right.up.up;
		addCellUp(cellHead.up);
		addTwoCell("LEFT", "RIGHT", cellHead.up.up);
		addCellRight(gTEMP3);
		addCellDown(gTEMP3.right);
		gTEMP3.right.down.down = cellHead.right.right;
		cellHead.right.right.up = gTEMP3.right.down;
		addCellLeft(gTEMP2);
		addTwoCell("UP", "DOWN", gTEMP2.left);
		gTEMP3.down = cellHead.left.left;
		cellHead.left.left.up = gTEMP3;
		return cellHead;
	}
}