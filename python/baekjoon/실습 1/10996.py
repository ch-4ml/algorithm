n = int(input())
for i in range(2 * n):
    star = 1 if i % 2 == 0 else -1
    for j in range(n):
        print("*" if star == 1 else " ", end="")
        star *= -1
    if n == 1:
        break
    print()