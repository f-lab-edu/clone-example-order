package dev.practice.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        /**
         * 1. command -> initPartner 생성
         * 2. initPartner -> DB에 저장
         * 3. 결과값 partner -> PartnerInfo 반환
         */

        var initPartner = command.toEntity();
        Partner partner = partnerStore.store(initPartner);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional(readOnly = true)
    public PartnerInfo getPartnerInfo(String partnerToken) {
        /**
         * 1. partnerToken -> DB 검색
         * 2. 결과값 partner -> PartnerInfo 반환
         */

        Partner partner = partnerReader.getPartner(partnerToken);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
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
        return new PartnerInfo(updatePartner);
    }

    @Override
    @Transactional
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
        return new PartnerInfo(updatePartner);
    }
}
