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

    if count >= len(lines)/2:
        return '1'
    return '0'


def find_most_and_least_common(bits, position):
    most = find_most_common_bit(bits, position)
    least = '0' if most == '1' else '1'
    return [most, least]


def find_oxygen_value(bits_list):
    filtered_list = bits_list
    for i in range(0, len(filtered_list[0])):
        most, _ = find_most_and_least_common(filtered_list, i)
        filtered_list = list(filter(lambda x: x[i] == most, filtered_list))
        if len(filtered_list) == 1:
            return filtered_list[0]


def find_scrubber_value(bits_list):
    filtered_list = bits_list
    for i in range(0, len(filtered_list[0])):
        _, least = find_most_and_least_common(filtered_list, i)
        filtered_list = list(filter(lambda x: x[i] == least, filtered_list))
        if len(filtered_list) == 1:
            return filtered_list[0]


if __name__ == '__main__':
    # lines = TEST_INPUT
    lines = read_file_to_lines("input")

    gamma_string = ''
    epsilon_string = ''

    for pos in range(0, len(lines[0])):
        most_common, least_common = find_most_and_least_common(lines, pos)
        gamma_string += most_common
        epsilon_string += least_common

    gamma = int(gamma_string, base=2)
    epsilon = int(epsilon_string, base=2)

    print("Gamma: {} Epsilon: {} Power Usage: {}".format(gamma, epsilon, gamma * epsilon))

    oxygen = int(find_oxygen_value(lines), base=2)
    co2 = int(find_scrubber_value(lines), base=2)
    print("Oxygen: {} CO2: {} Support Rating: {}".format(oxygen, co2, oxygen * co2))
