n = int(input())
l = 0
r = 1
count = 0
rep = 0
flag = -1
check = False

while(True):
    if check == True:
        break

    if flag == 1:
        r += 1
        count += 1
        if count == n:
            break
        for i in range(rep):
            r -= 1
            l += 1
            count += 1
            if count == n:
                check = True
                break
    else:
        l += 1
        count += 1
        if count == n:
            break
        for i in range(rep):
            l -= 1
            r += 1
            count += 1
            if count == n:
                check = True
                break

    flag *= -1
    rep += 1

print(l, "/", r, sep="")
