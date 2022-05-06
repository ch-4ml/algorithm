'''
    테스트 환경에서 input을 처리하기 위한 공용 코드입니다.
    제출 시 반드시 제거합니다.
'''
import inspect
import sys
import math

f = inspect.getfile(inspect.currentframe())
filename = f.split("\\")[-1].split(".")[0]
sys.stdin = open("input/" + filename + "_input.txt", "r")

'''
    아래에 코드 작성
'''

# 끊어지면 실패
# 한 칸만 있는 경우 성공으로 보고 작성

T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    board = [list(str(input())) for _ in range(n)]
    counts = set()
    for row in board:
        counts.add(row.count("#"))

    init_coordinate = []
    for i in range(n):
        for j in range(n):


    size = max(counts)

    result = "no"




    # print("#{} {}".format(test_case, _))