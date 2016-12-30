import org.uael.jds.Stack;

import java.util.Iterator;

/**
 * The type Stack test.
 */
public class StackTest extends ContainerTest<Stack<Integer>> {
    @Override
    Stack<Integer> create() {
        return new Stack<>();
    }

    @Override
    Stack<Integer> create(Integer... values) {
        return new Stack<>(values);
    }

    @Override
    Stack<Integer> create(Iterable<? extends Integer> iterable) {
        return new Stack<>(iterable);
    }

    @Override
    Stack<Integer> create(Iterator<? extends Integer> iterator) {
        return new Stack<>(iterator);
    }
}
