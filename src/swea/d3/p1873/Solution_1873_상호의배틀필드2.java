package swea.d3.p1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1873_상호의배틀필드2 {
	
	static final char LAND = '.';
	static final char BRICK = '*';
	static final char IRON = '#';
	static final char WATER = '-';
	static int h, w, x, y;
	static char direction;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t < T + 1; t++) {			
			// Draw map
			String[] params = in.readLine().split(" ");
			h = Integer.parseInt(params[0]);
			w = Integer.parseInt(params[1]);
			map = new char[h][w];
			for(int i = 0; i < h; i++) {
				map[i] = in.readLine().toCharArray();
			}
			
			// Find position of tank
			find:
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
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
			for(int i = 0; i < N; i++) {
				action(actions[i]);
			}
			
			// Print result
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				if(i < h-1) sb.append("\n");
			}
			System.out.println(sb);
		}
	}
	
	// direction | 탱크가 바라보는 방향 | ^: 상, v: 하, <: 좌, >: 우
	static void action(char action) {
		switch(action) {
		case 'U':
			direction = '^';
			map[y][x] = direction;
			if(y > 0 && map[y-1][x] == LAND) {
				map[y-1][x] = '^';
				map[y][x] = LAND;
				y--;
			}
			break;
		case 'D':
			direction = 'v';
			map[y][x] = direction;
			if(y < h-1 && map[y+1][x] == LAND) {
				map[y+1][x] = 'v';
				map[y][x] = LAND;
				y++;
			}
			break;
		case 'L':
			direction = '<';
			map[y][x] = direction;
			if(x > 0 && map[y][x-1] == LAND) {
				map[y][x-1] = '<';
				map[y][x] = LAND;
				x--;
			}
			break;
		case 'R':
			direction = '>';
			map[y][x] = direction;
			if(x < w-1 && map[y][x+1] == LAND) {
				map[y][x+1] = '>';
				map[y][x] = LAND;
				x++;
			}
			break;
		case 'S':
			int nx = x;
			int ny = y;
			switch(direction) {
			case '^':
				while(ny > 0) {
					ny--;
					if(map[ny][x] == BRICK) {
						map[ny][x] = LAND;
						break;
					} else if(map[ny][x] == IRON) break;
				}
				break;
			case 'v':
				while(ny < h-1) {
					ny++;
					if(map[ny][x] == BRICK) {
						map[ny][x] = LAND;
						break;
					} else if(map[ny][x] == IRON) break;
				}
				break;
			case '<':
				while(nx > 0) {
					nx--;
					if(map[y][nx] == BRICK) {
						map[y][nx] = LAND;
						break;
					} else if(map[y][nx] == IRON) break;
				}
				break;
			case '>':
				while(nx < w-1) {
					nx++;
					if(map[y][nx] == BRICK) {
						map[y][nx] = LAND;
						break;
					} else if(map[y][nx] == IRON) break;
				}
				break;
			}
			break;
		}
	}
}