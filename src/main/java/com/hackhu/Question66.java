package com.hackhu;

import java.util.Arrays;

public class Question66 {
    /**
     * 题：设计一个函数用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中任意一格开始，
     * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再进入该格子。（路径中不能有重复格子）
     * 思路分析：回溯法
     * 1、定义和矩阵同样大小数组来记录该格子是否已经遍历
     * 2、从（0,0） 开始，选择上下左右任意一点为下一路径，不能超过数组长度
     * 3、递归：下一步可以选择上、下、左、右任意一格。
     * 4、剪枝：与目前字符串当前需要的字符不匹配、已走过该格子、超过格子边界
     * 5、出现任意一种解即返回 true
     * @param matrix
     * @param target
     * @return
     */
    int row=0, col = 0;
    char[][] matrx = null;
    public boolean hasPath(char[][] matrix,String target){
        if (matrix == null || target == null) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        this.row = row;
        this.col = col;
        this.matrx = matrix;
        for (int i = 0; i < row; i++) { // 选取起始点
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                for (int k = 0; k < visited.length; k++) { // 初始化可访问性
                    Arrays.fill(visited[k], false);
                }
                if (hasPath(i,j,target,0,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(int indexRow,int indexCol,String target,int index,boolean[][] visited) {
        if (index == target.length()) { // 路径和目标字符一致，匹配成功
            return true;
        }
        boolean pathEqual = false;
        if (indexRow >= 0 && indexRow < row && indexCol >= 0 &&
                indexCol < col && matrx[indexRow][indexCol] == target.charAt(index)&&
                !visited[indexRow][indexCol]) { // 确认当前格子可访问
            visited[indexRow][indexCol] = true; // 将当前格子设置为已访问
            index++;
            pathEqual = hasPath(indexRow - 1, indexCol, target, index,visited) || //上下左右任意一种通过即可
                    hasPath(indexRow + 1, indexCol, target, index,visited) ||
                    hasPath(indexRow, indexCol - 1, target, index,visited)||
                    hasPath(indexRow, indexCol + 1, target, index,visited);
        }
        return pathEqual;
    }

    public static void main(String[] args) {
        Question66 q = new Question66();
        char[][] matrix={
                {'a','b','c','e'},
                {'f','s','c','s'},
                {'a','d','e','e'}
        };
        System.out.println(q.hasPath(matrix,"abcb"));
    }
}
