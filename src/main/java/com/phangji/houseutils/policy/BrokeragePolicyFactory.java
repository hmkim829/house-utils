package com.phangji.houseutils.policy;

import com.phangji.houseutils.constants.ActionType;
import com.phangji.houseutils.exception.ErrorCode;
import com.phangji.houseutils.exception.HouseUtilsException;

public class BrokeragePolicyFactory {

    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case PURCHASE -> {
                return purchaseBrokeragePolicy;
            }
            case RENT -> {
                return rentBrokeragePolicy;
            }
            default -> throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType에 대한 정책이 존재하지 않습니다.");
        }
    }
}
