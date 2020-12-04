const fs = require('fs');

class Elevator {
  constructor() {
    this.floor = 0;
    this.basementPositions = [];
  }

  move(instructions) {
    instructions.split('').forEach((instruction, index) => {
      if (instruction === '(') {
        this.floor++;
      } else if (instruction === ')') {
        this.floor--;
      }
      if (this.floor === -1) {
        this.basementPositions.push(index+1);
      }
    });
  }
}

module.exports = {
  Elevator
};

function main() {
  const input = fs.readFileSync('input', 'utf8');
  const elevator = new Elevator();
  elevator.move(input);
  console.log(`That puts you on floor: ${elevator.floor}`);
  console.log(`Positions that put Santa in the basement: ${elevator.basementPositions.toString()}`);
}

main();
