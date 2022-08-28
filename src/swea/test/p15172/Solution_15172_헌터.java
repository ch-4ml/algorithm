package swea.test.p15172;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Piece {
	int id, r, c;
	boolean opened, visited;

	public Piece(int id, int r, int c, boolean opened, boolean visited) {
		super();
		this.id = id;
		this.r = r;
		this.c = c;
		this.opened = opened; // 0: 불가, 1: 가능
		this.visited = visited; // 0: 미방문, 1: 방문
	}

	public int getDistance(Piece p) {
		return Math.abs(this.r - p.r) + Math.abs(this.c - p.c);
	}

	@Override
	public String toString() {
		return "id=" + id;
	}

}

public class Solution_15172_헌터 {

	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			int N = Integer.parseInt(in.readLine());

			List<Piece> pieces = new ArrayList<>();
			// 헌터 추가
			Piece hunter = new Piece(0, 1, 1, false, true);

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if (value == 0)
						continue;
					else if (value < 0)
						pieces.add(new Piece(value, i, j, false, false));
					else
						pieces.add(new Piece(value, i, j, true, false));
				}
			}

			pieces.sort(new Comparator<Piece>() {
				@Override
				public int compare(Piece o1, Piece o2) {
					return o1.id - o2.id;
				}
			});

			dfs(pieces, hunter, pieces.size(), 0, 0);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	static void dfs(List<Piece> pieces, Piece start, int size, int count, int distance) {
		if (count == size) {
			min = min > distance ? distance : min;
			return;
		}

		for (int i = 0; i < size; i++) {
			Piece next = pieces.get(i);
			if (next.visited || !next.opened)
				continue;

			next.visited = true;
			if (next.id > 0)
				pieces.get(size / 2 - pieces.get(i).id).opened = true;

			dfs(pieces, next, size, count + 1, distance + start.getDistance(next));

			next.visited = false;
			if (next.id > 0)
				pieces.get(size / 2 - pieces.get(i).id).opened = false;
		}
	}
}
