package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bidder {

  private String name;
  //입찰보증금
  private int deposit;
  //입찰가
  private int bidAmount;
  public boolean isSuccessfulBid = false;
  public int benefit = 0;
}
