import sys
sys.stdin = open("input/4869_input.txt", "r")

def calc(width, count):
    return calc(width - 10, count) + calc(width - 20, count * 2) if width >= 20 else count
        
T = int(input())
for test_case in range(1, T + 1):
    print('#{} {}'.format(test_case, calc(int(input()), 1)))