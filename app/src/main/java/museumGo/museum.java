package museumGo;

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

    /**
     * Default constructor and initialize salesTax for NY
     * @param ticketPriceStudent
     * @param ticketPriceAdult
     * @param ticketPriceSenior
     */
    public museum(int ticketPriceStudent, int ticketPriceAdult, int ticketPriceSenior){
        this.ticketPriceStudent = ticketPriceStudent;
        this.ticketPriceAdult = ticketPriceAdult;
        this.ticketPriceSenior = ticketPriceSenior;
        salesTax = 0.08875;
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
    public double addTicket(){
        return 0;
    }

    /**
     * Remove ticket to the current "list" of tickets
     */
    public double removeTicket(){
        return 0;
    }

    /**
     * Find total price with sales tax on it
     * @return double total price
     */
    public double totalPrice(){
        return 0;
    }

}
