import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uael.jds.BiSTree;

import java.util.concurrent.ThreadLocalRandom;

public class BiSTreeTest {
    BiSTree<Integer> empty, size1, size2;
    Integer one, two;

    @Test
    public void clear() throws Exception {
        Assert.assertTrue(empty.isEmpty());
        size1.clear();
        Assert.assertTrue(size1.isEmpty());
        size2.clear();
        Assert.assertTrue(size2.isEmpty());
    }

    @Test
    public void equalsTest() throws Exception {
        Assert.assertEquals(empty, empty);
        Assert.assertEquals(size1, size1);
        Assert.assertEquals(size2, size2);
        BiSTree<Integer> _size1 = new BiSTree<>(), _size2 = new BiSTree<>();
        _size1.insert(one);
        _size2.insert(one);
        _size2.insert(two);
        Assert.assertEquals(_size1, size1);
        Assert.assertEquals(_size2, size2);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(empty.isEmpty());
        Assert.assertFalse(size1.isEmpty());
        Assert.assertFalse(size2.isEmpty());
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

    /**
     * Next int integer.
     * @return the integer
     */
    Integer nextInt() {
        return nextInt(-100, 100);
    }

    @Before
    public void setUp() throws Exception {
        empty = new BiSTree<>();
        size1 = new BiSTree<>();
        size1.insert(one = nextInt());
        size2 = new BiSTree<>();
        size2.insert(one);
        size2.insert(two = nextInt());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(1, size1.size());
        Assert.assertEquals(2, size2.size());
    }

    @Test
    public void toStringTest() throws Exception {
//        Assert.assertEquals("BiTree{size=0}", empty.toString());
//        Assert.assertEquals("BiTree{root=Node{value=AvlNode{data="+one+", hidden=false, factor=BALANCED}, left=null, right=null}, size=1}", size1.toString());
//        Assert.assertEquals("BiTree{root=Node{value=AvlNode{data="+one+", hidden=false, factor=LEFT_HEAVY}, left=Node{value=AvlNode{data="+two+", hidden=false, factor=BALANCED}, left=null, right=null}, right=null}, size=2}", size2.toString());
    }
}
