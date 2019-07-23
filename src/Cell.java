public class Cell {
    private int x;
    private int y;
    private boolean isComputer = false;
    private boolean isShip = false;
    private boolean isDeletedComputer = false;
    private boolean isDeletedShip = false;


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public boolean isShip() {
        return isShip;
    }

    public void setShip(boolean ship) {
        isShip = ship;
    }

    public boolean isDeletedComputer() {
        return isDeletedComputer;
    }

    public void setDeletedComputer(boolean deletedComputer) {
        isDeletedComputer = deletedComputer;
    }

    public boolean isDeletedShip() {
        return isDeletedShip;
    }

    public void setDeletedShip(boolean deletedShip) {
        isDeletedShip = deletedShip;
    }


}
