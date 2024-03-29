package io.johnvincent.kakuro;

import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Appgui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1;

	private DataStore m_dataStore = new DataStore();

	private JTextField m_textCount = new JTextField(5);
	private JTextField m_textSquares = new JTextField(3);
	private JTextArea m_messagesArea;
	private JButton m_btnCalculate;
	private JButton m_btnClear;
	private JButton m_btnExit;

	public static void main(String[] args) {(new Appgui()).doApp();}
	private void doApp() {
		setContentPane(makeContentPane());
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				doStop();
			}
		});
		setTitle("Kakuro");
		setSize(700,900);
		pack();
		setVisible(true);			
	}

	public void doStop() {System.exit(0);}
	private Container makeContentPane() {
		JPanel boardPanel = new JPanel();  // panel for the squares
		boardPanel.add (new JLabel("Count:"));
		boardPanel.add (m_textCount);
		boardPanel.add (new JLabel("Squares:"));
		boardPanel.add (m_textSquares);
		
		JPanel topPane = new JPanel(); // panel for the board
		topPane.setLayout(new BorderLayout());
		topPane.add(boardPanel, BorderLayout.CENTER);

		JPanel midPane = new JPanel();
		m_messagesArea = new JTextArea(30,40);
		m_messagesArea.setEditable(true);		
		m_messagesArea.setDragEnabled(true);	
		midPane.add(new JScrollPane(m_messagesArea));

		JPanel lowPane = new JPanel();
		m_btnCalculate = new JButton("Start");
		m_btnCalculate.addActionListener(this);
		m_btnClear = new JButton("Clear");
		m_btnClear.addActionListener(this);
		m_btnExit = new JButton("Exit");
		m_btnExit.addActionListener(this);
		lowPane.add(m_btnCalculate);
		lowPane.add(m_btnClear);
		lowPane.add(m_btnExit);	

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(topPane,BorderLayout.NORTH);
		pane.add(midPane,BorderLayout.CENTER);
		pane.add(lowPane,BorderLayout.SOUTH);			
		return pane;
	}	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JButton) {
			if (source == m_btnCalculate) {
				doCalculate();
			}
			else if (source == m_btnClear) {
				clearMessagesArea();
			}
			else if (source == m_btnExit) {
				doStop();
			}
		}
	}
	private void doCalculate() {
		int squares = 0;
		int count = 0;
		try {
			squares = makeInt(m_textSquares.getText());
			count = makeInt(m_textCount.getText());
		}
		catch (Exception ex) {
			setMessagesArea("Unable to make sense of your numbers.");
			setMessagesArea("Please check them and try again.");
			return;
		}
		setMessagesArea(" Count: "+ count+ ", Squares: "+squares+"\n");
		Answers all = (new Utils(m_dataStore, squares, count)).doCalculate();
		setMessagesArea(" Solutions: "+all.getSize()+"\n");
		Answer answer;
		Iterator<Answer> iter = all.getAnswers();
		while (iter.hasNext()) {
			answer = iter.next();
			setMessagesArea(" "+answer.toString());
		}
		setMessagesArea("\n --------------------------- \n");
	}
	public static int makeInt(String str) {
		int num = Integer.parseInt(str);
		if (num < 0) return -num;
		return num;
	}
	public void setMessagesArea(final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_messagesArea.append(msg);
					m_messagesArea.append("\n");
					m_messagesArea.setCaretPosition(m_messagesArea.getText().length());
					validate();
				}
			}
		);
	}
	public void clearMessagesArea() {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_messagesArea.setText("");
					m_messagesArea.setCaretPosition(m_messagesArea.getText().length());
					validate();
				}
			}
		);
	}
}
