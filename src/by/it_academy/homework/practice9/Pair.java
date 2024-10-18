package by.it_academy.homework.practice9;

//    Реализовать класс Pair, который будет содержать 2 значения любого типа. Класс умеет выводить:
//    first() - возвращает 1ый элемент
//    last() - возвращает 2ой элемент
//** swap() - меняет элементы местами**
//    replaceFirst() - заменяет 1ый элемент на новый
//    replaceLast() - заменяет 2ой элемент на новый

public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T first() {
        return first;
    }

    public T second() {
        return second;
    }

    public void swap() {
        T temp = first;
        first = second;
        second = temp;
    }

    public void replaceFirst(T item) {
        first = item;
    }

    public void replaceLast(T item) {
        second = item;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
