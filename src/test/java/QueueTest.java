import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.Queue;

import java.util.Iterator;

/**
 * The type Queue test.
 */
public class QueueTest extends ContainerTest<Queue<Integer>> {
    @Override
    Queue<Integer> create() {
        return new Queue<>();
    }

    @Override
    Queue<Integer> create(Integer... values) {
        return new Queue<>(values);
    }

    @Override
    Queue<Integer> create(Iterable<? extends Integer> iterable) {
        return new Queue<>(iterable);
    }

    @Override
    Queue<Integer> create(Iterator<? extends Integer> iterator) {
        return new Queue<>(iterator);
    }

    @Test
    @Override
    @SuppressWarnings("Duplicates")
    public void pop() throws Exception {
        Assert.assertNull(empty.pop());
        Assert.assertEquals(0, empty.size());
        Assert.assertEquals(one, size1.pop());
        Assert.assertEquals(0, size1.size());
        Assert.assertEquals(one, size2.pop());
        Assert.assertEquals(1, size2.size());
        Assert.assertEquals(two, size2.pop());
        Assert.assertEquals(0, size2.size());
        Assert.assertNotNull(sizeMax.pop());
        Assert.assertEquals(maxSize - 1, sizeMax.size());
    }
}
