import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class MetricConverter {
    @FXML
    private TextField tfInput;
    @FXML
    private Label lbOutput;
    @FXML
    private AnchorPane pnMetricConverter; 
    @FXML
    private RadioButton btKilometer, btYard, btMiles, btMeters, btCentimeters, btInches, btFeet, btKelvin, btCelsius, btFahrenheit;
    @FXML
    private RadioButton btKilometerEnd, btYardEnd, btMilesEnd, btMetersEnd, btCentimetersEnd, btInchesEnd, btFeetEnd, btKelvinEnd, btCelsiusEnd, btFahrenheitEnd;

    String startingUnit;
    double firstStartingUnit;
    String endingUnit;
    String Output;
    double unit;
    double continuedUnit;
    double commonConversion = 0.;
    double meterToFeet = 3.2808398950131233;
    boolean typeOfMeasurement;
    boolean typeOfMeasurement2;

    /// starting unit  [,] amount of starting unit [,] desired conversion value.

    public void ButtonPressed(ActionEvent event){
        if (btYard.isSelected()){
            startingUnit = "yards";
            typeOfMeasurement = true; // true indicating that it is a distance, moreover to indicate that it is not the same as the temp
        } else if (btMiles.isSelected()){
            startingUnit = "miles";
            typeOfMeasurement = true;
        } else if (btKilometer.isSelected()){
            startingUnit = "kilometers";
            typeOfMeasurement = true;
        } else if (btMeters.isSelected()){
            startingUnit = "meters";
            typeOfMeasurement = true;
        } else if (btCentimeters.isSelected()){
            startingUnit = "centimeters";
            typeOfMeasurement = true;
        } else if (btInches.isSelected()){
            startingUnit = "inches";
            typeOfMeasurement = true;
        } else if (btFeet.isSelected()){
            startingUnit = "feet";
            typeOfMeasurement = true;
        } else if (btKelvin.isSelected()){
            startingUnit = "kelvin";
            typeOfMeasurement = false;
        } else if (btFahrenheit.isSelected()){
            startingUnit = "fahrenheit";
            typeOfMeasurement = false;
        } else if (btCelsius.isSelected()){
            startingUnit = "celsius";
            typeOfMeasurement = false;
        }
    }

    public void ButtonPressedEnd(ActionEvent event){
        if (btYardEnd.isSelected()){
            endingUnit = "yards";
            typeOfMeasurement2 = true;
        } else if (btMilesEnd.isSelected()){
            endingUnit = "miles";
            typeOfMeasurement2 = true;
        } else if (btKilometerEnd.isSelected()){
            endingUnit = "kilometers";
            typeOfMeasurement2 = true;
        } else if (btMetersEnd.isSelected()){
            endingUnit = "meters";
            typeOfMeasurement2 = true;
        } else if (btCentimetersEnd.isSelected()){
            endingUnit = "centimeters";
            typeOfMeasurement2 = true;
        } else if (btInchesEnd.isSelected()){
            endingUnit = "inches";
            typeOfMeasurement2 = true;
        } else if (btFeetEnd.isSelected()){
            endingUnit = "feet";
            typeOfMeasurement2 = true;
        } else if (btKelvinEnd.isSelected()){
            endingUnit = "kelvin";
            typeOfMeasurement2 = false;
        } else if (btFahrenheitEnd.isSelected()){
            endingUnit = "fahrenheit";
            typeOfMeasurement2 = false;
        } else if (btCelsiusEnd.isSelected()){
            endingUnit = "celsius";
            typeOfMeasurement2 = false;
        }
    }

    public void GetUnit(){
        unit = Double.parseDouble(tfInput.getText());
    }

    public void Calculate(){
        if (((typeOfMeasurement2)&&(typeOfMeasurement))||((!typeOfMeasurement2)&&(!typeOfMeasurement))) {
            GetUnit();
        if ((startingUnit.equalsIgnoreCase("kilometers"))||(startingUnit.equalsIgnoreCase("miles"))){
            if (startingUnit.equalsIgnoreCase("kilometers")){
                commonConversion = (unit * 1000 ) * meterToFeet;
            } else if (startingUnit.equalsIgnoreCase("miles")){
                commonConversion = unit * 5280;
            }
        } else if ((startingUnit.equalsIgnoreCase("meters"))||(startingUnit.equalsIgnoreCase("centimeters"))||
                (startingUnit.equalsIgnoreCase("yards"))||(startingUnit.equalsIgnoreCase("feet"))||
                (startingUnit.equalsIgnoreCase("inches"))){
            if (startingUnit.equalsIgnoreCase("meters")){
                commonConversion = unit * meterToFeet;
            } else if (startingUnit.equalsIgnoreCase("centimeters")){
                commonConversion = (unit / 100) * meterToFeet;
            } else if (startingUnit.equalsIgnoreCase("yards")){
                commonConversion = unit * 3;
            } else if (startingUnit.equalsIgnoreCase("feet")){
                commonConversion = unit;
            } else if (startingUnit.equalsIgnoreCase("inches")){
                commonConversion = unit / 12;
            }
        } else if ((startingUnit.equalsIgnoreCase("kelvin"))||(startingUnit.equalsIgnoreCase("celsius"))||
            (startingUnit.equalsIgnoreCase("fahrenheit"))){
                if (startingUnit.equalsIgnoreCase("kelvin")){
                    commonConversion = unit + 273.15;
                } else if (startingUnit.equalsIgnoreCase("celsius")){
                    commonConversion = unit;
                } else if (startingUnit.equalsIgnoreCase("fahrenheit")){
                    commonConversion = (unit * 9/5) + 32;
                }
        } else {
            System.out.println("Please select a starting unit\n");
        }


        if ((endingUnit.equalsIgnoreCase("kilometers"))||(endingUnit.equalsIgnoreCase("miles"))){
            if (endingUnit.equalsIgnoreCase("kilometers")){
                continuedUnit = (commonConversion / 1000) / meterToFeet;
                // System.out.println(continuedUnit + " kilometers");
            } else if (endingUnit.equalsIgnoreCase("miles")){
                continuedUnit = commonConversion / 5280;
                // System.out.println(continuedUnit + " miles");
            }
        } else if ((endingUnit.equalsIgnoreCase("meters"))||(endingUnit.equalsIgnoreCase("centimeters"))||
        (endingUnit.equalsIgnoreCase("yards"))||(endingUnit.equalsIgnoreCase("feet"))||
        (endingUnit.equalsIgnoreCase("inches"))){
            if (endingUnit.equalsIgnoreCase("meters")){
                continuedUnit = commonConversion / meterToFeet;
                // System.out.println(continuedUnit + " meters");
            } else if (endingUnit.equalsIgnoreCase("centimeters")){
                continuedUnit = (commonConversion / meterToFeet) * 100;
                // System.out.println(continuedUnit + " centimeters");
            } else if (endingUnit.equalsIgnoreCase("yards")){
                continuedUnit = commonConversion / 3;
                // System.out.println(continuedUnit + " yards");
            } else if (endingUnit.equalsIgnoreCase("feet")){
                continuedUnit = commonConversion;
                // System.out.println(continuedUnit + " feet");
            } else if (endingUnit.equalsIgnoreCase("inches")){
                continuedUnit = commonConversion * 12;
                //System.out.println(continuedUnit + " inches");
            }
                    
        } else if ((endingUnit.equalsIgnoreCase("kelvin"))||(endingUnit.equalsIgnoreCase("celsius"))||
        (endingUnit.equalsIgnoreCase("fahrenheit"))){
            if (endingUnit.equalsIgnoreCase("kelvin")){
                continuedUnit = commonConversion - 273.15;
                //System.out.println(continuedUnit + " degrees Kelvin");
            } else if (endingUnit.equalsIgnoreCase("celsius")){
                continuedUnit = commonConversion;
                //System.out.println(continuedUnit + " degrees Celsius");
            } else if (endingUnit.equalsIgnoreCase("fahrenheit")){
                continuedUnit = (commonConversion * 9/5) + 32;
                //System.out.println(continuedUnit + " degrees Fahrenheit");
            }
        } else {
            System.out.println("Please select a conversion unit\n");
        }
        AddToOutput(new ActionEvent());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            //alert.setTitle();
            alert.setHeaderText("Distances and Temperature can not be converted");
            alert.setContentText("Please choose new units");
            alert.showAndWait();
        }
    }

    public void AddToOutput(ActionEvent event){
        lbOutput.setText("Output: " + continuedUnit + " " + endingUnit);
    }
}
