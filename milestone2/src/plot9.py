
import math
import statistics
import matplotlib.pyplot as plt

from pathlib import Path
from program1 import program1
from program5 import program5

# Input files generated earlier
INPUT_DIR = Path(__file__).resolve().parent / "plot9_inputs"

sizes = [100, 500, 1000, 2000, 5000, 10000, 25000, 50000]
TRIALS = 30

average_relative_costs = []

for n in sizes:
    relative_costs = []

    for trial in range(1, TRIALS + 1):
        filename = INPUT_DIR / f"input_{n}_trial_{trial}.txt"

        with open(filename, "r") as file:
            data = list(map(int, file.read().split()))

        input_n = data[0]
        k = data[1]
        costs = data[2:]

        assert input_n == n
        assert len(costs) == n

        Eg, greedy_path = program1(n, k, costs)

        Eo, optimal_path = program5(n, k, [0] + costs)

        Cr = (Eg - Eo) / Eo
        relative_costs.append(Cr)

    average_Cr = statistics.mean(relative_costs)
    average_relative_costs.append(average_Cr)

    print(f"n = {n}, k = {k}, Average Cr = {average_Cr:.4f}")

# Plot 9 - Relative Excess Cost
plt.plot(sizes, average_relative_costs, marker="o", label="Program 1")
plt.xlabel("Input Size (n)")
plt.ylabel("Average Relative Excess Cost (Cr)")
plt.title("Plot 9 - Relative Excess Cost of Program 1")
plt.grid(True)
plt.legend()
plt.savefig("plot9.png")
plt.clf()