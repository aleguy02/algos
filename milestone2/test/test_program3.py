from program3 import program3


def test_given():
    n = 7
    k = 3
    costs = [0, 7, 2, 9, 4, 1, 8, 3]

    path, total_cost = program3(n, k, costs)

    assert total_cost == 6
    assert path == [2, 5, 7]
