b = []
d = []
for i in range(5):
    b.append(int(input())) if i < 3 else d.append(int(input()))
print(min(b) + min(d) - 50)