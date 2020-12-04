import { CounterUpper } from '../src/counterUpper';

test('Should calculate fuel for all masses input.', () => {
  const counter = new CounterUpper();
  expect(counter.calculate([12, 14])).toBe(4);
});

test('Should calculate the fuel given a mass.', () => {
  const counter = new CounterUpper();
  expect(counter.calculateFuel(12)).toBe(2);
  expect(counter.calculateFuel(14)).toBe(2);
  expect(counter.calculateFuel(1969)).toBe(654);
  expect(counter.calculateFuel(100756)).toBe(33583);
});

test('should calculate the fuel for mass + fuel.', () => {
  const counter = new CounterUpper();
  expect(counter.calculateFuelFuel(12)).toBe(2);
  expect(counter.calculateFuelFuel(14)).toBe(2);
  expect(counter.calculateFuelFuel(1969)).toBe(966);
  expect(counter.calculateFuelFuel(100756)).toBe(50346);
});
