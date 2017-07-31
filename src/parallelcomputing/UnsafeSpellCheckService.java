package parallelcomputing;

import java.util.LinkedHashMap;
import java.util.Map;

public class UnsafeSpellCheckService {
    private static final int MAX_ENTRIES = 3;

    private static LinkedHashMap<String, String[]> cahcedClosestStrings = new LinkedHashMap<String, String[]>() {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    };
}
