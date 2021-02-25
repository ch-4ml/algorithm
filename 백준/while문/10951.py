import sys
input = sys.stdin.readline
while 1:
    s = input()
    if s == "":
        break
    a, b = map(int, s.split(" "))
    print(a + b)