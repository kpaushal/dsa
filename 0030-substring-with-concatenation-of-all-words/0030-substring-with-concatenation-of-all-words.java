import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int totalWords = words.length;

        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int matched = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (wordCount.containsKey(word)) {

                    window.put(word,
                            window.getOrDefault(word, 0) + 1);

                    matched++;

                    while (window.get(word) > wordCount.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLength);

                        window.put(leftWord,
                                window.get(leftWord) - 1);

                        left += wordLength;
                        matched--;
                    }

                    if (matched == totalWords) {

                        result.add(left);

                        String leftWord =
                                s.substring(left, left + wordLength);

                        window.put(leftWord,
                                window.get(leftWord) - 1);

                        left += wordLength;
                        matched--;
                    }

                } else {

                    window.clear();
                    matched = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}