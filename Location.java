public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // public Location getAdjacentLocation(Direction dir) {
    //     int dx = 0, dy = 0;

    //     if (dir == Direction.EAST || dir == Direction.NORTH_EAST || dir == Direction.SOUTH_EAST) {
    //         dx = -10;
    //     } else if (dir == Direction.WEST || dir == Direction.NORTH_WEST || dir == Direction.SOUTH_WEST) {
    //         dx = 10;
    //     }

    //     if (dir == Direction.NORTH || dir == Direction.NORTH_EAST || dir == Direction.NORTH_WEST) {
    //         dy = -10;
    //     } else if (dir == Direction.SOUTH || dir == Direction.SOUTH_EAST || dir == Direction.SOUTH_WEST) {
    //         dy = 10;
    //     }

    //     return new Location(x + dx, y + dy);
    // }
}
