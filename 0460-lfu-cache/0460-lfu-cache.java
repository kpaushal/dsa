import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {

    class Node {
        int key;
        int value;
        int frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private int capacity;
    private int minFrequency;

    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencyMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.minFrequency = 0;

        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        updateFrequency(cache.get(key));

        return cache.get(key).value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {

            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (cache.size() == capacity) {

            LinkedHashSet<Integer> keys =
                    frequencyMap.get(minFrequency);

            int removeKey = keys.iterator().next();

            keys.remove(removeKey);

            if (keys.isEmpty()) {
                frequencyMap.remove(minFrequency);
            }

            cache.remove(removeKey);
        }

        Node node = new Node(key, value);

        cache.put(key, node);

        frequencyMap
                .computeIfAbsent(1, k -> new LinkedHashSet<>())
                .add(key);

        minFrequency = 1;
    }

    private void updateFrequency(Node node) {

        int freq = node.frequency;

        LinkedHashSet<Integer> keys =
                frequencyMap.get(freq);

        keys.remove(node.key);

        if (keys.isEmpty()) {

            frequencyMap.remove(freq);

            if (minFrequency == freq) {
                minFrequency++;
            }
        }

        node.frequency++;

        frequencyMap
                .computeIfAbsent(node.frequency,
                        k -> new LinkedHashSet<>())
                .add(node.key);
    }
}