class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        
        int steps = 1;
        int r = rStart, c = cStart;
        
        result[index++] = new int[]{r, c}; 

        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    r += directions[dirIndex][0];
                    c += directions[dirIndex][1];
                    
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                    }
                    
                    if (index == rows * cols) {
                        return result;
                    }
                }
                dirIndex = (dirIndex + 1) % 4;
            }
            steps++;
        }
        
        return result;
    }
}
