import java.security.KeyStore;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class GameArea {
    List<Cell> yourCells = new ArrayList<>();
    List<Cell> computerCells = new ArrayList<>();

    public GameArea() {
        System.out.println("Battle ship started!");
        System.out.println();
        startGame();
    }

    Scanner input = new Scanner(System.in);

    void startGame() {
        Cell[][] cells = new Cell[9][9];
        this.drawGameArea(cells, true);
        firstYourTurn(cells);
        firstComputerTurn(cells);
        this.drawGameArea(cells, false);
        while (true) {
            yourTurn(cells);
            computerTurn(cells);
            this.drawGameArea(cells, false);
        }
    }

    void drawGameArea(Cell[][] cells, boolean isInit) {

        System.out.println("  123456789  ");
        for (int y = 0; y < 9; y++) {
            System.out.print((y + 1) + "|");
            for (int x = 0; x < 9; x++) {

                if (isInit) {
                    cells[x][y] = new Cell(x, y);
                }
                drawCell(cells[x][y]);
            }
            System.out.println("|" + (y + 1));
        }
        System.out.println("  123456789  ");
    }

    void drawCell(Cell cell) {
        if (cell.isComputer()) {
            System.out.print("C");
        } else if (cell.isShip()) {
            System.out.print("S");
        } else if (cell.isDeletedComputer()) {
            System.out.print("x");
        } else if (cell.isDeletedShip()) {
            System.out.print("!");
        } else {
            System.out.print(" ");
        }
    }

    void yourTurn(Cell[][] cells) {
        System.out.print("Enter x of your next: ");
        int x = input.nextInt();

        System.out.print("Enter y of your next ship: ");
        int y = input.nextInt();

        Cell selectedCell = cells[x - 1][y - 1];

        if (selectedCell.isComputer()) {
            selectedCell.setComputer(false);
            computerCells.remove(selectedCell);
        }
        selectedCell.setDeletedComputer(true);

        if (computerCells.size() == 0) {
            System.out.println();
            System.out.println("Congrats! Win!");
            System.exit(0);
        }
    }

    void computerTurn(Cell[][] cells) {
        Random random = new Random();
        int x = random.nextInt(9);
        int y = random.nextInt(9);

        if (cells[x][y].isShip()) {
            cells[x][y].setShip(false);
            yourCells.remove(cells[x][y]);
        }
        cells[x][y].setDeletedShip(true);

        if (yourCells.size() == 0) {
            System.out.println();
            System.out.println("Lose..");
            System.exit(0);
        }
    }

    void firstYourTurn(Cell[][] cells) {
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter x of your " + (i + 1) + " ship: ");
            int x = input.nextInt();

            System.out.print("Enter y of your" + (i + 1) + " ship: ");
            int y = input.nextInt();
            System.out.println();
            cells[x - 1][y - 1].setShip(true);
            yourCells.add(cells[x - 1][y - 1]);
        }
    }

    void firstComputerTurn(Cell[][] cells) {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int x = random.nextInt(9);
            int y = random.nextInt(9);

            if (!cells[x][y].isShip() || !cells[x][y].isComputer()) {
                cells[x][y].setComputer(true);
                computerCells.add(cells[x][y]);
            }
        }
    }
}
