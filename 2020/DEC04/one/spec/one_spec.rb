RSpec.describe One do
  it "has a version number" do
    expect(One::VERSION).not_to be nil
  end

  context "read_file" do
    it "should read a file" do
      file_string = One::read_file("test_input")
      expect(file_string.size).to eq(283)
      expect(file_string.count "\n").to eq(13)
    end
  end

  context "parse_input" do
    it "should create an element for each passport" do
      input = One::read_file("test_input")
      passports = One::parse_input(input)
      expect(passports.size).to eq(4)
    end
  end

  context "process_record" do
    it "should find all fields for a passport" do
      input = One::read_file("test_input")
      records = One::parse_input(input)
      records.each do |record|
        passport = One::process_record(record)
        expect(passport.keys.size > 0).to be(true)
      end
    end
  end

  context "is_valid" do
    it "should return true for valid passports" do
      passport = {
        :byr => "1982",
        :iyr => "2012",
        :eyr => "2022",
        :hgt => "74in",
        :hcl => "#54380f",
        :ecl => "brn",
        :pid => "888555000",
        :cid => "ignored"
      }
      expect(One::is_valid(passport)).to be(true)
    end
  end
end
