package jp.co.jdsnet.base.webapp.parts;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserConfirmModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private String usrid;
  private String pwd;
  private String count;
}
