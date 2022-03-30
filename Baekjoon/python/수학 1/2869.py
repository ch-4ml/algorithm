a, b, v = map(int, input().split(" "))
d = (v - b) // (a - b)
print(d if (v - b) % (a - b) == 0 else d + 1)