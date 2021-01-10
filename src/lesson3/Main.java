package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------Первое задание---------");
        List asList = Arrays.asList("product1", "product2", "product2", "product2", "product2", "product3", "product4" , "product4", "product4");
        Set<String> mySet = new LinkedHashSet<>(asList);
        for(String s : mySet) {
            System.out.println(String.format("Object: %s (%d)", s, Collections.frequency(asList, s)));
        }
        System.out.println("---------Второе задание---------");
        Phonebook.addNewNote("surname1" ,"0(000)000-00-00");
        Phonebook.addNewNote("surname1" ,"1(111)111-11-11");
        Phonebook.addNewNote("surname2" ,"2(222)222-22-22");
        Phonebook.addNewNote("surname3" ,"3(333)333-33-33");

        Phonebook.findPerson("surname1");

    }
}
