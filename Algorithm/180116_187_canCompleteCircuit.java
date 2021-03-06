/**
187. 加油站 
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。

你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。

求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。

 注意事项
数据保证答案唯一。

样例
现在有4个加油站，汽油量gas[i]=[1, 1, 3, 1]，环路旅行时消耗的汽油量cost[i]=[2, 2, 1, 1]。则出发的加油站的编号为2。
*/

public class Solution {
    /*
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
		int sumgas = 0, sumcost = 0;
		for (int i=0; i<gas.length; i++) {  // i为头的位置
			int p = i, n = 0;
			while (n < gas.length) {    // n记录是否走完一圈
			    n++;
				sumgas += gas[p];
				sumcost += cost[p];
				if (sumgas < sumcost) { // 无法支撑，跳出换个头开始
					sumgas = 0;
					sumcost = 0;
					break;
				} else {
					p++;
					if (p == gas.length)    // p为以i头开始走到的位置，p走到尾，换为0开始
						p=0;
					if (n == gas.length)    // 如果走完一圈
						return i;
				}
			}
		}
		return -1;
    }
}