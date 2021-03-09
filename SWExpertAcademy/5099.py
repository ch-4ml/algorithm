import sys
sys.stdin = open('input/5099_input.txt', 'r')

T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    cheese = list(map(int, input().split()))
    pizza = [ (i, cheese[i]) for i in range(m) ]
    queue = []
    for i in range(n):
        queue.append(pizza[i])
        pizza.pop(i)

    while len(queue) > 1:
        if queue[0][1] == 0:  # 치즈가 다 녹음
            queue.pop(0)
            if pizza:
                queue.insert(0, pizza.pop(0))        
        else:
            p, c = queue.pop(0)
            new_pizza = (p, c // 2)
            queue.append(new_pizza)
    
    print('#{} {}'.format(test_case, queue[0][0] + 1))