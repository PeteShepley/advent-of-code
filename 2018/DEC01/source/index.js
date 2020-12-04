const fs = require('fs');

class Device {
  constructor() {
    this.frequency = 0;
    this.visited = [0];
    this.visitedTwice = [];
    this.trackChanges = false;
  }

  change(input) {
    const ops = input.trim().split(/[,\n]/).map((i) => i.trim());
    do {
      ops.forEach((op) => {
        if (op[0] === '+') {
          this.frequency += parseInt(op.slice(1));
        } else if (op[0] === '-') {
          this.frequency -= parseInt(op.slice(1));
        }
        this.trackVisited();
      });
    } while (this.trackChanges && this.visitedTwice.length <= 0);
  }

  trackVisited() {
    if (this.visited.includes(this.frequency) && !this.visitedTwice.includes(this.frequency)) {
      this.visitedTwice.push(this.frequency);
    } else if (!this.visited.includes(this.frequency)) {
      this.visited.push(this.frequency);
    }
  }

  freq() {
    return this.frequency;
  }

  firstVisitedTwice() {
    return this.visitedTwice[0];
  }
}

module.exports = {
  Device
};

function main() {
  const input = fs.readFileSync('input', 'utf8');
  const dev = new Device();
  dev.trackChanges = true;
  dev.change(input);

  console.log(`Frequency after changes: ${dev.freq()}`);
  console.log(`First frequency visited twice: ${dev.firstVisitedTwice()}`);
}

main();
