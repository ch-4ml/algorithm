import sys
sys.stdin = open('input/4843_input.txt', 'r')

T = int(input())
for test_case in range(1, T + 1):
    length = int(input())
    num_list = list(map(int, input().split()))
    num_list.sort()
    num_list.reverse()
    new_list = []
    for i in range(5):
        new_list.append(num_list[i])
        new_list.append(num_list[-i-1])
    result = ' '.join(map(str, new_list))
    print('#{} {}'.format(test_case, result))
