import org.junit.Assert;
import org.junit.Test;
import org.uael.jds.Vector;

import java.util.Iterator;

public class VectorTest extends SequenceTest<Vector<Integer>> {
    @Override
    Vector<Integer> create() {
        return new Vector<>();
    }

    @Override
    Vector<Integer> create(Integer... values) {
        return new Vector<>(values);
    }

    @Override
    Vector<Integer> create(Iterable<? extends Integer> iterable) {
        return new Vector<>(iterable);
    }

    @Override
    Vector<Integer> create(Iterator<? extends Integer> iterator) {
        return new Vector<>(iterator);
    }

    @Test
    @Override
    public void capacity() throws Exception {

    }

    @Test
    @Override
    public void getEmpty() throws Exception {
        Assert.assertNull(empty.get(0));
    }

    @Test
    @Override
    public void getFail() throws Exception {
        Assert.assertNull(size1.get(1));
    }

    @Test
    @Override
    public void resize() throws Exception {

    }
}
