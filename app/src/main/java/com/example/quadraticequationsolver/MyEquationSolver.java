package com.example.quadraticequationsolver;

import android.text.TextUtils;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

// Extended BaseObservable to enable the use of the @Bindable annotation.
// This allows the property to be observed for changes.
public class MyEquationSolver extends BaseObservable
{
    // Variables for storing input data from EditText fields
    String result;
    private String a;
    private String b;
    private String c;

    private String equationDisplay;//Created this variable for displaying the whole equation


    // Getters and setters for the variables to enable data binding from the layout file
    // having getters and setters for the variables is required. Data binding relies
    // on these methods to automatically update the UI when the underlying data changes and vice versa.

    //  //@Bindable annotation in data binding, we only need to annotate the getter method.
    //    // The setter method will call notifyPropertyChanged()
    //    // to notify that a property has changed and update the UI
    @Bindable
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
        notifyPropertyChanged(BR.a);// This method notifies observers that the property has changed
        updateEquationDisplay();
    }
    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
        notifyPropertyChanged(BR.b);// This method notifies observers that the property has changed
        updateEquationDisplay();
    }
    @Bindable
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
        //BR is a generated class that contains identifiers for all @Bindable
        // properties to notify the data binding system of property changes.
        notifyPropertyChanged(BR.c);// This method notifies observers that the property has changed
        //Calling this method, so that a,b and c all can
        //be showcased on the textview
        updateEquationDisplay();
    }
//Created constructor for initializing the variables
    public MyEquationSolver()
    {
        //Initializing the variables with empty String, to avoid null in the TextView
        this.a = "";
        this.b = "";
        this.c = "";
        this.equationDisplay="";
    }
    // Method for displaying all the variables together in the TextView
    private void updateEquationDisplay()
    {
        setEquationDisplay("a: "+a+", b: "+b+", c: "+c);
    }
    @Bindable
    public String getEquationDisplay() {
        return equationDisplay;
    }
    public void setEquationDisplay(String equationDisplay)
    {
        this.equationDisplay = equationDisplay;
        notifyPropertyChanged(BR.equationDisplay);
    }
    //Method that we will be calling from the layout file, and by using onClick(), of button
    public void SolveEquation(View view) {
        //Converting the String variables to int.
        try {
            int a = Integer.parseInt(getA());
            int b = Integer.parseInt(getB());
            int c = Integer.parseInt(getC());
            // Calculate the Discriminant
            double discriminant = b * b - 4 * a * c;
            // Finding the solutions (roots)
            double x1, x2;
            if (discriminant > 0) {
                // Two real and distinct roots (Solutions)
                x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                result = "X1= " + x1 + ", X2= " + x2;
            } else if (discriminant < 0) {
                result = "No real roots";
            } else {
                // One real solution
                x1 = -b / (2 * a);
                result = "X= " + x1;
            }
            //Calling this method,to showcase the a,b and c and result as well
            setEquationDisplay("a: " + getA() + ", b: " + getB() + ", c:" + c + "\nResult: " + result);

        } catch (NumberFormatException e)
        {
           setEquationDisplay("Something wrong in the input");
        }
    }
}