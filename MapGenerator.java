import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                map[r][c] = 1;
            }
        }
        brickWidth = 540/ col;
        brickHeight = 150/row;
    }

    public void draw(Graphics2D g) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if(map[r][c] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(c * brickWidth + 80, r * brickHeight + 50, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(c * brickWidth + 80, r * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickvalue(int value, int row, int col) {
        map[row][col] = value;
    }

}