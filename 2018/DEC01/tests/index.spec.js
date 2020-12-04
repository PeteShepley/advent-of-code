const { Device } = require('../source');

describe('Device', () => {
  let device;

  beforeEach(() => {
    device = new Device();
  });

  it('should display current frequency', () => {
    expect(device.freq()).toBe(0);
  });

  it('should increase frequency with an input +1', () => {
    device.change('+1');
    expect(device.freq()).toBe(1);
  });

  it('should increase frequency by 2 with input of +2', () => {
    device.change('+2');
    expect(device.freq()).toBe(2);
  });

  it('should decrease frequency with input of -1', () => {
    device.change('-1');
    expect(device.freq()).toBe(-1);
  });

  it('should decrease frequency by 2 with input of -2', () => {
    device.change('-2');
    expect(device.freq()).toBe(-2);
  });

  it('should take multiple instructions', () => {
    device.change('+1, +2, -1, -2');
    expect(device.freq()).toBe(0);
  });

  it('should track frequencies visited twice', () => {
    device.trackChanges = true;
    device.change('+1, -1');
    expect(device.firstVisitedTwice()).toBe(0);
  });

  it('should track frequencies visited twice with many changes', () => {
    device.trackChanges = true;
    device.change('+3, +3, +4, -2, -4');
    expect(device.firstVisitedTwice()).toBe(10);
  });

  it('should track even more changes', () => {
    device.trackChanges = true;
    device.change('+7, +7, -2, -7, -4');
    expect(device.firstVisitedTwice()).toBe(14);
  });
});
