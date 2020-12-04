const fs = require('fs');

const DIRECTIONS_NAMES = [
  'north',
  'east',
  'south',
  'west'
];

const DIRECTION_MOVES = [
  [0, 1],
  [1, 0],
  [0, -1],
  [-1, 0]
];

class GPS {
  constructor() {
    this.compass = 0;
    this.totalDistance = 0;
    this.pos = [0, 0];
    this.visited = ['0,0'];
  }

  process(steps) {
    if (steps) {
      steps.split(',').map((s) => s.trim()).forEach((step) => {
        const rotation = step.slice(0, 1);
        const distance = parseInt(step.slice(1));
        this.turn(rotation);
        this.move(distance);
      });
    }
  }

  turn(rotation) {
    switch(this.compass) {
      case 0:
        this.compass = rotation === 'R' ? 1 : 3;
        break;
      case 1:
        this.compass = rotation === 'R' ? 2 : 0;
        break;
      case 2:
        this.compass = rotation === 'R' ? 3 : 1;
        break;
      case 3:
        this.compass = rotation === 'R' ? 0 : 2;
        break;
    }
  }

  move(distance) {
    this.totalDistance += distance;
    for (let i = 0; i < distance; i++) {
      this.pos[0] += DIRECTION_MOVES[this.compass][0];
      this.pos[1] += DIRECTION_MOVES[this.compass][1];

      let location = `${this.pos[0]},${this.pos[1]}`;
      if (this.visited.includes(location)) {
        console.log(`Visited again: ${location}`);
      }
      this.visited.push(location);
    }
  }

  direction() {
    return DIRECTIONS_NAMES[this.compass];
  }

  distance() {
    return this.totalDistance;
  }

  fromOrigin() {
    return Math.abs(this.pos[0]) + Math.abs(this.pos[1]);
  }
}

module.exports = {
  GPS
};

function main() {
  const input = fs.readFileSync('input', 'utf8');
  const gps = new GPS();
  gps.process(input);
  console.log(`GPS: We are ${gps.fromOrigin()} blocks away.`);
}

main();
