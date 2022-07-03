import sys
sys.stdin = open("input/4874_input.txt", "r")

def calc(n1, op, n2):
    return n1 + n2 if op == '+' else n1 - n2 if op == '-' else n1 * n2 if op == '*' else n1 / n2

T = int(input())
for test_case in range(1, T + 1):
    result = 'error'
    stack = []
    for e in input().split():
        if e in ['+', '-', '*', '/']:    
            if e == '/' and stack[-1] == 0 or len(stack) < 2:
                break
            else:
                stack.append(int(calc(stack.pop(-2), e, stack.pop(-1))))
        elif e == '.':
            if len(stack) == 1:
                result = stack.pop()
        else:
            stack.append(int(e))

    print('#{} {}'.format(test_case, result))