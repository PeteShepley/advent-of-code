const { Adder } = require('../source');

describe('Adder', () => {
  it('should produce a sum of 3', () => {
    expect(Adder.add('1122')).toBe(3);
  });

  it('should produce sum of 4', () => {
    expect(Adder.add('1111')).toBe(4);
  });

  it('should produce sum of 0', () => {
    expect(Adder.add('1234')).toBe(0);
  });

  it('should produce sum of 9', () => {
    expect(Adder.add('91212129')).toBe(9);
  });

  describe('add2', () => {
    it('should produce sum of 6', () => {
      expect(Adder.add2('1212')).toBe(6);
    });
    it('should produce sum of 0', () => {
      expect(Adder.add2('1221')).toBe(0);
    });
    it('should produce sum of 4', () => {
      expect(Adder.add2('123425')).toBe(4);
    });
    it('should produce sum of 12', () => {
      expect(Adder.add2('123123')).toBe(12);
    });
    it('should produce sum of 4', () => {
      expect(Adder.add2('12131415')).toBe(4);
    });
  });
});

