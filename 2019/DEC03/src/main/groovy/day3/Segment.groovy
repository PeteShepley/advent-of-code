package day3

class Segment {
    String direction
    int length

    Segment(String segmentDefinition) {
        direction = segmentDefinition[0]
        length = Integer.parseInt(segmentDefinition.substring(1))
    }

    String toString() {
        "${direction}${length}"
    }
}
