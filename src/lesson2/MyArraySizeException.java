package lesson2;

public class MyArraySizeException extends IndexOutOfBoundsException {
    public MyArraySizeException() {
        super("Ошибка! Максимальный размер двумерного массива 4 x 4");
    }
}
