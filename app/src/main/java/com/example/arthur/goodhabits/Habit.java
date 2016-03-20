package com.example.arthur.goodhabits;

/**
 * Created by Arthur on 3/18/2016.
 */
public class Habit {

    private String task;
    private boolean checked;

    public Habit(String task, boolean checked){
        this.task = task;
        this.checked = checked;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


}
