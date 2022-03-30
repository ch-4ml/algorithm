a, b, c = map(int, input().split())
if c > b:
    x = a / (c - b) + 1
    print(int(x))
else:
    print(-1)