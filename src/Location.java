public class Location implements Cloneable {

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void move(int direction){
        switch (direction)
        {
            case Directions.NORTH:
            {
                --y;
                break;
            }
            case Directions.SOUTH:
            {
                ++y;
                break;
            }
            case Directions.WEST:
            {
                --x;
                break;
            }
            case Directions.EAST: {
                ++x;
                break;
            }
        }
    }
    public Location adjacent(int direction){
        switch (direction)
        {
            case Directions.NORTH:
            {
                return new Location(x,y-1);
            }
            case Directions.EAST:
            {
                return new Location(x+1,y);
            }
            case Directions.SOUTH:{
                return new Location(x,y+1);
            }
            case Directions.WEST:{
                return new Location(x-1,y);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
