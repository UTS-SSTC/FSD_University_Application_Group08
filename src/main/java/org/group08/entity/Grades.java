package org.group08.entity;

import lombok.Data;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/16
 */
@Data
public class Grades {
    private String studentId;
    private String subjectId;
    private float score;
    public char type;
    public char label;
}
