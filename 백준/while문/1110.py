n = input()
origin = n
count = 0
while True:
    if len(n) < 2:
        n = "0" + n
    n = n[1] + str(int(n[0]) + int(n[1]))[-1]
    count += 1
    if int(origin) == int(n):
        print(count)
        break