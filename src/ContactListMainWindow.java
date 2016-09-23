import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class ContactListMainWindow extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2390608022892318994L;
	private JPanel contentPane;
	static Acquaintances contactList = new Acquaintances();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactListMainWindow frame = new ContactListMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try
			      {
			         FileInputStream fileIn = new FileInputStream("contactlist");
			         ObjectInputStream input = null;
					try {
						input = new ObjectInputStream(fileIn);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
					}
			         try {
						 contactList = (Acquaintances) input.readObject();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
					}
			         try {
						input.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
			         try {
						fileIn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			      }catch(FileNotFoundException a)
			      {
			         //System.out.println("OOPs!! File Not Found");
			      }catch(ClassNotFoundException c)
			      {
			         System.out.println("Acquaintances class not found");
			         c.printStackTrace();
			         return;
			      }
				
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public void init() {
		try
	      {
	         FileInputStream fileIn = new FileInputStream("contactlist");
	         ObjectInputStream input = null;
			try {
				input = new ObjectInputStream(fileIn);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				//e2.printStackTrace();
			}
	         try {
				 contactList = (Acquaintances) input.readObject();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				//e2.printStackTrace();
			}
	         try {
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
	         try {
				fileIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	      }catch(FileNotFoundException a)
	      {
	         //System.out.println("OOPs!! File Not Found");
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Acquaintances class not found");
	         c.printStackTrace();
	         return;
	      }
		
		//setResizable(false);
		//setTitle("Contact List");
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/contactlist.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setIconImage(image);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setBounds(0,0, 705, 475);
		contentPane = new JPanel();
		contentPane.setToolTipText("Hi This is the Main Window of the Contact List Software\n");
		contentPane.setBackground(new Color(0, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(271, 0, 167, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact List");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(294, 29, 127, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton createButton = new JButton("Create New Contacts");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseCreateContact chooseCreateFrame = new chooseCreateContact(contactList);
				chooseCreateFrame.setVisible(true);
			}
		});
		try {
			image = ImageIO.read(getClass().getResource("/create.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createButton.setIcon(new ImageIcon( image));
		createButton.setBounds(173, 56, 386, 47);
		contentPane.add(createButton);
		
		JButton deleteButton = new JButton(" Delete Existing Contacts");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choseDeleteContact choseDelFrame = new choseDeleteContact(contactList);
				choseDelFrame.setVisible(true);
			}
		});
		deleteButton.setBounds(173, 127, 386, 47);
		try {
			image = ImageIO.read(getClass().getResource("/delete.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteButton.setIcon(new ImageIcon( image));
		contentPane.add(deleteButton);
		
		JButton displayAllButton = new JButton("Display Entire List of Acquaintances ");
		displayAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayAll disPlayAllFrame = new displayAll(contactList);
				disPlayAllFrame.setVisible(true);
			}
		});
		displayAllButton.setBounds(173, 197, 386, 47);
		try {
			image = ImageIO.read(getClass().getResource("/displayall.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayAllButton.setIcon(new ImageIcon( image));
		contentPane.add(displayAllButton);
		
		JButton specificDisplayButton = new JButton("Display Specific Category of Acquaintances");
		specificDisplayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseSpecificDispaly specificDisplay = new chooseSpecificDispaly(contactList);
				specificDisplay.setVisible(true);
			}
		});
		specificDisplayButton.setBounds(173, 264, 386, 53);
		try {
			image = ImageIO.read(getClass().getResource("/specific.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		specificDisplayButton.setIcon(new ImageIcon( image));
		contentPane.add(specificDisplayButton);
		
		JButton searchButton = new JButton("Search List of Acquaintances");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchList searchChoose  = new searchList(contactList);
				searchChoose.setVisible(true);
			}
		});
		searchButton.setBounds(173, 334, 386, 47);
		try {
			image = ImageIO.read(getClass().getResource("/search.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchButton.setIcon(new ImageIcon( image));
		contentPane.add(searchButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);;
			}
		});
		btnExit.setBounds(304, 406, 117, 34);
		try {
			image = ImageIO.read(getClass().getResource("/exit.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnExit.setIcon(new ImageIcon( image));
		contentPane.add(btnExit);
	}
}
