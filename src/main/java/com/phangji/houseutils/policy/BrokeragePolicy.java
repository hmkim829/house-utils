package com.phangji.houseutils.policy;

import com.phangji.houseutils.exception.ErrorCode;
import com.phangji.houseutils.exception.HouseUtilsException;

import java.util.List;

public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price){
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessTan())
                .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }
}
