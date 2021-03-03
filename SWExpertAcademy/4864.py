import sys
sys.stdin = open("input/4864_input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    ans = input()
    print('#{} {}'.format(test_case, 1 if input().find(ans) != -1 else 0))