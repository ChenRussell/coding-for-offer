package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-3-28
 * <p>
 * ��Ŀ����
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length ==0) return false;
        int root = sequence[sequence.length - 1];

        boolean bool = checkBST(sequence, 0, sequence.length - 1);
        return bool;
    }

    boolean checkBST(int seq[], int start, int end) {
        if (start >=end) return true;   // tag-1 ����������end<0,��������start>=end
        int root = seq[end];
        int tag=0;
        boolean flag = false;
        for (int i = start; i < end; i++) {
            if (seq[i]>root) {
                tag=i;
                flag = true;    // �������ҵ�����root��
                break;
            }
        }

        // ���Ҳ��Ŵ���root��ʱ��tag=0, tag-1 ����ȥ�ᱨ��
        for (int i = tag; i < end && flag; i++) {
            if (seq[i]<root)
                return false;
        }
//        return true;
        boolean left=true;
//        if (end>0)
        left= checkBST(seq, start, tag-1);

        boolean right = true;
//        if (end>0)
        right = checkBST(seq, tag, end-1);

        return left && right ;

    }

    public static void main(String[] args) {
        int arr[] = {5,7,6,9,11,10,8};
        int arr2[] = {4,6,7,5};
        VerifySquenceOfBST obj = new VerifySquenceOfBST();
        boolean bool = obj.checkBST(arr2, 0, arr2.length - 1);
        System.out.println(bool);
    }
}
