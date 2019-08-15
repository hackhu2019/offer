package com.hackhu;

public class Question20 {
    /**
     * 输入一个矩阵（二维数组），按照顺时针顺序（从外到里）打印矩阵数据
     * 先打印（i~col.length-i）列的第 i 行 数据
     * 再打印(i~row.length-i)行的第 col.length-i-1 列数据
     * 再打印（col.length-i~i+1）列的第 n-i 行数据
     * 最后打印 (row.length-i，i+1)列的第 i 列数据
     * 执行一次 i++
     * 当 i *2>=row.length&& i*2>=col.length 时停止打印
     * 特殊情况，只有一行、一列
     * @param matrix
     */
    public void printMatrixClockWisely(int[][] matrix){
        if (matrix == null) {
            return;
        }
        int n = 0; // n 代表打印第几圈，从 0 开始
        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        while (n * 2 < colLen && n * 2 < rowLen) {
            printMatrixInCircle(matrix, n,colLen-n,n,rowLen-n);
            n++;
        }
    }
    private void printMatrixInCircle(int[][] matrix,int startCol,int endCol,int startRow,int endRow){

        // 打印从左到右
        for (int i = startCol; i < endCol; i++) {
            System.out.print(matrix[startRow][i]+" ");
        }

        // 只有一行，则不打印
        if (startRow < endRow-1) {
            // 打印从上到下
            for (int i = startRow+1; i < endRow; i++) {
                System.out.print(matrix[i][endCol-1]+" ");
            }
        }

        // 不止一行一列
        if (startRow < endRow-1 && startCol < endCol - 1) {
            // 打印从右到左
            for (int i = endCol-2; i >=startCol ; i--) {
                System.out.print(matrix[endRow-1][i]+" ");
            }
        }

        // 不止两行两列
        if (startRow < endRow-2 && startCol < endCol - 2) {
            // 最后打印 (row.length-i，i+1)列的第 i 列数据，从下到上
            for (int i = endRow-2; i > startRow; i--) {
                System.out.print(matrix[i][startCol]+" ");
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {10, 9, 8, 7, 6},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Question20 question20 = new Question20();
        question20.printMatrixClockWisely(matrix);
    }
}
