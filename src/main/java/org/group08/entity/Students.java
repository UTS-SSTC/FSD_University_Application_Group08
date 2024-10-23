package org.group08.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private String id;
    private String password;
    private String name;
    private String email;
}
