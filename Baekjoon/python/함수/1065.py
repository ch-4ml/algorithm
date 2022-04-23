def check(n):
    if len(str(n)) < 3:
        return True
    temp = set()
    for i in range(len(str(n)) - 1):
        temp.add(int(str(n)[i]) - int(str(n)[i + 1]))
    return False if len(temp) > 1 else True

n = int(input())
count = 0
for i in range(1, n + 1):
    if check(i):
        count += 1

print(count)
