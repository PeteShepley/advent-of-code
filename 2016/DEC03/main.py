def read_file_to_lines(filename):
    """
    Reads an input filename and process it into a list of strings representing
    the lines of input.
    :param filename: File to read
    :return: List of string
    """
    with open(filename) as reader:
        return reader.read().split('\n')


def is_possible_triangle(sides):
    (a, b, c) = [int(i) for i in sides]
    test = (a + b) > c and (b + c) > a and (a + c) > b
    return test


if __name__ == '__main__':
    count = 0
    lines = read_file_to_lines("input")
    for line in lines:
        if line != '':
            if is_possible_triangle(line.split()):
                count += 1
    print("{}".format(count))

    vertical_count = 0
    for i in range(0, len(lines), 3):
        if lines[i] != '':
            first = lines[i].split()
            second = lines[i+1].split()
            third = lines[i+2].split()
            if is_possible_triangle((first[0], second[0], third[0])):
                vertical_count += 1
            if is_possible_triangle((first[1], second[1], third[1])):
                vertical_count += 1
            if is_possible_triangle((first[2], second[2], third[2])):
                vertical_count += 1

    print("{}".format(vertical_count))
