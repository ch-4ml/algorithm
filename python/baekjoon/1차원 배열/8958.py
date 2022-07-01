n = int(input())
for i in range(n):
    a = input()
    b = []
    for j in range(len(a)):
        b.append(0 if a[j] == "X" else b[j-1] + 1 if len(b) != 0 else 1)
    print(sum(b))