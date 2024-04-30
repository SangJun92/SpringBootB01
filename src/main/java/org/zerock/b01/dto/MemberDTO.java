package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String member_id;
    private String member_pw;
    private String name;
    private String phone;
    private String Email1;
    private String Email2;
    private String gender;
    private boolean agree;
    private LocalDate create_date;
}
