require "digest"

def find_second_half(first_half, leading_zeros = 5)
  second_half_try = 0
  found = false
  until found
    hash = Digest::MD5.hexdigest(first_half + second_half_try.to_s)
    if hash[0..(leading_zeros-1)] == ("0" * leading_zeros)
      found = true
    else
      second_half_try += 1
    end
  end
  second_half_try.to_s
end

puts find_second_half("yzbqklnj")
puts find_second_half("yzbqklnj", 6)
