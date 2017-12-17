package calculator;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class NumberButton extends JButton
{
	Integer num;
	public NumberButton(String args,TextField text) {
		// TODO Auto-generated constructor stub
		super(args);
		num=Integer.parseInt(args);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText(text.getText()+num.toString());
				text.requestFocus();
				text.setCaretPosition(text.getText().length());
			}
		});
	}
}
