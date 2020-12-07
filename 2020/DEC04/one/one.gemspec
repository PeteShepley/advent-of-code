require_relative 'lib/one/version'

Gem::Specification.new do |spec|
  spec.name          = "one"
  spec.version       = One::VERSION
  spec.authors       = ["Pete Shepley"]
  spec.email         = ["peter.shepley@gmail.com"]

  spec.summary       = "Advent of Code Day 4"
  spec.description   = "Advent of Code Day 4"
  spec.homepage      = "https://peteshepley.com"
  spec.license       = "MIT"
  spec.required_ruby_version = Gem::Requirement.new(">= 2.3.0")

  spec.metadata["allowed_push_host"] = "false"

  spec.metadata["homepage_uri"] = spec.homepage
  # spec.metadata["source_code_uri"] = ""
  # spec.metadata["changelog_uri"] = ""

  # Specify which files should be added to the gem when it is released.
  # The `git ls-files -z` loads the files in the RubyGem that have been added into git.
  spec.files         = Dir.chdir(File.expand_path('..', __FILE__)) do
    `git ls-files -z`.split("\x0").reject { |f| f.match(%r{^(test|spec|features)/}) }
  end
  spec.bindir        = "exe"
  spec.executables   = spec.files.grep(%r{^exe/}) { |f| File.basename(f) }
  spec.require_paths = ["lib"]
end
