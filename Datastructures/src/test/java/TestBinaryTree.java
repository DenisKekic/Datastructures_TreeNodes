import Tree.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestBinaryTree {
    private BinaryTree<String> binaryTree;

    @Before
    public void setup(){
        binaryTree = new BinaryTree<>();
        binaryTree.add("Potopea");
        binaryTree.add("Jakubek");
        binaryTree.add("Undesser");
    }

    @Test
    public void testContains(){
        assertTrue(binaryTree.contains("Potopea"));
        assertTrue(binaryTree.contains("Jakubek"));
        assertTrue(binaryTree.contains("Undesser"));
        assertFalse(binaryTree.contains("Idiskut"));
    }

    @Test
    public void testSize(){
        assertEquals(3,binaryTree.size());
        binaryTree.add("Idiskut");
        assertEquals(4,binaryTree.size());
    }

    @Test
    public void testList(){
        List<Comparable> l = binaryTree.getAllValues();
        assertEquals("Jakubek", l.get(0));
        assertEquals("Potopea", l.get(1));
        assertEquals("Undesser", l.get(2));
    }

    @Test
    public void delete(){
        binaryTree.delete("Potopea");
        //assertEquals(2, binaryTree.size());
        assertFalse(binaryTree.contains("Potopea"));
    }
}
