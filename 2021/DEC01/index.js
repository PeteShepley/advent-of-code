const fs = require('fs');

class Window {
  constructor() {
    this.values = [];
  }

  isReady() {
    return this.values.length === 3;
  }

  push(value) {
    if (this.values.length >= 3) {
      this.values.shift();
    }
    this.values.push(value);
  }

  sum() {
    return this.values.reduce((sum, value) => sum + value, 0);
  }
}

async function main() {
  // const input = [
  //   199, 200, 208, 210, 200, 207, 240, 269, 260, 263
  // ];
  const text = fs.readFileSync('input', {encoding: 'utf-8', flag: 'r'});
  const input = text.split(/\n/).map((item) => parseInt(item));

  const window = new Window();
  let prevSum;
  let count = 0;
  input.forEach((item) => {
    window.push(item);
    if (window.isReady()) {
      if (prevSum && prevSum < window.sum()) {
        count += 1;
      }
      prevSum = window.sum();
    }
  });

  console.log(`Times increased: ${count}`);
}

main()
  .then(() => console.info('Script Executed'))
  .catch((error) => {
    console.error('Error running script');
    console.debug(error);
  });
