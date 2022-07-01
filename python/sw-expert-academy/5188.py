import sys
sys.stdin = open('input/5188_input.txt', 'r')

# Brute-Force
def search(i, j, total):
    if i > n - 1 or j > n - 1:
        return
    total += board[i][j]
    if i == j == n - 1:
        totals.add(total)
        return
    search(i, j + 1, total)
    search(i + 1, j, total)

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    board = [ [ j for j in map(int, input().split()) ] for _ in range(n) ]
    totals = set()
    search(0, 0, 0)
    print("#{} {}".format(test_case, min(list(totals))))