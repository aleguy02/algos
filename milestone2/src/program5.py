from typing import List, Tuple
from collections import deque

def program5(n: int, k: int, costs: List[int]) -> Tuple[int, List[int]]:
    """
    Solution to Program 5
    
    Parameters:
    n (int): number of panels
    k (int): maximum number of positions in a forward jump
    costs (List[int]): the landing costs of the panels

    Returns:
    int:  minimum total energy cost
    List[int]: the indices of the visited panels in increasing order(1-indexed, including n and excluding 0)
    """

    M = [None] * (n+1)
    M[0] = 0
    parent = [None] * (n+1)

    Q = deque([0])
    
    for j in range (1, n+1):
        while Q and Q[0] < j - k:
            Q.popleft()
        bestPrevious = Q[0]
        M[j] = M[bestPrevious] + costs[j]
        parent[j] = bestPrevious

        while Q and M[Q[-1]] >= M[j]:
            Q.pop()

        Q.append(j)
    
    path = backtrack5(n, parent)
    return M[n], path

def backtrack5(n:int, parent: List[int]) -> List[int]:
    path = []
    current = n

    while current != 0:
        path.append(current)
        current = parent[current]

    path.reverse()
    return path

if __name__ == '__main__':
    n, k = map(int, input().split())
    costs = list(map(int, input().split()))

    m, indices = program5(n, k, costs)

    print(m)
    print(len(indices))
    for i in indices:
        print(i)