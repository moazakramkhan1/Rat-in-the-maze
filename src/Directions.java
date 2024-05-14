public class Directions {
    public static final int NORTH=0, EAST=1,WEST=3,SOUTH=2;
    private int direction;

    public Directions(int d) {
        if(d<0 || d>3)
            throw new IllegalArgumentException();
        this.direction = d;
    }
    public int getDirection()
    {
        return direction;
    }
}
