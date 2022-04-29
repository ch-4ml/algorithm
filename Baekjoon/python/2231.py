target = int(input())
result = 0
for i in range(target):
    num = i
    s = num
    while num >= 1:
        s += num % 10
        num //= 10
    if s == target:
        result = i
        break
print(result)