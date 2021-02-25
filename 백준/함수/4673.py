a = [i for i in range(1, 10001)]

def d(n):
    for i in str(n):
        n += int(i)
    if n in a:
        a.remove(n)

for i in range(10000):
    d(i)

for i in a:
    print(i)
