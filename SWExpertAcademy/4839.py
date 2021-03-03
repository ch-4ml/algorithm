import sys
sys.stdin = open('input/4839_input.txt', 'r')

def binary_search(l, r, target, count):
    c = int((l + r) / 2)
    count += 1
    if c == target:
      return count
    return binary_search(l, c, target, count) if c > target else binary_search(c, r, target, count)

T = int(input())
for test_case in range(1, T + 1):
    p, a, b = map(int, input().split())
    count_a = binary_search(1, p, a, 0)
    count_b = binary_search(1, p, b, 0)
    result = 'A' if count_a < count_b else 'B' if count_a > count_b else '0'
    print('#{} {}'.format(test_case, result))

