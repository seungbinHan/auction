package dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AuctionItem {

  //감정가
  private int appraisedPrice;
  //유찰횟수
  private int miscarryCount;
  //최저입찰가
  private int minimumPrice;
  //입찰보증금
  private int deposit;
  private String name;
  // 근저당 일자
  private LocalDate collateralDate;
  // 근저당 금액
  private int collateralPrice;
  // 현재 점유자 보증금
  private int occupyDeposit;
  // 현재 점유자 전입일
  private LocalDate occupyDate;
  // 현재 점유자 확정일자 날짜
  private LocalDate confirmationDate;
}
