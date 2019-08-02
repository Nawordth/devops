import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.InetAddress;

import java.net.InetAddress;
class hostname {
	public static void main(String[] args) 
	   throws Exception {
		//InetAddress addr = InetAddress.getLocalHost();
		//String hostaddress = addr.getHostAddress();
		//System.out.println("Local HostAddress:  "+ hostaddress);
		//String hostname = addr.getHostName();
		//System.out.println("Local host name: "+hostname);
	}
}

public class PageHitCounter extends HttpServlet {
       private int hitCount; 

          public void init() { 
             // Reset hit counter.
             hitCount = 0;
          } 

          public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

             // Set response content type
             response.setContentType("text/html");

             // This method executes whenever the servlet is hit 
             // increment hitCount 
               hitCount++; 
		       PrintWriter out = response.getWriter();
		      /* String title1 = "Site Visit Count";
		       String title2 = "Host Address";
		       String title3= "Host Name"; */
		             
		       InetAddress addr = InetAddress.getLocalHost();
		       String hostaddress = addr.getHostAddress();
		       String hostname = addr.getHostName();
		       String title = "DevOps Challenge 2k19" ;
		       String var1 = "Site Visit Count :" ;
		       String var2 = "Host IP address :" ;
		       String var3 = "Host Name :" ;
		       
		       
		       System.out.println(hitCount);
		       System.out.println("Local HostAddress:  "+ hostaddress);
		       System.out.println("Local host name: "+hostname);
	     	 
       
             String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
             
             out.println(docType +
                "<html>\n" +
                   "<head><title>" + title + "</title></head>\n" +
                   "<body bgcolor = \"#f0f0f0\">\n" +
                      "<h1 align = \"center\">" + "DevOps Challenge 2k19" + "</h1>\n" +
                     /* "<h2 align = \"center\">" + hitCount + "</h2>\n" +
                      "<h1 align = \"center\">" + title2 + "</h1>\n" +
                      "<h2 align = \"center\">" + hostaddress + "</h2>\n" +
                      "<h1 align = \"center\">" + title3 + "</h1>\n" +
                      "<h2 align = \"center\">" + hostname + "</h2>\n" + */
                      "<table>"
                      + "<tr>"
                      + "<td> <h2> " +var1+ " </h2></td>"
                      + "<td> <h2>"  +hitCount+   " </h2> </td>"
                      		+ "</tr>"
                      
                      + "<tr>"
                      + "<td> <h2> " +var2+ " </h2></td>"
                      + "<td> <h2>"  +hostaddress+   " </h2> </td>"
                          + "</tr>"
                      
                        + "<tr>"
                        + "<td> <h2> " +var3+ " </h2></td>"
                        + "<td> <h2>"  +hostname+   " </h2> </td>"
                            + "</tr>"
                          
                      		
                      + "</table>\n" +  
                      
                   "</body>"
              + "</html>"
             );
          }
          
          public void destroy() { 
             // This is optional step but if you like you
             // can write hitCount value in your database.
          } 
}
