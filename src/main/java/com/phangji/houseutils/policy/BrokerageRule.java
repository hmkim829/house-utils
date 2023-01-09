package com.phangji.houseutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * 가격이 특정 범위일 때, 상한효율과 상한금액을 가지는 클래스
 */
@AllArgsConstructor
@Getter
public class BrokerageRule {
    private Long lessTan;
    private Double brokeragePercent;

    @Nullable
    private Long limitAmount;

    public BrokerageRule(Long lessTan, Double brokeragePercent) {
        this(lessTan, brokeragePercent, Long.MAX_VALUE);
    }

    public Long calcMaxBrokerage(Long price){
        return Math.min(multiplyPercent(price),limitAmount);
    }

    private Long multiplyPercent(Long price){
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
