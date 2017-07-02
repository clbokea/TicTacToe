//package presentationLayer;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class InitializeGui
{

	JFrame frame = new JFrame();
	
	public InitializeGui()
	{
		frame = new JFrame("Tic Tac Toe");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 3));
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}
