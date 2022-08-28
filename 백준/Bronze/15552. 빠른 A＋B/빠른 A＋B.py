import sys
input = sys.stdin.readline
rep = input()
for i in range(int(rep)):
    a, b = input().split(" ")
    print(int(a) + int(b))