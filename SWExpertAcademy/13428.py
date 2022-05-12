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


def swap(lst, select_index, target_index):
    l = lst[::]
    l[select_index], l[target_index] = l[target_index], l[select_index]
    return l 


T = int(input())
for test_case in range(1, T+1):
    num_list = set()
    str_list = list(input())
    
    num_list.add(int("".join(str_list)))
    for i in range(len(str_list)-1):
        for j in range(i+1, len(str_list)):
            swapped = swap(str_list, i, j)
            if swapped[0] == "0":
                continue
            num_list.add(int("".join(swapped)))
    print("#{} {} {}".format(test_case, min(num_list), max(num_list)))