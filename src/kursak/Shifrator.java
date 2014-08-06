package kursak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Shifrator implements ActionListener{
	
    static int size;
    static int count;
    static char[] charArray;
	 
	   public Shifrator() {
	      initComponents();
	   }
	 
	   private JFrame viewForm;
	 
	   private void initComponents() {
	      viewForm = new JFrame("Шифратор");
	      viewForm.setSize(700, 300);
	      viewForm.setVisible(true);
	      viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	      
	      final JTextField textField = new JTextField(255);
	      textField.setLocation(50, 100);
	      textField.setSize(600, 25);
	      textField.setVisible(true);
	      
	      final JTextField textField2 = new JTextField(255);
	      textField2.setLocation(50, 200);
	      textField2.setSize(600, 25);
	      textField2.setVisible(true);
	      
	      JLabel label = new JLabel();
	      label.setLocation(50, 75);
	      label.setSize(600, 25);
	      label.setVisible(true);
	      label.setText("Введите сообщение или укажите путь к файлу");
	      
	      JLabel label2 = new JLabel();
	      label2.setLocation(50, 175);
	      label2.setSize(100, 25);
	      label2.setVisible(true);
	      label2.setText("Результат");
	 
	      JButton button = new JButton("Открыть файл");
	      button.setVisible(true);
	      button.setLocation(12, 12);
	      button.setSize(165, 50);
	      button.addActionListener(new ActionListener() {
	 
	         public void actionPerformed(ActionEvent e) {

	        	 String Text = textField.getText();
	            
	             String S;
	   		 	 
	   	         try{
	   	            FileReader fr = new FileReader (Text);  
	   	            BufferedReader br = new BufferedReader(fr); 
	   	         
	   	            while((S=br.readLine())!=null){
	   	            	textField.setText(S);
	   	            }
	   	         }
	   	      catch (IOException y){}
	         } 
	         });
	      
	      JButton button2 = new JButton("Зашифровать");
	      button2.setVisible(true);
	      button2.setLocation(175, 12);
	      button2.setSize(165, 50);
	      button2.addActionListener(new ActionListener() {
	 
	         public void actionPerformed(ActionEvent e) {
	        	 String S;
	        	 int s=1;
	        	 
	        	 S = textField.getText();
	        	 
	        	 StringReader sl = new StringReader(S);
	             BufferedReader br = new BufferedReader(sl);
	        	
	        	 try {
					while((S=br.readLine())!=null){
					
					   size = S.length();
					   count = 0;
					   charArray = new char[size];
					   for (int j = 0; j < size;){
					   charArray[s] = S.charAt(j);
					   j=j+1;
					   s=s-1;
					   charArray[s] = S.charAt(j); 
					   j=j+1;
					   s=s+3;
					   }  
					   
					    String asd = "";
					
					    for (int i = 0; i < size; i++)
					    	asd = asd + String.valueOf(charArray[i]);
					    
					    	textField2.setText(asd);	
					
       }
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
	         }
	      });
	      
	      JButton button3 = new JButton("Расшифровать");
	      button3.setVisible(true);
	      button3.setLocation(175+165, 12);
	      button3.setSize(165, 50);
	      button3.addActionListener(new ActionListener() {
	 
	         public void actionPerformed(ActionEvent e) {
	        	 String S;
	        	 int s=1;
	        	 
	        	 S = textField.getText();
	        	 
	        	 StringReader sl = new StringReader(S);
	             BufferedReader br = new BufferedReader(sl);
	        	
	        	 try {
					while((S=br.readLine())!=null){
					
					   size = S.length();
					   count = 0;
					   charArray = new char[size];
					   for (int j = 0; j < size;){
					   charArray[s] = S.charAt(j);
					   j=j+1;
					   s=s-1;
					   charArray[s] = S.charAt(j); 
					   j=j+1;
					   s=s+3;
					   }  
					   
					    String asd = "";
					
					    for (int i = 0; i < size; i++)
					    	asd = asd + String.valueOf(charArray[i]);
					    
					    	textField2.setText(asd);	
						
       }
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
	         }
	 
	      });
	      
	      JButton button4 = new JButton("Сохранить в файл");
	      button4.setVisible(true);
	      button4.setLocation(175+165+165, 12);
	      button4.setSize(165, 50);
	      button4.addActionListener(new ActionListener() {
	 
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 String Name = textField.getText();

	        	 File flt = new File(Name);
	        	 
	        	  FileWriter wrt = null;
				try {
					wrt = new FileWriter(flt);
				} catch (IOException e1) {
					e1.printStackTrace();
				} 	 
	        	  CharSequence cq = textField2.getText();
	        	  try {
					wrt.append(cq);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        	  try {
					wrt.flush();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
	        	 
	        	  CharArrayWriter ch = new CharArrayWriter();
	        	  ch.append(cq);
	        	  ch.flush();
	         }
	 
	      });
	      
	     
	       
	      viewForm.getContentPane().add(label);
	      viewForm.getContentPane().add(label2);
	      viewForm.getContentPane().add(textField);
	      viewForm.getContentPane().add(textField2);
	      viewForm.getContentPane().add(button);
	      viewForm.getContentPane().add(button2);
	      viewForm.getContentPane().add(button3);
	      viewForm.getContentPane().add(button4);
	      viewForm.getContentPane().add(new JLabel());
	   }
	 
	   public void actionPerformed(ActionEvent action) {
	   }
	 
	   public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            new Shifrator();
	         }
	      });
	   }
}