coordinates = sorted([list(map(int, input().split())) for _ in range(int(input()))], key=lambda x: (x[0], x[1]))
for c in coordinates:
    print(c[0], c[1])
