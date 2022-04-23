# for r in range(int(input())):
#     k = int(input()) # 층 수
#     n = int(input()) # 호 수
#     room = [i for i in range(1, n + 1)]
#     for i in range(k):
#         temp = []
#         for j in range(1, n + 1):
#             t = 0
#             for l in range(j):
#                 t += room[l]
#             temp.append(t)
#         room = temp
#     print(room[n - 1])

for rep in range(int(input())):
    k = int(input()) # k: 층 수
    n = int(input()) # n: 호 수
    # 집에 사는 사람 수 사이의 배율을 나열하면 규칙성을 찾을 수 있음
    people = n
    for i in range(1, k + 1): people *= (i + n) / (i + 1)
    # 파이썬은 실수를 부동소수점 방식으로 표현하는데,
    # 부동소수점은 실수를 정확히 표현할 수 없는 문제가 있음(오차가 발생할 수 있음)
    print(round(people))