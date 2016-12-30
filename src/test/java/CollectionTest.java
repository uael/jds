import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uael.jds.Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Collection test.
 * @param <U> the type parameter
 */
abstract class CollectionTest<U extends Collection<Integer>> {
    /**
     * The Empty, Size 1, Size 2 and Size Max.
     */
    U empty, /**
     * The Size 1.
     */
    size1, /**
     * The Size 2.
     */
    size2, /**
     * The Size max.
     */
    sizeMax;
    /**
     * The MaxSize.
     */
    int maxSize;
    /**
     * The One and Two.
     */
    Integer one, /**
     * The Two.
     */
    two;

    /**
     * Instantiates a new Collection test.
     */
    CollectionTest() {
        this(50);
    }

    /**
     * Instantiates a new Collection test.
     * @param maxSize the max size
     */
    CollectionTest(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Clear.
     * @throws Exception the exception
     */
    @Test
    public void clear() throws Exception {
        size1.clear();
        Assert.assertTrue(size1.isEmpty());
        size2.clear();
        Assert.assertTrue(size2.isEmpty());
        sizeMax.clear();
        Assert.assertTrue(sizeMax.isEmpty());
    }

    /**
     * Create u.
     * @return the u
     */
    abstract U create();

    /**
     * Create u.
     * @param values the values
     * @return the u
     */
    abstract U create(Integer... values);

    /**
     * Create u.
     * @param iterable the iterable
     * @return the u
     */
    abstract U create(Iterable<? extends Integer> iterable);

    /**
     * Create u.
     * @param iterator the iterator
     * @return the u
     */
    abstract U create(Iterator<? extends Integer> iterator);

    /**
     * Is empty.
     * @throws Exception the exception
     */
    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(empty.isEmpty());
        Assert.assertFalse(size1.isEmpty());
        Assert.assertFalse(size2.isEmpty());
        Assert.assertFalse(sizeMax.isEmpty());
    }

    /**
     * Iterator.
     * @throws Exception the exception
     */
    @Test
    public void iterator() throws Exception {
        Iterator<Integer> it = empty.iterator();
        Assert.assertFalse(it.hasNext());
        Assert.assertNull(it.next());
        it = size1.iterator();
        for (int i = 0; i < 1; i++) {
            Assert.assertTrue(it.hasNext());
            Assert.assertNotNull(it.next());
        }
        Assert.assertFalse(it.hasNext());
        Assert.assertNull(it.next());
        it = size2.iterator();
        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(it.hasNext());
            Assert.assertNotNull(it.next());
        }
        Assert.assertFalse(it.hasNext());
        Assert.assertNull(it.next());
        it = sizeMax.iterator();
        for (int i = 0; i < maxSize; i++) {
            Assert.assertTrue(it.hasNext());
            Assert.assertNotNull(it.next());
        }
        Assert.assertFalse(it.hasNext());
        Assert.assertNull(it.next());
    }

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

    /**
     * Sets up.
     * @throws Exception the exception
     */
    @SuppressWarnings({"unchecked", "ArraysAsListWithZeroOrOneArgument"})
    @Before
    public void setUp() throws Exception {
        empty = create();
        Integer[] data = new Integer[maxSize];
        for (int i = 0; i < maxSize; i++) {
            data[i] = nextInt();
        }
        one = nextInt();
        two = nextInt();
        if (one.equals(two)) {
            two++;
        }
        switch (nextInt(1, 3)) {
            case 1: {
                size1 = create(one);
                size2 = create(one, two);
                sizeMax = create(data);
                break;
            }
            case 2: {
                size1 = create(Arrays.asList(one));
                size2 = create(Arrays.asList(one, two));
                sizeMax = create(Arrays.asList(data));
                break;
            }
            case 3: {
                size1 = create(Arrays.asList(one).iterator());
                size2 = create(Arrays.asList(one, two).iterator());
                sizeMax = create(Arrays.asList(data).iterator());
                break;
            }
        }
    }

    /**
     * Size.
     * @throws Exception the exception
     */
    @Test
    public void size() throws Exception {
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(1, size1.size());
        Assert.assertEquals(2, size2.size());
        Assert.assertEquals(maxSize, sizeMax.size());
    }
}