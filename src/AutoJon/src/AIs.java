package AutoJon.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.SMTPMessage;

import javax.activation.*;
import java.util.Properties;

public class AIs {

	public static String letterGen(String name, boolean nbool, String jRef, boolean jRefbool, String title, boolean wd, boolean cs, boolean cpp, boolean java, String site, boolean compBool, String company) {
		String letter, att, intro, p1, p2, p3, conc, sig;
		
		intro = "";
		p1 = "";
		p2 = "";
		p3 = "";
		
		//generate a header
		if (nbool) {
			att = name;
		} else {
			att = "Dear Recruiter\n \n";
		}
		
		if (jRefbool) {
			intro = "I would like to apply for the " + title + " with your client (ref: " + jRef + ") found on " + site + ".\n\n";
		}
		
		p1 = "I graduated in May 2014 from the University of Salford where I was awarded a First Class Master’s in Physics. "
				+ "At graduation I was among the top three students in my class for academic performance.  During my time at Salford I "
				+ "participated in an exchange year in the United States where I was included in the Dean’s List, which is reserved for "
				+ "students with exceptional grades, and where I completed my Bachelor’s Thesis in computational astrophysics.  For my "
				+ "Master’s thesis I was chosen for an internship at Daresbury Laboratory in Warrington, where I completed an internship in "
				+ "computational analysis of semiconductors.\n\n";
		
		if (cpp && java) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work primarily in an object oriented system with C++ and Java, and I have solid knowledge of Fortran through updating legacy code.  "
					+ "I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (cpp && !java) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with C++ and Java, though I also have experience of Fortran through updating legacy code.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (!cpp && java) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with Java and C++, though I also have experience of Fortran through updating legacy code.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (cs) {
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with Java and C++, though I also have an interest in game development where I use C# for writing "
					+ "animation scripts in Unity.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		} else if (wd) {
			//need to change this to a web dev paragraph
			p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit in Belgium "
					+ "where I am currently working on the application of automation in materials research.  So far I have automated the "
					+ "generation of input files, data extraction and analysis methods used within the group.  I also collaborate on the "
					+ "development of the Q Chem package with a development team at the National Taiwan Institute.\n\n";
			p3 = "For development I work mostly with Java and C++, though I also have an interest in game development where I use C# for writing "
					+ "animation scripts in Unity.  I also have experience of web development and have a HTML, CSS and JavaScript.\n\n";
		}
		
		if (!compBool) {
		conc = "Your client would benefit from my unique background, my knowledge in research and problem solving in addition to my proven track record "
				+ "across several disciplines. My excellent academic record and desire to grow within this role ensure that I would be a positive "
				+ "addition to your client's team. If you have any additional questions or require any further documentation, I am available to be"
				+ " contacted through phone or email. \n\n";
		} else {
			conc = company + " would benefit from my unique background, my knowledge in research and problem solving in addition to my proven track record "
					+ "across several disciplines. My excellent academic record and desire to grow within this role ensure that I would be a positive "
					+ "addition to your client's team. If you have any additional questions or require any further documentation, I am available to be"
					+ " contacted through phone or email. \n\n";
			
		}
		
		
		sig = "Regards, \n\nJon Collins";
				
		letter = att + intro + p1 + p2 + p3 + conc + sig;
		
		try {
		PrintWriter CL = new PrintWriter("CoverLetter.doc");
		
		CL.write(letter);
		CL.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return letter;
	}
	
	public static String emailGen(String name, boolean nbool, String jRef, boolean jRefbool, String title) {
		String email, main, sig;
		
		if (!nbool) {
			name = "Dear Recruiter";
		}
		
		if (jRefbool) {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position (ref:" + jRef + ") with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		} else {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		}
		
		sig = "Regards\n\nJon Collins, and AutoJon";
		
		email = name + ",\n\n" + main + sig;
		
		return email;
	}
	
