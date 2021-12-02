const fs = require('fs');

async function main() {
  // const input = [
  //   199, 200, 208, 210, 200, 207, 240, 269, 260, 263
  // ];
  const text = fs.readFileSync('input', {encoding: 'utf-8', flag: 'r'});
  const input = text.split(/\n/).map((item) => parseInt(item));

  let prevItem;
  let count = 0;
  input.forEach((item) => {
    if (prevItem) {
      count = item > prevItem ? count + 1 : count;
    }
    prevItem = item;
  });

  console.log(`Times increased: ${count}`);
}

main()
  .then(() => console.info('Script Executed'))
  .catch((error) => {
    console.error('Error running script');
    console.debug(error);
  });
