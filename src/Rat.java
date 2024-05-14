public class Rat {
    private Maze maze;
    private Location location;

    public Rat(Maze maze)
    {
        this.maze=maze;
        location=new Location(1,1);
    }

    public Location getLocation() throws CloneNotSupportedException {
        return (Location)location.clone();
    }


    public void setLocation(Location location)
    {
        this.location=location;
    }
    public boolean canMove(int direction)
    {
        Location neighbor=location.adjacent(direction);
        return maze.isOpen(neighbor);
    }

    public void move(int direction){
        location.move(direction);
        maze.markMoved(location);
    }

    public boolean isOut()
    {
        int xCoordinate=location.getX();
        int yCoordinate=location.getY();
        if(xCoordinate== maze.getWidht()-1 && yCoordinate== maze.getHeight()-2)
        {
            return true;
        }
        return false;
    }
}
