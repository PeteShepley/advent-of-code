TEST_INPUT = [
    "00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"
]


def read_file_to_lines(filename):
    """
    Reads an input filename and process it into a list of strings representing
    the lines of input.
    :param filename: File to read
    :return: List of string
    """
    with open(filename) as reader:
        return reader.read().split('\n')


def find_most_common_bit(lines, pos):
    count = 0
    for line in lines:
        if line[pos] == '1':
            count += 1

    if count > len(lines)/2:
        return '1'
    return '0'


if __name__ == '__main__':
    # lines = TEST_INPUT
    lines = read_file_to_lines("input")

    gamma_string = ''
    epsilon_string = ''
    for index in range(0, len(lines[0])):
        most_common = find_most_common_bit(lines, index)
        gamma_string += most_common
        epsilon_string += '0' if most_common == '1' else '1'

    gamma = int(gamma_string, base=2)
    epsilon = int(epsilon_string, base=2)

    print("Gamma: {} Epsilon: {} Power Usage: {}".format(gamma, epsilon, gamma * epsilon))
