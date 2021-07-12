for i in range(int(input())):
    rep, s = input().split(" ")
    for j in s:
        print(j * int(rep), end="")
    print()