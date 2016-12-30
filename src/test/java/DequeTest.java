import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.Deque;

import java.util.Iterator;

public class DequeTest extends SequenceTest<Deque<Integer>> {
    @Override
    @Test
    public void capacity() throws Exception {
        Assert.assertEquals(Integer.MAX_VALUE, empty.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, size1.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, size2.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, sizeMax.capacity());
    }

    @Override
    @Test
    public void resize() throws Exception {

    }

    @Override
    @Test
    public void iteratorEmpty() throws Exception {
        super.iteratorEmpty();
    }

    @Override
    Deque<Integer> create() {
        return new Deque<>();
    }

    @Override
    Deque<Integer> create(Integer... values) {
        return new Deque<>(values);
    }

    @Override
    Deque<Integer> create(Iterable<? extends Integer> iterable) {
        return new Deque<>(iterable);
    }

    @Override
    Deque<Integer> create(Iterator<? extends Integer> iterator) {
        return new Deque<>(iterator);
    }
}
