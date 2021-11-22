package com.tute.leetCode;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class test02 {

    //TODO LeetCode
    // 一个集合    i项值为value[i]
    //              标签为labels[i]
    // 要求从集合的项中选出子集 S

    //TODO     |s| <= num_wanted



    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        // 定义优先队列 ， 将 values[i],labels[i] 组队 ， 以 values[i] 由大到小排序
        PriorityQueue<int[]> maxHeap = new PriorityQueue((Comparator<int[]>) (o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < values.length; i++) {
            maxHeap.add(new int[]{values[i], labels[i]});
        }

        // 定义 HashMap 集合 存储 labels 使用多少次
        HashMap<Integer, Integer> map = new HashMap<>();
        // 定义返回结果 result , num 为临时值
        int result = 0, num = 0;

        // 当 numWanted > 0 表示没取够值 并且 maxHeap 不允许为空
        while (numWanted > 0 && !maxHeap.isEmpty()) {
            // 获取最大堆中的 values[i] 最大的 一对 values-label 值
            int[] poll = maxHeap.poll();
            // 查询 label 的使用次数，如果大于等于 useLimit 跳过当前值
            if ((num = map.getOrDefault(poll[1], 0)) == useLimit) {
                continue;
            }
            // 加上 value 值
            result += poll[0];
            // 记录使用次数
            map.put(poll[1], num + 1);
            // 取到值，可取值要 -1；
            numWanted--;
        }

        return result;
    }
}
