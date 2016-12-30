import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.Sequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

abstract class SequenceTest<U extends Sequence<Integer>> extends ContainerTest<U> {
    @Override
    @Test(expected = AssertionError.class)
    public void iteratorEmpty() throws Exception {
        super.iteratorEmpty();
    }

    @Test
    public abstract void capacity() throws Exception;

    @Test
    public void contains() throws Exception {
        Assert.assertFalse(empty.contains(one));
        Assert.assertFalse(empty.contains(two));
        Assert.assertTrue(size1.contains(one));
        Assert.assertFalse(size1.contains(two));
        Assert.assertTrue(size2.contains(one));
        Assert.assertTrue(size2.contains(two));
    }

    @Test
    public void containsArray() throws Exception {
        Assert.assertFalse(empty.contains(one, two));
        Assert.assertFalse(size1.contains(one, two));
        Assert.assertTrue(size2.contains(one, two));
    }

    @Test
    public void containsIterable() throws Exception {
        Assert.assertTrue(empty.contains(Collections.emptyList()));
        Assert.assertFalse(empty.contains(Collections.singletonList(one)));
        Assert.assertFalse(empty.contains(Arrays.asList(one, two)));
        Assert.assertTrue(size1.contains(Collections.emptyList()));
        Assert.assertTrue(size1.contains(Collections.singletonList(one)));
        Assert.assertFalse(size1.contains(Arrays.asList(one, two)));
        Assert.assertTrue(size2.contains(Collections.emptyList()));
        Assert.assertTrue(size2.contains(Collections.singletonList(one)));
        Assert.assertTrue(size2.contains(Arrays.asList(one, two)));
    }

    @Test
    public void containsIterator() throws Exception {
        Assert.assertTrue(empty.contains(empty.iterator()));
        Assert.assertFalse(empty.contains(size1.iterator()));
        Assert.assertFalse(empty.contains(size2.iterator()));
        Assert.assertTrue(size1.contains(empty.iterator()));
        Assert.assertTrue(size1.contains(size1.iterator()));
        Assert.assertFalse(size1.contains(size2.iterator()));
        Assert.assertTrue(size2.contains(empty.iterator()));
        Assert.assertTrue(size2.contains(size1.iterator()));
        Assert.assertTrue(size2.contains(size2.iterator()));
    }

    @Test
    public void erase() throws Exception {
        Assert.assertFalse(empty.erase(one));
        Assert.assertFalse(empty.erase(two));
        Assert.assertTrue(size1.erase(one));
        Assert.assertEquals(0, size1.size());
        Assert.assertFalse(size1.erase(two));
        Assert.assertTrue(size2.erase(one));
        Assert.assertEquals(1, size2.size());
        Assert.assertTrue(size2.erase(two));
        Assert.assertEquals(0, size2.size());
    }

    @Test
    public void eraseArray() throws Exception {
        Assert.assertFalse(empty.erase(one, two));
        Assert.assertFalse(size1.erase(one, two));
        Assert.assertEquals(0, size1.size());
        Assert.assertTrue(size2.erase(one, two));
        Assert.assertEquals(0, size2.size());
    }

    @Test
    public void eraseIterable() throws Exception {
        Assert.assertTrue(empty.erase(Collections.emptyList()));
        Assert.assertFalse(empty.erase(Collections.singletonList(one)));
        Assert.assertFalse(empty.erase(Arrays.asList(one, two)));
        Assert.assertTrue(size1.erase(Collections.emptyList()));
        Assert.assertEquals(1, size1.size());
        Assert.assertTrue(size1.erase(Collections.singletonList(one)));
        Assert.assertEquals(0, size1.size());
        Assert.assertFalse(size1.erase(Arrays.asList(one, two)));
        Assert.assertEquals(0, size1.size());
        Assert.assertTrue(size2.erase(Collections.emptyList()));
        Assert.assertEquals(2, size2.size());
        Assert.assertTrue(size2.erase(Collections.singletonList(one)));
        Assert.assertEquals(1, size2.size());
        Assert.assertFalse(size2.erase(Arrays.asList(one, two)));
        Assert.assertEquals(0, size2.size());
    }

    @Test
    public void eraseIterator() throws Exception {
        Assert.assertTrue(empty.erase(Collections.emptyList().iterator()));
        Assert.assertFalse(empty.erase(Collections.singletonList(one).iterator()));
        Assert.assertFalse(empty.erase(Arrays.asList(one, two).iterator()));
        Assert.assertTrue(size1.erase(Collections.emptyList().iterator()));
        Assert.assertEquals(1, size1.size());
        Assert.assertTrue(size1.erase(Collections.singletonList(one).iterator()));
        Assert.assertEquals(0, size1.size());
        Assert.assertFalse(size1.erase(Arrays.asList(one, two).iterator()));
        Assert.assertEquals(0, size1.size());
        Assert.assertTrue(size2.erase(Collections.emptyList().iterator()));
        Assert.assertEquals(2, size2.size());
        Assert.assertTrue(size2.erase(Collections.singletonList(one).iterator()));
        Assert.assertEquals(1, size2.size());
        Assert.assertFalse(size2.erase(Arrays.asList(one, two).iterator()));
        Assert.assertEquals(0, size2.size());
    }

    @Test
    public void filterNull() throws Exception {

    }

    @Test
    public void filter() throws Exception {

    }

    @Test(expected = NoSuchElementException.class)
    public void getEmpty() throws Exception {
        Assert.assertNull(empty.get(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void getFail() throws Exception {
        Assert.assertNull(size1.get(1));
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(one, size1.get(0));
        Assert.assertEquals(one, size2.get(0));
        Assert.assertEquals(two, size2.get(1));
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertArray() throws Exception {

    }

    @Test
    public void insertIterable() throws Exception {

    }

    @Test
    public void insertIterator() throws Exception {

    }

    @Test
    public abstract void resize() throws Exception;

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void set() throws Exception {

    }

    @Test
    public void shift() throws Exception {

    }

    @Test
    public void slice() throws Exception {

    }

    @Test
    public void unshift() throws Exception {

    }

    @Test
    public void unshiftArray() throws Exception {

    }

    @Test
    public void unshiftIterable() throws Exception {

    }

    @Test
    public void unshiftIterator() throws Exception {

    }
}