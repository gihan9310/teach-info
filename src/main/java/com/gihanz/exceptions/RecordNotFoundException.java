package com.gihanz.exceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException {

    private String error;

}
