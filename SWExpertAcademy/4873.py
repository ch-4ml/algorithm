import sys
sys.stdin = open("input/4873_input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    s = input()
    stack = []
    for char in s:
        stack.pop() if len(stack) > 0 and stack[-1] == char else stack.append(char)            
    print('#{} {}'.format(test_case, len(stack)))