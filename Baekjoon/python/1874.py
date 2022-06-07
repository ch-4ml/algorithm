n = int(input())
target = [int(input()) for _ in range(n)]
result = []

i = 1
stack = []
while len(target) > 0:
    if len(stack) > 0 and stack[-1] == target[0]:
        result.append("-")
        stack.pop(-1)
        target.pop(0)
    elif i <= n:
        result.append("+")
        stack.append(i)
        i += 1
    else:
        result = ["NO"]
        break

for r in result:
    print(r)
