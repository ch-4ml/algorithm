import sys
sys.stdin = open("input/4866_input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    code = input()
    result = 1
    stack = []
    for c in code:
        if c == '{' or c == '(':
            stack.append(c)
        elif c == '}':
            if len(stack) < 1 or stack.pop() != '{':
                result = 0
                break
        elif c == ')':
            if len(stack) < 1 or stack.pop() != '(':
                result = 0
                break
        else:
            continue
    
    if len(stack) != 0:
        result = 0
    
    print('#{} {}'.format(test_case, result))