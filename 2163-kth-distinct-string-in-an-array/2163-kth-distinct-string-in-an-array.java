class Solution {
     public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        List<String> distinctStrings = new ArrayList<>();
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) {
                distinctStrings.add(str);
            }
        }

        return k <= distinctStrings.size() ? distinctStrings.get(k - 1) : "";
    }
}