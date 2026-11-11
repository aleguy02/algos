import ast
import math
import statistics
import subprocess
import sys
from pathlib import Path
import matplotlib.pyplot as plt

GENERATOR = "generate_input_file.py"
MAKEPLOT = "make_plot.py"

INPUT_DIR = Path("plots/inputs")
OUTPUT_DIR = Path("plots/graphs")

INPUT_DIR.mkdir(parents=True, exist_ok =True)
OUTPUT_DIR.mkdir(parents=True, exist_ok=True)

REPTITIONS = 1
# Program 3: Small inputs (exponential recursion)
small_sizes = [5, 8, 11, 14, 17, 20, 23]

# Program 4A: Medium inputs (recursion depth limits)
medium_sizes = [3000, 4000, 5000, 6000, 7000, 8000]

# Program 4B: Larger inputs (O(nk))
large_sizes = [100, 500, 1000, 2000, 4000, 8000]

# Program 5: Very large inputs (O(n))
linear_sizes = [1000, 5000, 10000, 25000, 50000, 90000]

def generate_input(n):
    filepath = INPUT_DIR / f"input_{n}"
    if not filepath.exists():
        subprocess.run([sys.executable, GENERATOR, "-s", str(n), "-r", "100"], check=True)
    return filepath

def measure_runtime(algorithm, n):
    filepath = generate_input(n)
    k = math.ceil(n/10)
    times = []

    for _ in range(REPTITIONS):
        result = subprocess.run(
            [sys.executable, MAKEPLOT, "-a", algorithm, "-k", str(k),
             "-f", str(filepath)],
             capture_output = True,
             text = True,
             check = True
        )

        data = ast.literal_eval(result.stdout.strip())
        times.append(data["execution_time_ms"])

    return statistics.median(times)

def collect_data(algorithm, sizes):
    results = []
    for n in sizes:
        elapsed = measure_runtime(algorithm, n)
        results.append(elapsed)
        print(f"Program {algorithm}: n={n}, time={elapsed:.5f} ms")
    return results

def make_plot(series, filename, title, log_scale=False):
    plt.figure(figsize=(10, 6))

    for label, (sizes, times) in series.items():
        plt.plot(sizes, times, marker="o", label=label)

    if log_scale:
        plt.yscale("log")

    plt.xlabel("Input size (n)")
    plt.ylabel("Execution time (ms)")
    plt.title(title + " - k = ceil(n/10)")
    plt.grid(True, alpha=0.3)
    plt.legend()
    plt.tight_layout()

    plt.savefig(OUTPUT_DIR / filename, dpi=200)
    plt.close()

data3 = collect_data("3", small_sizes)
data4a = collect_data("4A", medium_sizes)
data4b = collect_data("4B", medium_sizes)
data5 = collect_data("5", linear_sizes)

make_plot({"Program 3": (small_sizes, data3)}, "plot3.png", "Program 3 Runtime")
make_plot({"Program 4A": (medium_sizes, data4a)}, "plot4.png", "Program 4A Runtime")
make_plot({"Program 4B": (medium_sizes, data4b)}, "plot5.png", "Program 4B Runtime")
make_plot({"Program 5": (linear_sizes, data5)}, "plot6.png", "Program 5 Runtime")


combined = {}

for algorithm in ["3", "4A", "4B", "5"]:
    combined[f"Program {algorithm}"] = (
        small_sizes,
        collect_data(algorithm, small_sizes)
    )

make_plot(combined,"plot7.png","All Programs Comparison",log_scale=True)

comparison = {
    "Program 4A": (medium_sizes, data4a),
    "Program 4B": (medium_sizes, data4b
    )
}

make_plot(comparison, "plot8.png", "4A vs 4B Comparison")
