class PassportValidator
  REQUIRED_FIELDS = [:byr, :iyr, :eyr, :hgt, :hcl, :ecl, :pid, :cid]
  NORTH_POLE_FIELDS = [:byr, :iyr, :eyr, :hgt, :hcl, :ecl, :pid]
  VALID_EYE_COLORS = %w[amb blu brn gry grn hzl oth]

  def initialize(passport)
    @passport = passport
  end

  def is_valid?
    has_required_fields
  end

  private

  def has_required_fields
    NORTH_POLE_FIELDS.all? { |field| @passport.has_key? field } and
      has_valid_birthyear and
      has_valid_issueyear and
      has_valid_exp and
      has_valid_height and
      has_valid_hair_color and
      has_valid_eye_color and
      has_valid_id
  end

  def has_valid_birthyear
    @passport[:byr].size == 4 and @passport[:byr].to_i >= 1920 and @passport[:byr].to_i <= 2002
  end

  def has_valid_issueyear
    @passport[:iyr].size == 4 and @passport[:iyr].to_i >= 2010 and @passport[:iyr].to_i <= 2020
  end

  def has_valid_exp
    @passport[:eyr].size == 4 and @passport[:eyr].to_i >= 2020 and @passport[:eyr].to_i <= 2030
  end

  def has_valid_height
    if @passport[:hgt].include?("in")
      @passport[:hgt].to_i >= 59 and @passport[:hgt].to_i <= 76
    elsif @passport[:hgt].include?("cm")
      @passport[:hgt].to_i >= 150 and @passport[:hgt].to_i <= 193
    else
      false
    end
  end

  def has_valid_hair_color
    @passport[:hcl][0] == '#' and @passport[:hcl][1..].match?(/^[0-9a-fA-F]*$/)
  end

  def has_valid_eye_color
    VALID_EYE_COLORS.any? { |color| @passport[:ecl] == color }
  end

  def has_valid_id
    @passport[:pid].size == 9 and @passport[:pid].match?(/^\d*$/)
  end
end
