package ru.innopolis.ejb;

import javax.ejb.Stateless;
import java.util.Map;
import java.util.Set;

@Stateless
public class EnvironmentVarBean {
    public Set<Map.Entry<String, String>> getAllVariables() {
        //Можно отсортировать через список
        return System.getenv().entrySet();
    }

    public String getValueVariable(String name) {
        return System.getenv(name);
    }
}
