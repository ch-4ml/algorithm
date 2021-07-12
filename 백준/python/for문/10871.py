import sys
input = sys.stdin.readline
n, x = map(int, input().split(" "))
nums = map(int, input().split(" "))
for i in nums:
    if i < x:
        print(i, end = " ")