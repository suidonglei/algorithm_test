package learn.contest;

/**
 * 5230
 *
 */
public class StraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean returnFlag = true;
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        int a = 0;
        int b = 0;
        if(0 != (point2[0] - point1[0])) {
            a = (point2[1] - point1[1])/(point2[0] - point1[0]);
            b = point1[1] - a * point1[0];
        } else {
            b = point2[1] - point1[1];
        }
        for(int[] point: coordinates) {
            if(point[1] != a * point[0] + b) {
                return false;
            }
        }
        return returnFlag;
    }

    public static void main(String[] args) {
        StraightLine straightLine = new StraightLine();
        System.out.println(straightLine.checkStraightLine(new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}}));
    }
}
