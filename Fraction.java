package fraction;

import java.lang.*;

/**
 * Provides a fraction function for calculation.
 * @author zhang
 * @version 1.0
 *
 */
public class Fraction implements Comparable{
    private int numerator;
    private int denominator;
    
    /**
     * Creates a Fraction object with numerator and denominator.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator){
        checkDenominator(denominator);
        createFractionNoGCD(numerator, denominator);
        produceFractionWithGCD();
    }
    
    // produce a fraction without considering nomorlization
    private void createFractionNoGCD(int numerator, int denominator) {
        if (numerator * denominator < 0) {
            this.numerator = Math.abs(numerator) * (-1);
        } else {
            this.numerator = Math.abs(numerator);
        }
        
        this.denominator = Math.abs(denominator);
    }

    private void checkDenominator(int d) {
        if (d == 0) {
            throw new ArithmeticException();
        }
    }
    
    // reduce the fraction with Euclid's algorithm
    private void produceFractionWithGCD() {
        int num = Math.abs(this.numerator);
        int den = this.denominator;
        int moyu = num % den;
        
        while (moyu != 0) {
            num = den;
            den = moyu;
            moyu = num % den;
        }
        
        this.numerator = this.numerator / den;
        this.denominator = this.denominator / den;
    }
    /**
     * Creates a Fraction object only with numerator and 1 is the implicit denominator.
     * @param wholeNumber used a numerator.
     */
    public Fraction(int wholeNumber){
        this.numerator = wholeNumber;
        this.denominator = 1;
    }
    
    /**
     * Creates a Fraction object with a string.
     * @param fraction
     */
    public Fraction(String fraction) {
        
        int tempNum = 0;
        int tempDen = 0;
        
        if(!fraction.contains("/")) {
            this.numerator = Integer.parseInt(fraction);
            this.denominator = 1;
            return;
        } else {
            String[] s = fraction.split("/");
            if (s.length != 2) {
                
                System.out.println("Please input the fraction in correct format!");
                return;
            }
            tempNum = Integer.parseInt(s[0].trim());
            tempDen = Integer.parseInt(s[1].trim());
        }
        
        checkDenominator(tempDen);
        createFractionNoGCD(tempNum, tempDen);
        produceFractionWithGCD();
    }
    
    /**
     * Returns the sum of this Fraction and the Fraction f.
     * @param f The fraction to be added to this one.
     * @return The sum of the two Fractions.
     */
    public Fraction add(Fraction f) {
        int tempNum = this.numerator * f.denominator + this.denominator * f.numerator;
        int tempDen = this.denominator * f.denominator;
  
        return new Fraction(tempNum, tempDen);
    }
    
    /**
     * Returns the subtraction of this Fraction and the Fraction f. 
     * @param f The Fraction to be subtracted from this one.
     * @return The subtraction of the two Fractions.
     */
    public Fraction subtract(Fraction f) {
        int tempNum = this.numerator * f.denominator - this.denominator * f.numerator;
        int tempDen = this.denominator * f.denominator;
  
        return new Fraction(tempNum, tempDen);
    }
    
    /**
     * Returns the multiplication of this Fraction and the Fraction f.
     * @param f The Fraction to be multiplied to this one.
     * @return The multiplication of the two Fractions.
     */
    public Fraction multiply(Fraction f) {
        int tempNum = this.numerator * f.numerator;
        int tempDen = this.denominator * f.denominator;
  
        return new Fraction(tempNum, tempDen);
    }
    
    /**
     * Returns the division of this Fraction and the Fraction f.
     * @param f The Fraction to be divided by this one.
     * @return The division of the two Fractions.
     */
    public Fraction divide(Fraction f) {
        int tempNum = this.numerator * f.denominator;
        int tempDen = this.denominator * f.numerator;
  
        return new Fraction(tempNum, tempDen);
    }
    
    /**
     * Returns the absolution of this Fraction.
     * @return
     */
    public Fraction abs() {
        int tempNum = Math.abs(this.numerator);
        return new Fraction(tempNum, this.denominator);
    }
    
    /**
     * Returns the negative value of this Fraction
     * @return
     */
    public Fraction negate() {
        int tempNum = -1 * this.numerator;
        return new Fraction(tempNum, this.denominator);
    }
    
    /**
     * Returns the inversion of this Fraction
     * @return
     */
    public Fraction inverse() {
        int tempNum = this.denominator;
        int tempDen = this.numerator;
        return new Fraction(tempNum, tempDen);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Fraction) {
            return ((Fraction)o).numerator * this.denominator == ((Fraction)o).denominator * this.numerator;
        }
        return false;
    }
    
    @Override
    public int compareTo(Object o) {
        if (o instanceof Integer) {
            if (this.numerator < this.denominator * (int)o) {
                return -1;
            } else if(this.numerator < this.denominator * (int)o) {
                return 1;
            } else {
                return 0;
            }
        }
        
        if (o instanceof Fraction) {
            if (this.numerator * ((Fraction)o).denominator < this.denominator * ((Fraction)o).numerator) {
                return -1;
            } else if(this.numerator * ((Fraction)o).denominator > this.denominator * ((Fraction)o).numerator) {
                return 1;
            } else {
                return 0;
            }
        }
        
        throw new ClassCastException();
    }
    
    @Override
    public String toString() {
        if (this.denominator == 1) {
            return Integer.toString(this.numerator);
        }
        
        return this.numerator + "/" + this.denominator;
    }

}
