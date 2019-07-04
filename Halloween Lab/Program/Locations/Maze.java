package Program.Locations;

/**
 * s = start
 * e = end
 * w = wall
 * p = path
 * c = crossroad
 * a = shortest path
 * x = player
 */
public class Maze
{
    public static final char[][][] templates = new char[3][21][21];
    
    static {loadTemplates();}
    
    private final char[][] layout, playField;
    private int[] playerPos;
    private boolean showHint;
    public Maze() {
        int randInt = (int) (Math.random() * templates.length);
        layout = cloneMaze(templates[randInt]);
        playField = cloneMaze(layout);
        playerPos = findPos('s');
        setMarker(playerPos, playField, 'x');
    }
    
    public void move(String direction) {
        // Replace player marker with layout marker
        setMarker(playerPos, playField, findMarker(playerPos, layout));
        while(canMove(direction)) {
            playerPos = nextPos(playerPos,direction);
            char marker = findMarker(playerPos, layout);
            if(marker == 'c' || marker == 's' || marker == 'e')
                break;
        }
        // Set player marker
        setMarker(playerPos, playField, 'x');
    }
    
    public boolean hasEscaped() {
        return findMarker(playerPos, layout) == 'e';
    }
    
    public void showHint() {
        showHint = true;
    }
    
    public boolean canMove(String actionChoice) {
        // If climb, true when standing at start pos
        // Otherwise, can move in direction
        if(MazeRoom.validMoves[0].equals(actionChoice))
            return findMarker(playerPos, layout) == 's';
        return canMove(playerPos, actionChoice);
    }
    
    private boolean canMove(int[] pos, String direction) {
        int[] nextPos = nextPos(pos,direction);
        return nextPos[0] >= 0 && nextPos[0] < playField[0].length
            && nextPos[1] >= 0 && nextPos[1] < playField.length
            && findMarker(nextPos , playField) != 'w';
    }
    
    private int[] findPos(char marker) {
        if(marker != 'x' && marker != 's' && marker != 'e')
            throw new RuntimeException("Attempting to find position of unsupported marker!");
        
        for(int y = 0 ; y < playField.length ; y++) {
            for(int x = 0 ; x < playField[y].length ; x++) {
                if(playField[y][x] == marker) {
                    return new int[] {x,y};
                }
            }
        }

        throw new RuntimeException("Supported marker disappeared!");
    }
    
    private void setMarker(int[] pos, char[][] board, char marker) {
        board[pos[1]][pos[0]] = marker;
    }
    
    private char findMarker(int[] pos, char[][] board) {
        return board[pos[1]][pos[0]];
    }
    
    private int[] nextPos(int[] pos, String direction) {
        switch(direction) {
            case "up": return new int[] {pos[0], pos[1]-1};
            case "down": return new int[] {pos[0], pos[1]+1};
            case "left": return new int[] {pos[0]-1, pos[1]};
            case "right": return new int[] {pos[0]+1,pos[1]};
            default: throw new RuntimeException("Invalid direction in maze!");
        }
    }
    
    public String toString() {
        String output = "";
        for(char[] row : playField) {
            output += String.valueOf(row) + "\n";
        }
        output = output.replace("s","S")
            .replace("e","E")
            .replace("w","▓")
            .replace("p"," ")
            .replace("c"," ")
            .replace("x","X");
        if(showHint)
            output = output.replace("a","#");
        else
            output = output.replace("a"," ");
        
        return output;
    }
    
    private static char[][] cloneMaze(char[][] maze) {
        int dim1 = maze.length;
        int dim2 = maze[0].length;
        char[][] copy = new char[dim1][dim2];
        for(int i = 0 ; i < dim1 ; i++) {
            copy[i] = maze[i].clone();
        }
        return copy;
    }
    
