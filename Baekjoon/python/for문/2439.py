import sys
input = sys.stdin.readline
rep = int(input())
for i in range(rep):
    print(" " * (rep - (i + 1)), "*" * (i + 1), sep = "")