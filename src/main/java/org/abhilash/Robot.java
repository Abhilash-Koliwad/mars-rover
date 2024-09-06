package org.abhilash;

import lombok.Getter;

@Getter
public class Robot {

    private int xPosition;
    private int yPosition;
    private Direction direction;
    private boolean isLost;

    public Robot(int xPosition, int yPosition, Direction direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
        this.isLost = false;
    }

    public void executeCommand(char command, int maxXPosition, int maxYPosition) {
        if (this.isLost) return;
        switch (command) {
            case 'L':
                this.direction = this.direction.turnLeft();
                break;
            case 'R':
                this.direction = this.direction.turnRight();
                break;
            case 'F':
                moveForward(maxXPosition, maxYPosition);
                break;
        }
    }

    private void moveForward(int maxXPosition, int maxYPosition) {
        if (this.isLost) return;
        int newXPosition = this.xPosition + this.direction.getXPositionDelta();
        int newYPosition = this.yPosition + this.direction.getYPositionDelta();
        if (newXPosition > maxXPosition || newXPosition < 0 || newYPosition > maxYPosition || newYPosition < 0) {
            this.isLost = true;
        } else {
            this.xPosition = newXPosition;
            this.yPosition = newYPosition;
        }
    }

    @Override
    public String toString() {
        return "(" + this.xPosition + ", " + this.yPosition + ", " + this.direction + ") " + (this.isLost ? "LOST" : "");
    }

}

