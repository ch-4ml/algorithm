"""
    테스트 환경에서 input을 처리하기 위한 공용 코드입니다.
    제출 시 반드시 제거합니다.
"""
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
    s = sum(filter(lambda x: x % 2 == 1, map(int, input().split())))
    print("#{} {}".format(test_case, s))