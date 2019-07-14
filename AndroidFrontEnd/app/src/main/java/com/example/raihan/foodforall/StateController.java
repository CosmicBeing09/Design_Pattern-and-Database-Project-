package com.example.raihan.foodforall;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.raihan.foodforall.Interfaces.Istate;

public class StateController implements Parcelable{
    Istate currentState;
    Istate prviousState;
    Istate nextState;

    public StateController(){}


    public Istate getNextState() {
        return nextState;
    }

    public void setNextState(Istate nextState) {
        this.nextState = nextState;
    }

    public Istate getCurrentState() {
        return currentState;

    }

    public void setCurrentState(Istate currentState) {
        this.currentState = currentState;
    }

    public Istate getPrviousState() {
        return prviousState;
    }

    public void setPrviousState(Istate prviousState) {
        this.prviousState = prviousState;
    }

    protected StateController(Parcel in) {
    }

    public static final Creator<StateController> CREATOR = new Creator<StateController>() {
        @Override
        public StateController createFromParcel(Parcel in) {
            return new StateController(in);
        }

        @Override
        public StateController[] newArray(int size) {
            return new StateController[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
