public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
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
