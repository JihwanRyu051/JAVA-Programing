package TicTacToeUsingGUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class TicTacToe extends JFrame{
	JLabel label;
	JTextArea text;
	JButton[][] btnArr = new JButton[3][3];
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagLayout grid = new GridBagLayout();
	TicTacToeBoard TTB = new TicTacToeBoard();
	JPanel panel = new JPanel();
	
	int count = 0;
	
	class Terminator extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	class QuitAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class RestartAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			count = 0;
			TTB.clear();
			label.setText("");
			for(int i=0; i<3; i++) 
				for(int j=0; j<3; j++) 
					btnArr[i][j].setText("");
		}
	}
	public TicTacToe() {
		setTitle("Tic Tac Toe");
		setSize(500,500);
		setLocation(100,200);
		addWindowListener(new Terminator());
		setContentPane(getPanel());
	}
		
	public static void main(String[] args) {
		JFrame jf = new TicTacToe();
		jf.setVisible(true);
		
	}
	
	public JPanel getPanel() {
		
		panel.setLayout(grid);
	
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		label = makeLabel();
		make(label, 0,0,3,1);
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);
	
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				btnArr[i][j] = makeButton(i,j);
				make(btnArr[i][j],j,i+1,1,1);
				panel.add(btnArr[i][j],gbc);
			}
		}
		JButton Quitbtn = makeButton(-1, 0);
		JButton Rebtn   = makeButton(-1,-1);
		make(Quitbtn, 0,4,1,1);
		panel.add(Quitbtn);
		make(Rebtn  , 2,4,1,1);
		panel.add(Rebtn  );	
		return panel; //setLayout(), FlowLayout()...
	}
	
	public void make(JComponent c, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        grid.setConstraints(c, gbc);
 }
	private JButton makeButton(int i, int j) {
		final JButton btn = new JButton();
		if(i<0) {
			if(j<0) {
				btn.setText("Restart");
				btn.addActionListener(new RestartAction());
			}
			else {
				btn.setText("Quit");
				btn.addActionListener(new QuitAction());
			}
		}
		else {
		btn.setName(i+""+j);
		btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(label.getText().equals("")) {
						if(btn.getText().equals("")) {
						count++;
						if(count%2 == 0) btn.setText("X");
						else 			 btn.setText("O");
						label.setText(TTB.run(btn));
						}
					}
			}
			});
		}
		return btn;
	}
	
	private JLabel makeLabel() {
		JLabel result = new JLabel("");
		result.setFont(new Font("Serif", Font.BOLD, 25));
		return result;
	}
}