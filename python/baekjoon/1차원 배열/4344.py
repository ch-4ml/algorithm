n = int(input())
for i in range(n):
    a = list(map(int, input().split(" ")))
    c = int(a.pop(0))
    avg = sum(a) / c
    s = 0
    for j in a:
        s += 1 if j > avg else 0
    print(f'{s / c:.3%}')