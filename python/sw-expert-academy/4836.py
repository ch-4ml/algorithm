T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    red = []
    blue = []
    result = 0
    for i in range(int(input())):
        new_rect = list(map(int, input().split()))
        red.append(new_rect) if new_rect[4] == 1 else blue.append(new_rect)
    for r in red:
        for b in blue:
            # purple
            row1 = r[0] if r[0] > b[0] else b[0]
            col1 = r[1] if r[1] > b[1] else b[1]
            row2 = r[2] if r[2] < b[2] else b[2]
            col2 = r[3] if r[3] < b[3] else b[3]
            if row2 - row1 < 0 or col2 - col1 < 0:
                continue
            result += (row2 - row1 + 1) * (col2 - col1 + 1)

    print('#{} {}'.format(test_case, result))

