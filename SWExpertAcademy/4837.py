T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = 0
    n, k = map(int, input().split())
    for i in range(1 << 12):
        bit_list = list(format(i, 'b').zfill(12))
        if bit_list.count('1') != n:
            continue
        if sum([j + 1 for j, value in enumerate(bit_list) if value == '1']) == k:
            result += 1
    print("#{} {}".format(test_case, result))