
import java.util.HashMap;
import java.util.Set;

//Реализовать частотный словарь слов русского языка (на вход принимается текст любой размерности)
public class Frequency_dictionary {
    String text;

    void Set_dict(String text) {
        HashMap<String, Integer> frequency_dict = new HashMap<>();
        //Удаляем все знаки в тексте и переводим в нижний регистр
        String new_text = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "").toLowerCase();
        //Удаляем лишние пробелы
        while (new_text.contains("  ")){
            new_text = new_text.replaceAll("  ", " ");
        }
        System.out.println(new_text);
        System.out.println("------------------------");
        // Создаем строку слов
        String[] arr = new_text.split(" ");

        /* Итерируем по словам.
        Если map не содержит слово как ключ, то мы добавляем его и присваиваем значение 1(т.е.встречается один раз).
        Либо мы ищем значение по этому ключу и увеличиваем счетчик повторений.
         */
        for (String i : arr) {
            if (frequency_dict.containsKey(i)) {
                frequency_dict.put(i, frequency_dict.get(i) + 1);
            }
            else {
                frequency_dict.put(i, 1);
            }
        }
        // Создаем список ключей
        Set<String> keys = frequency_dict.keySet();
        System.out.println(keys);
        // Итерируем по ключам и выводим в консоль
        for (String key : keys) {
                System.out.println(key + " : " + frequency_dict.get(key));
        }
    }
}