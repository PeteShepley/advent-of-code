
async function main() {
}

main()
  .then(() => console.info('Script Executed'))
  .catch((error) => {
    console.error('Error running script');
    console.debug(error);
  });
