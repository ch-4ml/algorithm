import sys
sys.stdin = open("input/4875_input.txt", "r")

def find(matrix, target):
    size = len(matrix)
    return [ (x, y) for x in range(size) for y in range(size) if maze[y][x] == target ]

def clockwise_inspect(matrix, coordinates):
    size = len(matrix)
    x, y = coordinates
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]
    for i in range(4):
        target_x = x + dx[i]
        target_y = y + dy[i]
        if not -1 < target_x < size or not -1 < target_y < size:
            continue
        elif matrix[target_y][target_x] == 1:
            continue
        else:
            return (target_x, target_y)
    return ()

T = int(input())
for test_case in range(1, T + 1):
    answer = 0
    maze = []
    stack = []
    for _ in range(int(input())):
        maze.append(list(map(int, input())))

    current = find(maze, 2)[0]
    fin = find(maze, 3)[0]

    stack.append(current)
    while stack:
        result = clockwise_inspect(maze, stack[-1])
        if result == fin:
            answer = 1
            break
        elif result:
            res_x, res_y = stack[-1]
            maze[res_y][res_x] = 1
            stack.append(result)
        else:
            res_x, res_y = stack.pop()
            maze[res_y][res_x] = 1
    
    print('#{} {}'.format(test_case, answer))