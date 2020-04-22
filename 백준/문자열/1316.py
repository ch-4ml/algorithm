count = 0
for i in range(int(input())):
    word = input()
    wordSet = set(word)
    isGroupWord = True
    for j in wordSet:
        idx = word.index(j)
        if word.count(j) == 1:
            continue
        for k in range(idx, idx + word.count(j) - 1):
            if word[k] != word[k + 1]:
                isGroupWord = False
                break
        if not isGroupWord:
            break
    if isGroupWord: 
        count += 1
print(count)