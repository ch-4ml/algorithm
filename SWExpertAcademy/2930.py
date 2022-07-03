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

T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    heap = []
    result = []
    for i in range(n):
        operation = str(input())
        if operation[0] == "1":
            _, x = map(int, operation.split())
            heap.append(x)
        else:
            if len(heap) > 0:
                result.append(str(heap.pop(heap.index(max(heap)))))
            else:
                result.append("-1")
                break

    res = " ".join(result)
    print("#{} {}".format(test_case, res))
