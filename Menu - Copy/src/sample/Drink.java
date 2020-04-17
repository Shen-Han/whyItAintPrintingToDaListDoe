
package sample;

public class Drink extends MenuItem {

    private Integer mL;

    //Use super to inherit the variables from MenuItems

    public Drink(String name, Integer calories, Integer protein, Double price, Integer mL) {
        super(name, calories, protein, price);
        setMl(mL);
    }

    public Integer getML() {
        return mL;
    }

    public Integer setMl(Integer mL) {
        if(mL>= 100&& mL <= 1000) {
            this.mL = mL;
        }
        else throw new IllegalArgumentException("Protein count must be between 0 and 200.");
        return mL;
    }

    public String toString(){
        return String.format("%s, cal:$d, price:$%.2f, ml:%d", name,calories,price, mL);
    }
}
