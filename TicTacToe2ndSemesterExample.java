//package presentationLayer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToe2ndSemesterExample implements ActionListener
{
	JFrame frame;
	InitializeGui gui = new InitializeGui();
	boolean user = true;
	Map<Integer, Integer> userPoint = new HashMap<Integer, Integer>();
	Map<Integer, Integer> values = new HashMap<Integer, Integer>();
	List<Integer> wins = new ArrayList<Integer>();
	ImageIcon oImg = new ImageIcon("/Users/clbo/Google Drive/KEA_Macbook/Eclipse/Mandatory/TicTacToe/img/oPhoto-icon.png");
	ImageIcon xImg = new ImageIcon("/Users/clbo/Google Drive/KEA_Macbook/Eclipse/Mandatory/TicTacToe/img/Red-X.png");

	public TicTacToe2ndSemesterExample()
	{

		oImg = resizeImg(oImg);
		xImg = resizeImg(xImg);
		
		frame = gui.getFrame();
		initializeScoreMap();
		setButtonValues();
		populateWin();
		addButtons();

		// Make it visible
		frame.setVisible(true);

	}

	private ImageIcon resizeImg(ImageIcon x)
	{
		Image img = x.getImage();
		Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		return new ImageIcon( newimg );
	}

	private void initializeScoreMap()
	{
		userPoint.put(1, 0);
		userPoint.put(2, 0);
	}

	private void addButtons()
	{
		for (int i = 0; i < 9; i++)
		{
			String s = Integer.toString(values.get(i));
			JButton btn = new JButton(s);
			btn.setForeground(new Color(1, 1, 1, 1));
			btn.setBackground(Color.DARK_GRAY);
			btn.setOpaque(true);
			Border border = new LineBorder(Color.WHITE);
			btn.setBorder(border);
			frame.add(btn);
			btn.addActionListener(this);

		}
	}

	private void setButtonValues()
	{
		int counter = 0;
		for (int i = 0; i < 9; i++)
		{
			if (counter == 0)
			{
				values.put(i, counter + 1);
				counter++;
			}
			else
			{
				counter = counter * 2;
				values.put(i, counter);
			}
		}
	}

	private void populateWin()
	{
		// initialize wins arrayList
		wins.add(values.get(0) + values.get(1) + values.get(2));
		wins.add(values.get(3) + values.get(4) + values.get(5));
		wins.add(values.get(6) + values.get(7) + values.get(8));
		wins.add(values.get(0) + values.get(3) + values.get(6));
		wins.add(values.get(1) + values.get(4) + values.get(7));
		wins.add(values.get(2) + values.get(5) + values.get(8));
		wins.add(values.get(0) + values.get(4) + values.get(8));
		wins.add(values.get(2) + values.get(4) + values.get(6));
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton btnClicked = (JButton) e.getSource();

		if (user)
		{
			int sum = userPoint.get(1) + Integer.parseInt(btnClicked.getText());
			btnClicked.setText("");
			btnClicked.setIcon(xImg);
			userPoint.put(1, sum);
		}
		else
		{
			int sum = userPoint.get(2) + Integer.parseInt(btnClicked.getText());
			btnClicked.setText("");
			btnClicked.setIcon(oImg);
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

}