const {GPS} = require('../source');

describe('GPS', () => {
  let gps;

  beforeEach(() => {
    gps = new GPS();
  });

  it('should process empty instructions.', () => {
    gps.process('');
    expect(gps.direction()).toBe('north');
    expect(gps.distance()).toBe(0);
    expect(gps.fromOrigin()).toBe(0);
  });

  it('should process a single instruction.', () => {
    gps.process('R1');
    expect(gps.direction()).toBe('east');
    expect(gps.distance()).toBe(1);
    expect(gps.fromOrigin()).toBe(1);
  });

  it('should process two instructions.', () => {
    gps.process('R1, R1');
    expect(gps.direction()).toBe('south');
    expect(gps.distance()).toBe(2);
    expect(gps.fromOrigin()).toBe(2);
  });

  it('should go in a circle.', () => {
    gps.process('R1, R1, R1, R1');
    expect(gps.direction()).toBe('north');
    expect(gps.distance()).toBe(4);
    expect(gps.fromOrigin()).toBe(0);
  });

  it('should process left turn.', () => {
    gps.process('L1');
    expect(gps.direction()).toBe('west');
    expect(gps.distance()).toBe(1);
    expect(gps.fromOrigin()).toBe(1);
  });

  it('should R2, L3', () => {
    gps.process('R2, L3');
    expect(gps.direction()).toBe('north');
    expect(gps.distance()).toBe(5);
    expect(gps.fromOrigin()).toBe(5);
  });

  it('should R2, R2, R2', () => {
    gps.process('R2, R2, R2');
    expect(gps.direction()).toBe('west');
    expect(gps.distance()).toBe(6);
    expect(gps.fromOrigin()).toBe(2);
  });

  it('should R5, L5, R5, R3', () => {
    gps.process('R5, L5, R5, R3');
    expect(gps.direction()).toBe('south');
    expect(gps.distance()).toBe(18);
    expect(gps.fromOrigin()).toBe(12);
  });
});
