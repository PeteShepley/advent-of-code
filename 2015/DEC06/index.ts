import * as fs from 'fs/promises';
import * as path from 'path';
import { BrightGrid, Grid } from './grid';

async function readInput(fileName: string): Promise<string[]> {
  const file = await fs.open(fileName, 'r');
  const fullText = (await file.readFile()).toString();
  await file.close();
  return fullText.split('\n');
}

type Tuple = [number, number];
type Tokens = [string, Tuple, Tuple];

function getOperation(instruction: string): string {
  const matches = instruction.match(/^(turn on|turn off|toggle)/);
  return matches ? matches[1] : '';
}

function getCoords(instruction: string): number[][] {
  const matches = instruction.match(/(\d+,\d+)/g);
  if (matches) {
    return matches.map((coord: string) => coord.split(',').map(item => +item));
  } else {
    return [];
  }
}

function parseInstruction(instruction: string): Tokens {
  const op = getOperation(instruction);
  const [from, to] = getCoords(instruction);
  return [op, from as Tuple, to as Tuple];
}

async function main() {
  const fileName = path.resolve('.', 'input');
  const instructions = await readInput(fileName);

  const lights = new Grid();
  const brights = new BrightGrid();

  instructions.map(parseInstruction).forEach(([op, from , to]: Tokens) => {
    switch (op) {
      case 'turn on':
        lights.rangeOn(from, to);
        brights.rangeOn(from, to);
        break;
      case 'turn off':
        lights.rangeOff(from, to);
        brights.rangeOff(from, to);
        break;
      case 'toggle':
        lights.rangeToggle(from, to);
        brights.rangeToggle(from , to);
        break;
      default:
        break;
    }
  });

  console.log(lights.total());
  console.log(lights.countOn());

  console.log(brights.total());
  console.log(brights.countOn());
}

main();
