package denisenko.hw10.robot;

public class Main {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        boolean robotConnect = false;
        for (int i = 0; i < 3; i++) {

            try (RobotConnection rb = robotConnectionManager.getConnection()) {

                rb.moveRobotTo(toX, toY);
                robotConnect = true;

            } catch (RobotConnectionException rce) {
                System.out.println("Robot exeption in work!");
            }
        }
        if (!robotConnect) {
            throw new RobotConnectionException("No connection!!!");
        }

    }
}
