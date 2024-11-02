TEST_INPUT = <<TEST_INPUT
7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
8  2 23  4 24
21  9 14 16  7
6 10  3 18  5
1 12 20 15 19

3 15  0  2 22
9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
2  0 12  3  7
TEST_INPUT

class DrawnNumbers
  def initialize(number_list)
    @values = number_list.split(',')
  end

  def to_s
    @values.join(' - ')
  end
end

class Board
  def initialize(input_board)
    @rows = input_board.map { |row| row.split(/\s+/) }
  end

  def to_s
    @rows.map do |row|
      row.join('-')
    end.to_s
  end
end

class Game
  attr_reader :drawn_numbers, :boards

  def initialize(input)
    @drawn_numbers = DrawnNumbers.new(input.shift(2).first)
    @boards = []
    while input.length >= 5
      board = Board.new(input.shift(5))
      input.shift
      @boards.push(board)
    end
  end
end

def main
  input = TEST_INPUT.split("\n")
  game = Game.new(input)
  game.boards.each do |board|
    puts(board)
  end
end

main
