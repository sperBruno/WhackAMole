import java.util.Scanner;

public class WhackAMole {

    /**
     * @param args
     */

    int score;
    int molesLeft;
    int attemptsLeft;
    char[][] moleGrid;

    WhackAMole(int numAttempts, int gridDimension) {
	this.attemptsLeft = numAttempts;
	this.moleGrid = new char[gridDimension][gridDimension];
    }

    boolean place(int x, int y) {
	if (moleGrid[x][y] == 'M') {
	    return true;
	} else {
	    moleGrid[x][y] = 'M';
	    return false;
	}
    }

    void whack(int x, int y) {

	if (moleGrid[x][y] == 'M') {
	    moleGrid[x][y] = 'W';
	    score++;
	    attemptsLeft--;
	    molesLeft--;
	} else {
	    moleGrid[x][y] = '*';
	    attemptsLeft--;
	}
    }

    void printGridToUser() {
	int i;
	int j;
	for (i = 0; i < moleGrid.length; i++) {
	    for (j = 0; j < moleGrid.length; j++) {
		System.out.print(moleGrid[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    void printGrid() {
	int i;
	int j;
	for (i = 0; i < moleGrid.length; i++) {
	    for (j = 0; j < moleGrid.length; j++) {
		 moleGrid[i][j] = '*';
	    }
	}
	for (i = 0; i < moleGrid.length; i++) {
	    for (j = 0; j < moleGrid.length; j++) {
		System.out.print(moleGrid[i][j] + " ");
	    }
	    System.out.println();
	}

    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	WhackAMole x = new WhackAMole(50, 10);
	x.printGrid();
	int i;
	int j;
	for (i = 0; i < 10; i++) {
	    for (j = 0; j < 10; j++) {
		x.place((int) (Math.random() * 10), (int) (Math.random() * 10));
	    }
	}
	while (x.attemptsLeft > 0) {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Insert X: ");
	    int x_position = scan.nextInt();
	    System.out.println("Insert Y: ");
	    int y_position = scan.nextInt();
	    if (x_position == -1 || y_position == -1) {
		break;
	    } else {
		x.whack(x_position, y_position);
	    }
	}

	x.printGridToUser();

    }

}
