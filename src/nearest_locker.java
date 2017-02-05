/*
Find the nearest locker in the city: 

For this task:
A positive whole number range 1-9 representing the length of your city in city blocks
A positive whole number range 1-9 representing the width of your city in city blocks
An array containing all x coordinate representing amazon locker locations, each x coordinate range 1-9
An array containing all x coordinate representing amazon locker locations, each y coordinate
 
Job is to construct a 2-d grid of the city. each element of the grid should be a positive whole number
that specifies the number of block to the closest locker. The distance between two blocks is the sum of
their horizontal and vertical distance (diagonal direction is considered a distance of 2)

---

Example 1:

given:
3
5
1
1

return:
012
123
234
345
456

--

given:
1. 7
2. 5
3. 24
4. 37

return:
32345
21234
10123
21234
32323
43212
32101

*/

public class nearest_locker {
	public static void main(String[] args) {

        int cityLength = 5;
        int cityWidth = 7;
        int[] lockerXCoordinates = { 2,4 };
        int[] lockerYCoordinates = { 3,7 };
        int[][] lockerDistances = getLockerDistanceGrid(cityLength, cityWidth, lockerXCoordinates, lockerYCoordinates);

        for (int i = 0; i < cityWidth; i++) {
            for (int j = 0; j < cityLength; j++) {
                System.out.print(lockerDistances[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getLockerDistanceGrid(int cityWidth, int cityLength, int[] xCordinates, int[] yCordinates) {
        int[][] lockerDistances = new int[cityWidth][cityLength];
        for (int i = 0; i < cityLength; i++) {
            for (int j = 0; j < cityWidth; j++) {
                int lockDistance = findNearestLocker(i, j, xCordinates, yCordinates);
                lockerDistances[j][i] = lockDistance;
            }
        }
        return lockerDistances;
    }

    // compute the min distance from each locker to each x,y coordinate
    private static int findNearestLocker(int i, int j, int[] xCordinates, int[] yCordinates) {
        int totalLocker = xCordinates.length;
        int distance = Integer.MAX_VALUE;
        for (int l = 0; l < totalLocker; l++) {
            int x = xCordinates[l];
            int y = yCordinates[l];
            int tempDistance = Math.abs(x - j - 1) + Math.abs(y - i - 1);
            if (distance > tempDistance) {
                distance = tempDistance;
            }
        }
        return distance;
    }
}
