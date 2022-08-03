package swea.d3.p1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1873_상호의배틀필드 {

	static final char LAND = '.';
	static final char BRICK = '*';
	static final char IRON = '#';
	static final char WATER = '-';
	static final char[] DIRECTIONS_CHAR = { 'U', 'D', 'L', 'R' };
	static final char[] DIRECTIONS_SIGN = { '^', 'v', '<', '>' };
	static final int[] dx = { 0, 0, -1, 1 };
	static final int[] dy = { -1, 1, 0, 0 };
	static int h, w, x, y;
	static char direction;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t < T + 1; t++) {
			// Draw map
			String[] params = in.readLine().split(" ");
			h = Integer.parseInt(params[0]);
			w = Integer.parseInt(params[1]);
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = in.readLine().toCharArray();
			}

			// Find position of tank
			find: for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (indexOf(DIRECTIONS_SIGN, map[i][j]) > -1) {
						direction = map[i][j];
						x = j;
						y = i;
						break find;
					}
				}
			}

			// Action
			int N = Integer.parseInt(in.readLine());
			char[] actions = in.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				action(actions[i]);
			}

			// Print result
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				if (i < h - 1)
					sb.append("\n");
			}
			System.out.println(sb);
		}
	}

	static int indexOf(char[] characters, char character) {
		int result = -1;
		int len = characters.length;
		for (int i = 0; i < len; i++) {
			if (characters[i] == character) {
				result = i;
				break;
			}
		}
		return result;
	}

	// Action
	static void action(char action) {
		int nx, ny;
		int dcIdx = indexOf(DIRECTIONS_CHAR, action);
		// Move
		if (dcIdx > -1) {
			nx = x + dx[dcIdx];
			ny = y + dy[dcIdx];
			direction = DIRECTIONS_SIGN[dcIdx];
			map[y][x] = direction;
			if (nx > -1 && ny > -1 && nx < w && ny < h && map[ny][nx] == LAND) {
				map[ny][nx] = DIRECTIONS_SIGN[dcIdx];
				map[y][x] = LAND;
				x = nx;
				y = ny;
			}
			// Shoot
		} else {
			int dsIdx = indexOf(DIRECTIONS_SIGN, direction);
			nx = x + dx[dsIdx];
			ny = y + dy[dsIdx];
			while (nx > -1 && ny > -1 && nx < w && ny < h) {
				if (map[ny][nx] == BRICK) {
					map[ny][nx] = LAND;
					break;
				} else if (map[ny][nx] == IRON)
					break;
				nx += dx[dsIdx];
				ny += dy[dsIdx];
			}
		}
	}
}
