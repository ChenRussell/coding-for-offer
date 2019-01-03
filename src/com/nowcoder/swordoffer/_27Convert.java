package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/9/25.
 * <p>
 * ��Ŀ����
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class _27Convert {

    TreeNode lastNodeInList = null;     // ����һ��ȫ�ֱ���������ǲ�������Ļ���������

    public TreeNode convert(TreeNode pRootOfTree) {


        convertNode(pRootOfTree);

        while (lastNodeInList!=null && lastNodeInList.left != null) {
            lastNodeInList = lastNodeInList.left;
        }

        return lastNodeInList;
    }

    // ʹ���������
    private void convertNode(TreeNode pRootOfTree) {

        if (pRootOfTree != null) {
            convertNode(pRootOfTree.left);

            pRootOfTree.left = lastNodeInList;

            if (lastNodeInList != null) {
                lastNodeInList.right = pRootOfTree;
            }
            lastNodeInList = pRootOfTree;   // ����lastNodeInList

            convertNode(pRootOfTree.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        _27Convert convert = new _27Convert();
        TreeNode head = convert.convert(node);
        TreeNode pre = null;
        while (head != null) {
            System.out.println(head.val);
            pre = head;
            head = head.right;
        }


        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.left;
        }
    }
}
