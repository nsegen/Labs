package by.bsu.mmf.nsegen.collections;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

/**
 * Created by nsegen on 3.10.16.
 */
public class Tree<T> implements ITree<T> {

    private List<T> tree;
    private Long amountLevels;

    public Tree(List<T> tree) {
        this.tree = new ArrayList<>(tree);
        amountLevels =  Math.round( Math.log(tree.size()+1)/Math.log(2)+1e-10)+1;
    }

    private boolean isEmptyOrNull(Integer index) {
        if (index==null || index >= tree.size())
            return true;
        return false;
    }

    private Integer getLeftBranch(Integer index) {
        return index*2 +1 < tree.size() ? index*2 +1 : null;
    }

    private Integer getRightBranch(Integer index) {
        return index*2 +2 < tree.size() ? index*2 +2 : null;
    }

    private T getData(Integer index) {
        return tree.get(index);
    }

    @Override
    public void directBypass() {
        System.out.println();
        System.out.println(preOrderTraversalSubFun(0));
    }

    private String preOrderTraversalSubFun(Integer index) {
        if (isEmptyOrNull(index)) return "";
        return getData(index) + " " + preOrderTraversalSubFun(getLeftBranch(index)) + " " + preOrderTraversalSubFun(getRightBranch(index));
    }

    @Override
    public void balancedBypass() {
        System.out.println();
        System.out.println(inOrderTraversalSubFun(0));
    }

    private String inOrderTraversalSubFun(Integer index) {
        if (isEmptyOrNull(index)) return "";
        return  inOrderTraversalSubFun(getLeftBranch(index)) + " " +getData(index) +  " " + inOrderTraversalSubFun(getRightBranch(index));
    }

    @Override
    public void reverseBypass() {
        System.out.println();
        System.out.println(postOrderTraversalSubFun(0));
    }

    private String postOrderTraversalSubFun(Integer index) {
        if (isEmptyOrNull(index)) return "";
        return  postOrderTraversalSubFun(getLeftBranch(index))+  " " + postOrderTraversalSubFun(getRightBranch(index))  + " " +getData(index) ;
    }

    @Override
    public void printTree() {
        int levelWidth = 2*tree.size();
        int widthForEachElement;
        double amountOfElementsAtLevel;
        int oldWidthForEachElement=levelWidth;
        for (int i = 0; i < amountLevels; i++) {
            amountOfElementsAtLevel = Math.pow(2,i);
            widthForEachElement = toIntExact(Math.round(levelWidth / amountOfElementsAtLevel));
            String format;
            Long currElement =  Math.round(Math.pow(2, i ) - 1);

            for (int j = 0; j < amountOfElementsAtLevel; j++) {
                if (currElement >= tree.size() ) {
                    System.out.println();
                    return;
                }
                format = "%"  + oldWidthForEachElement +"s";
                if (j==0 && i!=0) {
                    format = "%"  +( oldWidthForEachElement/2)+"s";
                }
                System.out.printf(format, tree.get(toIntExact(currElement)));

                currElement++;
            }
            oldWidthForEachElement =widthForEachElement;
            System.out.println();

        }

    }
}
