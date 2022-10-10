// you can also use imports, for example:
// import java.util.*;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
// import java.util.stream;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Vertex implements Comparable<Vertex> {
    public int idx;
    public int degree;
    public Vertex(int i, int d) {
        idx = i;
        degree = d;
    }
    @Override
    public int compareTo(Vertex other) {
        Integer thisDegree = this.degree;
        Integer otherDegree = other.degree;
        return thisDegree.compareTo(otherDegree);
    }
}

class Solution {
    public int solution(int N, int[] A, int[] B) {
        // node with highest degree gets highest number
        // compute degrees

        int[] degrees = new int[N + 1]; // 1 to N, 0 unused
        List<Vertex> verticesList = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int u = A[i];
            int v = B[i];
            degrees[u]++;
            degrees[v]++;
        }
        for (int i = 1; i < degrees.length; i++) {
            verticesList.add(new Vertex(i, degrees[i]));
        }

        Collections.sort(verticesList);
        Collections.reverse(verticesList);
        int sum = 0;
        int a = N;
        for (Vertex v : verticesList) {
            // System.out.println(v.degree);
            sum += v.degree * a;
            a--;
        }
        return sum;

    }
}
