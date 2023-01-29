package com.example.creasy.model;

import java.util.ArrayList;
import java.util.List;

public enum StateProspect {

    NOT_STARTED,
    IN_PROGRESS,
    TO_FOLLOW_UP,
    ENDED;

    public static List<StateProspect> getProspectStates() {
        List<StateProspect>  prospectStates =  new ArrayList<>();
        prospectStates.add(NOT_STARTED);
        prospectStates.add(IN_PROGRESS);
        prospectStates.add(TO_FOLLOW_UP);

        return prospectStates;
    }

    public static List<StateProspect> getCustomerState() {
        List<StateProspect>  customerState =  new ArrayList<>();
        customerState.add(ENDED);
        return customerState;
    }

}
