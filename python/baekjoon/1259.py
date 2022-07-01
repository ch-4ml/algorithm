import math

while True:
    s = input()
    if s == "0":
        break

    if len(s) == 1:
        print("yes")
        continue

    if s[0] == "0":
        print("no")
        continue

    mid = math.floor(len(s) / 2)

    if len(s) % 2 == 0:
        print("yes" if s[:mid] == s[:mid-1:-1] else "no")
    else:
        print("yes" if s[:mid + 1] == s[:mid-1:-1] else "no")


