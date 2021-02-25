a = input().upper()
s = set(a)
c = {}
for i in s:
    c[i] = a.count(i)
print(max(c.keys(), key=lambda k: c[k]) if list(c.values()).count(max(c.values())) < 2 else "?")