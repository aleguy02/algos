import argparse
from random import randint

def generate_costs(size: int, r: int) -> list[int]:
    vals = [0]
    vals.extend([randint(1, r) for _ in range(size)])
    return vals

def create_input_file(size: int, val_range: int) -> None:
    costs = generate_costs(size, val_range)
    costs_str = " ".join([str(c) for c in costs])

    with open(f"plots/inputs/input_{size}", "w") as f:
        f.write(costs_str)
    
if __name__=="__main__":
    parser = argparse.ArgumentParser(
            prog='ProgramName',
            description='What the program does',
            epilog='Text at the bottom of help'
        )
    parser.add_argument('-s', '--size', type=int, required=True)
    parser.add_argument('-r', '--range', type=int, required=False)
    args = parser.parse_args()
    val_range = args.range or 100
    create_input_file(args.size, val_range)