import Tree.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestBinaryTreeInteger {
    private BinaryTree<Integer> binaryTree;

    @Before
    public void setup(){
        binaryTree = new BinaryTree<>();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(5);
        binaryTree.add(-10);
        binaryTree.add(20);
        binaryTree.add(165);
        binaryTree.add(14);
        binaryTree.add(-3);
    }

    @Test
    public void testContains(){
        assertTrue(binaryTree.contains(1));
        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(165));
        assertFalse(binaryTree.contains(120));
    }

    @Test
    public void testSize(){
        assertEquals(8,binaryTree.size());
        binaryTree.add(7);
        assertEquals(9,binaryTree.size());
    }

    @Test
    public void testList(){
        List<Comparable> l = binaryTree.getAllValues();
        assertEquals(-10, l.get(0));
        assertEquals(-3, l.get(1));
        assertEquals(2, l.get(3));
        assertEquals(165, l.get(7));
    }

}
