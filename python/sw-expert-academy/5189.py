import sys
import itertools
sys.stdin = open('input/5189_input.txt', 'r')

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    fields = [ [ j for j in map(int, input().split()) ] for _ in range(n) ]
    field_array = [ i + 1 for i in range(n - 1) ]
    field_permutations = itertools.permutations(field_array)

    times = []
    for field_permutation in field_permutations:
        start = end = total = 0
        for field in field_permutation:
            total += fields[start][field]
            start = field
        total += fields[start][end]
        times.append(total)
    print("#{} {}".format(test_case, min(times)))