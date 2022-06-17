package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree <T extends Comparable>{
    private TreeNode<T> root;

    // Methods to implement follow below

    public void add(T object){
        root = addRecursive(root, object);
    }

    private TreeNode addRecursive(TreeNode current, T object){
        // find the place where to add a new node in order to keep the tree sorted
        // if current is null return new Node()
        // Use compareTo to find in which node you must continue

        if(current == null){
            current = new TreeNode(object);
            return current;
        }

        if(current.getValue().compareTo(object) > 0){
            current.setLeft(addRecursive(current.getLeft(),object));
        }
        else if(current.getValue().compareTo(object) < 0){
            current.setRight(addRecursive(current.getRight(),object));
        }
        return current;
    }

    public boolean contains(T value){
        return containsRecursiv(root, value);
    }

    private boolean containsRecursiv(TreeNode current, T value){
        // ist current NULL -> return false
        // ist current == value --> return true
        // sonst ist value < current -> suche im linken Unterbaum weiter
        // ansonsten im rechten Unterbaum

        if(current == null){
            return false;
        }
        if(current.getValue().compareTo(value) == 0){
            return true;
        }
        else if(current.getValue().compareTo(value) < 0){
            return containsRecursiv(current.getRight(),value);
        }
        else{
            return containsRecursiv(current.getLeft(),value);
        }
    }

    public int size(){
        return sizeRecursiv(root);
    }

    private int sizeRecursiv(TreeNode current){
        // wenn current Null ist -> return 0
        if(current == null){
            return 0;
        }
        // returniere 1 + sizeRecursiv(left) + sizeRecursiv(right)
        return 1 + sizeRecursiv(current.getLeft()) + sizeRecursiv(current.getRight());
    }

    public List<Comparable> getAllValues(){ // soll die Liste sortiert zurückgeben
        if(root == null){
            return null;
        }
        List<Comparable> l = new ArrayList();
        getAllValuesRecursive(root,l);
        return l;
    }

    private void getAllValuesRecursive(TreeNode current , List<Comparable> l){
        // gehe alle Knoten durch und gebe Sie zur Liste,
        // beginne immer zuerst beim linken Knoten
        if(current.getLeft() != null){
            getAllValuesRecursive(current.getLeft(),l);
        }
        l.add(current.getValue());

        if(current.getRight() != null){
            getAllValuesRecursive(current.getRight(), l);
        }

    }

    public void delete(T object){
        root = deleteRecursive(root, object);
    }

    private TreeNode deleteRecursive(TreeNode current, T object) {
        if (current == null) {
            return null;
        }

        if (object == current.getValue()) {
            // Wenn linker und rechter Knoten NULL sind -> setze diesen auf NULL
            if((current.getLeft() == null) && (current.getRight() == null)){
                current = null;
                return current;
            }
            // Wenn linker oder rechter Knoten NULL ist -> setze diesen durch sein
            // untergeordnetes Element
            else{
                if((current.getLeft() == null) && (current.getRight() != null)){
                    current = current.getRight();
                    return current;
                }
                if((current.getLeft() != null) && (current.getRight() == null)){
                    current = current.getLeft();
                    return current;
                }
            }
            // komplexer Fall:
            // 1. finde kleinsten Wert im rechten Unterbaum
            T smallestObject = findSmallest(current.getRight());
            // 2. ersetze diesen Knoten durch den kleinsten Wert current = smallestObject
            current.setValue(smallestObject);
            // 3. lösche den kleinsten Knoten im rechten Unterbaum
            deleteRecursive(current.getRight(), smallestObject);
        }
        if (current.getValue().compareTo(object) > 0) {
            current.setLeft(deleteRecursive(current.getLeft(), object));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(), object));
        return current;
    }

    private T findSmallest(TreeNode root) {
        return root.getLeft() == null ? (T) root.getValue() : findSmallest(root.getLeft());
        /*
        if(root.getLeft() == null){
            return root.getValue();
        }
        else{
            return findSmallest(root.getLeft());
        }
        */
    }
}
