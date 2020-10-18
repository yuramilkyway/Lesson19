package ru.innopolis.Servler;

import ru.innopolis.ejb.EnvironmentVarBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class EnvironmentVarsRest extends HttpServlet {

    @EJB
    private EnvironmentVarBean environmentVarBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        PrintWriter writer = resp.getWriter();

        String pathInfo = req.getPathInfo();
        if (pathInfo != null) {
            doGetSingle(writer, pathInfo.substring(1));
        } else {
            doGetAll(writer);
        }
    }

    private void doGetAll(PrintWriter writer) {
        Set<Map.Entry<String, String>> allVariables = environmentVarBean.getAllVariables();

        for (Map.Entry<String, String> variable : allVariables) {
            writer.println(variable);
        }
    }

    private void doGetSingle(PrintWriter writer, String name) {
        writer.println(environmentVarBean.getValueVariable(name));
    }
}
