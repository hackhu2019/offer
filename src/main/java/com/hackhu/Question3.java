package com.hackhu;

public class Question3 {
    /**
     * 先从右往左遍历，排除比 target 大的列
     * 若已遍历至最左列仍大于 target 则返回 false
     * 若当前遍历点小于 target 则从上往下遍历
     * 若已遍历至最底层，仍大于 target 则返回 false
     * @param array
     * @return
     */
    public boolean TwoDimensionalArrayFindNum(int[][] array, int target){
        if (array == null) {
            return false;
        }
        int right = array[0].length-1;
        int top = 0;
        while (right >= 0&&top<array.length) {
            if (array[top][right] > target) {
                right--;
            } else if (array[top][right] == target) {
                System.out.println("目标所在的坐标为：" +
                        ""+top+","+right);
                return true;
            }else { // 已排除比 target 大的列
                top++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        Question3 q = new Question3();
        System.out.println(q.TwoDimensionalArrayFindNum(arrays,7));
    }
}
