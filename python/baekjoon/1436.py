target = int(input())
number = 666
count = 1
while count < target:
    number += 1
    if str(number).find("666") > -1:
        count += 1

print(number)
