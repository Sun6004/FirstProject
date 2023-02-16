package basicProject;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class testLogic extends JFrame implements KeyListener{
	
	JTextArea ta = new JTextArea();
	
	
	
	public testLogic() {
		ta.setText("		가나다라마바사");
		ta.setFont(new Font("Courier New", Font.PLAIN, 30));
		this.add(ta);
		this.pack();
		this.setTitle("Let's play Space Invaders");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	public static void main(String[] args) {
		new testLogic();
	}
	
}	
