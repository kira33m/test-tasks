package word_counter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        // Ввод строки и числа n
        String text = sc.nextLine().toLowerCase().replaceAll("[\\p{Punct}]+", " ");
        int n = sc.nextInt();
        // Подсчёт слов
        String[] words = text.trim().split("\\s+");
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String w : words) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }
        // Вывод слов, встречающихся ровно n раз
        boolean found = false;
        for (var entry : countMap.entrySet()) {
            if (entry.getValue() == n) {
                System.out.print(entry.getKey() + " ");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("NO");
        }
        }
    }
}
