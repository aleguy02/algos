
def program1(n, k, costs):
    min_cost = 0
    indices = []
    i = 0

    while i < n:
        i += k
        i = min(i, n)
        min_cost += costs[i - 1]
        indices.append(i)

    return min_cost, indices


def main():
    n, k = map(int, input().split())
    costs = []

    while len(costs) < n:
        costs.extend(map(int, input().split()))

    min_cost, indices = program1(n, k, costs)

    print(min_cost)
    print(len(indices))

    for index in indices:
        print(index)


if __name__ == "__main__":
    main()
