package org.abhilash;

import lombok.Getter;

@Getter
public class RobotCommand {

    private final Robot robot;
    private final char[] commands;

    public RobotCommand(Robot robot, String commands) {
        this.robot = robot;
        this.commands = commands.toCharArray();
    }

}

