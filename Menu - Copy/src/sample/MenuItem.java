
package sample;

import java.util.regex.Pattern;

public class MenuItem {
    protected String name;
    protected Integer calories,protein;
    protected Double price;

    public MenuItem(String name, Integer calories, Integer protein, Double price) {
        setName(name);
        setCalories(calories);
        setProtein(protein);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {

        if(isWord(name)) {
            String firstLetter = name.substring(0, 1).toUpperCase();
            name = firstLetter + name.substring(1);
            this.name = name;
        } else
            throw new IllegalArgumentException("Please enter a valid name that is only composed of letters and spaces.");

        return name;
    }


    public Integer getCalories() {
        return calories;
    }

    public Integer setCalories(Integer calories) {
        if(calories>= 0&& calories <= 5000) {
            this.calories = calories;
        }
        else throw new IllegalArgumentException("Calorie count must be between 0 and 5000.");
        return calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public Integer setProtein(Integer protein) {
        if(protein>= 0&& protein <= 200) {
            this.protein = protein;
        }
        else throw new IllegalArgumentException("Protein count must be between 0 and 200.");
        return protein;
    }

    public Double getPrice() {
        return price;
    }

    public Double setPrice(Double price) {
        if(price>= 0&& price <= 100) {
            this.price = price;
        }
        else throw new IllegalArgumentException("Price must be below 100 dollars.");
        return price;
    }

    //Have to validate for spaces between names too. Not sure how yet
    public static boolean isWord(String in){
        return Pattern.matches("[a-zA-Z]+",in);
    }

    public String toString(){
        return String.format("%s, cal:$d, price:$%.2f.", name,calories,price);
    }

}
