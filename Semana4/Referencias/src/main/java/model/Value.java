package model;

public class Value {
    private int v;

    public void setValue(int v){
       this.v = v;
    }

    public int getValue(){
        return v;
    }

    @Override
    public boolean equals(Object obj) {
        return this.v == ( (Value)obj ).getValue();
    }

    public Value clone() {
        Value temp = new Value();
        temp.setValue(this.v);
        return temp;
    }
}
