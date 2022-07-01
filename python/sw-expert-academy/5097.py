import sys
sys.stdin = open('input/5097_input.txt', 'r')

T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    nums = list(map(int, input().split()))
    for _ in range(m):
        nums.append(nums.pop(0))
    print('#{} {}'.format(test_case, nums[0]))