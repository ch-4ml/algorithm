import sys
sys.stdin = open('input/5102_input.txt', 'r')

def search(search_edges, target, depth):
    for edge in search_edges:
        if edge[1] == target[1]:
            return depth

        new_edges = get_edges(edge[1])
        visited[edge[1] - 1] = True

        # print(new_edges)

        if not new_edges:
            continue
        else:
            queue.append(search(new_edges, target, depth + 1))
    return 9999

def get_edges(node):
    # 해당 노드를 포함하는 간선을 모두 조회
    new_edges = [ new_edge for new_edge in edges if node in new_edge ]
    
    # 간선 정보에서 찾으려는 노드가 앞에 있는 경우에 간선 정보(시작 노드 위치, 끝 노드 위치)를 변경
    for i in range(len(new_edges)):
        begin, end = new_edges[i]
        if end == node:
            new_edges[i] = (end, begin)
 
    # 이미 방문한 노드는 제외
    new_edges = [ new_edge for new_edge in new_edges if not visited[new_edge[1] - 1] ]     
    return new_edges

T = int(input())
for test_case in range(1, T + 1):
    v, e = map(int, input().split())
    edges = [ tuple(map(int, input().split())) for _ in range(e) ]
    visited = [ False for _ in range(v) ]
    
    target = tuple(map(int, input().split()))
    
    start_edges = get_edges(target[0])
    visited[target[0] - 1] = True

    queue = []
    result = 9999

    queue.append(search(start_edges, target, 1))

    while queue:
        depth = queue.pop()
        if depth < result:
            result = depth
    
    if result == 9999:
        result = 0

    print('#{} {}'.format(test_case, result))