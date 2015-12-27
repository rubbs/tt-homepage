package de.rubbs.sfgtt.mail;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ruben on 21.12.15.
 */
@Data
@Builder
public class ParseResultDTO {
    boolean html;
    String content;
}
