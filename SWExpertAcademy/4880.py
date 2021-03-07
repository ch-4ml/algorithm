import sys
sys.stdin = open("input/4880_input.txt", "r")

# 1: 가위, 2: 바위, 3: 보
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
    # A 그룹과 B 그룹을 비교하고 우승자 index를 return 
    if (begin + end) // 2 - begin == 1 and end - (begin + end) // 2 + 1 == 1:
        return compare(begin, end)
    else:
        print(begin, (begin + end) // 2 + 1, (begin + end) // 2 + 1, end)
        return compare(game(begin, (begin + end) // 2 + 1), game((begin + end) // 2 + 1, end))

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    cards = map(int, input().split())
    result = game(1, n + 1)
    print(result)
