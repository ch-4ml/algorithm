import sys
sys.stdin = open("input/4880_input.txt", "r")

def compare(idx1, idx2):
    if cards[idx1] - cards[idx2] == -2:
        return idx1
    elif cards[idx1] - cards[idx2] == 2:
        return idx2
    elif cards[idx1] - cards[idx2] >= 0:
        return idx1
    else:
        return idx2
        
def game(begin, end):
    if begin == end:
        return begin
    else:
        return compare(game(begin, (begin + end) // 2), game((begin + end) // 2 + 1, end))
    

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    cards = list(map(int, input().split()))
    result = game(0, n - 1)
    print('#{} {}'.format(test_case, result + 1))
