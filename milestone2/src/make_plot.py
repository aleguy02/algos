
from program3 import program3
from program4A import program4A
from program4B import program4B
from program5 import program5
import time
import argparse
import statistics


def read_input_file(fp: str) -> list[int]:
    with open(fp, "r") as f:
        vals = [int(c) for c in f.readline().split()]
    return vals


if __name__ == "__main__":
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
        raise ValueError("Invalid algorithm, must be one of: 3, 4A, 4B, 5")

    k = args.k or 3
    costs = read_input_file(args.file)
    n = len(costs) - 1

    # Fewer runs for Program 3 due to exponential runtime
    warmups = 1 if args.algorithm == "3" else 3
    trials = 5 if args.algorithm == "3" else 15

    # Select algorithm while keeping the original if/elif structure
    if args.algorithm == "3":
        algorithm = program3
    elif args.algorithm == "4A":
        algorithm = program4A
    elif args.algorithm == "4B":
        algorithm = program4B
    else:
        algorithm = program5

    # Warm-up executions (not timed)
    for _ in range(warmups):
        total, path = algorithm(n, k, costs)

    # Measure execution time across multiple trials
    times = []

    for _ in range(trials):
        start = time.perf_counter_ns()
        total, path = algorithm(n, k, costs)
        end = time.perf_counter_ns()

        times.append((end - start) / 1_000_000)

    # Calculate median execution time
    execution_time_ms = statistics.median(times)

    results = {
        "input_size": n,
        "k_value": k,
        "execution_time_ms": execution_time_ms
    }

    print(results)
    # print("Path indices:", path)
    # print("Total cost:", total)
