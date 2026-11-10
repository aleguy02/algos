from program3 import program3
from program4a import program4A
from program4B import program4B
from program5 import program5
import argparse

def read_input_file(fp: str) -> list[int]:
    with open(fp, "r") as f:
        vals = [int(c) for c in f.readline().split()]
    return vals

def create_plot():
    pass

if __name__=="__main__":
    parser = argparse.ArgumentParser(
        prog='ProgramName',
        description='What the program does',
        epilog='Text at the bottom of help'
    )
    parser.add_argument('-k', '--k', type=int, required=False)
    parser.add_argument('-f', '--file', type=str, required=True)
    args = parser.parse_args()
    k = args.k or 3
    costs = read_input_file(args.file)
    n = len(costs)-1
    # total, path = program3(n, k, costs)
    # total, path = program4A(n, k, costs)
    # total, path = program4B(n, k, costs)
    total, path = program5(n, k, costs)
    print("Path indices:", path)
    print("Total cost:", total)