package dev.practice.order.infrastructure.partner;

import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner partner) {
        if (StringUtils.isEmpty(partner.getPartnerToken())) throw new RuntimeException("partner.getPartnerToken()");
        if (StringUtils.isEmpty(partner.getPartnerName())) throw new RuntimeException("partner.getPartnerName()");
        if (StringUtils.isEmpty(partner.getBusinessNo())) throw new RuntimeException("partner.getBusinessNo()");
        if (StringUtils.isEmpty(partner.getEmail())) throw new RuntimeException("partner.getEmail()");
        if (partner.getStatus() == null) throw new RuntimeException("partner.getStatus()");

        return partnerRepository.save(partner);
    }
}
