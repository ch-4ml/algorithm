import itertools

# itertools
n, m = map(int, input().split())
cards = list(map(int, input().split()))

c = itertools.combinations(cards, 3)
print(max([sum(combination) if sum(combination) <= m else 0 for combination in c]))

# # no itertools  # timeout

# n, m = map(int, input().split())
# cards = list(map(int, input().split()))

# results = set()
# for i in range(1<<n):
#     combination = []
#     for j in range(len(cards)):  # j: 0, 1, 2, 3, 4
#         if i & (1<<j):  # i<<j: 1(00001), 2(00010), 4(00100), 8(01000), 16(10000)
#             combination.append(cards[j])
#     if len(combination) == 3:
#         result = sum(combination)
#         if result <= m:
#             results.add(result)
# print(max(results))