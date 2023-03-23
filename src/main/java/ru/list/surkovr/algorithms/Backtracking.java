package ru.list.surkovr.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    // На входе имеется множество элементов, требуется найти все возможные сочетания
    // Алгоритм Восстановление (Бэктрэкинг) рекурсивно находит все возможные сочетания

    public static void backtrack(int[] src, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == src.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (visited[i]) continue;
            list.add(src[i]);
            visited[i] = true;
            backtrack(src, visited, list, result);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
