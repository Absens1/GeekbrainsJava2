package lesson3;

import java.util.*;

public class Phonebook {

    private static Map<String, List<String>> book = new LinkedHashMap<>();

    public static void addNewNote(String surname, String number) {
        if(book.containsKey(surname)){
            List<String> numbers = book.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
            }
        } else {
            book.put(surname, new ArrayList<>(Arrays.asList(number)));
        }
        System.out.println(String.format("Номер %s успешно добавлен для фамилии %s", number, surname));
    }

    public static void findPerson(String surname) {
        if(book.containsKey(surname)){
            System.out.println(String.format("Список номеров для фамилии %s \n%s", surname, book.get(surname)));
        } else {
            System.out.println(String.format("Нет записи для фамилии %s", surname));
        }
    }
}
