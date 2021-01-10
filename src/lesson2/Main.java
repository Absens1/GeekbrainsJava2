package lesson2;

public class Main {

    public static void main(String[] args) {
        //Создание двумерного массива
        String[][] array = new String[4][4];
        //Заполнение массива с помощью циклов
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf(i * j);
            }
        }
        // Вызов метода конвертации и сложения содержимого массива, передача массива. Вывод результата
        System.out.println("Сумма содержимого массива: " + mergeArrayElements(array));
    }

    public static int mergeArrayElements(String arr[][]) {
        // Если размер массива превышает 4x4, кинуть исключение
        if (arr.length > 4 || arr[0].length > 4) throw new MyArraySizeException();
        int sum = 0;
        // Цикл по всему массиву
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    // Конвертация из стоки в цифру и подсчет суммы
                    sum += Integer.parseInt(arr[i][j]);
                }
                // Вызов исключения в случае, если символ в массиве не удастся конвертировать в цифру
                catch (NumberFormatException a){
                    throw new MyArrayDataException(1,2);
                }
            }
        }
        return sum;
    }
}



