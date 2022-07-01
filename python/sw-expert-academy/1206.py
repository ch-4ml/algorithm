# T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(10):
    result = 0
    n = int(input())
    l = list(map(int, input().split()))
    for i in range(2, n - 2):
        h = l[i - 2 : i + 3]
        if max(h) == l[i]:
            h.remove(l[i])
            result += l[i] - max(h)
    print('#{} {}'.format(test_case + 1, result))