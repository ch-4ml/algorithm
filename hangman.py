import random

infile = open('quiz.txt', 'r')
count = int(input('몇 번의 기회를 드릴까요? ex) 3 => '))
words = infile.readlines()

word = words[random.randrange(len(words))].replace('\n', '')
guesses = []
print('Word:', ' _ ' * len(word))
answer = ""
while count > 0:
    guess = input('Guess character or word => ')
    guesses.append(guess)
    # guess character
    if len(guess) == 1:
        answer = ""
        for c in word:
            if c in guesses:
                answer += c
            else:
                answer += " _ "
    # guess word
    else:
        if word == guess:
            answer = guess

    # result
    print('-------------')
    print('Word:', answer)
    print('Guess:', guess)
    print('Misses: ', end='')
    for g in guesses:
        if g not in word:        
            print(g, end=' ')
    print()
    print('-------------')    

    if "_" not in answer:
        break

    count -= 1

if count > 0:
    print("추리 성공!")
else:
    print("추리 실패!")

infile.close()