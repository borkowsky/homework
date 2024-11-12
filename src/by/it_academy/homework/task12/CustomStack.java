package by.it_academy.homework.task12;

import java.util.LinkedList;
import java.util.List;

public class CustomStack<E> {
    private final List<E> ITEMS;

    public CustomStack() {
        this.ITEMS = new LinkedList<>();
    }

    public boolean isEmpty() {
        return this.ITEMS.isEmpty();
    }

    public E peek() {
        return this.isEmpty() ? null : this.ITEMS.getLast();
    }

    public E pop() {
        return this.isEmpty() ? null : this.ITEMS.removeLast();
    }

    public E push(E obj) {
        this.ITEMS.add(obj);
        return this.peek();
    }

    public int search(E obj) {
        return this.ITEMS.indexOf(obj);
    }

    @Override
    public String toString() {
        return ITEMS.toString();
    }
}
