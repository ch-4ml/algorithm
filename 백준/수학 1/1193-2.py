x = 0
n = int(input())
while x * (x + 1) / 2 < n:
    x += 1

rep = x * (x + 1) / 2 - n + 1
for i in range(1, x + 1):
    if x % 2 == 1:
        l = i
        r = x + 1 - i
    else:
        l = x + 1 - i
        r = i
    if rep == i:
        print(l, "/", r, sep="")
        break
