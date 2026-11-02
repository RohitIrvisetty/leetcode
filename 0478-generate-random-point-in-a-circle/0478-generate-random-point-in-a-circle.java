
import java.util.Random;

class Solution {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double x = (random.nextDouble() * 2 - 1) * radius;
            double y = (random.nextDouble() * 2 - 1) * radius;

            if (x * x + y * y <= radius * radius) {
                return new double[]{xCenter + x, yCenter + y};
            }
        }
    }
}
