# 중간에 Max가 된 경우에는 남은 교환 수가 0보다 큰 짝수인지 검사하고,
# 0보다 큰 짝수인 경우에는 그대로 유지,
# 아닌 경우 같은 숫자가 있는지 검사하고
# 같은 숫자가 있는 경우에는 그대로 유지(같은 수끼리 교환)
# 없는 경우 가장 덜 작아지는 쪽으로 찾아서 변경

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
    value, count = input().split(" ")
    count = int(count)
    max_value = "".join(sorted(value, reverse=True))
    while count > 0:
        if value == max_value:  # 현재 상태가 최대값인 경우
            if count % 2 == 0:  # 남은 교환 수가 짝수인 경우
                break
            # 남은 교환 수가 홀수인 경우
            elif len(value) != len(set(list(value))):  # 구성된 숫자 중 중복되는 숫자가 존재하는 경우
                break
            elif len(value) != 1:
                num_list = list(value)
                num_list[-1], num_list[-2] = num_list[-2], num_list[-1]
                value = "".join(num_list)
                break
            else:
                break

        else:  # 현재 상태가 최대값이 아닌 경우
            # 중복되는 max_num이 있을 경우, 순서를 어떻게 변경하느냐에 따라서 달라질 수 있기 때문에
            # max 숫자가 몇 개 있는지 파악하고, 교환 횟수가 몇 회 남았는지 파악한 뒤 한꺼번에 맨 앞으로 옮기는 처리를 하여
            # 해당 숫자들과 교환되는 작은 숫자들이 내림차순으로 정렬되어 뒤쪽으로 넘어갈 수 있도록 처리하는 것이 좋겠다.
            answer = ""
            for i in range(len(value)):
                if list(value)[i] == list(max_value)[i]:
                    answer += list(value)[i]
                else:
                    break

            tmp_value = value.replace(answer, "", 1)
            num_list = list(tmp_value)
            max_num = max(num_list)
            max_count = num_list.count(max_num)
            reps = count if count < max_count else max_count
            selects = []
            targets = []
            s_index = len(tmp_value)
            t_index = 0

            # 교환할 숫자들의 리스트 구하기
            for i in range(reps):
                s_index = tmp_value.rfind(max_num, 0, s_index)
                selects.append(s_index)
                for j in range(t_index, s_index):
                    if num_list[j] < max_num:
                        targets.append([j, num_list[j]])
                        t_index = j + 1
                        break

            # 교환당할 숫자 리스트를 값 기준 오름차순으로 정렬
            targets.sort(key=lambda x: x[1])

            # 교환
            for i in range(len(targets)):
                s_idx = selects[i]
                t_idx = targets[i][0]
                num_list[s_idx], num_list[t_idx] = num_list[t_idx], num_list[s_idx]

            value = answer + "".join(num_list)
            count -= len(targets)

    print("#{} {}".format(test_case, value))
