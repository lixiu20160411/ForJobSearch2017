package demo;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
 

@SuppressWarnings("serial")
public class getStringFromAss extends JFrame{

	    JPanel row1 = new JPanel();
	    public getStringFromAss() throws HeadlessException {
	        super("demo");
	        setSize(600 , 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        GridLayout gridLayout = new GridLayout(5, 1, 10, 10);
	        setLayout(gridLayout);
	        
	        FlowLayout flowLayout1 = new FlowLayout(FlowLayout.CENTER , 10 , 10);
	        row1.setLayout(flowLayout1);   
	        
			JTextArea jt1 = new JTextArea();
			jt1.setBounds(120,20,500,20);
			jt1.setSize(500,20);  
			row1.add(jt1);
			jt1.setText("   ");
			jt1.setVisible(true);
			
			JButton btn = new JButton();
			btn.setBounds(381, 48, 80, 27);
			btn.addActionListener(new ActionListener(){
 
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser chooser = new JFileChooser();					
					chooser.setFileSelectionMode(0);//设置文件选择器只能选择0（文件），1（文件夹）
					
					int status = chooser.showOpenDialog(null);//打开文件浏览器，点击取消则返回1
					if(status == 1)
						return;
					else{
						File fileSrc= chooser.getSelectedFile();//读取选择器选择到的文件
						jt1.setText(fileSrc.getAbsolutePath());//获取文件绝对路径并写入到文本框内 
						if(!fileSrc.exists())
							return;			 
						try { 
							BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileSrc),"UTF-8"));  
							
							File fileDst = new File(fileSrc.getPath()+".txt");
							FileWriter fw = null;
							if(fileDst.exists()){
								fileDst.delete();
							}
							try {
								fileDst.createNewFile();
								fw = new FileWriter(fileDst,true);
							} catch (IOException e) {
								e.printStackTrace();
							}
							PrintWriter pwDst = new PrintWriter(fw,true);

							String strLine = "",temp="",temp1="";
							try {
								while( (strLine = br.readLine()) != null ){
									int iFirst=strLine.indexOf("0000,,");
									int iSecond=strLine.indexOf("\\N{");
									int iThird=strLine.indexOf("&}");
									int iFourth=strLine.indexOf("{\\r}");
									
									if(iFirst>0 && iSecond>iFirst && iThird>iSecond){ 
										temp=strLine.substring(iFirst+6,iSecond);
										if(iFourth>0)
											temp1=strLine.substring(iThird+2,strLine.length()-4);
										else
											temp1=strLine.substring(iThird+2,strLine.length());
										
										pwDst.println(temp1+System.getProperty("line.separator")+temp+System.getProperty("line.separator"));
									}


// Dialogue: 0,0:05:32.96,0:05:34.59,Default,,0000,0000,0000,,你很安全\N{\fs14\1c&HD5FFFF&}You are safe.{\r}
									
								} 
								br.close();
							} catch (NumberFormatException | IOException e) { 
								e.printStackTrace();
							}	 

							pwDst.flush();
							pwDst.close();
						
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					

					
					}
					  
				 
				
				
				}
			});			 
			btn.setText("浏览");
			row1.add(btn);			
	        add(row1); 
	        
	        setVisible(true);
	    }	    
	    
	    public static void main(String[] args) {
	    	  new getStringFromAss();
	    }

	  

}
