package de.rubbs.sfgtt.db;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ruben on 29.11.15.
 */
@Builder
@Data
public class Player {
    String name;
    String email;
}

