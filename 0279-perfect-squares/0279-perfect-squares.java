import java.util.*;

class Solution {

    public int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(n);
        visited.add(n);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;

            while (size-- > 0) {

                int current = queue.poll();

                for (int i = 1; i * i <= current; i++) {

                    int next = current - i * i;

                    if (next == 0) {
                        return level;
                    }

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return level;
    }
}