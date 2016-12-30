import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.List;

import java.util.Iterator;

public class ListTest extends SequenceTest<List<Integer>> {
    @Test
    @Override
    public void capacity() throws Exception {
        Assert.assertEquals(Integer.MAX_VALUE, empty.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, size1.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, size2.capacity());
        Assert.assertEquals(Integer.MAX_VALUE, sizeMax.capacity());
    }

    @Override
    List<Integer> create() {
        return new List<>();
    }

    @Override
    List<Integer> create(Integer... values) {
        return new List<>(values);
    }

    @Override
    List<Integer> create(Iterable<? extends Integer> iterable) {
        return new List<>(iterable);
    }

    @Override
    List<Integer> create(Iterator<? extends Integer> iterator) {
        return new List<>(iterator);
    }

    @Test
    @Override
    public void resize() throws Exception {

    }
}
