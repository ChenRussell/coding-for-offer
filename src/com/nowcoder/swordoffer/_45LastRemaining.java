package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ChenRui on 18-4-15
 *
 * ԲȦ��׷��ʣ�µ�����
 * 0,1,2,...,n-1��n�������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ������
 */
public class _45LastRemaining {

    static public int LastRemaining_Solution(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            count++;
            if (count == m) {
                iterator.remove();
                count = 0;
            }
            if (list.size() == 1)   break;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int res = LastRemaining_Solution(3, 1);  // todo ������ȷ�ԣ�����������ôʵ��תȦ��
        System.out.println(res);
    }
}
