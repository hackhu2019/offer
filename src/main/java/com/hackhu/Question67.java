package com.hackhu;

import java.util.Arrays;

public class Question67 {
    /**
     * 题：地上有一个 M 行 N 列的方格。一个机器人从坐标（0,0）的格子开始移动，它每一次可以向左、右、上、下移动一格，
     * 但不能进入行坐标和列坐标的位数之和大于 K 的格子。问该机器人可以达到多少个格子。
     * 思路分析：回溯
     * 1、用相同大小的数组记录当前格子是否访问
     * 2、每次选择上下左右任意符合要求的格子（在方格内、坐标数位之和不大于 K、未被访问）
     * 3、记录当前遍历的格子数，大于 maxLong 则更新
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    int maxLong = 0,row=0, col=0, k = 0;

    public int moveCount(int m, int n, int k) {
        this.row = m;
        this.col = n;
        this.k = k;
        boolean[][] visited = new boolean[m][n]; // 默认为 false
        moveCount(0, 0, 0, visited); // 固定从（0,0） 开始
        return maxLong;
    }

    private void moveCount(int rowIndex, int colIndex, int count, boolean[][] visited) {
        maxLong = maxLong < count ? count : maxLong; // 存储最大距离
        if (rowIndex >= 0 && rowIndex < row &&
                colIndex >= 0 && colIndex < col && !visited[rowIndex][colIndex]&&
                getDigitSum(rowIndex,colIndex)<=k) { // 判断是否满足可移动条件
            visited[rowIndex][colIndex] = true; // 更改可访问性
            count++; // 增加长度
            moveCount(rowIndex + 1, colIndex, count, visited); // 从上、下、左、右 任意前进一步
            moveCount(rowIndex - 1, colIndex, count, visited);
            moveCount(rowIndex, colIndex + 1, count, visited);
            moveCount(rowIndex, colIndex - 1, count, visited);
        }
    }

    private int getDigitSum(int row, int col) { // 计算坐标数位和
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Question67 q = new Question67();
        System.out.println(q.moveCount(2,2,1));
//        System.out.println(Arrays.toString(new boolean[3]));
    }
}
