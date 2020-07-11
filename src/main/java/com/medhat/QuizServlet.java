package com.medhat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/")
public class QuizServlet extends HttpServlet {

    Quiz quiz;
    HttpSession session ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession(true);
        request.setAttribute("correct", true);
        request.setAttribute("win", false);
        if (session.getAttribute("quiz")==null) {
            session.setAttribute("quiz",new Quiz());
        }
        request.setAttribute("quiz", (Quiz) session.getAttribute("quiz"));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setAttribute("win", false);

        this.quiz =   (Quiz) session.getAttribute("quiz");
        if (request.getParameter("btnStart") != null) {

            session.setAttribute("quiz",new Quiz());
            this.quiz =   (Quiz) session.getAttribute("quiz");
            request.setAttribute("correct", true);
        }
        else if (request.getParameterMap().containsKey("txtAnswer") != false ) {
            request.setAttribute("correct", false);
            int txtAnswer = Integer.parseInt(request.getParameter("txtAnswer"));

            if (this.quiz.isCorrect(txtAnswer)) {
                if(this.quiz.getNumCorrect()==this.quiz.getQuestions().size()) {
                    request.setAttribute("win", true);
                    session.setAttribute("quiz",null);
                }
                request.setAttribute("correct", true);
            }

        }
        request.setAttribute("quiz", this.quiz);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
