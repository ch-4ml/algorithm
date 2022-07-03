import sys
sys.stdin = open('input/4861_input.txt', 'r')

def check_circular(letter):
    return letter[:int(len(letter)/2)] == letter[-1:-int(len(letter)/2)-1:-1]

T = int(input())
for test_case in range(1, T + 1):
    answer = ''
    size, ans_len = map(int, input().split())
    
    matrix = []
    for i in range(size):
        matrix.append(input())

    for i in range(size):
        if answer != '':
            break

        for j in range(size):
            if j + ans_len > size:
                break
                
            # horizontal
            letter = matrix[i][j : j + ans_len]
            if check_circular(letter):
                answer = ''.join(letter)
                break
        
            # vertical
            letter = [ matrix[k][i] for k in range(j, j + ans_len) ]
            if check_circular(letter):
                answer = ''.join(letter)
                break

    print('#{} {}'.format(test_case, answer))
