/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.nyuu.grideditor.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author unyuu
 */
public class GridPanel extends JPanel {
    /*
        Количество строк - 1..10
        Количество столбцов - 1..10
        Толщина линий - 1..16
    */
    private static final int   DEFAULT_ROW_COUNT        = 3;
    private static final int   DEFAULT_COLUMN_COUNT     = 3;
    private static final int   DEFAULT_LINE_WIDTH       = 5;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.white;
    private static final Color DEFAULT_GRID_COLOR       = Color.black;
        
    private int   rowCount        = DEFAULT_ROW_COUNT;
    private int   columnCount     = DEFAULT_COLUMN_COUNT;
    private int   lineWidth       = DEFAULT_LINE_WIDTH;
    private Color backgroundColor = DEFAULT_BACKGROUND_COLOR;
    private Color gridColor       = DEFAULT_GRID_COLOR;
    
    private boolean filled = false;

    public GridPanel() {
        
    }

    public void setRowCount(int rowCount) {
        if (rowCount < 1)  rowCount = 1;
        if (rowCount > 10) rowCount = 10;
        this.rowCount = rowCount;
    }

    public void setColumnCount(int columnCount) {
        if (columnCount < 1)  columnCount = 1;
        if (columnCount > 10) columnCount = 10;
        this.columnCount = columnCount;
    }

    public void setLineWidth(int lineWidth) {
        if (lineWidth < 1)  lineWidth = 1;
        if (lineWidth > 16) lineWidth = 16;
        this.lineWidth = lineWidth;
    }

    public void setBackgroundColor(Color backgroundColor) {
        if (backgroundColor != null)
            this.backgroundColor = backgroundColor;
    }

    public void setGridColor(Color gridColor) {
        if (gridColor != null)
            this.gridColor = gridColor;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }    

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(gridColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        
        double colSize = (double)getWidth() / columnCount;
        for (int col = 0; col <= columnCount; ++col) {
            int x = (int)(colSize * col);
            g2d.drawLine(x, 0, x, getHeight()-1);
        }
        
        double rowSize = (double)getHeight() / rowCount;
        for (int row = 0; row <= rowCount; ++row) {
            int y = (int)(rowSize * row);
            g2d.drawLine(0, y, getWidth()-1, y);
        }
        
        for (int col = 0; col < columnCount; ++col)
            for (int row = 0; row < rowCount; ++row) {
                int x = (int)(colSize * col);
                int y = (int)(rowSize * row);
                if (filled)
                    g2d.fillOval(
                            x + lineWidth,
                            y + lineWidth,
                            (int)colSize - lineWidth*2,
                            (int)rowSize - lineWidth*2);
                else
                    g2d.drawOval(
                            x + lineWidth,
                            y + lineWidth,
                            (int)colSize - lineWidth*2,
                            (int)rowSize - lineWidth*2);
            }
    }  
    
    
}
