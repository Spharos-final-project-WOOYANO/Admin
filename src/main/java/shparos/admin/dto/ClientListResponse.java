package shparos.admin.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientListResponse {
    //사업자 아이디
    private String clientId;
    //대표자 명
    private String ceoName;
    //상호명
    private String clientName;
    //사업자 전화번호
    private String clientPhone;
    //사업자 주소ㅓ
    private String clientAddress;
    // 사업자 번호
    private String clientRegistrationNumber;
    //사업자 등록증 사본파일
    private String clientRegistrationImgUrl;
    //사업자 상태
    private Integer clientStatus;
    // 신청일
    private LocalDateTime clientRegistrationDate;
}
