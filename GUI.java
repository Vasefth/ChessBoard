import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	private Board board;
	
	public GUI() {
						
		board = new Board();
		
		this.setContentPane(board);
		
		ChessListener listener = new ChessListener();
		board.addMouseMotionListener(listener);
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class Board extends JPanel {
		
		private static final int ROWS = 8;
		private static final int COLUMNS = 8;
		private int xCoord = 50;
		private int yCoord = 50;
		
		public void setXCoord(int x) {
			xCoord = x;
		}
		
		public void setYCoord(int y) {
			yCoord = y;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int sqSize = this.getHeight() / ROWS;
			for(int i=0; i<ROWS; i++)  //σάρωση γραμμών
				for(int j=0; j<COLUMNS; j++)  // σάρωση στηλών
				{
				     int x = i * sqSize;
				     int y = j * sqSize;
				     
				     if( (i+j)%2 != 0) {
				       g.setColor(Color.BLUE);
				       g.fillRect(x, y, sqSize, sqSize);
				     }
				     else
				     {
				       g.setColor(Color.YELLOW);
					   g.fillRect(x, y, sqSize, sqSize); 
				     }
				}	
			g.setColor(Color.RED);
			g.fillOval(xCoord, yCoord, 40, 40);
		}
	}
	
	class ChessListener implements MouseMotionListener {
		
		public void mouseDragged(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			board.setXCoord(x-20);
			board.setYCoord(y-20);
			board.repaint();
			
		}
		
		public void mouseMoved(MouseEvent e) {
			
		}	
	}
}