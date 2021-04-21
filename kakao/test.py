d = {1: [100], 2: [100, 200]}
print(d)
print(d[1])
print(3 in d)

arr = [0, 1, 2, 3]
n = len(arr)

for i in range(1 << n):
    for j in range(n):
        if i & (1 << j):
            print(j, end=' ')
    print()