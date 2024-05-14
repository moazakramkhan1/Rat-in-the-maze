import java.io.IOException;
import java.util.Stack;

public class SolveMaze {

    Maze maze;
    Rat rat;
    Stack<Location> stack;

    public SolveMaze(String file) throws IOException, CloneNotSupportedException {
        maze=new Maze(file);
        rat=new Rat(maze);
        stack=new Stack<>();
        stack.push(rat.getLocation());
        maze.markMoved(rat.getLocation());
        maze.print();
        while (!stack.isEmpty() && !rat.isOut()) {

            boolean moved = false;

            for (int i = Directions.NORTH; i <= Directions.WEST; i++) {

                if (rat.canMove(i)) {
                    rat.move(i);
                    stack.push(new Location(rat.getLocation().getX(), rat.getLocation().getY()));
                    moved = true;
                    break;
                }
            }
            if (!moved) {
                maze.markTried(stack.pop());
                Location newLoc = new Location(stack.peek().getX(), stack.peek().getY());
                rat.setLocation(newLoc);
            }

        }
        System.out.println();
        maze.print();
    }

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
       new SolveMaze("C:\\Users\\Moaz Akram Khan\\IdeaProjects\\LABassignmentMaze\\out\\production\\LABassignmentMaze\\maze.txt");
    }
}
