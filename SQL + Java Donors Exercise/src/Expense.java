
public class Expense {

	public static void main(String[] args) { }
		    private String expense_type;
		    private double amount;
		    private String business;
		    private int due_month;
		    private int due_day;

		    // default constructor ~ provided by java doesn't need to be coded


		    // constructor to set all values
		    public Expense(String expense_type, double amount, String business, int due_month, int due_day) {
		        this.expense_type = expense_type;
		        this.amount = amount;
		        this.business = business;

		        if(due_month < 1 || due_month > 12){
		            this.due_month = 0;
		        } else this.due_month = due_month;

		        if(due_day < 1 || due_day > 31){
		            this.due_day = 0;
		        } else this.due_day = due_day;
		    }

		    // copy constructor
		    public Expense(Expense exp) {    
		        this.expense_type = exp.expense_type;
		        this.amount = exp.amount;
		        this.business = exp.business;

		        if(exp.due_month < 1 || exp.due_month > 12){
		            this.due_month = 0;
		        } else this.due_month = exp.due_month;

		        if(exp.due_day < 1 || exp.due_day > 31){
		            this.due_day = 0;
		        } else this.due_day = exp.due_day;
		    }


		    // Accessors / mutators to get/set specific counts
		    public String getExpense_type() {
		        return expense_type;
		    }

		    public double getAmount() {
		        return amount;
		    }

		    public String getBusiness() {
		        return business;
		    }

		    public int getDue_month() {
		        return due_month;
		    }

		    public void setDue_month(int due_month) {
		        if(due_month < 1 || due_month > 12){
		            this.due_month = 0;
		        } else this.due_month = due_month;
		    }

		    public int getDue_day() {
		        return due_day;
		    }

		    public void setDue_day(int due_day) {
		        if(due_day < 1 || due_day > 31){
		            this.due_day = 0;
		        } else this.due_day = due_day;
		    }

		    public String toString(){

		        String dd = "";

		        if(due_day < 10){
		            dd+= "0"+due_day;
		        } else dd+= due_day;

		        dd+="/";

		        if(due_month < 10){
		            dd+="0"+due_month;
		        } else dd+= due_month;

		        return 
		            "expense type   : " + expense_type  + "\n" +
		            "amount         : " + amount        + "\n" +
		            "business       : " + business      + "\n" +
		            "due date       : " + dd; 
		    }

		    public boolean equals(Expense exp) {  
		        if(  
		            this.expense_type.equals(exp.expense_type)  &&
		            this.business.equals(exp.business)          &&
		            this.amount     == exp.amount               &&
		            this.due_month  == exp.due_month            &&
		            this.due_day    == exp.due_day
		        ) {
		            return true;
		        } 
		        return false;
		    }


		

	}


