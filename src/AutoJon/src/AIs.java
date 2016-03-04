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

	public static String letterGen(String name, boolean nbool, String jRef, boolean jRefbool, String title, boolean g1, boolean g2, boolean g3, boolean s1, String siteRaw, boolean compBool, String company) {
		String letter, att, intro, p1, p2, p31, p32, conc, sig;
		
		intro = "";
		p1 = "";
		p2 = "";
		p31 = "";
		p32 = "";
	//	p33 = "";
		
		String site = "";
		
		for (int i = 11; i < siteRaw.length(); i++) {
			site = site + siteRaw.charAt(i);
		}
		
		//generate a header
		if (nbool) {
			att = name + ",\n\n";
		} else {
			att = "Dear Recruiter,\n \n";
		}
		
		if (jRefbool) {
			intro = "I would like to apply for the " + title + " with your client (ref: " + jRef + ") found on " + site + ".\n\n";
		} else {
			intro = "I would like to apply for the " + title + " with your client found on " + site + ".\n\n";
		}
		
		p1 = "I graduated in May 2014 from the University of Salford where I was awarded a First Class Master’s in Physics. "
				+ "At graduation I was among the top three students in my class for academic performance.  During my time at Salford I "
				+ "participated in an exchange year in the United States where I was included in the Dean’s List, which is reserved for "
				+ "students with exceptional grades, and where I completed my Bachelor’s Thesis in computational astrophysics.  For my "
				+ "Master’s thesis I was chosen for an internship at Daresbury Laboratory in Warrington, where I completed an internship in "
				+ "computational analysis of semiconductors.\n\n";
		
		p2 = "After a year in the United States working as a tutor, I returned to Europe to conduct a PhD at Hasselt Universiteit "
				+ "in Belgium where I am currently working on the application of automation in materials research.  "
				+ "I have already automated the calculation process and analysis of the subsequent output with some software "
				+ "written in C++ and development is ongoing, and I contribute to the Q Chem package through a collaboration "
				+ "with my co-promotor at the National University of Taiwan.";
		
	
		if (g1) {
			p31 = "Most of my code is written in object oriented languages C++ and Java, unless a specific problem requires another solution."
					+ "  I also have a solid knowledge of Fortran, as much of my work involves the update of legacy code.  In my time working"
					+ " on the development of code I have also improved my planning and design skills, which I’ve found to be crucial to a "
					+ "successful project.  ";
		} else if (g2) {
			p31 = "I mainly make use of HTML, CSS and JavaScript, and associated libraries such as d3.js, in my work for processing and "
					+ "display of data. In summer of 2015 I contracted to complete a web app for the completion of physics calculations "
					+ "and display of data to end users.  I am also the current webmaster for the website of my research group.  ";
		} else if (g3) {
			p31 = "My background in physics has provided me with a strong foundation in the mathematics required for game programming.  "
					+ "I have experience in using Blender for modelling, and have made a few models for myself, and I am gaining confidence"
					+ " with Unity and working toward producing a game of my own.  I also have a strong interest in physics engines: I "
					+ "have developed some fairly basic engines for 2D graphical output of calculation results and I am currently "
					+ "developing a 3D engine for my research group.  ";
			s1 = true;
		}
		
		if (s1) {
			p32 = "I am also required to regularly brief my colleagues and senior staff members in Belgium with updates on my work,"
					+ " and also to liaise with the development teams in Taiwan.\n\n";
		} else {
			
			p32 = "My background in physics has also provided me with a strong foundation in mathematics and problem solving, and in "
					+ "data handling which much of my code is currently used for.\n\n";
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
				
		letter = att + intro + p1 + p2 + p31 + p32 + conc + sig;
		//letter = intro + p1 + p2 + p3 + conc + sig;
		
		/*try {
		PrintWriter CL = new PrintWriter("CoverLetter.docx");
		
		CL.write(letter);
		CL.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		return letter;
	}
	
	public static String emailGen(String name, boolean nbool, String jRef, boolean jRefbool, String title) {
		String email, main, sig;
		
		if (!nbool) {
			name = "Dear Recruiter";
		}
		
		//System.out.println("name in emailgen" + name);
		
		if (jRefbool) {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position (ref:" + jRef + ") with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		} else {
			main = "Hi! I am Jon's auto-application bot!\n\nI have matched your requirements for the " + title + " position with Jon's specifications and submitted a CV with a cover letter I wrote.  We both hope to hear back from you soon.\n\n";
		}
		
		sig = "Regards\n\nJon Collins, and AutoJon\n\n\n";
		
		String sub = "We're still ironing out the kinks, so we're sorry if I got it wrong.  We're working on making me smarter.";
		
		//email = name + ",\n\n" + main + sig + sub;
	
		email = "\n\n" + main;
	
		return email;
	}
	
	public static void mailer(String login, String password, String emessage, String jobname, String email, String letter) {
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
		        InternetAddress.parse( "autojonfeedback@gmail.com, " + email));
		        		
		        		message.setSubject("Application for " + jobname);
		       // message.setText(emessage);
		        //             message.setContent
			   //   ("This Is my First Mail Through Java", "/");
		      //  message.setMessage("This Is my First Mail Through Java");
		                    BodyPart messageBodyPart = new MimeBodyPart();
		                    messageBodyPart.setText(letter + "\n\n" + emessage);
		                    

		        Multipart multipart = new MimeMultipart();
		        	
		        multipart.addBodyPart(messageBodyPart);
		        /* removed cover letter for testing reasons
		        //attach things
		        BodyPart attach = new MimeBodyPart();
		        DataSource source = new FileDataSource("CoverLetter.docx");
		        attach.setDataHandler(new DataHandler(source));
		        attach.setFileName("CoverLetter.docx");
		        multipart.addBodyPart(attach);
		        */
		        BodyPart CV = new MimeBodyPart();
		        DataSource cvSource = new FileDataSource("joncollinsCV.pdf");
		        CV.setDataHandler(new DataHandler(cvSource));
		        CV.setFileName("joncollinsCV.pdf");
		        multipart.addBodyPart(CV);
		        
		        message.setContent(multipart);
		        
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
		    			 
		    	
		    	//System.out.println("email is being called");
		    	//System.out.println(doc);
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
		    	
		    	System.out.println(email);
		    	return email;
		    }
	
	public static String nameSearch(String email) {
		int at = 0;
		String rawName = "";
		String firstName = "", surName = "";
		char f, s;
		
		//System.out.println("email is being called");
		
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
		
		if (rawName.contains(".")) {
			f = Character.toUpperCase(firstName.charAt(0));
			s = Character.toUpperCase(surName.charAt(0));

			firstName = f + firstName.substring(1, firstName.length());
			surName = s + surName.substring(1, surName.length());
		}
		
		return firstName + " " + surName;
	}

	public static String refSearch(String search) {
		String ref = "";
		int i = 8;
		
		while (search.charAt(i) != '<') {
				i++;
				//System.out.println(search.charAt(i));
			}
			
		if (search.charAt(i) == '<') {	
			ref = search.substring(8, i);
		}
		System.out.println("ref: " + ref);
		
		return ref;
		
		//System.out.println("Job string index: " + search.indexOf("Job ref. no."));
		//System.out.println(search.substring(search.indexOf("Job ref. no.")+22, search.indexOf("Job ref. no.")+28));
	}
	
}
