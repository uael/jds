import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.Container;

import java.util.Arrays;

/**
 * The type Container test.
 *
 * @param <U> the type parameter
 */
abstract class ContainerTest<U extends Container<Integer>> extends CollectionTest<U> {

    /**
     * First.
     *
     * @throws Exception the exception
     */
    @Test
    public void first() throws Exception {
        Assert.assertNull(empty.first());
        Assert.assertEquals(one, size1.first());
        Assert.assertEquals(one, size2.first());
        Assert.assertNotNull(sizeMax.first());
    }

    /**
     * Last.
     *
     * @throws Exception the exception
     */
    @Test
    public void last() throws Exception {
        Assert.assertNull(empty.last());
        Assert.assertEquals(one, size1.last());
        Assert.assertEquals(two, size2.last());
        Assert.assertNotNull(sizeMax.last());
    }

    /**
     * Pop.
     *
     * @throws Exception the exception
     */
    @Test
    public void pop() throws Exception {
        Assert.assertNull(empty.pop());
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(one, size1.pop());
        Assert.assertEquals(0, size1.size());
        Assert.assertEquals(two, size2.pop());
        Assert.assertEquals(1, size2.size());
        Assert.assertEquals(one, size2.pop());
        Assert.assertEquals(0, size2.size());
        Assert.assertNotNull(sizeMax.pop());
        Assert.assertEquals(maxSize - 1, sizeMax.size());
    }

    @Test
    public void iteratorEmpty() throws Exception {
        super.iterator();
        Assert.assertTrue(empty.isEmpty());
        Assert.assertTrue(size1.isEmpty());
        Assert.assertTrue(size2.isEmpty());
        Assert.assertTrue(sizeMax.isEmpty());
    }

    /**
     * Push.
     *
     * @throws Exception the exception
     */
    @Test
    public void push() throws Exception {
        Integer rand = nextInt();
        empty.push(rand);
        Assert.assertEquals(empty.last(), rand);
        Assert.assertEquals(1, empty.size());
        size1.push(rand);
        Assert.assertEquals(size1.last(), rand);
        Assert.assertEquals(2, size1.size());
        size2.push(rand);
        Assert.assertEquals(size2.last(), rand);
        Assert.assertEquals(3, size2.size());
        sizeMax.push(rand);
        Assert.assertEquals(sizeMax.last(), rand);
        Assert.assertEquals(maxSize + 1, sizeMax.size());
    }

    /**
     * Push array.
     *
     * @throws Exception the exception
     */
    @Test
    public void pushArray() throws Exception {
        Integer rand1 = nextInt(), rand2 = nextInt();
        empty.push(rand1, rand2);
        Assert.assertEquals(empty.last(), rand2);
        Assert.assertEquals(2, empty.size());
        size1.push(rand1, rand2);
        Assert.assertEquals(size1.last(), rand2);
        Assert.assertEquals(3, size1.size());
        size2.push(rand1, rand2);
        Assert.assertEquals(size2.last(), rand2);
        Assert.assertEquals(4, size2.size());
        sizeMax.push(rand1, rand2);
        Assert.assertEquals(sizeMax.last(), rand2);
        Assert.assertEquals(maxSize + 2, sizeMax.size());
    }

    /**
     * Push iterable.
     *
     * @throws Exception the exception
     */
    @Test
    public void pushIterable() throws Exception {
        Integer rand1 = nextInt(), rand2 = nextInt();
        empty.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(empty.last(), rand2);
        Assert.assertEquals(2, empty.size());
        size1.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(size1.last(), rand2);
        Assert.assertEquals(3, size1.size());
        size2.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(size2.last(), rand2);
        Assert.assertEquals(4, size2.size());
        sizeMax.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(sizeMax.last(), rand2);
        Assert.assertEquals(maxSize + 2, sizeMax.size());
    }

    /**
     * Push iterator.
     *
     * @throws Exception the exception
     */
    @Test
    public void pushIterator() throws Exception {
        Integer rand1 = nextInt(), rand2 = nextInt();
        empty.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(empty.last(), rand2);
        Assert.assertEquals(2, empty.size());
        size1.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(size1.last(), rand2);
        Assert.assertEquals(3, size1.size());
        size2.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(size2.last(), rand2);
        Assert.assertEquals(4, size2.size());
        sizeMax.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(sizeMax.last(), rand2);
        Assert.assertEquals(maxSize + 2, sizeMax.size());
    }
}