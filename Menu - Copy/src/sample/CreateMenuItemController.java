
package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateMenuItemController implements Initializable {

    @FXML TextField nameEntry, calorieEntry, proteinEntry, priceEntry, miliLiters;
    @FXML CheckBox convertToDrink;
    @FXML Label errorMessage, mL;
    @FXML ListView menuItems;



    //Set Drink class related fields and labels to invisible to start
    public void initialize(URL location, ResourceBundle resources) {
        mL.setVisible(false);
        miliLiters.setVisible(false);

    }

    //Check if the drink button is pressed first, it yes, create a Drink class item, if not, create a MenuItem class item.
    public void submitButton(){

        Drink drinkItem;
        MenuItem menuItem;

        if (!convertToDrink.isSelected()) {
            if (fieldsAreFull()) {
                try {
                    menuItem = new MenuItem(nameEntry.getText(),
                            Integer.parseInt(calorieEntry.getText()),
                            Integer.parseInt(proteinEntry.getText()),
                            Double.parseDouble(priceEntry.getText()));
                    menuItems.getItems().addAll(menuItem);
                } catch (IllegalArgumentException e) {
                    errorMessage.setText(e.getLocalizedMessage());
                }
            }
        }
        if (convertToDrink.isSelected()){
            if (fieldsAreFull()) {
                try {
                    drinkItem = new Drink(nameEntry.getText(),
                            Integer.parseInt(calorieEntry.getText()),
                            Integer.parseInt(proteinEntry.getText()),
                            Double.parseDouble(priceEntry.getText()),
                            Integer.parseInt(miliLiters.getText()));
                    menuItems.getItems().addAll(drinkItem);
                } catch (IllegalArgumentException e) {
                    errorMessage.setText(e.getLocalizedMessage());
                }
            }
        }
        //This doesn't work, didn't have enough time to troubleshoot why the listview lines within the above two groups
        //are not populating the listview.
        menuItems.getItems().addAll(toString());
    }

    //Check if drink checkbox is selected and set the relevant fields and labels visible or not depending.

    public void drinkConvert(){
       if (convertToDrink.isSelected()){
        mL.setVisible(true);
        miliLiters.setVisible(true);
       } else if (!convertToDrink.isSelected()){
           mL.setVisible(false);
           miliLiters.setVisible(false);
       }
    }

    //validation boolean from assignment 2 upscaled to validate for four fields. There has to be a simpler way than this.

    public boolean fieldsAreFull() {
        String message = "";
        if (nameEntry.getText().isEmpty()) {
            message = "Name field is empty";
        }

        if (calorieEntry.getText().isEmpty()) {
            if (message.isEmpty()) {
                message = "Calorie count is empty";
            } else
                message = "Name and Calorie fields are Empty";
        }
        if (proteinEntry.getText().isEmpty()) {
            if (message.isEmpty())
                message = "Protein count is Empty";
            else if (nameEntry.getText().isEmpty() && !calorieEntry.getText().isEmpty())
                message = "Name and Protein fields are empty.";
            else if (!nameEntry.getText().isEmpty() && calorieEntry.getText().isEmpty())
                message = "Calorie and Protein fields are empty.";
            else
                message = "Name, Calorie, and Protein fields are empty";
        }
        if (priceEntry.getText().isEmpty()) {
            if (message.isEmpty())
                message = "Price field is Empty";
            else if (nameEntry.getText().isEmpty() && !calorieEntry.getText().isEmpty()
                    &&!proteinEntry.getText().isEmpty())
                message = "Name and Price fields are empty.";
            else if (nameEntry.getText().isEmpty() && calorieEntry.getText().isEmpty()
                    &&!proteinEntry.getText().isEmpty())
                message = "Name, Calorie and Price fields are empty.";
            else if (!nameEntry.getText().isEmpty() && calorieEntry.getText().isEmpty()
                    &&!proteinEntry.getText().isEmpty())
                message = "Calorie and Price fields are empty.";
            else if (!nameEntry.getText().isEmpty() && calorieEntry.getText().isEmpty()
                    &&proteinEntry.getText().isEmpty())
                message = "Calorie, Protein, and Price fields are empty";
            else if (!nameEntry.getText().isEmpty() && !calorieEntry.getText().isEmpty()
                    &&proteinEntry.getText().isEmpty())
                message = "Protein and Price fields are empty";
            else if (nameEntry.getText().isEmpty() && calorieEntry.getText().isEmpty()
                    &&proteinEntry.getText().isEmpty())
                message = "All fields are empty";
        }
        errorMessage.setText(message);

        return false;
    }
}

