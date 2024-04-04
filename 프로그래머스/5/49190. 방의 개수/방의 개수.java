import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Vertex {
        int r; // row
        int c; // column

        public Vertex(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex vertex = (Vertex) o;
            return r == vertex.r && c == vertex.c;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(r * 10 + c).hashCode();
        }
    }

    static class Edge {
        int r; // row
        int c; // column
        int d; // direction

        int[] cross = {0, -1, 0, 1};

        public Edge(int r, int c, int d) {
            this.r = d < 4 ? r : r + dr[d];
            this.c = d < 4 ? c : c + dc[d];
            this.d = d < 4 ? d : d - 4;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Edge)) return false;
            Edge edge = (Edge) o;
            return r == edge.r && c == edge.c && d == edge.d;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(r * 100 + c * 10 + d).hashCode();
        }

        public Edge getCrossedEdge() {
            if (d % 2 == 0) return null;
            int cr = r + cross[d];
            int cd = d == 1 ? 3 : 1;
            return new Edge(cr, c, cd);
        }
    }

    public int solution(int[] arrows) {
        int answer = 0;

        Set<Vertex> vertices = new HashSet<>();
        Set<Edge> edges = new HashSet<>();

        int r = 0;
        int c = 0;

        vertices.add(new Vertex(r, c));

        int vCount = 1;
        int eCount = 0;
        for (int d : arrows) {
            Edge edge = new Edge(r, c, d);
            edges.add(edge);

            int nr = r + dr[d];
            int nc = c + dc[d];

            // 새로운 간선인 경우
            if (eCount != edges.size()) {
                vertices.add(new Vertex(nr, nc));

                // 이미 방문한 정점인 경우
                if (vCount == vertices.size()) answer += 1;

                // 이번 간선이 대각선이고, 가로지르는 대각선이 존재하는 경우
                if (d % 2 == 1 && edges.contains(edge.getCrossedEdge())) answer += 1;
            }

            r = nr;
            c = nc;
            vCount = vertices.size();
            eCount = edges.size();
        }

        return answer;
    }


}