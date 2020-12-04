const { Elevator } = require('../source');

describe('Elevator', () => {
  let elevator;

  beforeEach(() => {
    elevator = new Elevator();
  });

  it('should start at floor 0.', () => {
    expect(elevator.floor).toBe(0);
  });

  it('should move up one floor given instruction.', () => {
    elevator.move('(');
    expect(elevator.floor).toBe(1);
  });

  it('should move up two floors given instruction.', () => {
    elevator.move('((');
    expect(elevator.floor).toBe(2);
  });

  it('should move down one floor given instruction.', () => {
    elevator.move(')');
    expect(elevator.floor).toBe(-1);
  });

  it('should allow for complicated instruction sets.', () => {
    elevator.move('((())((())((()');
    expect(elevator.floor).toBe(4);
  });
});
