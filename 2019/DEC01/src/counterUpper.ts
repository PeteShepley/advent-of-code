export class CounterUpper {
  public calculate(masses: number[]): number {
    return masses.reduce((total, mass) => {
      return total + this.calculateFuel(mass);
    }, 0);
  }

  public calculateWithFuel(masses: number[]): number {
    return masses.reduce((total, mass) => {
      return total + this.calculateFuelFuel(mass);
    }, 0);
  }

  public calculateFuel(mass: number): number {
    return Math.floor(mass / 3) - 2;
  }

  public calculateFuelFuel(mass: number): number {
    const fuel = this.calculateFuel(mass);
    if (fuel <= 0) {
      return 0;
    } else {
      return fuel + this.calculateFuelFuel(fuel);
    }
  }
}
