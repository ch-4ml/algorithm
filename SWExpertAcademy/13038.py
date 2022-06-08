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
    result = 0

    n = int(input())
    days = list(map(int, input().split()))

    # 수업이 있는 날짜의 index를 가지는 list 선언
    open_days = [day[0] for day in enumerate(days) if day[1] == 1]

    # 일주일치 수업 수
    classes_of_week = len(open_days)

    # 목표 수강 일수를 채우기 위해 필요한 주(week)와 남은 일수(rest) 구하기
    week = n // classes_of_week
    rest = n % classes_of_week

    # 나누어 떨어질 때
    if rest == 0:
        # 시작 요일 (수업이 있는 요일부터 각각 수강을 시작할 때 일주일에 최소로 머물러야 함)
        stay = []
        for open_day in open_days:
            idx = open_day
            count = 0
            check = 0
            while check < classes_of_week:
                if days[idx] == 1:
                    check += 1
                count += 1
                idx = idx + 1 if idx < 6 else 0
            stay.append(count)
        result = 7 * (week - 1) + min(stay)
    else:
        stay = []
        for open_day in open_days:
            idx = open_day
            count = 0
            check = 0
            while check < rest:
                if days[idx] == 1:
                    check += 1
                count += 1
                idx = idx + 1 if idx < 6 else 0
            stay.append(count)
        result = 7 * week + min(stay)

    print("#{} {}".format(test_case, result))
