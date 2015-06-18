package kaust.orientationapp;


public class Task {

    String name = null;
    String hint = null;
    boolean selected = false;

    public Task(String name, String hint, boolean selected) {
        super();
        this.name = name;
        this.hint = hint;
        this.selected = selected;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
    public String getHint() {
        return hint;
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public boolean isSelected() {
        return selected;
    }


}
