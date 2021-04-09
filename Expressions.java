package final350_package;

/*Author: Vanessa Abrahams
 * Date: March 30, 2021
 * Project: Project 1 - Prefix to Postfix Conversions
 * Description: This class runs the GUI that users will enter data - whether prefix to postfix and viceversa. 
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Expressions extends JFrame {
	Converter converter = new Converter();
	public Expressions() {
		//setup GUI with labels, buttons and textfield components
		JLabel label = new JLabel("Enter expression");
		JTextField textfield = new JTextField(20);
		JButton btn1 = new JButton("Prefix to Postfix");
		JButton btn2 = new JButton("Postfix to Prefix");
		JLabel label_two = new JLabel("                  Result");
		JLabel result = new JLabel();
		JTextField resultfield = new JTextField(20);
		//add actionlisteners for the prefix button to convert to postfix
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prefix = textfield.getText();
				// when button is clicked, try to convert prefix to postfix
				try {
					//fill result field with the postfix expression
					resultfield.setText(converter.parsePrefixToPostfix(prefix));
				// if the button is clicked and the prefix expression can't be converted as entered, error message
				} catch (SyntaxError error) {
					JOptionPane.showMessageDialog(Expressions.this, error.getMessage(), "Error Message",
                            JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//add actionlisteners for the postfix button to convert to prefix
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String postfix = textfield.getText();
				// when button is clicked, try to convert postfix to prefix
				try {
					//fill result field with the prefix expression
					resultfield.setText(converter.parsePostfixToPrefix(postfix));
					// if the button is clicked and the postfix expression can't be converted as entered, error message
				} catch (SyntaxError error) {
					JOptionPane.showMessageDialog(Expressions.this, error.getMessage(), "Error Message",
                            JOptionPane.ERROR_MESSAGE);
				}
			}
		}); 
		// add components, layout and set the size of the GUI
		setSize(400, 200);
		add(label);
		add(textfield);
		add(btn1);
		add(btn2);
		add(label_two);
		add(result);
		add(resultfield);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Expression Converter");
	}
	// run main method
    public static void main(String[] args) throws SyntaxError {
    	
    	Expressions window = new Expressions();
    }
    
    
}
