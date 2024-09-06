package org.abhilash;

import java.util.ArrayList;
import java.util.List;

public class MarsGrid {

    private final int rows;
    private final int columns;
    private final List<RobotCommand> robotCommands;

    public MarsGrid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.robotCommands = new ArrayList<>();
    }

    public void addRobotCommand(RobotCommand robotCommand) {
        this.robotCommands.add(robotCommand);
    }

    public void processCommands() {
        for (RobotCommand robotCommand : this.robotCommands) {
            Robot robot = robotCommand.getRobot();
            char[] commands = robotCommand.getCommands();
            for (char command : commands) {
                robot.executeCommand(command, this.rows - 1, this.columns - 1);
                if (robot.isLost()) {
                    break;
                }
            }
        }
    }

    public void printRobots() {
        for (RobotCommand robotCommand : this.robotCommands) {
            System.out.println(robotCommand.getRobot());
        }
    }

}

