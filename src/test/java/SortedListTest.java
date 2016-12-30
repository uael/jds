import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.SortedList;

import java.util.Arrays;
import java.util.Iterator;

/**
 * The type Ordered list test.
 */
public class SortedListTest extends SequenceTest<SortedList<Integer>> {
    @Override
    SortedList<Integer> create() {
        return new SortedList<>();
    }

    @Override
    SortedList<Integer> create(Integer... values) {
        return new SortedList<>(values);
    }

    @Override
    SortedList<Integer> create(Iterable<? extends Integer> iterable) {
        return new SortedList<>(iterable);
    }

    @Override
    SortedList<Integer> create(Iterator<? extends Integer> iterator) {
        return new SortedList<>(iterator);
    }

    @Test
    @Override
    public void capacity() throws Exception {
        Assert.assertEquals(Integer.MAX_VALUE, empty.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, size1.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, size2.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, sizeMax.capacity());
    }

    @Test
    @Override
    public void resize() throws Exception {

    }

    @Test
    @Override
    public void pop() throws Exception {
        Assert.assertNull(empty.pop());
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(one, size1.pop());
        Assert.assertEquals(0, size1.size());
        Assert.assertEquals(new Integer(Math.max(one, two)), size2.pop());
        Assert.assertEquals(1, size2.size());
        Assert.assertEquals(new Integer(Math.min(one, two)), size2.pop());
        Assert.assertEquals(0, size2.size());
        Assert.assertNotNull(sizeMax.pop());
        Assert.assertEquals(maxSize - 1, sizeMax.size());
    }

    @Test
    @Override
    public void first() throws Exception {
        Assert.assertNull(empty.first());
        Assert.assertEquals(one, size1.first());
        Assert.assertEquals(new Integer(Math.min(one, two)), size2.first());
        Assert.assertNotNull(sizeMax.first());
    }

    @Test
    @Override
    public void last() throws Exception {
        Assert.assertNull(empty.last());
        Assert.assertEquals(one, size1.last());
        Assert.assertEquals(new Integer(Math.max(one, two)), size2.last());
        Assert.assertNotNull(sizeMax.last());
    }

    @Test
    @Override
    public void push() throws Exception {
        Integer rand = nextInt();
        empty.push(rand);
        Assert.assertEquals(empty.last(), rand);
        Assert.assertEquals(1, empty.size());
        size1.push(rand);
        Assert.assertEquals(size1.last(), new Integer(Math.max(one, rand)));
        Assert.assertEquals(2, size1.size());
        size2.push(rand);
        Assert.assertEquals(size2.last(), new Integer(Math.max(two, Math.max(one, rand))));
        Assert.assertEquals(3, size2.size());
        sizeMax.push(rand);
        Assert.assertEquals(maxSize + 1, sizeMax.size());
    }

    @Test
    @Override
    public void pushArray() throws Exception {
        Integer rand1 = nextInt(), rand2 = nextInt();
        empty.push(rand1, rand2);
        Assert.assertEquals(empty.last(), new Integer(Math.max(rand1, rand2)));
        Assert.assertEquals(2, empty.size());
        size1.push(rand1, rand2);
        Assert.assertEquals(size1.last(), new Integer(Math.max(rand1, Math.max(rand2, one))));
        Assert.assertEquals(3, size1.size());
        size2.push(rand1, rand2);
        Assert.assertEquals(size2.last(), new Integer(Math.max(rand1, Math.max(rand2, Math.max(one, two)))));
        Assert.assertEquals(4, size2.size());
        sizeMax.push(rand1, rand2);
        Assert.assertEquals(maxSize + 2, sizeMax.size());
    }

    @Test
    @Override
    public void pushIterable() throws Exception {
        Integer rand1 = nextInt(), rand2 = nextInt();
        empty.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(empty.last(), new Integer(Math.max(rand1, rand2)));
        Assert.assertEquals(2, empty.size());
        size1.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(size1.last(), new Integer(Math.max(rand1, Math.max(rand2, one))));
        Assert.assertEquals(3, size1.size());
        size2.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(size2.last(), new Integer(Math.max(rand1, Math.max(rand2, Math.max(one, two)))));
        Assert.assertEquals(4, size2.size());
        sizeMax.push(Arrays.asList(rand1, rand2));
        Assert.assertEquals(maxSize + 2, sizeMax.size());
    }

    @Test
    @Override
    public void pushIterator() throws Exception {
        Integer rand1 = nextInt(), rand2 = nextInt();
        empty.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(empty.last(), new Integer(Math.max(rand1, rand2)));
        Assert.assertEquals(2, empty.size());
        size1.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(size1.last(), new Integer(Math.max(rand1, Math.max(rand2, one))));
        Assert.assertEquals(3, size1.size());
        size2.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(size2.last(), new Integer(Math.max(rand1, Math.max(rand2, Math.max(one, two)))));
        Assert.assertEquals(4, size2.size());
        sizeMax.push(Arrays.asList(rand1, rand2).iterator());
        Assert.assertEquals(maxSize + 2, sizeMax.size());
    }

    @Test
    @Override
    public void get() throws Exception {
        Assert.assertEquals(one, size1.get(0));
        Assert.assertEquals(new Integer(Math.min(one, two)), size2.get(0));
        Assert.assertEquals(new Integer(Math.max(one, two)), size2.get(1));
    }
}
