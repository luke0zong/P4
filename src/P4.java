// P4 Assignment
// Author: Yaowei Zong
// Date:   Jun 30, 2015
// Class:  CS160
// Email:  zongyw@cs.colostate.edu

public class P4 {

    public static void main(String[] args) {

        // Create maze
        String fileName = args[0];
        Maze maze = new Maze(fileName);
        System.out.println("Maze name: " + fileName);

        // Get dimensions
        int mazeWidth = maze.getWidth();
        int mazeHeight = maze.getHeight();
        System.out.println("Maze width: " + mazeWidth);
        System.out.println("Maze height: " + mazeHeight);


        int x = 0, y = 0;

        do {
             /* NEED WORKING!
            // New move right.
            if (y % 2 == 0) {
                for (x = 0; x < (mazeWidth + 1); x++) {
                    if (!maze.moveRight()) {
                        maze.moveDown();
                        maze.moveRight();
                        maze.moveRight();
                        maze.moveUp();
                        x++;
                    }
                    if (maze.isDone()) {
                        System.out.println("Done!");
                        System.exit(0);
                    }
                }

                maze.moveDown();
                y++;
                if (maze.isDone()) {
                    System.out.println("Done!");
                    System.exit(0);
                }


            }

            // new move left
            if (y % 2 == 1) {
                for (x = mazeWidth - 1; x > 0; x--) {
                    if (!maze.moveLeft()) {
                        maze.moveDown();
                        maze.moveLeft();
                        maze.moveLeft();
                        maze.moveUp();
                        x--;
                    }
                    if (maze.isDone()) {
                        System.out.println("Done!");
                        System.exit(0);
                    }
                }

                maze.moveDown();
                y++;
                if (maze.isDone()) {
                    System.out.println("Done!");
                    System.exit(0);
                }
            }

             */


            // Move right
            while (y % 2 == 0) {
                // End of row
                if (x == mazeWidth - 1) {
                    maze.moveDown();
                    y++;
                    if (maze.isDone()) {
                        System.out.println("Done!");
                        System.exit(0);
                    }
                } else if (maze.moveRight()) {
                    x++;
                    if (maze.isDone()) {
                        System.out.println("Done!");
                        System.exit(0);
                    }

                }
                // Occur obstacle
                else {
                    maze.moveDown();
                    maze.moveRight();
                    maze.moveRight();
                    maze.moveUp();
                    x += 2;
                }

            }


            //Move Left
            while (y % 2 == 1) {
                // End of row
                if (x == 0) {
                    maze.moveDown();
                    y++;
                    if (maze.isDone()) {
                        System.out.println("Done!");
                        System.exit(0);
                    }
                } else if (maze.moveLeft()) {
                    x--;
                    if (maze.isDone()) {
                        System.out.println("Done!");
                        System.exit(0);
                    }
                } else {
                    maze.moveDown();
                    maze.moveLeft();
                    maze.moveLeft();
                    maze.moveUp();
                    x -= 2;
                }
            }


            if (maze.isDone()) {
                System.out.println("Done!");
                System.exit(0);

            }
        }
        while (!maze.isDone());

    }
}