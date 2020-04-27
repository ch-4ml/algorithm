n = int(input())
l = 0
r = 0
count = 0
limit = 2
flag = -1

while(count < n):
    for i in range(1, limit):
        count += 1
        if count == n:
            if flag == 1:
                l = i
                r = limit - i
            else:
                l = limit - i
                r = i
            break

    flag *= -1
    limit += 1

print(l, "/", r, sep="")
