package dev.practice.order.infrastructure.order;

import dev.practice.order.domain.order.OrderCommand;
import dev.practice.order.domain.order.PayMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverPayApiCaller implements PaymentApiCaller {

    @Override
    public boolean support(PayMethod payMethod) {
        return PayMethod.NAVER_PAY == payMethod;
    }

    @Override
    public void pay(OrderCommand.PaymentRequest request) {
        // TODO - 구현
    }
}
