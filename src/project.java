import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class project implements ActionListener {
    JFrame f1, f2,f3; 
    JButton b1, b2, b3, b4, b5;
    JCheckBox cb1, cb2, cb3, cb4;
    JProgressBar br;
    JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,l1,l2,l3,l4,l5,l6	;
    TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JComboBox chb1;


    public static void main(String[] args) throws IOException  {
        project obj = new project();
    	database.display();
        
}

    project() {
        f1 = new JFrame();
        f1.setSize(900, 800);
        f1.setVisible(true);
        f1.setLayout(null);
        
        br = new JProgressBar();
        br.setBounds(0, 20, 800, 200);
        br.setOrientation(0);
        br.setBackground(Color.black);
        br.setFont(new Font("Arial", Font.BOLD, 50));
        br.setForeground(Color.yellow);
        br.setString("MAULI AUTO GARAGE");
        br.setStringPainted(true);
        f1.add(br);


        b1 = new JButton("COMPLETE PACKAGE");
        b1.setBounds(300, 300, 200, 50);
        b1.addActionListener(this);
        f1.add(b1);

        b2 = new JButton("CUSTOMIZE PACKAGE");
        b2.setBounds(300, 400, 200, 50);
        b2.addActionListener(this);
        f1.add(b2);

        b3 = new JButton("RESALE");
        b3.setBounds(300, 500, 200, 50);
        b3.addActionListener(this);
        f1.add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            openSelectionWindow();
        } else if (e.getSource() == b2) {
        	openCustomizationWindow();
        } else if (e.getSource() == b3) {
            new Slideshow();
        }
    }   


    private void openSelectionWindow() {
        JFrame selectionFrame = new JFrame("Selection Window");

        
        f2 = selectionFrame;
        f2.setSize(900, 900);
        f2.setLayout(null);
        f2.setResizable(false); 
        
        L1=new JLabel("COMPLETE PACKAGE");
		L1.setBounds(100, 50, 300, 50);
		L1.setFont(new Font("Arial",Font.BOLD,22));
		f2.add(L1);
		
		L2=new JLabel("NAME");
		L2.setBounds(50,200,50,25);
		f2.add(L2);
		tf1=new TextField();
		tf1.setBounds(150, 200,500,25);
		f2.add(tf1);
		
		L3=new JLabel("MOBILE NO.");
		L3.setBounds(50,250,80,25);
		f2.add(L3);
		tf2=new TextField();
		tf2.setBounds(150, 250, 500,25);
		f2.add(tf2);
		
		L4=new JLabel("EMAIL");
		L4.setBounds(50,300,50,25);
		f2.add(L4);
		tf3=new TextField();
		tf3.setBounds(150, 300, 199,25);
		f2.add(tf3);
		
		
		L5=new JLabel("VEHICAL NO.");
		L5.setBounds(50,400,80,25);
		f2.add(L5);
		tf4=new TextField();
		tf4.setBounds(150, 400, 500,25);
		f2.add(tf4);
		
		L6=new JLabel("COMPANY");
		L6.setBounds(50,450,80,25);
		f2.add(L6);
		tf5=new TextField();
		tf5.setBounds(150, 450, 500,25);
		f2.add(tf5);
		
		L7=new JLabel("MODEL");
		L7.setBounds(50,500,50,25);
		f2.add(L7);
		tf6=new TextField();
		tf6.setBounds(150, 500, 500,25);
		f2.add(tf6);

        L8 = new JLabel("WASHING = 120/-");
        L8.setBounds(50, 550, 150, 25);
        f2.add(L8);
        
        L9 = new JLabel("OIL CHANGE = 550/-");
        L9.setBounds(50,600, 150, 25);
        f2.add(L9);
       

        L10 = new JLabel("FITTING = 100/-");
        L10.setBounds(50, 650, 150, 25);
        f2.add(L10);

		L11 = new JLabel("CLEANING = 100/-");
        L11.setBounds(50, 700, 150, 25);
        f2.add(L11);
        
		tf1.addKeyListener(new KeyAdapter() // Name
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z') || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
			}
		});
		
		tf2.addKeyListener(new KeyAdapter() // mobile number
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
		 }
		 
		});
									
		tf3.addKeyListener(new KeyAdapter() // Email
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>'A'&& ch<='z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
		  		{
		  			f2.getToolkit().beep();
		  			ke.consume();
		  		}
				
			}
		});
		
		String s1[] = {"@gmail.com","@yahoo.com","@rediffmail.com","@outlook.com","@msn.co.in"};
	      chb1 = new JComboBox(s1);
	      chb1.setBounds(350,300,200,30);
	      f2.add(chb1);
		
		tf4.addKeyListener(new KeyAdapter() // Vehicle Number
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>'A'&& ch<='z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE ))
		  		{
		  			f2.getToolkit().beep();
		  			ke.consume();
		  		}
				
			}
		});
		
		tf5.addKeyListener(new KeyAdapter() // Company
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>'A'&& ch<='z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
		  		{
		  			f2.getToolkit().beep();
		  			ke.consume();
		  		}
				
			}
		});
		
		 b4=new JButton("SUBMIT");
	     b4.setBounds(400,250,100,25);
