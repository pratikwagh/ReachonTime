package myapplication2.com.reachontime;

/**
 * Created by user on 15/2/18.
 */

public class Task {
    private String name,time;

    public Task(){


    }

    public Task(String name,String time){

        this.name=name;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }
}