    private static void loadTemplates() {
        // Board 1
        templates[0] = new char[][] {
            "wwwwwwwwwwwwwwwwwwwww".toCharArray(),
            "scacppppwppcppppppppw".toCharArray(),
            "wpwawwwwwwwpwwwwwwwpw".toCharArray(),
            "wpwaaawpppwpwpppppwpw".toCharArray(),
            "wwwwwawpwwwpwpwwwpwpw".toCharArray(),
            "wpwppcacwaacacwpppwpw".toCharArray(),
            "wpwwwwwawawwwawwwwwpw".toCharArray(),
            "wpwpppwaaawaaawppppcw".toCharArray(),
            "wpwwwpwwwwwawwwwwwwpw".toCharArray(),
            "wcaawcaaaawcppppppwpw".toCharArray(),
            "wawawawwwawawwwwwpwpw".toCharArray(),
            "wawaaawppcaawpppwpwpw".toCharArray(),
            "wawwwwwpwwwwwpwwwwwpw".toCharArray(),
            "wawpppwpppwppcppppppw".toCharArray(),
            "wawwwpwwwwwpwwwwwwwww".toCharArray(),
            "waaawpppcpppwpppppppw".toCharArray(),
            "wwwawwwwpwwwwpwwwwwpw".toCharArray(),
            "wppcaaawpwaaacacaawpw".toCharArray(),
            "wpwwwwawwwawwwwpwawww".toCharArray(),
            "wppppwaaaaawppppwaaae".toCharArray(),
            "wwwwwwwwwwwwwwwwwwwww".toCharArray()
        };
        
        // Board 2
        templates[1] = new char[][] {
            "wwwwwwwwwwwwwwwwwwwww".toCharArray(),
            "sawpppppwppppppcppppw".toCharArray(),
            "wawpwwwpwpwwwwwpwwwpw".toCharArray(),
            "wcacaawpwpwpppppwpwpw".toCharArray(),
            "wpwwwawwwpwwwwwwwpwpw".toCharArray(),
            "wpppwawpppwppppppcwpw".toCharArray(),
            "wwwpwawpwwwwwwwwwpwww".toCharArray(),
            "wpwpwaacwpppppppwpppw".toCharArray(),
            "wpwwwwwawpwwwwwpwwwpw".toCharArray(),
            "wpwaaaaawcacppwpppwpw".toCharArray(),
            "wpwawwwwwawawwwwwpwpw".toCharArray(),
            "wpwaaawaaawawpppppwpw".toCharArray(),
            "wpwwwawawwwawpwwwwwpw".toCharArray(),
            "wpppwawawaaawpwppcppw".toCharArray(),
            "wwwpwawawawwwpwwwpwww".toCharArray(),
            "wppcpcaawawpppwpcpwae".toCharArray(),
            "wpwpwwwwwawpwwwwpwwaw".toCharArray(),
            "wpwpwaaaaawppppwpppaw".toCharArray(),
            "wwwwwawwwwwwwwwwwwwaw".toCharArray(),
            "wppppcaaaaaaaaaaaaaaw".toCharArray(),
            "wwwwwwwwwwwwwwwwwwwww".toCharArray()
        };
        
        // Board 3
        templates[2] = new char[][] {
            "wwwwwwwwwwwwwwwwwwwww".toCharArray(),
            "scppwpppppppppwpppppw".toCharArray(),
            "wawwwpwwwwwwwpwwwwwpw".toCharArray(),
            "wawpwpwpwpppwpwpppppw".toCharArray(),
            "wawpwwwpwpwpwpwpwwwww".toCharArray(),
            "wcacaaacwpwcacwpwppce".toCharArray(),
            "wpwwwwwawwwawawpwwwaw".toCharArray(),
            "wpwpwpwaaaacwcppwaacw".toCharArray(),
            "wpwpwpwwwwwpwawwwawpw".toCharArray(),
            "wpppwcppppppwawaaawpw".toCharArray(),
            "wwwwwpwwwwwwwawawwwww".toCharArray(),
            "wppcpcppwaaaaawaaaaaw".toCharArray(),
            "wpwpwwwwwawwwwwwwwwaw".toCharArray(),
            "wpwpwaaaacppwpppwaaaw".toCharArray(),
            "wpwwwawwwwwpwpwwwawww".toCharArray(),
            "wpwpwaaawppcppwaacppw".toCharArray(),
            "wpwpwwwawwwwwwwawwwpw".toCharArray(),
            "wpwpppwaaaaaaaaawpwpw".toCharArray(),
            "wpwwwpwwwwwwwwwwwpwpw".toCharArray(),
            "wppppcppppppppppppwpw".toCharArray(),
            "wwwwwwwwwwwwwwwwwwwww".toCharArray()
        };
    }
}
