package com.gocheat.recursion;

// Q. 전달받은 이미지의 Blob의 크기를 구하시오
// 1. 입력으로 Binary 이미지가 주어진다.
// 2. 각 픽셀은 background pixel(흰색)이거나 혹은 imagepixel(파란색)이다.
// 3. 서로 연결된 image pixel들의 집합을 Blob이라고 부른다.
// 4. 상하좌우 및 대각방향으로도 연결된 것을 Blob으로 간주한다.
public class CountingCellsInBlob {
    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int ALREADY_COLOR = 2;

    private static int N = 5;
    private static int[][] grid = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
    };
    public int countCells(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return 0;
        } else if (grid[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            grid[x][y] = ALREADY_COLOR;
            return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1) + countCells(x + 1, y + 1) +
                    countCells(x - 1, y) + countCells(x + 1, y) +
                    countCells(x - 1, y - 1) + countCells(x, y - 1) + countCells(x + 1, y - 1);
        }
    }

	public static void main(String[] args) {
		CountingCellsInBlob recursion = new CountingCellsInBlob();
		int result = recursion.countCells(0,3);
		System.out.println(result);
	}
}
