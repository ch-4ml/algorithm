words = set()
for _ in range(int(input())):
    words.add(str(input()))

for word in sorted(words, key=lambda x: (len(x), x)):
    print(word)