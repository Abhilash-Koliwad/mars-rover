package org.abhilash;

public class MarsRoverApplication {

    public static void main(String[] args) {

        // Initialise the MarsGrid
        MarsGrid marsGrid = new MarsGrid(3, 7);

        // Create Robot1 with its position, direction and commands
        Robot robot1 = new Robot(2, 3, Direction.E);
        String commands1 = "LFRFF";
        RobotCommand robotCommand1 = new RobotCommand(robot1, commands1);

        // Create Robot2 with its position, direction and commands
        Robot robot2 = new Robot(0, 2, Direction.N);
        String commands2 = "FFLFRFF";
        RobotCommand robotCommand2 = new RobotCommand(robot2, commands2);

        // Add RobotCommand objects to the MarsGrid
        marsGrid.addRobotCommand(robotCommand1);
        marsGrid.addRobotCommand(robotCommand2);

        // Process commands for all robots
        marsGrid.processCommands();

        // Print the final result
        marsGrid.printRobots();
    }


}