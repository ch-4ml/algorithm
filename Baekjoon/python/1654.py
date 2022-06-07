k, n = map(int, input().split())
cables = [int(input()) for _ in range(k)]

# 길이를 이진 탐색
left = 0
right = (1 << 31) - 1
mid = (left + right) // 2

while left <= right:
    count = sum(map(lambda x: x // mid, cables))

    if count >= n:
        left = mid + 1
    else:
        right = mid - 1

    mid = (left + right) // 2

print(mid)
