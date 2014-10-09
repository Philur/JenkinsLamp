/*
 * Created by KDMA02 2013-09-30 15:59
 */
package se.caglabs.jenkinslamps;

public class CommandControllerStub implements LampController {
    private String name;
    private boolean state;

    public CommandControllerStub(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnLamp(boolean on) {
        state = on;
    }

    public boolean getState() {
        return state;
    }
}
