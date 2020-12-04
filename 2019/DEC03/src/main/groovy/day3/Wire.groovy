package day3

class Wire {
    Segment[] segments

    Wire(String wireDefinition) {
        segments = wireDefinition.split(',').collect { new Segment(it) }
    }

    Boolean hasPoint(Integer[] point) {
        calculateLineGraph().contains(point)
    }

    Boolean checkCollision(Wire other) {
        true
    }

    String toString() {
        segments.collect { it.toString() }
    }

    private Integer[] calculateLineGraph() {
        segments.inject([[0, 0]]) { points, segment -> points.add(createPoints(points.last(), segment)) }
    }

    private Integer[] createPoints(Integer[] startingPoint, Segment segment) {
        def vector
        switch(segment.direction) {
            case "U":
                vector = [0, 1]
                break
            case "D":
                vector = [0, -1]
                break
            case "R":
                vector = [1, 0]
                break
            case "L":
                vector = [-1, 0]
                break
        }
        (1..segment.length).collect { i -> [startingPoint[0]+i*vector[0], startingPoint[1]+i*vector[1]] }
    }
}
