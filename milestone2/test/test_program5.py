from program5 import program5

def test_given():
    n = 7
    k = 3
    costs = [0, 7, 2, 9, 4, 1, 8, 3]
    total_cost, path = program5(n, k, costs)
    assert total_cost == 6
    assert path == [2, 5, 7]

def test_one_jump():
    n = 7
    k = 7
    costs = [0, 7, 2, 9, 4, 1, 8, 3]
    total_cost, path = program5(n, k, costs)
    assert total_cost == 3
    assert path == [7]

    n = 7
    k = 100
    costs = [0, 7, 2, 9, 4, 1, 8, 3]
    total_cost, path = program5(n, k, costs)
    assert total_cost == 3
    assert path == [7]

def test_k_is_one():
    n = 7
    k = 1
    costs = [0, 7, 2, 9, 4, 1, 8, 3]
    total_cost, path = program5(n, k, costs)
    assert total_cost == 34
    assert path == [1, 2, 3, 4, 5, 6, 7]