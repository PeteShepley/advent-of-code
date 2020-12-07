def read_file_to_lines(filename):
    """
    Reads an input filename and process it into a list of strings representing
    the lines of input.
    :param filename: File to read
    :return: List of string
    """
    with open(filename) as reader:
        return reader.read().split('\n')


def process_map_input(input_lines):
    """
    Find the dimensions of a map using the lines of input
    :param input_lines: List of string representing the map
    :return: (x: width, y: height) Tuple
    """
    height = len(input_lines) - 1
    width = len(input_lines[0])
    return width, height


def check_for_tree(tree_map, width, pos):
    """
    Checks a position on the map for a tree
    :param tree_map: List of string representing map
    :param width: Width of the initial section of map
    :param pos: Position to check
    :return: 1 if there is a tree, 0 if not
    """
    x = pos[0] % width
    y = pos[1]
    if tree_map[y] != '' and tree_map[y][x] == '#':
        return 1
    return 0


def find_number_of_trees(tree_map, slope):
    (width, height) = process_map_input(tree_map)
    pos = [0, 0]
    number_of_trees = 0
    while pos[1] <= height - 1:
        number_of_trees += check_for_tree(tree_map, width, pos)
        pos[0] += slope[0]
        pos[1] += slope[1]
    return number_of_trees


def main(filename):
    """
    Main application
    :param filename: File name for input tree_map
    :return: None
    """
    tree_map = read_file_to_lines(filename)
    total = 1
    slopes = [
        [1, 1],
        [3, 1],
        [5, 1],
        [7, 1],
        [1, 2]
    ]

    for slope in slopes:
        number_of_trees = find_number_of_trees(tree_map, slope)
        total *= number_of_trees

    print(f'Multiplication of trees: {total}')


if __name__ == '__main__':
    main('input')
