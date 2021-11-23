type Tuple = [number, number];

export class Grid {
  protected static readonly MAX_ROWS = 1000;
  protected static readonly MAX_COLS = 1000;

  protected readonly items: number[];

  constructor() {
    this.items = [];
    this.items.length = Grid.MAX_ROWS * Grid.MAX_COLS;
  }

  get(row: number, column: number): number {
    return this.items[(row * Grid.MAX_COLS) + column];
  }

  set(row: number, column: number, value: number): void {
    this.items[(row * Grid.MAX_COLS) + column] = value;
  }

  toggle(row: number, column: number): void {
    this.set(row, column, this.get(row, column) === 1 ? 0 : 1);
  }

  off(row: number, column: number): void {
    this.set(row, column, 0);
  }

  on(row: number, column: number): void {
    this.set(row, column, 1);
  }

  total(): number {
    return this.items.length;
  }

  countOn(): number {
    return this.items.reduce((count: number, item: number) => count + item);
  }

  rangeOn(from: Tuple, to: Tuple): void {
    for (let i = from[0]; i <= to[0]; i++) {
      for (let j = from[1]; j <= to[1]; j++) {
        this.on(i, j);
      }
    }
  }

  rangeOff(from: Tuple, to: Tuple): void {
    for (let i = from[0]; i <= to[0]; i++) {
      for (let j = from[1]; j <= to[1]; j++) {
        this.off(i, j);
      }
    }
  }

  rangeToggle(from: Tuple, to: Tuple): void {
    for (let i = from[0]; i <= to[0]; i++) {
      for (let j = from[1]; j <= to[1]; j++) {
        this.toggle(i, j);
      }
    }
  }
}

export class BrightGrid extends Grid {
  constructor() {
    super();
    for (let i = 0; i < this.items.length; i++) {
      this.items[i] = 0;
    }
  }

  on(row: number, col: number): void {
    this.set(row, col, this.get(row, col) + 1)
  }

  off(row: number, col: number): void {
    this.set(row, col, Math.max(this.get(row, col) - 1, 0));
  }

  toggle(row: number, col: number): void {
    this.set(row, col, this.get(row, col) + 2);
  }
}
