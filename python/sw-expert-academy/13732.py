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
    result = True
    n = int(input())
    board = [input() for _ in range(n)]

    row_shapes = set()
    lines = []
    for line, row in enumerate(board):
        row_shape = tuple((row.count("#"), row.find("#"), row.rfind("#")));
        if row_shape[0] > 0:
            lines.append(line)
            row_shapes.add(row_shape)

    # '#' 개수나 위치가 줄마다 다른 경우, 또는 '#'이 하나도 없는 경우
    if len(row_shapes) != 1:
        result = False

    # '#'이 간격을 두고 배치된 경우
    count, s_index, f_index = list(row_shapes)[0]
    if f_index-s_index != count-1:
        result = False

    # 한 줄당 '#' 개수와 '#'으로 변이 구성된 줄 수가 다른 경우
    if count != len(lines):
        result = False

    # 변이 구성된 각 줄이 간격을 두고 배치된 경우
    isGap = False
    for i in range(len(lines) - 1):
        if lines[i+1] - lines[i] != 1:
            isGap = True
            break
    if isGap:
        result = False

    print("#{} {}".format(test_case, "yes" if result else "no"))
