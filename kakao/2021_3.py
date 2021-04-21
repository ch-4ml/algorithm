def solution(info, query):
    scores = {}  # 해당 지원자 그룹에 포함된 지원자의 점수 dict { group: list }
    answer = []

    # Groups Table 만들기
    # 지원자가 포함될 수 있는 모든 그룹 배열
    languages = ['cpp', 'java', 'python', '-']
    jobs = ['backend', 'frontend', '-']
    careers = ['junior', 'senior', '-']
    foods = ['chicken', 'pizza', '-']
    groups = [ ' '.join([lan, job, career, food]) for lan in languages for job in jobs for career in careers for food in foods ]
    for g in groups:
        scores.setdefault(g, [])

    # 지원자에 대한 정보 추가
    for i in info:
        lan, job, career, food, score = i.split()
        score = int(score)

        group_base = [lan, job, career, food]
        n = len(group_base)

        for j in range(1 << n):
            g = group_base[:]
            for k in range(n):
                if j & (1 << k):
                    g[k] = '-'
            group = ' '.join(g)
            scores[group].append(score)
    
    # 정렬
    for s in scores.values():
        s.sort()

    # for s in scores:
    #     print(s, scores[s])

    # 결과 확인
    for q in query:
        group, score = q[:q.rindex(' ')].replace(' and ', ' '), q[q.rindex(' ') + 1:]
        n = len(scores[group])
        answer.append(n - lower_bound(scores[group], 0, n, int(score)))
    return answer

def lower_bound(lst, l, r, target):
    while(r > l):
        c = (l + r) // 2
        if lst[c] < target:
            l = c + 1
        else:
            r = c
    return r


info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150", "- and - and - and - 500"]
print(solution(info, query))

'''
풀이할 때 놓친 부분

1. 모든 경우를 만들어놓긴 했는데 딕셔너리에 추가를 안해서 검사 단계 때 없는 케이스 나왔을 때 에러 발생했음
2. lower_bound 찾을 때 모든 원소가 target 보다 작은 경우를 코드에 포함시키지 못함

'''