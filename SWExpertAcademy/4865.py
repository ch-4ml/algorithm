import sys
sys.stdin = open("input/4865_input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    char_set = set(input())
    string = input()
    count = [ string.count(char) for char in char_set ]
    print('#{} {}'.format(test_case, max(count)))
