package automation;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.Font;


public class Automation {
	private static String songName;
	
	private static String songURL;
	
	private JFrame frame;
	static JLabel lblDontCloseMe = new JLabel("No new Updates.");
 public static int s=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Automation window = new Automation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Automation() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 213, 178);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblDontCloseMe.setBounds(12, 55, 183, 40);
		frame.getContentPane().add(lblDontCloseMe);
		
		JLabel lblHeySarb = new JLabel("Hey Sarb!");
		lblHeySarb.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblHeySarb.setBounds(51, 32, 104, 16);
		frame.getContentPane().add(lblHeySarb);
		downloadAll();
		frame.dispose();
	}
	
	
	
	void downloadAll() {

    	
    	
		
		
		try {
			
			Document doc = Jsoup.connect("https://djpunjab.fm/page/top20.html?download=320&type=week").userAgent("mozilla/17.0").get();
		
			Elements temp=doc.select("ol li");
			


		    
		int i=0;
		for (Element punjabi:temp) {
			
			try{

				 
				Element link = doc.select("li a").get(i); 
				i++;
				 songName = punjabi.getElementsByTag("li").first().text();
				 
					


				 
				 
				
				 songURL= link.absUrl("href");

				  
					download(songURL, songName);
				
				 

							 
				 
				   

						
			}catch(java.lang.NullPointerException e) {
				System.out.println("");
			}
			
		}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	
   
  
  
  }

	
	
	
	
	public static void download(String songURL, String songName)  {
		
		
		String user =System.getProperty("user.name");
		 String File_NAME = "C://Users//"+user+"//Music//"+songName+".mp3";
		 
		 File tmpDir = new File(File_NAME);
		 boolean exists = tmpDir.exists();
		 if(exists) {
			
		 }else if(!exists){
			 
			 
		// TODO Auto-generated method stub+
		// songURL = "http://s320.ve.vc/data/320/47699/295004/Red%20Eyes%20-%20Karan%20Aujla%20(DjPunjab.Com).mp3";
		try (BufferedInputStream in = new BufferedInputStream(new URL(songURL).openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(File_NAME)) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    s++;
			        
					lblDontCloseMe.setText(s+" new song(s) added.");
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				       

				    }
				} catch (IOException e) {
				    // handle exception
					
					System.out.println(e.getMessage());
				}
		
		 }
	}

	
	
	
	
	
	
	
	
	
}
