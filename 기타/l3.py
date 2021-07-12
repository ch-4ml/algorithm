enter = [1,4,2,3]
leave = [2,1,4,3]

room = []
meet = [0] * len(enter)

# 나간 사람 배열을 기준으로 반복합니다.
for l in leave:

    # enter 배열을 복사해서 temp_enter 할당합니다(enter가 계속 바뀔거에요)
    temp_enter = enter.copy()

    # 들어온 사람 배열을 기준으로 반복하는데
    for e in temp_enter:

        # 나간 사람이 들어온 사람 배열에 있으면
        if l in temp_enter:

            # 방에다가 들어온 사람을 집어넣고
            room.append(e)
            # enter 배열에서 들어온 사람을 뺍니다(순서대로 반복하니까 0을 pop 했어요)
            enter.pop(0)

        # 들어온 사람이랑 나간 사람이랑 똑같아지면 그만 반복합니다.
        # 출입 순서가 명확해지는 곳
        if l == e:
            break

    # 방에서 나간 사람을 뺍니다
    room.remove(l)

    # 나가는 사람이 방에 있는 사람 수를 세서 더합니다
    meet[l - 1] += len(room)

    # 방에 있는 사람들이 지금 나간 사람 수(1)를 세서 더합니다
    for r in room:
        meet[r - 1] += 1
        
print(meet)