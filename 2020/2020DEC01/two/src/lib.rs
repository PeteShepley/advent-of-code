use std::fs;

fn calculate_for_three(values: &[u32]) -> u32 {
    for first in values.iter() {
        for second in values.iter() {
            for third in values.iter() {
                if first + second + third == 2020 {
                    return first * second * third;
                }
            }
        }
    }
    return 0;
}

fn read_file_of_integers(filename: String) -> Vec<u32> {
    let contents = fs::read_to_string(filename).expect("Error reading input");
    let mut lines = contents.lines();
    let mut report = Vec::<u32>::new();

    while let Some(line) = lines.next() {
        report.push(line.parse().unwrap());
    }

    return report;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_calculate_for_three() {
        let test_report = [1721, 979, 366, 299, 675, 1456];
        let result = calculate_for_three(&test_report);
        assert_eq!(241861950, result);
    }

    #[test]
    fn test_read_file() {
        read_file_of_integers(String::from("./input"));
    }

    #[test]
    fn test_calculcate_for_three_against_file() {
        let report = read_file_of_integers(String::from("./input"));
        let result = calculate_for_three(&report);
        println!("{}", result);
    }
}
