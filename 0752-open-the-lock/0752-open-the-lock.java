import java.util.*;

class Solution {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return moves;
                }

                if (dead.contains(current)) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {

                    char[] chars = current.toCharArray();

                    char original = chars[i];

                    chars[i] = original == '9' ? '0' : (char) (original + 1);
                    String next = new String(chars);

                    if (!visited.contains(next) && !dead.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }

                    chars[i] = original == '0' ? '9' : (char) (original - 1);
                    next = new String(chars);

                    if (!visited.contains(next) && !dead.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}