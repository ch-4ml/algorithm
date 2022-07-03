n, m = map(int, input().split())
board = [ list(input()) for _ in range(n)]
results = set()

def color_a_board(init_color, init_row, init_col):
    count = 0
    criteria = True
    for row in range(init_row, init_row + 8):
        for col in range(init_col, init_col + 8):
            if (board[row][col] == init_color) != criteria:
                count += 1
            criteria = not(criteria)
        criteria = not(criteria)
    return count

for r in range(0, n-7):
    for c in range(0, m-7):
        results.add(min(color_a_board('W', r, c), color_a_board('B', r, c)))

print(min(results))