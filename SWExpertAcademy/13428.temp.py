'''
    테스트 환경에서 input을 처리하기 위한 공용 코드입니다.
    제출 시 반드시 제거합니다.
'''
import inspect
import sys

f = inspect.getfile(inspect.currentframe())
filename = f.split("\\")[-1].split(".")[0] 
sys.stdin = open("input/" + filename + "_input.txt", "r")

'''
    아래에 코드 작성
'''

def diff_index_of(string, num, start_index):
    for i in range(start_index, len(string)):
        if string[i] != num:
            return i
    return -1

T = int(input())
for test_case in range(1, T+1):
    string = input()
    
    # max
    max_num = str(max(map(int, list(string))))
    max_val = list(string[::])
    select = "".join(max_val).rindex(max_num)
    target = diff_index_of(max_val, max_num, 0)

    if target > -1 and select > target:    
        max_val[target], max_val[select] = max_val[select], max_val[target]
    
    # min
    min_num = str(min(map(int, list(string))))
    min_val = list(string[::])
    select = "".join(min_val).rindex(min_num)
    
    if select == 0:
        temp = string[::]
        temp = temp.replace(str(min_num), "9")
        min_num = str(min(map(int, list(temp))))
        select = temp.rindex(min_num)
        target = diff_index_of(min_val, min_num, 1)
        if select != 0 and target > -1 and select > target:
            min_val[target], min_val[select] = min_val[select], min_val[target]

    elif min_num == "0":
        # case 1: 0을 이동하는 경우
        min_vals = set()
        target = diff_index_of(min_val, min_num, 1)
        if target > -1 and select > target:
            min_val[target], min_val[select] = min_val[select], min_val[target]
        min_vals.add(int("".join(min_val)))

        # case 2: 0을 이동하지 않는 경우
        min_val = list(string[::])
        temp = string[::]
        temp = temp.replace("0", "9")
        min_num = str(min(map(int, list(temp))))
        select = temp.rindex(min_num)
        target = diff_index_of(min_val, min_num, 0)
        if select != 0 and target > -1 and select > target:
            min_val[target], min_val[select] = min_val[select], min_val[target]
        min_vals.add(int("".join(min_val)))
        min_val = str(min(min_vals))
            
    else:
        # case 3: 최저값 인덱스가 0인 경우
        # 최저값 인덱스가 0, 1인 경우, 0, 1, 2인 경우......
        min_val = list(string[::])

        # case 4: 일반적인 경우
        target = diff_index_of(string, min_num, 0)
        if target > -1 and select > target:
            min_val[target], min_val[select] = min_val[select], min_val[target]

    print("#{} {} {}".format(test_case, "".join(min_val), "".join(max_val)))