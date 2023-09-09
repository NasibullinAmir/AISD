package Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
    public static List<Integer> findIntersection(int[] x, int[] y) {
        // Создаем хэш-таблицы для подсчета кратностей элементов в массивах x и y
        Map<Integer, Integer> countX = new HashMap<>();
        Map<Integer, Integer> countY = new HashMap<>();

        // Подсчитываем кратности элементов в массивах
        for (int num : x) {
            countX.put(num, countX.getOrDefault(num, 0) + 1);
        }

        for (int num : y) {
            countY.put(num, countY.getOrDefault(num, 0) + 1);
        }

        // Создаем список для хранения пересечения
        List<Integer> intersection = new ArrayList<>();

        for (int num : x) {
            if (countX.get(num) > 0 && countY.containsKey(num)) {
                // Добавление общего элемента
                intersection.add(num);

                // Уменьшаем кратности элемента в обеих хэш-таблицах
                countX.put(num, countX.get(num) - 1);
                countY.put(num, countY.get(num) - 1);
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 2, 3, 4};
        int[] y = {2, 2, 3, 5};

        List<Integer> intersection = findIntersection(x, y);
        System.out.println("Пересечение массивов x и y: " + intersection);
    }
}
