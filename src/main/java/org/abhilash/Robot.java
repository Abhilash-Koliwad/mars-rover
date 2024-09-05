package org.abhilash;

public class Robot {

    private int xPosition;
    private int yPosition;
    private Direction direction;
    private boolean lost;

    public Robot(int xPosition, int yPosition, Direction direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
        this.lost = false;
    }

    public void executeCommand(char command, int rows, int columns) {
        if (this.lost) return;
        switch (command) {
            case 'L':
                direction = direction.turnLeft();
                break;
            case 'R':
                direction = direction.turnRight();
                break;
            case 'F':
                moveForward(rows, columns);
                break;
        }
    }

    private void moveForward(int rows, int columns) {
        if (this.lost) return;
        int newXPosition = this.xPosition + this.direction.getXPositionDelta();
        int newYPosition = this.yPosition + this.direction.getYPositionDelta();
        if (newXPosition > rows || newXPosition < 0 || newYPosition > columns || newYPosition < 0) {
            this.lost = true;
        } else {
            this.xPosition = newXPosition;
            this.yPosition = newYPosition;
        }
    }

    @Override
    public String toString() {
        return "(" + this.xPosition + ", " + this.yPosition + ", " + this.direction + ") " + (lost ? "LOST" : "");
    }

}

