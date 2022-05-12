'''
    테스트 환경에서 input을 처리하기 위한 공용 코드입니다.
    제출 시 반드시 제거합니다.
'''
import array
import inspect
import sys

f = inspect.getfile(inspect.currentframe())
filename = f.split("\\")[-1].split(".")[0]
sys.stdin = open("input/" + filename + "_input.txt", "r")

'''
    아래에 코드 작성
'''

T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    values = list(map(int, input().split()))
    total = 0
    while len(values) > 0:
        max_value = max(values)
        max_index = values.index(max_value)
        total += max_value * len(values[:max_index]) - sum(values[:max_index])
        values = values[max_index + 1:]
    print("#{} {}".format(test_case, total))