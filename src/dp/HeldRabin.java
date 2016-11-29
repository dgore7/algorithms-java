package dp;

import java.util.*;

/**
 * Created by dgore7 on 11/28/2016.
 */
public class HeldRabin {

    private static class Index {
        int currentVertex;
        Set<Integer> vertexSet;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (currentVertex != index.currentVertex) return false;
            return vertexSet != null ? vertexSet.equals(index.vertexSet) : index.vertexSet == null;

        }

        @Override
        public int hashCode() {
            int result = currentVertex;
            result = 31 * result + (vertexSet == null ? 0 : vertexSet.hashCode());
            return result;
        }

        private static Index createIndex(int vertex, Set<Integer> vertexSet) {
            Index i = new Index();
            i.currentVertex = vertex;
            i.vertexSet = vertexSet;
            return i;
        }
    }

    public class SetSizeComparator implements Comparator<Set<Integer>> {
        @Override
        public int compare(Set<Integer> o1, Set<Integer> o2) {
            if (o1.size() < o2.size())
                return -1;
            if (o2.size() < o1.size())
                return 1;
            return 0;
        }
    }

    public int minCost(int[][] distance) {
        // stores intermediate values in map
        Map<Index, Integer> minCostDP   = new HashMap<>();
        Map<Index, Integer> parent      = new HashMap<>();

        List<Set<Integer>> allSets;

        for (Set<Integer> set : allSets) {
            for (int currentVertex = 1; currentVertex < distance.length; currentVertex++) {
                if (set.contains(currentVertex)) continue;
                Index index = Index.createIndex(currentVertex,set);
                int minCost = Integer.MAX_VALUE;
                int minPrevVertex = 0;

                Set<Integer> copySet = new HashSet<>();
                for (int prevVertex : set) {
                    int cost = distance[prevVertex][currentVertex] + getCost(copySet, prevVertex, minCostDP);
                }
            }
        }
    }

    private int getCost(Set<Integer> set, int prevVertex, Map<Index, Integer> minCostDP) {
        set.remove(prevVertex);
        Index index = Index.createIndex(prevVertex, set);
        int cost = minCostDP.get(index);
        set.add(prevVertex);
        return cost;
    }

    private List<Set<Integer>> generateCombinations(int n) {
        int[] input = new int[n];
        for (int i=0; i<input.length; i++)
            input[i] = i+1;
        List<Set<Integer>> allSets= new ArrayList<>();
        int[] result = new int[n];
        generateCombinations(input, 0, 0, allSets, result);
        Collections.sort(allSets, new SetSizeComparator());
        return allSets;
    }

    private void generateCombinations(int[] input, int start, int pos, List<Set<Integer>> allSets, int[] result) {
        if (pos == input.length) return;
        Set<Integer> set = createSet(result, pos);
        allSets.add(set);

        for (int i = start; i < input.length; i++) {
            result[pos] = input[i];
            generateCombinations(input, i+1, pos+1, allSets, result);
        }

    }

    private static Set<Integer> createSet(int[] input, int pos) {
        if (pos == 0)
            return new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pos; i++) {
            set.add(input[i]);
        }
        return set;
    }
}
