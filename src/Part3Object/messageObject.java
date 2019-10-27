package Part3Object;

import java.io.Serializable;

public class messageObject implements Serializable {
    private String command;
    private String[] arguments;
    private String result;

    public messageObject(String[] initializeArgs){
        if (initializeArgs.length >= 1) {
            command = initializeArgs[0];
            String[] copy = new String[initializeArgs.length -1];
            for (int i = 1; i < initializeArgs.length; i++) {
                copy[i-1] = initializeArgs[i];
            }
            arguments = copy;
        } else {
            command = "";
            arguments = new String[0];
        }
        result = "";
    }

    public void setResult(String updatedResult) {
        result = updatedResult;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getResult() {
        return result;
    }
}