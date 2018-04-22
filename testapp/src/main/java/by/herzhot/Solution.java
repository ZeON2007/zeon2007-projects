package by.herzhot;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {

    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private BigInteger prod = BigInteger.ONE;

    public int getResult() {
        return prod.mod(BigInteger.valueOf(1000000007L)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (Color.RED == node.getColor()) {
            prod = prod.multiply(node.getValue() == 0 ? BigInteger.ONE : BigInteger.valueOf((long)node.getValue()));
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.RED == leaf.getColor()) {
            prod = prod.multiply(leaf.getValue() == 0 ? BigInteger.ONE : BigInteger.valueOf((long)leaf.getValue()));
        }
    }
}

class FancyVisitor extends TreeVis {

    private int sumOfEvenDepthNode = 0;
    private int sumOfGreenLeaf = 0;

    public int getResult() {
        return Math.abs(sumOfEvenDepthNode - sumOfGreenLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumOfEvenDepthNode += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.GREEN == leaf.getColor()) {
            sumOfGreenLeaf += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] values = new int[n + 1];
        boolean[] colors = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            colors[i] = sc.nextInt() == 1;
        }

        Map<Integer, List<Integer>> relationLeft = new HashMap<>(n - 1);
        Map<Integer, List<Integer>> relationRight = new HashMap<>(n - 1);
        for (int i = 1; i < n; i++) {
            int numLeft = sc.nextInt();
            int numRight = sc.nextInt();
            if (relationLeft.containsKey(numLeft)) {
                relationLeft.get(numLeft).add(numRight);
            } else {
                List<Integer> numRightList = new ArrayList<>();
                numRightList.add(numRight);
                relationLeft.put(numLeft, numRightList);
            }
            if (relationRight.containsKey(numRight)) {
                relationRight.get(numRight).add(numLeft);
            } else {
                List<Integer> numLeftList = new ArrayList<>();
                numLeftList.add(numLeft);
                relationRight.put(numRight, numLeftList);
            }
        }

        Queue<TreeNode> treeNodes = new LinkedList<>();
        TreeNode root = new TreeNode(values[1], colors[1] ? Color.GREEN : Color.RED, 0);
        treeNodes.add(root);
        Map<TreeNode, Integer> nodeRefs = new HashMap<>(n + 1);
        nodeRefs.put(root, 1);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            Integer index = nodeRefs.get(node);
            List<Integer> childsList = new ArrayList<>();
            if (relationLeft.containsKey(index)) {
                for (Integer val : relationLeft.get(index)) {
                    if (!nodeRefs.containsValue(val)) {
                        childsList.add(val);
                    }
                }
            }
            if (relationRight.containsKey(index)) {
                for (Integer val : relationRight.get(index)) {
                    if (!nodeRefs.containsValue(val)) {
                        childsList.add(val);
                    }
                }
            }
            for (Integer ch : childsList) {
                if (isLeaf(index, ch, relationLeft, relationRight, nodeRefs)) {
                    node.addChild(new TreeLeaf(values[ch], colors[ch] ? Color.GREEN : Color.RED, node.getDepth() + 1));
                } else {
                    TreeNode child =  new TreeNode(values[ch], colors[ch] ? Color.GREEN : Color.RED, node.getDepth() + 1);
                    node.addChild(child);
                    nodeRefs.put(child, ch);
                    treeNodes.add(child);
                }
            }
        }
        return root;
    }


    private static boolean isLeaf(Integer parent, Integer child, Map<Integer, List<Integer>> relationLeft,
                                  Map<Integer, List<Integer>> relationRight, Map<TreeNode, Integer> nodeRefs) {
        boolean containsLeft = relationLeft.containsKey(child);
        boolean containsRight = relationRight.containsKey(child);
        if (containsLeft && containsRight) {
            return false;
        } else {
            if (containsLeft) {
                List<Integer> values = relationLeft.get(child);
                if (values.size() == 1 && parent.equals(values.get(0))) {
                    return true;
                }
            } else {
                List<Integer> values = relationRight.get(child);
                if (values.size() == 1 && parent.equals(values.get(0))) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
