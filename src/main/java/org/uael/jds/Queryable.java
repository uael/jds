package org.uael.jds;

/**
 * The interface Queryable.
 *
 * @param <T> the type parameter
 */
public interface Queryable<T> extends Sequence<T> {
    /**
     * Count int.
     *
     * @return the int
     */
    default int count() {
        return this.size();
    }

    /**
     * Count int.
     *
     * @param predicate the predicate
     * @return the int
     */
    int count(Predicate<Boolean, T> predicate);

    /**
     * Select list.
     *
     * @param <U> the type parameter
     * @return the list
     */
    @SuppressWarnings("unchecked")
    default <U> List<U> select() {
        return this.select((x) -> (U) x);
    }

    /**
     * Select list.
     *
     * @param <U>       the type parameter
     * @param predicate the predicate
     * @return the list
     */
    <U> List<U> select(Predicate<U, T> predicate);

    /**
     * Where list.
     *
     * @param predicate the predicate
     * @return the list
     */
    List<T> where(Predicate<Boolean, T> predicate);
}
