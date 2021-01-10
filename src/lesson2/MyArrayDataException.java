package lesson2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int row, int column) {
        super("Ошибка! Не удалось преобразовать значение в массиве. Строка: " + row + ". Столбец: " + column);
    }
}
