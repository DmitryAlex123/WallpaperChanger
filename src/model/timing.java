package model;

public class timing {
    private String second;
    private int microsecond;

    public timing(String second, int microsecond){
        this.second = second;
        this.microsecond = microsecond;
    }

    public String getSecond() {
        return second;
    }

    public int getMicrosecond() {
        return microsecond;
    }

    @Override
    public String toString(){
        return second;
    }
}
