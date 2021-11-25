package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func realLen(line string) int {
	count := 0
	for i := 0; i < len(line); {
		switch string(line[i]) {
		case `\`:
			if string(line[i+1]) == `x` {
				i += 4
			} else {
				i += 2
			}
		default:
			i += 1
		}
		count += 1
	}
	return count
}

func encode(line string) string {
	return strconv.Quote(line)
}

func processLine(line string) (char, real, enc int) {
	char = len(line)
	real = realLen(line[1 : char-1])
	enc = len(encode(line))
	return
}

func main() {
	var totalCharCount, totalRealCount, totalEncCount = 0, 0, 0

	// Get Input
	file, err := os.Open("input")
	if err != nil {
		fmt.Println(err)
	}
	defer file.Close()

	// Read Lines
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := scanner.Text()
		charCount, realCount, encCount := processLine(line)
		totalCharCount += charCount
		totalRealCount += realCount
		totalEncCount += encCount
	}

	partOne := fmt.Sprintf("Part one: %d - %d = %d", totalCharCount, totalRealCount, totalCharCount-totalRealCount)
	partTwo := fmt.Sprintf("Part two: %d - %d = %d", totalEncCount, totalCharCount, totalEncCount-totalCharCount)
	fmt.Println(partOne)
	fmt.Println(partTwo)

	if err := scanner.Err(); err != nil {
		fmt.Println(err)
	}
}
