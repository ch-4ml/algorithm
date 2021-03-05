import sys
sys.stdin = open("input/4871_input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    v, e = map(int, input().split())
    l_start, l_finish, stack = [], [], []
    visited = [False] * v
    result = 0

    for i in range(e):
        start, finish = map(int, input().split())
        l_start.append(start)
        l_finish.append(finish)
    
    s, g = map(int, input().split())
    stack.append(s)
    visited[s-1] = True
    while stack:
        l_idx = [ i for i in range(e) if l_start[i] == stack[-1] and not visited[l_finish[i]-1] ]
        if len(l_idx) > 0:
            stack.append(l_finish[l_idx[0]])
            visited[l_finish[l_idx[0]] - 1] = True
        elif stack.pop() == g:
            result = 1
            break

    print('#{} {}'.format(test_case, result))
