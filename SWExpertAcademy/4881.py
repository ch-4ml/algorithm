import sys, datetime
sys.stdin = open("input/4881_input.txt", "r")

def _sum(perm, current):
    return sum([ matrix[i][perm[i]] for i in range(current) ])
    
def construct_permutation(perm, current):
    p = perm.copy()
    if current == size:
        print(p)
        sum_ = _sum(p, current)
        global result
        if sum_ < result:
            result = sum_
        return

    if _sum(p, current) >= result:
        return

    candidates = [ i for i in range(size) if not i in p ]

    for c in candidates:
        p[current] = c
        construct_permutation(p, current + 1)

T = int(input())
for test_case in range(1, T + 1):
    result = 90
    size = int(input())
    matrix = [ list(map(int, input().split())) for _ in range(size) ]
    construct_permutation([-1] * size, 0)

    print('#{} {}'.format(test_case, result))