package dev.practice.order.interfaces.partner;

import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PartnerDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotEmpty(message = "partnerName은 필수값입니다.")
        private String partnerName;

        @NotEmpty(message = "businessNo는 필수값입니다.")
        private String email;

        @Email(message = "email 형식에 맞아야 합니다.")
        @NotEmpty(message = "email은 필수값입니다.")
        private String businessNo;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        private final String partnerToken;
        private final String partnerName;
        private final String businessNo;
        private final String email;
        private final Partner.Status status;

        public RegisterResponse(PartnerInfo partnerInfo) {
            this.partnerToken = partnerInfo.getPartnerToken();
            this.partnerName = partnerInfo.getPartnerName();
            this.businessNo = partnerInfo.getBusinessNo();
            this.email = partnerInfo.getEmail();
            this.status = partnerInfo.getStatus();
        }
    }
}