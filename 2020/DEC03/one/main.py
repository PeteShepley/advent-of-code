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


def check_for_tree(map, width, pos):
    """
    Checks a position on the map for a tree
    :param map: List of string representing map
    :param pos: Position to check
    :return: 1 if there is a tree, 0 if not
    """
    x = pos[0] % width
    y = pos[1]
    if map[y] != '' and map[y][x] == '#':
        return 1
    return 0


def main(filename):
    """
    Main application
    :param filename: File name for input map
    :return: None
    """
    map = read_file_to_lines(filename)
    (width, height) = process_map_input(map)

    pos = [0, 0]
    number_of_trees = 0
    while pos[1] <= height - 1:
        pos[0] += 3
        pos[1] += 1
        number_of_trees += check_for_tree(map, width, pos)
    print(f'Number of trees: {number_of_trees}')


if __name__ == '__main__':
    main('input')
