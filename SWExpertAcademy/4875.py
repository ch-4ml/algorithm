import sys
sys.stdin = open("input/4875_input.txt", "r")

def find(matrix, target):
    size = len(matrix)
    return [ (x, y) for x in range(size) for y in range(size) if maze[y][x] == target ]

def clockwise_inspect(matrix, coordinates):
    size = len(matrix)
    stack = []
    x, y = coordinates
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]
    for i in range(4):
        target_x = x + dx[i]
        target_y = y + dy[i]
        if 0 < target_x, target_y < size - 1:  # 이게 되나?
            if matrix[target_y][target_x] == 0:
                stack.append
            elif matrix[target_y][target_x] == 3:
                return 1
            

T = int(input())
for test_case in range(1, T + 1):
    maze = []
    for _ in range(int(input())):
        maze.append(list(map(int, input())))
    start = find(maze, 2)[0]
    fin = find(maze, 3)[0]
