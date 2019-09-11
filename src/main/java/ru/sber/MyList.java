package ru.sber;

public class MyList<T> {
    private Entity<T> first;
    private Entity<T> last;
    private int length = 0;

    public int size() {
        return length;
    }

    /**
     * Add new element into the end of list
     *
     * @param t
     */
    public void add(T t) {
        Entity<T> entity = last;
        last = new Entity<>();
        last.value = t;
        last.prev = entity;
        if (entity == null) {
            first = last;
        } else {
            entity.next = last;
        }
        length++;
    }

    /**
     * Add new element into the head of list
     *
     * @param t
     */
    public void addReverse(T t) {
        Entity<T> entity = first;
        first = new Entity<>();
        first.value = t;
        first.next = entity;
        if (entity == null) {
            last = first;
        } else {
            entity.prev = first;
        }
        length++;
    }

    /**
     * Remove first element from list
     *
     * @return true if removed
     */
    public boolean remove() {
        if (first == null) {
            return false;
        }

        Entity<T> iterator = first;
        Entity<T> next = iterator.next;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        length--;

        return true;
    }

    /**
     * Remove last element from list
     *
     * @return true if removed
     */
    public boolean removeLast() {
        if (last == null) {
            return false;
        }

        Entity<T> iterator = last;
        Entity<T> prev = iterator.prev;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        length--;

        return true;
    }

    /**
     * Returns first value or null if not exist
     *
     * @return value
     */
    public T get() {
        if (first == null) {
            return null;
        }

        return first.value;
    }

    /**
     * Returns last value or null if list is empty
     *
     * @return value
     */
    public T getLast() {
        if (last == null) {
            return null;
        }

        return last.value;
    }

    private class Entity<T> {
        T value;
        Entity<T> prev;
        Entity<T> next;
    }

//TODO add/remove into/from middle of list
}