	public static void mailer(String login, String password) {
		Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class",
		            "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "805");

		    Session session = Session.getDefaultInstance(props,new         javax.mail.Authenticator()
		                            {
		                                 @Override
		                                protected PasswordAuthentication     getPasswordAuthentication()
		                                {
		                return new PasswordAuthentication(login, password);
		                                }
		        });

		    try {

		        SMTPMessage message = new SMTPMessage(session);
		        message.setFrom(new InternetAddress("jonacollins3@gmail.com"));
		        message.setRecipients(Message.RecipientType.TO, //receiver here
		                                 InternetAddress.parse( "jonacollins3@gmail.com" ));

		                    message.setSubject("Testing Subject");
		        message.setText("This is Test mail");
		       //              message.setContent
			     // ("This Is my First Mail Through Java", "/");
		      //  message.setMessage("This Is my First Mail Through Java");

		                    message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
		                    int returnOption = message.getReturnOption();

		                     //System.out.println(returnOption);        
		                Transport.send(message);
		               System.out.println("sent");

		    }
		            catch (MessagingException e)
		            {
		        throw new RuntimeException(e);

		    }
		}

	//mail server
	
	public static void server() {

		        new Thread(new SimpleServer()).start();

		        new Thread(new SimpleClient()).start();

		    }

		    static class SimpleServer implements Runnable {

		        @Override

		        public void run() {

		            ServerSocket serverSocket = null;
		
		            try {
		                serverSocket = new ServerSocket(3333);

		                serverSocket.setSoTimeout(7000);
		                while (true) {
		                    Socket clientSocket = serverSocket.accept();
		                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		                    System.out.println("Client said :" + inputReader.readLine());
		                }
		            } catch (SocketTimeoutException e) {
		                e.printStackTrace();
		            } catch (IOException e) {
		                e.printStackTrace();
		            } finally {
		                try {
		                    if (serverSocket != null)
		                        serverSocket.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
		    static class SimpleClient implements Runnable {
		        @Override
		        public void run() {
		            Socket socket = null;
		            try {
		                Thread.sleep(3000);
		                socket = new Socket("localhost", 3333);
		                PrintWriter outWriter = new PrintWriter(
		                        socket.getOutputStream(), true);
		                outWriter.println("Hello Mr. Server!");
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            } catch (UnknownHostException e) {
		                e.printStackTrace();
		            } catch (IOException e) {
		                e.printStackTrace();
		            } finally {
		                try {
		                    if (socket != null)
		                        socket.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }

		    public static String emailSearch(String doc) {
		    	String email = "";
		    	int beg = 0, end = 0;
		    			   		    	
		    	if (doc.contains("@")) {
		    	beg = doc.indexOf("@");
		    	end = doc.indexOf("@");
		    	while (doc.charAt(beg) != ' ') {
		    		beg--;
		    	}
		    	
		    	while (doc.charAt(end) != ' ') {
		    		end++;
		    	}
		    		
		    	while (beg < end) {
		    			email = email + doc.charAt(beg);
		    			beg++;
		    		}	
		    	}
		    	
		    	return email;
		    }
	
	public static String nameSearch(String email) {
		int at = 0;
		String rawName = "";
		String firstName = "", surName = "";
		char f, s;
		
		if (email.contains("@")) {
			at = email.indexOf("@");
		}
		
		for (int i = 0; i < at; i++) {
			rawName = rawName + email.charAt(i);
		}
		
		if (rawName.contains(".")) {
			for (int i = 1; i < rawName.indexOf("."); i++) {
				firstName = firstName + rawName.charAt(i);
			}
			for (int i = (rawName.indexOf(".") + 1); i < rawName.length(); i++) {
				surName = surName + rawName.charAt(i);
			}
		}
		
		f = Character.toUpperCase(firstName.charAt(0));
		s = Character.toUpperCase(surName.charAt(0));

		System.out.println(f);
		System.out.println(s);
		
		System.out.println(rawName);
		System.out.println(firstName);
		System.out.println(surName);
		
		firstName = f + firstName.substring(1, firstName.length());
		surName = s + surName.substring(1, surName.length());
		
		return firstName + " " + surName;
	}
	
}
