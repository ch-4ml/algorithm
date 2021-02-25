def convert(c):
    num = 9 if ord(c) > 86 \
        else 8 if ord(c) > 83 \
        else 7 if ord(c) > 79 \
        else 6 if ord(c) > 76 \
        else 5 if ord(c) > 73 \
        else 4 if ord(c) > 70 \
        else 3 if ord(c) > 67 \
        else 2
    return num

count = 0
for i in input():
    count += convert(i) + 1
print(count)
