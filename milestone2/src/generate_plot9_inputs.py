
import math
import random
from pathlib import Path

# Directory for generated inputs
INPUT_DIR = Path(__file__).resolve().parent / "plot9_inputs"
INPUT_DIR.mkdir(parents=True, exist_ok=True)

# Input sizes to test
sizes = [100, 500, 1000, 2000, 5000, 10000, 25000, 50000]

TRIALS = 30

rng = random.Random(42)

for n in sizes:
    k = math.ceil(n / 10)

    for trial in range(1, TRIALS + 1):

        costs = [rng.randint(1, 100) for _ in range(n)]

        filename = INPUT_DIR / f"input_{n}_trial_{trial}.txt"

        with open(filename, "w") as file:
            file.write(f"{n} {k}\n")
            file.write(" ".join(map(str, costs)) + "\n")

    print(f"Generated {TRIALS} inputs for n = {n}, k = {k}")

print(f"\nTotal files generated: {len(sizes) * TRIALS}")
print(f"Saved to: {INPUT_DIR}")
