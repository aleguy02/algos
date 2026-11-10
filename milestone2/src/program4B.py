from typing import List, Tuple


def program4B(n: int, k: int, costs: List[int]) -> Tuple[int, List[int]]:
    """
    Solution to Program 4B
    
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

    for j in range (1, n+1):
        minimumOfPrevK = float ('inf')
        for p in range(max(0, j-k), j):
            if M[p] < minimumOfPrevK:
                minimumOfPrevK = M[p]
                parent[j] = p
        M[j] = minimumOfPrevK + costs[j]

    path = backtrack4b(n, parent)
    return (M[n], path)

def backtrack4b (n: int, parent: List[int]) -> List[int]:
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

    m, indices = program4B(n, k, costs)

    print(m)
    print(len(indices))
    for i in indices:
        print(i)