import sys
sys.stdin = open('input/5105_input.txt', 'r')

def find(matrix, target):
    return [ (x, y) for y in range(n) for x in range(n) if matrix[y][x] == target ]

def clockwise_inspect(matrix, coordiates):
    x, y = coordiates
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]
    last = ()
    for i in range(4):
        target_x = x + dx[i]
        target_y = y + dy[i]   
        if not -1 < target_x < n or not -1 < target_y < n:
            continue
        elif matrix[target_y][target_x] == 1 or visited[target_y][target_x]:
            continue
        else:
            return (target_x, target_y)
    return ()

T = int(input())
for test_case in range(1, T + 1):
    result = 0
    n = int(input())
    maze = [ list(map(int, input())) for _ in range(n) ]
    visited = [ [ False for _ in range(n) ] for _ in range(n) ]
    begin = find(maze, 2)[0]
    end = find(maze, 3)[0]
    stack = []
    stack.append(begin)
    while stack:
        cur_x, cur_y = stack[-1]
        visited[cur_y][cur_x] = True
        new = clockwise_inspect(maze, (cur_x, cur_y))
        if new == end:
            result = len(stack) - 1
            break
        elif new:
            stack.append(new)
        else:
            stack.pop()
    
    print('#{} {}'.format(test_case, result))