//        b4.addActionListener(this);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(50, 750, 100, 25);     
        submitButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
//        		b4.addActionListener(this);
        		System.out.println("Submit Button Clicked");
            	String name = tf1.getText();
            	String mobileNumber = tf2.getText();
                String email = tf3.getText();
                String selectedDomain = (String) chb1.getSelectedItem();
                email = email + selectedDomain;
            	String vehicleNumber = tf4.getText();
            	String model = tf6.getText();
            	int washing = 120; // Default value or fetch from text field if needed
            	int oilChange = 550; // Default value or fetch from text field if needed
            	int fitting = 100; // Default value or fetch from text field if needed
            	int cleaning = 100; // Default value or fetch from text field if needed
            	int extra = 0; // Default value or fetch from text field if needed
            	database.insertData(name, mobileNumber, email, vehicleNumber, model, washing, oilChange, fitting, cleaning, extra);
            	
            	// Pdf Generation
            	
                List<String> productNames = Arrays.asList("Oil Change", "Fitting", "Cleaning");
                List<Integer> productPrices = Arrays.asList(oilChange, fitting, cleaning);
                List<Integer> productQuantities = Arrays.asList(1, 1, 1);
                
                int pretotal = 0;
                for (int i = 0; i < productNames.size(); i++) {
                    pretotal += productPrices.get(i) * productQuantities.get(i);
                }

                String total = String.valueOf(pretotal);
                PdfGenerator pdfGenerator;
				try {
					pdfGenerator = new PdfGenerator(name, mobileNumber, vehicleNumber, model, productNames, productPrices, productQuantities, total);
					pdfGenerator.generatePdf();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                System.out.println("Invoice generated successfully!");
            	
            	
            	JOptionPane.showMessageDialog(f2, "Data submitted successfully!");
            	
            	
            	
            	f2.dispose();
            }
        });
        
        f2.add(submitButton);		
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setVisible(true);
        
        
}

    private void openCustomizationWindow() {	
        f2 = new JFrame("Customization Window");
        f2.setSize(900, 900);
        f2.setLayout(null);
        f2.setResizable(false); 
        
        L1=new JLabel("Customized Package");
		L1.setBounds(100, 50, 300, 50);
		L1.setFont(new Font("Arial",Font.BOLD,22));
		f2.add(L1);
		
		L2=new JLabel("NAME");
		L2.setBounds(50,200,50,25);
		f2.add(L2);
		tf1=new TextField();
		tf1.setBounds(150, 200,500,25);
		f2.add(tf1);
		
		L3=new JLabel("MOBILE NO.");
		L3.setBounds(50,250,80,25);
		f2.add(L3);
		tf2=new TextField();
		tf2.setBounds(150, 250, 500,25);
		f2.add(tf2);
		
		L4=new JLabel("EMAIL");
		L4.setBounds(50,300,50,25);
		f2.add(L4);
		tf3=new TextField();
		tf3.setBounds(150, 300, 199,25);
		f2.add(tf3);
		
		
		L5=new JLabel("VEHICAL NO.");
		L5.setBounds(50,400,80,25);
		f2.add(L5);
		tf4=new TextField();
		tf4.setBounds(150, 400, 500,25);
		f2.add(tf4);
		
		L6=new JLabel("COMPANY");
		L6.setBounds(50,450,80,25);
		f2.add(L6);
		tf5=new TextField();
		tf5.setBounds(150, 450, 500,25);
		f2.add(tf5);
		
		L7=new JLabel("MODEL");
		L7.setBounds(50,500,50,25);
		f2.add(L7);
		tf6=new TextField();
		tf6.setBounds(150, 500, 500,25);
		f2.add(tf6);

        L8 = new JLabel("WASHING");
        L8.setBounds(50, 550, 80, 25);
        f2.add(L8);
		tf7=new TextField();
		tf7.setBounds(150, 550, 500,25);
		f2.add(tf7);
        
        L9 = new JLabel("OIL CHANGE");
        L9.setBounds(50,600, 100, 25);
        f2.add(L9);
		tf8=new TextField();
		tf8.setBounds(150, 600, 500,25);
		f2.add(tf8);

        L10 = new JLabel("FITTING");
        L10.setBounds(50, 650, 100, 25);
        f2.add(L10);
		tf9=new TextField();
		tf9.setBounds(150, 650, 500,25);
		f2.add(tf9);
        
		L11 = new JLabel("CLEANING");
        L11.setBounds(50, 700, 100, 25);
        f2.add(L11);
		tf10=new TextField();
		tf10.setBounds(150, 700, 500,25);
		f2.add(tf10);
       
       
		
		tf1.addKeyListener(new KeyAdapter() // Name
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')||ch==KeyEvent.VK_BACK_SPACE||ch==KeyEvent.VK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
			}
		});
		
		
		tf2.addKeyListener(new KeyAdapter() // mobile number
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
		 }
		 
		});
					
					
					
		tf3.addKeyListener(new KeyAdapter() // Email
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='A'&& ch<='z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
		  		{
		  			f2.getToolkit().beep();
		  			ke.consume();
		  		}
				
			}
		});
		
		String s1[] = {"@gmail.com","@yahoo.com","@rediffmail.com","@outlook.com","@msn.co.in"};
	      chb1 = new JComboBox(s1);
	      chb1.setBounds(350,300,200,30);
	      f2.add(chb1);
		
		tf4.addKeyListener(new KeyAdapter() // Vehicle Number
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='A'&& ch<='Z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
		  		{
		  			f2.getToolkit().beep();
		  			ke.consume();
		  		}
				
			}
		});
		
		tf5.addKeyListener(new KeyAdapter() // Company
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='A'&& ch<='Z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
		  		{
		  			f2.getToolkit().beep();
		  			ke.consume();
		  		}
				
			}
		});
		tf6.addKeyListener(new KeyAdapter() // model
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='A'&& ch<='Z')||(ch>='a' && ch<='z')||(ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
		 }
		 
		});
		
		tf7.addKeyListener(new KeyAdapter() // washing
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
		 }
		 
		});
		
		tf8.addKeyListener(new KeyAdapter() // oil change
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
		 }
		 
		});
		
		tf9.addKeyListener(new KeyAdapter() // fitting
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
		 }
		 
		});
		
		tf10.addKeyListener(new KeyAdapter() // cleaning
		{
		 public void keyTyped(KeyEvent ke)	
		 {
				char ch=ke.getKeyChar();
				if(!((ch>='0'&&ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
				{
					f2.getToolkit().beep();
					ke.consume();
				}
				
		 }
		 
		});

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(50, 750, 100, 25);     
        submitButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
//        		b4.addActionListener(this);
        		System.out.println("Submit Button Clicked");
            	String name = tf1.getText();
            	String mobileNumber = tf2.getText();
                String email = tf3.getText();
                String selectedDomain = (String) chb1.getSelectedItem();
                email = email + selectedDomain;
            	String vehicleNumber = tf4.getText();
            	String model = tf6.getText();
            	
            	int washing = Integer.parseInt(tf7.getText());
            	int oilChange = Integer.parseInt(tf8.getText());
            	int fitting = Integer.parseInt(tf9.getText());
            	int cleaning = Integer.parseInt(tf10.getText());
            	int extra = 0; // Default value or fetch from text field if needed
            	database.insertData(name, mobileNumber, email, vehicleNumber, model, washing, oilChange, fitting, cleaning, extra);
            	
            	// Pdf Generation
            	
                List<String> productNames = Arrays.asList("Oil Change", "Fitting", "Cleaning");
                List<Integer> productPrices = Arrays.asList(oilChange, fitting, cleaning);
                List<Integer> productQuantities = Arrays.asList(1, 1, 1);
                
                int pretotal = 0;
                for (int i = 0; i < productNames.size(); i++) {
                    pretotal += productPrices.get(i) * productQuantities.get(i);
                }

                String total = String.valueOf(pretotal);
                PdfGenerator pdfGenerator;
				try {
					pdfGenerator = new PdfGenerator(name, mobileNumber, vehicleNumber, model, productNames, productPrices, productQuantities, total);
					pdfGenerator.generatePdf();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                System.out.println("Invoice generated successfully!");
            	
            	JOptionPane.showMessageDialog(f2, "Data submitted successfully!");
            	
            	f2.dispose();
            }
        });
        
        f2.add(submitButton);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setVisible(true);
    }

    public class Slideshow {
        JFrame frame;
        JLabel imageLabel;
        JLabel infoLabel;

        ImageIcon[] images;
        String[] models;
        String[] prices;
        boolean[] isNew;

        int currentIndex = 0;

        Slideshow() {
            frame = new JFrame();
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setLayout(null);

            // Initialize the arrays with image paths, models, prices, and isNew flags
            images = new ImageIcon[]{
                new ImageIcon("D:\\DMG project\\Silder\\src\\img\\1.jpg"),
                new ImageIcon("D:\\DMG project\\Silder\\src\\img\\2.jpg"),
                new ImageIcon("D:\\DMG project\\Silder\\src\\img\\3.jpeg"),
                new ImageIcon("D:\\DMG project\\Silder\\src\\img\\4.jpeg"),
                new ImageIcon("D:\\DMG project\\Silder\\src\\img\\5.jpg")
            };

            models = new String[]{"Wagnor 2014-2018", "Alto 2009-2016", "Indigo 2015-2019", "Nano 2012-2020", "Indigo 2019-2022"};
            prices = new String[]{"$10000", "$20000", "$30000", "$40000", "$50000"};
            isNew = new boolean[]{false, false, false, false, false}; // Example values, you can set them accordingly

            imageLabel = new JLabel(images[currentIndex]);
            imageLabel.setBounds(0, 0, 750, 530);
            frame.add(imageLabel);

            infoLabel = new JLabel();
            infoLabel.setBounds(0, 500, 750, 70);
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
            updateInfoLabel();
            frame.add(infoLabel);

            frame.setVisible(true);

            // Start a separate thread to change the images
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Thread.sleep(2000); // Change image every 2 seconds
                            currentIndex = (currentIndex + 1) % images.length;
                            imageLabel.setIcon(images[currentIndex]);
                            updateInfoLabel();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // Update the info label with current car information
        private void updateInfoLabel() {
            String info = models[currentIndex] + " - " + prices[currentIndex];
//            if (isNew[currentIndex]) {
//                info += " (New)";
//            } else {
//                info += " (Used)";
//            }
            infoLabel.setText(info);
        }

    }
}