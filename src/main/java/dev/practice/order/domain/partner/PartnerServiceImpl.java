package dev.practice.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    public PartnerInfo registerPartner(PartnerCommand command) {
        /**
         * 1. command -> initPartner 생성
         * 2. initPartner -> DB에 저장
         * 3. 결과값 partner -> PartnerInfo 반환
         */

        var initPartner = Partner.builder()
                .partnerName(command.getPartnerName())
                .businessNo(command.getBusinessNo())
                .email(command.getEmail())
                .build();

        Partner partner = partnerStore.store(initPartner);

        return PartnerInfo.builder()
                .id(partner.getId())
                .partnerToken(partner.getPartnerToken())
                .partnerName(partner.getPartnerName())
                .businessNo(partner.getBusinessNo())
                .email(partner.getEmail())
                .status(partner.getStatus())
                .build();
    }

    @Override
    public PartnerInfo getPartnerInfo(String partnerToken) {
        /**
         * 1. partnerToken -> DB 검색
         * 2. 결과값 partner -> PartnerInfo 반환
         */

        Partner partner = partnerReader.getPartner(partnerToken);

        return PartnerInfo.builder()
                .id(partner.getId())
                .partnerToken(partner.getPartnerToken())
                .partnerName(partner.getPartnerName())
                .businessNo(partner.getBusinessNo())
                .email(partner.getEmail())
                .status(partner.getStatus())
                .build();
    }

    @Override
    public PartnerInfo enablePartner(String partnerToken) {
        /**
         * 1. partnerToken -> DB 검색
         * 2. partner -> 상태 변경
         * 3. partner -> DB에 저장
         * 4. 결과값 partner -> PartnerInfo 반환
         */

        Partner partner = partnerReader.getPartner(partnerToken);

        partner.enable();

        Partner updatePartner = partnerStore.store(partner);

        return PartnerInfo.builder()
                .id(updatePartner.getId())
                .partnerToken(updatePartner.getPartnerToken())
                .partnerName(updatePartner.getPartnerName())
                .businessNo(updatePartner.getBusinessNo())
                .email(updatePartner.getEmail())
                .status(updatePartner.getStatus())
                .build();
    }

    @Override
    public PartnerInfo disablePartner(String partnerToken) {
        /**
         * 1. partnerToken -> DB 검색
         * 2. partner -> 상태 변경
         * 3. partner -> DB에 저장
         * 4. 결과값 partner -> PartnerInfo 반환
         */

        Partner partner = partnerReader.getPartner(partnerToken);

        partner.disable();

        Partner updatePartner = partnerStore.store(partner);

        return PartnerInfo.builder()
                .id(updatePartner.getId())
                .partnerToken(updatePartner.getPartnerToken())
                .partnerName(updatePartner.getPartnerName())
                .businessNo(updatePartner.getBusinessNo())
                .email(updatePartner.getEmail())
                .status(updatePartner.getStatus())
                .build();
    }
}
