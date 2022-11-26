import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/*
Создать два списка LinkedList и ArrayList
Измерить, сколько времени занимает 10 тысяч вызовов get 
для каждого списка (от 1  до 10001).
Метод getTimeMsOfGet должен вернуть время своего исполнения в миллисекундах.

Описание решения:
Метод main вызывает метод getTimeMsOfGet и метод fill.
Метод fill(List list) делает 10 тысяч вставок элементов в список.
Метод get10000(List list) производит 10 тысяч вызовов get для списка.
Метод getTimeMsOfGet возвращает время в миллисекундах, 
которое занимает 10 тысяч вызовов get для списка.
Программа выводит время в миллисекундах на экран.
*/
public class GetListArr {
    public static void main(String[] args) {
        System.out.println(getTimeMsOfGet(fill(new ArrayList())));
        System.out.println(getTimeMsOfGet(fill(new LinkedList())));
    }

    public static List fill(List list) {
        for (int i = 1; i < 10001; i++) {
            list.add(new Object());
        }
        return list;
    }

    public static long getTimeMsOfGet(List list) {
        
        Date dateAfter = new Date();
        get10000(list);

        Date dateBefore = new Date();
        return dateBefore.getTime() -dateAfter.getTime();
    }

    public static void get10000(List list) {
        if (list.isEmpty()) return;
        int x = list.size() / 2;

        for (int i = 1; i < 10001; i++) {
            list.get(x);
        }
    }
}