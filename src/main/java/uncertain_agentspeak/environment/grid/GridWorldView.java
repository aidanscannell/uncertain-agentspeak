package main.java.uncertain_agentspeak.environment.grid;

import javax.swing.*;
import java.awt.*;

public class GridWorldView extends JFrame {

    private int cellWidth;
    private int cellHeight;
    private Font font = new Font("Arial",Font.BOLD,10);
    private static int limit = (int)Math.pow(2,14);

    private GridWorldModel model;

    private GridCanvas gridArea;

    public GridWorldView(GridWorldModel gridWorldModel, String title, int windowSize) {
        super(title);
        this.model = gridWorldModel;
        initComponents(windowSize);
        model.setGridWorldView(this);
    }

    public void initComponents(int width) {
        setSize(width, width);
        getContentPane().setLayout(new BorderLayout());
        gridArea = new GridCanvas();
        getContentPane().add(BorderLayout.CENTER, gridArea);
    }

    @Override
    public void repaint() {
        cellWidth = gridArea.getWidth() / model.getWidth();
        cellHeight = gridArea.getHeight() / model.getHeight();
        super.repaint();
        gridArea.repaint();
    }

    public void update() {
        repaint();
    }

    public void update(int x, int y) {
        Graphics g = gridArea.getGraphics();
        if (g == null) {
            return;
        }
        drawEmpty(g, x, y);
        draw(g, x, y);
    }

    public void drawObstacle(Graphics g, int x, int y) {
        g.setColor(Color.lightGray);
        g.fillRect(x * cellWidth + 1, y * cellHeight+1, cellWidth-1, cellHeight-1);
        g.setColor(Color.lightGray);
        g.drawRect(x * cellWidth + 2, y * cellHeight+2, cellWidth-4, cellHeight-4);
    }

    public void drawAgent(Graphics g, int x, int y, Color c, int id) {
        g.setColor(c);
        g.fillOval(x * cellWidth+2, y * cellHeight+2, cellWidth-4, cellHeight-4);
        if (id >= 0) {
            g.setColor(Color.black);
            drawString(g, x, y, font, String.valueOf(id+1));
        }
    }

    public void drawString(Graphics g, int x, int y, Font f, String s) {
        g.setFont(f);
        FontMetrics metrics = g.getFontMetrics();
        int width = metrics.stringWidth( s );
        int height = metrics.getHeight();
        g.drawString( s, x*cellWidth+(cellWidth/2-width/2), y*cellHeight+(cellHeight/2+height/2));
    }

    public void drawEmpty(Graphics g, int x, int y) {
        g.setColor(Color.white);
        g.fillRect(x * cellWidth + 1, y * cellHeight+1, cellWidth-1, cellHeight-1);
        g.setColor(Color.lightGray);
        g.drawRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
    }

    public void draw(Graphics g, int x, int y, int object) {}

    private void draw(Graphics g, int x, int y) {
        if ((model.getGrid()[x][y] & GridWorldModel.OBSTACLE) != 0) {
            drawObstacle(g, x, y);
        }

        int vl = GridWorldModel.OBSTACLE*2;
        while (vl < limit) {
            if ((model.getGrid()[x][y] & vl) != 0) {
                draw(g, x, y, vl);
            }
            vl *= 2;
        }

        if ((model.getGrid()[x][y] & GridWorldModel.AGENT) != 0) {
            drawAgent(gridArea.getGraphics(), x, y, Color.blue, model.getAgentAtPos(new Location(x, y)));
        }
    }

    public Canvas getCanvas() {
        return gridArea;
    }

    public GridWorldModel getModel() {
        return model;
    }

    class GridCanvas extends Canvas {

        private static final long serialVersionUID = 1L;

        public void paint(Graphics g) {
            cellWidth = gridArea.getWidth() / model.getWidth();
            cellHeight = gridArea.getHeight() / model.getHeight();
            int mwidth = model.getWidth();
            int mheight = model.getHeight();

            g.setColor(Color.lightGray);
            for (int l = 1; l <= mheight; l++) {
                g.drawLine(0, l * cellHeight, mwidth * cellWidth, l * cellHeight);
            }
            for (int c = 1; c <= mwidth; c++) {
                g.drawLine(c * cellWidth, 0, c * cellWidth, mheight * cellHeight);
            }

            for (int x = 0; x < mwidth; x++) {
                for (int y = 0; y < mheight; y++) {
                    draw(g,x,y);
                }
            }
        }
    }
}
