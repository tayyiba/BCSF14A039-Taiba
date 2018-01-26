package com.example.awais.spendo;

/**
 * Created by awais on 7/25/2017.
 */

public class Expense {
    private int id;
    private int expenseAmount;
    private int cat_id;

    public Expense(int expenseAmount, int cat_id) {
        this.expenseAmount = expenseAmount;
        this.cat_id = cat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
}

