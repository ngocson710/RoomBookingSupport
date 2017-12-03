package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/17/2017.
 */

public class Facility {
    int FACILITY_ID;
    String FACILITY_NAME;
    int FACILITY_TYPE_ID;
    int FACILITY_ID_ROOT;
    String FACILITY_ADDRESS;
    int MAX_NUMBER_OF_PEOPLE;
    int SQUALL;
    String NOTE;


    public Facility(int FACILITY_ID, String FACILITY_NAME, int FACILITY_TYPE_ID, int FACILITY_ID_ROOT, String FACILITY_ADDRESS, int MAX_NUMBER_OF_PEOPLE, int SQUALL, String NOTE) {
        this.FACILITY_ID = FACILITY_ID;
        this.FACILITY_NAME = FACILITY_NAME;
        this.FACILITY_TYPE_ID = FACILITY_TYPE_ID;
        this.FACILITY_ID_ROOT = FACILITY_ID_ROOT;
        this.FACILITY_ADDRESS = FACILITY_ADDRESS;
        this.MAX_NUMBER_OF_PEOPLE = MAX_NUMBER_OF_PEOPLE;
        this.SQUALL = SQUALL;
        this.NOTE = NOTE;
    }

    public int getFACILITY_ID() {
        return FACILITY_ID;
    }

    public void setFACILITY_ID(int FACILITY_ID) {
        this.FACILITY_ID = FACILITY_ID;
    }

    public String getFACILITY_NAME() {
        return FACILITY_NAME;
    }

    public void setFACILITY_NAME(String FACILITY_NAME) {
        this.FACILITY_NAME = FACILITY_NAME;
    }

    public int getFACILITY_TYPE_ID() {
        return FACILITY_TYPE_ID;
    }

    public void setFACILITY_TYPE_ID(int FACILITY_TYPE_ID) {
        this.FACILITY_TYPE_ID = FACILITY_TYPE_ID;
    }

    public int getFACILITY_ID_ROOT() {
        return FACILITY_ID_ROOT;
    }

    public void setFACILITY_ID_ROOT(int FACILITY_ID_ROOT) {
        this.FACILITY_ID_ROOT = FACILITY_ID_ROOT;
    }

    public String getFACILITY_ADDRESS() {
        return FACILITY_ADDRESS;
    }

    public void setFACILITY_ADDRESS(String FACILITY_ADDRESS) {
        this.FACILITY_ADDRESS = FACILITY_ADDRESS;
    }

    public int getMAX_NUMBER_OF_PEOPLE() {
        return MAX_NUMBER_OF_PEOPLE;
    }

    public void setMAX_NUMBER_OF_PEOPLE(int MAX_NUMBER_OF_PEOPLE) {
        this.MAX_NUMBER_OF_PEOPLE = MAX_NUMBER_OF_PEOPLE;
    }

    public int getSQUALL() {
        return SQUALL;
    }

    public void setSQUALL(int SQUALL) {
        this.SQUALL = SQUALL;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }
}
