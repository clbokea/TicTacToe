package presentationLayer;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicTacToeExample implements ActionListener
{
	// Make a JFrame object
	JFrame frame;
	JButton btn1;
	boolean user = true;
	Map<Integer, Integer> userPoint = new HashMap<Integer, Integer>();
	Map<JButton, Integer> values = new HashMap<JButton, Integer>();
	ArrayList<Integer> wins = new ArrayList<Integer>();

	public TicTacToeExample()
	{
		// set initial score for users
		userPoint.put(1, 0);
		userPoint.put(2, 0);
		// add winning combination
		wins.add(7);
		wins.add(56);
		wins.add(448);
		wins.add(73);
		wins.add(146);
		wins.add(292);
		wins.add(273);
		wins.add(84);

		frame = new JFrame("Tic Tac Toe");

		// Sice of window
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(3, 3));

		// Buttons
		btn1 = new JButton("1");
		frame.add(btn1);
		btn1.addActionListener(this);
		values.put(btn1, 1);

		JButton btn2 = new JButton("2");
		frame.add(btn2);
		btn2.addActionListener(this);
		values.put(btn1, 2);

		JButton btn3 = new JButton("4");
		frame.add(btn3);
		btn3.addActionListener(this);
		values.put(btn1, 4);

		JButton btn4 = new JButton("8");
		frame.add(btn4);
		btn4.addActionListener(this);
		values.put(btn1, 8);

		JButton btn5 = new JButton("16");
		frame.add(btn5);
		btn5.addActionListener(this);
		values.put(btn1, 16);

		JButton btn6 = new JButton("32");
		frame.add(btn6);
		btn6.addActionListener(this);
		values.put(btn1, 32);

		JButton btn7 = new JButton("64");
		frame.add(btn7);
		btn7.addActionListener(this);
		values.put(btn1, 64);

		JButton btn8 = new JButton("128");
		frame.add(btn8);
		btn8.addActionListener(this);
		values.put(btn1, 128);

		JButton btn9 = new JButton("256");
		frame.add(btn9);
		btn9.addActionListener(this);
		values.put(btn1, 256);

		// Make it visible
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		JButton btnClicked = (JButton) e.getSource();

		ifAreaAlreadyFull();

		if (user)
		{
			int sum = userPoint.get(1) + Integer.parseInt(btnClicked.getText());
			btnClicked.setText("X");
			userPoint.put(1, sum);
		}
		else
		{
			int sum = userPoint.get(2) + Integer.parseInt(btnClicked.getText());
			btnClicked.setText("0");
			userPoint.put(2, sum);
		}
		btnClicked.setEnabled(false);
		win();
		user = !user;

	}

	private void win()
	{
		for (Integer w : wins)
		{
			if (userPoint.get(1).equals(w))
			{
				JOptionPane.showMessageDialog(null, "User X, You win!");
			}
			else if (userPoint.get(2).equals(w))
			{
				JOptionPane.showMessageDialog(null, "User 0, You win!");
			}
		}
	}

	private void ifAreaAlreadyFull()
	{
		// if user 1 clicked a user 1 field
		// mark the field (color) ready for moving

	}
}