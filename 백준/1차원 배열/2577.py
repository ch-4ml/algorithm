a, b, c = int(input()), int(input()), int(input())
for i in range(10):
    print(list(map(int, str(a * b * c))).count(i))