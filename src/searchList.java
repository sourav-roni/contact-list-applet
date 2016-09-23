import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class searchList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1992942600018557915L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchList frame = new searchList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public searchList(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Search List");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/contactlist.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of your Aquaintance");
		lblEnterTheName.setBounds(37, 67, 278, 15);
		contentPane.add(lblEnterTheName);
		
		textField = new JTextField();
		textField.setBounds(333, 59, 291, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchResult search = new searchResult(contactList,textField.getText());
				search.setVisible(true);
			}
		});
		btnGo.setBounds(102, 135, 117, 45);
		try {
			image = ImageIO.read(getClass().getResource("/search.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnGo.setIcon(new ImageIcon( image));
		contentPane.add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(437, 135, 108, 45);
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image));
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
			}
		});
		btnReset.setBounds(274, 145, 117, 25);
		try {
			image = ImageIO.read(getClass().getResource("/reset.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnReset.setIcon(new ImageIcon( image));
		contentPane.add(btnReset);
	}
}
