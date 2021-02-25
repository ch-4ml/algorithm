import sys
sys.stdin = open('4843_input.txt', 'r')

T = int(input())
for test_case in range(1, T + 1):
    length = int(input())
    num_list = list(map(int, input().split()))
    num_list.sort()
    asc = num_list[:int(length / 2)]
    desc = num_list[int(length / 2):]
    desc.reverse()  
    new_list = []
    for i in range(5):
        new_list.append(desc[i])
        new_list.append(asc[i])
    result = ' '.join(map(str, new_list))
    print('#{} {}'.format(test_case, result))
