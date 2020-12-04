// find the two numbers which add to 2020 and multiply them
use std::fs;

fn main() {
    // let test_report = [1721, 979, 366, 299, 675, 1456];
    let contents = fs::read_to_string("src/input").expect("Error reading input");
    let mut lines = contents.lines();
    let mut test_report = Vec::<u32>::new();

    while let Some(line) = lines.next() {
        test_report.push(line.parse().unwrap());
    }

    for first in test_report.iter() {
        for second in test_report.iter() {
            if first + second == 2020 {
                println!("{}", first * second);
            }
        }
    }
}
