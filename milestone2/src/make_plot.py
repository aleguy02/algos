from program3 import program3
from program4a import program4A
from program4B import program4B
from program5 import program5
import time
import argparse

def read_input_file(fp: str) -> list[int]:
    with open(fp, "r") as f:
        vals = [int(c) for c in f.readline().split()]
    return vals

if __name__=="__main__":
    parser = argparse.ArgumentParser(
        prog='ProgramName',
        description='What the program does',
        epilog='Text at the bottom of help'
    )
    parser.add_argument('-k', '--k', type=int, required=False)
    parser.add_argument('-f', '--file', type=str, required=True)
    parser.add_argument('-a', '--algorithm', type=str, required=True)
    args = parser.parse_args()

    if args.algorithm not in ("3", "4A", "4B", "5"):
        raise ValueError("Invalid algorith, must be one of: 3, 4A, 4B, 5")
    k = args.k or 3
    costs = read_input_file(args.file)
    n = len(costs)-1

    if args.algorithm == "3":
        start = time.perf_counter_ns()
        total, path = program3(n, k, costs)
        end = time.perf_counter_ns()
    elif args.algorithm == "4A":
        start = time.perf_counter_ns()
        total, path = program4A(n, k, costs)
        end = time.perf_counter_ns()
    elif args.algorithm == "4B":
        start = time.perf_counter_ns()
        total, path = program4B(n, k, costs)
        end = time.perf_counter_ns()
    else:
        start = time.perf_counter_ns()
        total, path = program5(n, k, costs)
        end = time.perf_counter_ns()
    results = {
        "input_size": n,
        "k_value": k,
        "execution_time_ms": (end - start) / 1_000_000  # milliseconds
    }
    print(results)
    # print("Path indices:", path)
    # print("Total cost:", total)