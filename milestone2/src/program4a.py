from typing import List, Tuple, Optional
import argparse
def program4A(n: int, k: int, costs: List[int]) -> Tuple[int, List[int]]:
    """
    Solution to Program 4A
    Parameters:
    n (int): number of panels
    k (int): maximum number of positions in a forward jump
    costs (List[int]): the landing costs of the panels
    M (int, List[int]): the memoization array for keeping track of
    what recursive calls of the algorithm we already made
    Returns:
    int: minimum total energy cost
    List[int]: the indices of the visited panels in increasing order(1-indexed,
    including n and excluding 0)
    """
    M = [None] * (n + 1)
    M[0] = 0

    parent = [None] * (n + 1)

    totalCost = program4ARecursive(n, k, costs, M, parent)
    path = []
    current = n

    while current != 0:
        path.append(current)
        current = parent[current]

    path.reverse()
    return totalCost, path

def program4ARecursive(n: int, k: int, costs: List[int], M: List[Optional[int]], parent: List[Optional[int]]) -> int:
    if M[n] is not None:
        return M[n]

    minimumOfPrevK = float ('inf')
    for j in range (max(0, n-k), n):
        if M[j] is None:
            costToJ = program4ARecursive (j, k, costs, M, parent)
        else:
            costToJ = M[j]
        if costToJ < minimumOfPrevK:
            minimumOfPrevK = costToJ
            parent[n] = j
    
    totalCost = minimumOfPrevK + costs[n]
    M[n] = totalCost
    return M[n]

if __name__ == '__main__':
    n, k = map(int, input().split())
    costs = list(map(int, input().split()))
    m, indices = program4A(n, k, costs)
    print(m)
    print(len(indices))
    for i in indices:
        print(i)