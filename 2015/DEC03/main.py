class Map:
    def __init__(self):
        self.x = 0
        self.y = 0
        self.map = {}
        self.deliver_present()

    def move(self, command):
        if command == '^':
            self.y -= 1
        elif command == '>':
            self.x += 1
        elif command == 'v':
            self.y += 1
        elif command == '<':
            self.x -= 1
        self.deliver_present()

    def deliver_present(self):
        key = "{},{}".format(self.x, self.y)
        if self.map.get(key) is None:
            self.map[key] = 1
        else:
            self.map[key] += 1


def read_file_to_lines(filename):
    """
    Reads an input filename and process it into a list of strings representing
    the lines of input.
    :param filename: File to read
    :return: List of string
    """
    with open(filename) as reader:
        return reader.read().split('\n')


def process_line(line):
    world_map = Map()
    for command in list(line):
        world_map.move(command)
    print("Number of houses: {}".format(len(world_map.map.keys())))

    santa = Map()
    robo = Map()
    commands = list(line)
    for idx in range(len(commands)):
        if idx % 2 == 0:
            santa.move(commands[idx])
        else:
            robo.move(commands[idx])
    print("Number of houses: {}".format(len(set(santa.map.keys()) | set(robo.map.keys()))))


if __name__ == '__main__':
    lines = read_file_to_lines("input")
    for line in lines:
        process_line(line)
