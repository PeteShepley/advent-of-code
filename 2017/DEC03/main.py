def get_ring_max(ring):
    return pow(ring + ring - 1, 2)


def get_ring_min(ring):
    return get_ring_max(ring - 1) + 1


if __name__ == '__main__':
    # location = 312051
    location = 2
    ring = 0
    while True:
        ring += 1
        ring_max = get_ring_max(ring)
        if ring_max > location:
            break
    print(ring)
    ring_min = get_ring_min(ring)
    ring_max = get_ring_max(ring)
    print(ring_min)
    print(ring_max)
    side = (ring_max - ring_min + 1) / 4
    print(side)
