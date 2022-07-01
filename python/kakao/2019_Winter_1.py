def solution(board, moves):
    answer = 0
    n = len(board)
    stack = []

    for i in moves:
        for j in range(n):
            friend = board[j][i - 1]
            board[j][i - 1] = 0
            if friend == 0:
                continue
            
            else:
                stack.append(friend)
                if len(stack) > 1 and stack[len(stack) - 1] == stack[len(stack) - 2]:
                    stack.pop()
                    stack.pop()    
                    answer += 2
                break
                
    return answer



board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	
moves = [1,5,3,5,1,2,1,4]
print(solution(board, moves))