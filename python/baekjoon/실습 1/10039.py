import sys
input = sys.stdin.readline
a = []
for i in range(5):
    n = int(input())
    a.append(40 if n < 40 else n)
print(sum(a) // 5)