package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartnerInfo {
    private final Long id;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final Partner.Status status;
}
