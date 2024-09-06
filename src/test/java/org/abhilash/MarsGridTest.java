package org.abhilash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarsGridTest {

    private MarsGrid marsGrid;

    @BeforeEach
    void setup() {
        marsGrid = new MarsGrid(4, 8);
    }

    @Test
    void processCommands_robotIsNotLost() {
        // Given
        Robot robot = new Robot(2, 3, Direction.N);
        String commands = "FLLFR";
        RobotCommand robotCommand = new RobotCommand(robot, commands);
        marsGrid.addRobotCommand(robotCommand);

        // When
        marsGrid.processCommands();

        // Then
        Assertions.assertEquals(2, robot.getXPosition());
        Assertions.assertEquals(3, robot.getYPosition());
        Assertions.assertEquals(Direction.W, robot.getDirection());
        Assertions.assertFalse(robot.isLost());
    }

    @Test
    void processCommands_robotIsLost() {
        // Given
        Robot robot = new Robot(2, 3, Direction.E);
        String commands = "LFRFF";
        RobotCommand robotCommand = new RobotCommand(robot, commands);
        marsGrid.addRobotCommand(robotCommand);

        // When
        marsGrid.processCommands();

        // Then
        Assertions.assertEquals(3, robot.getXPosition());
        Assertions.assertEquals(4, robot.getYPosition());
        Assertions.assertEquals(Direction.E, robot.getDirection());
        Assertions.assertTrue(robot.isLost());
    }

    @Test
    void processCommands_multipleRobots() {
        // Given
        Robot robot1 = new Robot(0, 2, Direction.N);
        String commands1 = "FFLFRFF";
        RobotCommand robotCommand1 = new RobotCommand(robot1, commands1);
        marsGrid.addRobotCommand(robotCommand1);

        Robot robot2 = new Robot(1, 0, Direction.S);
        String commands2 = "FFRLF";
        RobotCommand robotCommand2 = new RobotCommand(robot2, commands2);
        marsGrid.addRobotCommand(robotCommand2);

        // When
        marsGrid.processCommands();

        // Then
        Assertions.assertEquals(0, robot1.getXPosition());
        Assertions.assertEquals(4, robot1.getYPosition());
        Assertions.assertEquals(Direction.W, robot1.getDirection());
        Assertions.assertTrue(robot1.isLost());

        Assertions.assertEquals(1, robot2.getXPosition());
        Assertions.assertEquals(0, robot2.getYPosition());
        Assertions.assertEquals(Direction.S, robot2.getDirection());
        Assertions.assertTrue(robot2.isLost());
    }


}
