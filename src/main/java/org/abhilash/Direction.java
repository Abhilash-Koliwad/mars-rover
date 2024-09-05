package org.abhilash;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Direction {

    N(1, 0, 1),
    E(2, 1, 0),
    S(3, 0, -1),
    W(4, -1, 0);

    private final int value;
    private final int xPositionDelta;
    private final int yPositionDelta;

    Direction(int value, int xPositionDelta, int yPositionDelta) {
        this.value = value;
        this.xPositionDelta = xPositionDelta;
        this.yPositionDelta = yPositionDelta;
    }

    public static Direction fromValue(int value) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid direction value: " + value));
    }

    public Direction turnLeft() {
        int newValue = (this.value == 1) ? 4 : this.value - 1;
        return fromValue(newValue);
    }

    public Direction turnRight() {
        int newValue = (this.value == 4) ? 1 : this.value + 1;
        return fromValue(newValue);
    }

}
