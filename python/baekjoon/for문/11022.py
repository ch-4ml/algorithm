import sys
input = sys.stdin.readline
for i in range(int(input())):
    s = input()
    print("Case #{}: {} + {} = {}".format(i + 1, s[0], s[2], int(s[0]) + int(s[2])))