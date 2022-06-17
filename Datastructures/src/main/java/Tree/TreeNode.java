package Tree;

public class TreeNode<T extends Comparable>{
    private T object;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T obj){
        this.left= null;
        this.right = null;
        this.object = obj;
    } // left and right are set to null

    public T getValue(){
        return object;
    }

    public void setValue(T value){
        this.object = value;
    }

    public void setLeft(TreeNode node){
        this.left = node;
    }

    public TreeNode getLeft(){
        return left;
    }

    public void setRight(TreeNode node){
        this.right = node;
    }

    public TreeNode getRight(){
        return right;
    }
}
