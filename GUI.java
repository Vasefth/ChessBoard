import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GUI extends JFrame{

	public GUI() {
			
		Board board = new Board();
		this.setContentPane(board);
		
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class Board extends JPanel{
		
		private static final int ROWS = 8;
		private static final int COLUMNS = 8;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int sqSize1 = this.getHeight()/ROWS;
			int sqSize2 = this.getWidth()/COLUMNS;
			int sqSize = sqSize1;
			if(sqSize2 < sqSize) {
				sqSize = sqSize2;
			}
			
			for(int i=0;i<ROWS;i++) {
				for(int j=0;j<COLUMNS;j++) {
					int x,y;
					x = j*sqSize;
					y = i*sqSize;
					
					if((i+j)%2 ==0) {
						g.setColor(Color.RED);
						g.fillRect(x,y, sqSize, sqSize);
					}
					else {
						g.setColor(Color.BLUE);
						g.fillRect(x,y,sqSize,sqSize);
					}
				}
			}
		}
	}
}
