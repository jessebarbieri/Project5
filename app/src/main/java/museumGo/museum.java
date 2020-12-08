/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package museumGo;

import java.text.DecimalFormat;

/**
 * Class handles museum name, prices for each tickets,
 */
public class museum {

    /** declare variables **/
    private int ticketPriceStudent;
    private int ticketPriceAdult;
    private int ticketPriceSenior;

    private double salesTax;
    private double ticketTotal;

    public int students;
    public int adults;
    public int seniors;

    /**
     * Default constructor and initialize salesTax for NY
     * @param ticketPriceStudent price set for student
     * @param ticketPriceAdult price set for adult
     * @param ticketPriceSenior price set for senior
     */
    public museum(int ticketPriceStudent, int ticketPriceAdult, int ticketPriceSenior){
        this.ticketPriceStudent = ticketPriceStudent;
        this.ticketPriceAdult = ticketPriceAdult;
        this.ticketPriceSenior = ticketPriceSenior;

        // variables
        salesTax = 0.08875;
        ticketTotal = 0;
        students = 0;
        adults = 0;
        seniors = 0;
    }

    /**
     * Getters for price
     */
    public int ticketPriceSt(){
        return ticketPriceStudent;
    }
    public int ticketPriceS(){
        return ticketPriceSenior;
    }
    public int ticketPriceA(){
        return ticketPriceAdult;
    }

    /**
     * Add ticket to the current "list" of tickets
     * @return double new value
     */
    public int addTicket(int numOfTickets, String type){

        int returnVal = 0;
        int max = 5;

        if(type.equals("Student")){
            if(numOfTickets <= max){
                ++students;
                returnVal = ++numOfTickets;
            }else{
                return numOfTickets;
            }

        }if(type.equals("Adult")){
            if(numOfTickets <= max){
                ++adults;
                returnVal = ++numOfTickets;
            }else{
                return numOfTickets;
            }
        }if(type.equals("Senior")){
            if(numOfTickets <= max){
                ++seniors;
                returnVal = ++numOfTickets;
            }else{
                return numOfTickets;
            }
        }

        return returnVal;

    }

    /**
     * Remove ticket to the current "list" of tickets
     */
    public int removeTicket(int numOfTickets, String type){
        int returnVal = 0;

        if(type.equals("Student")){
            --students;
            returnVal = --numOfTickets;
        }else if(type.equals("Adult")){
            --adults;
            returnVal = --numOfTickets;
        }else  if(type.equals("Senior")){
            --seniors;
            returnVal = --numOfTickets;
        }

        return returnVal;
    }

    /**
     * Find total price with sales tax on it
     * @return double total price
     */
    public String totalPrice(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return (df.format(totalNoTax()*(1+salesTax)));
    }

    /**
     * Finds total price without sales tax on it
     * @return double total price without tax
     */
    public int totalNoTax(){
        int ticketTotal1 =  students*ticketPriceStudent;
        int ticketTotal2 =  seniors*ticketPriceSenior;
        int ticketTotal3 =  adults*ticketPriceAdult;

        return ticketTotal1 + ticketTotal2 + ticketTotal3;
    }

    /**
     * Finds the sales tax of the total
     * @return double tax amount
     */
    public String getSalesTax(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return (df.format(totalNoTax()*(salesTax)));
    }

}
