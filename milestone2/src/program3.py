from typing import List, Tuple
import argparse

def program3(n: int, k: int, costs: List[int]) -> Tuple[int, List[int]]:
    """
    Solution to Program 3
    Parameters:
    n (int): number of panels
    k (int): maximum number of positions in a forward jump
    costs (List[int]): the landing costs of the panels
    Returns:
    int: minimum total energy cost
    List[int]: the indices of the visited panels in increasing order(1-indexed,
    including n and excluding 0)
    """
    print(".", end="")
    if n == 0:
        return 0, []
    
    minimumOfPrevK = float('inf')
    path = []
    for j in range(max(0, n-k), n):
        costToJ, pathToJ = program3(j, k, costs)

        if costToJ < minimumOfPrevK:
            minimumOfPrevK = costToJ
            path = pathToJ

    totalCost = minimumOfPrevK + costs[n]
    path.append(n)
    return totalCost, path

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        prog='ProgramName',
        description='What the program does',
        epilog='Text at the bottom of help'
    )
    parser.add_argument('-n', '--n', type=int, required=True)
    parser.add_argument('-k', '--k', type=int, required=True)
    parser.add_argument('-c', '--costs', type=int, nargs='+', required=True)
    args = parser.parse_args()
    print(args)
    path, total = program3(args.n, args.k, args.costs)
    print("Total cost:", total)
    print("Path:", path)