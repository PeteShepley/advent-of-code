package day3

class WireTest extends GroovyTestCase {
    def wireDef1 = 'R75,D30,R83,U83,L12,D49,R71,U7,L72'
    def wireDef2 = 'U62,R66,U55,R34,D71,R55,D58,R83'

    void testParseWires() {
        def wire = new Wire(wireDef1)
        assertEquals wire.segments[0].toString(), 'R75'
    }

    void testWireHasPoint() {
        def wire = new Wire(wireDef1)
        assertTrue wire.hasPoint([0, 70])
    }

    void testCheckForCollision() {
        def wire1 = new Wire(wireDef1)
        def wire2 = new Wire(wireDef2)
        assertTrue wire1.checkCollision(wire2)
    }
}
