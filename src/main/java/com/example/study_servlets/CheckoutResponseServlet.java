package com.example.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/checkoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            PrintWriter printWriter = response.getWriter();
            String contents = "<body class=\"bg-light\">\r\n" + //
                    "    <div class=\"fs-3 mb-4\">Billing address</div>\r\n" + //
                    "        <form action=\"\">\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">first name</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" name=\"firstname\" id=\"firstname1\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">last name</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" name=\"lastname\" id=\"lastname1\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">Username/label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" placeholder=\"Username\" name=\"username\" id=\"username1\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">Email (Optional)</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"email\" placeholder=\"you@example.com\" name=\"useremail\" id=\"useremail1\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">Address</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" placeholder=\"1234 Main St\" name=\"address\" id=\"address1\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">Address 2 (Option)</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" placeholder=\"Apartment or suite\" name=\"address\" id=\"address21\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-3\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">Country</label>\r\n" + //
                    "                    <select class=\"form-select\" name=\"country\" id=\"\">\r\n" + //
                    "                        <option value=\"choose\">Choose...</option>\r\n" + //
                    "                        <option value=\"united_state\">United state</option>\r\n" + //
                    "                    </select>\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-3\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">State</label>\r\n" + //
                    "                    <select class=\"form-select\" name=\"state\" id=\"\">\r\n" + //
                    "                        <option value=\"choose\">Choose...</option>\r\n" + //
                    "                        <option value=\"califonia\">Califonia</option>\r\n" + //
                    "                    </select>\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-3\">\r\n" + //
                    "                    <label class=\"form-label\" for=\"\">Zip</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" name=\"zip\" id=\"zip1\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row mb-4\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <button class=\"bg-primary text-info\" type=\"submit\">\r\n" + //
                    "                        <link rel=\"stylesheet\" href=\"http://192.168.0.51:8080/checkoutResponseServlet\" >Submit\r\n" + //
                    "                    </button>\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "        </form>\r\n" + //
                    "</body>\r\n" + //
                    "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "<link rel=\"stylesheet\" href=\"../css/commons.css\">\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
