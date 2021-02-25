s = input()
for i in range(97, 123):
    print(s.index(chr(i)) if chr(i) in s else -1, end=" ")