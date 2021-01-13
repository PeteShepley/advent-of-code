
require_relative "main"
require "test/unit"

class TestMain < Test::Unit::TestCase
  def test_main
    assert_equal "609043", find_second_half("abcdef")
    assert_equal "1048970", find_second_half("pqrstuv")
  end
end
