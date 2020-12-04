require "one/version"
require "one/passport_validator"

module One
  class Error < StandardError; end

  def self.read_file(filename)
    file = File.new(filename)
    file.read
  end

  def self.parse_input(input)
    input.split(/\n\n/)
  end

  def self.process_record(record)
    passport = {}
    fields = record.split(/[ \n]/)
    fields.each do |field|
      key, value = field.split(":")
      passport[key.to_sym] = value
    end
    passport
  end

  def self.is_valid(passport)
    validator = PassportValidator.new(passport)
    validator.is_valid?
  end

  def self.run
    valid_passports = 0
    records = One::parse_input(One::read_file("input"))
    passports = records.map { |record| One::process_record(record) }
    passports.each { |passport| valid_passports += 1 if One::is_valid(passport) }
    puts valid_passports
  end
end
