# n: 학생 수
# lost: 체육복을 도난당한 학생 배열
# reserve: 여벌의 체육복을 가져온 학생 배열
def solution(n, lost, reserve):
    
    answer = 0
    
    for i in range(1, n + 1):
        if i not in lost:
            answer += 1

        elif i in reserve:
            answer += 1
            reserve.remove(i)
            lost.remove(i)

    for i in lost:
        if i - 1 in reserve:
            answer += 1
            reserve.remove(i - 1)
        elif i + 1 in reserve:
            answer += 1
            reserve.remove(i + 1)

    return answer
    

print(solution(5, [2, 4], [1, 3, 5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))