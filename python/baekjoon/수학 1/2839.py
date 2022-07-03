def calc(x, y, z):
    if x * 5 + y * 3 == z:
        return x
    else:
        return -1

z = int(input())
x = -1
sol = []
while x * 5 <= z:
    x += 1
    y = 0
    sol.append(calc(x, y, z))
    while x * 5 + y * 3 <= z:
        y += 1
        sol.append(calc(x, y, z))

if max(sol) == -1:
    print(-1)
else:
    x = max(sol)
    print(x + (z - 5 * x) // 3)