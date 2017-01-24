import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uael.jds.BinaryTree;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Stack test.
 */
public class BinaryTreeTest {
    BinaryTree<Integer> empty, size1, size2;
    Integer one, two;

    /**
     * Next int integer.
     * @return the integer
     */
    Integer nextInt() {
        return nextInt(-100, 100);
    }

    /**
     * Next int integer.
     * @param min the min
     * @param max the max
     * @return the integer
     */
    Integer nextInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    @Before
    public void setUp() throws Exception {
        empty = new BinaryTree<>();
        size1 = new BinaryTree<>();
        size1.insertLeft(one = nextInt());
        size2 = new BinaryTree<>();
        size2.insertLeft(one);
        size2.insertRight(two = nextInt());
    }

    @Test
    public void clear() throws Exception {
        Assert.assertTrue(empty.isEmpty());
        size1.clear();
        Assert.assertTrue(size1.isEmpty());
        size2.clear();
        Assert.assertTrue(size2.isEmpty());
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(empty.isEmpty());
        Assert.assertFalse(size1.isEmpty());
        Assert.assertFalse(size2.isEmpty());
    }
    
    @Test
    public void size() throws Exception {
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(1, size1.size());
        Assert.assertEquals(2, size2.size());
    }

    @Test
    public void toStringTest() throws Exception {
        Assert.assertEquals("BinaryTree{size=0}", empty.toString());
        Assert.assertEquals("BinaryTree{root=Node{value="+one+", left=null, right=null}, size=1}", size1.toString());
        Assert.assertEquals("BinaryTree{root=Node{value="+one+", left=null, right=Node{value="+two+", left=null, right=null}}, size=2}", size2.toString());
    }

    @Test
    public void equalsTest() throws Exception {
        Assert.assertEquals(empty, empty);
        Assert.assertEquals(size1, size1);
        Assert.assertEquals(size2, size2);
        BinaryTree<Integer> _size1 = new BinaryTree<>(), _size2 = new BinaryTree<>();
        _size1.insertLeft(one);
        _size2.insertLeft(one);
        _size2.insertRight(two);
        Assert.assertEquals(_size1, size1);
        Assert.assertEquals(_size2, size2);
    }
}
