const fs = require('fs');

class Adder {
  static add(input) {
    let total = 0;
    for (let i = 0; i < input.length; i++) {
      const current = parseInt(input[i]);
      const next = (i === input.length-1) ? parseInt(input[0]) : parseInt(input[i+1]);
      if (current === next) {
        total += current;
      }
    }
    return total;
  }

  static add2(input) {
    let total = 0;
    for (let i = 0; i < input.length; i++) {
      const current = parseInt(input[i]);
      const step = Math.floor(input.length / 2);
      const next = parseInt(input[(i + step) % input.length]);
      if (current === next) {
        total += current;
      }
    }
    return total;
  }
}

module.exports = {
  Adder
};

function main() {
  const input = fs.readFileSync('input', 'utf8').trim();
  const sum = Adder.add(input);
  console.log(`Sum of input: ${sum}`);

  const sum2 = Adder.add2(input);
  console.log(`Sum2 of input: ${sum2}`);
}

main();
