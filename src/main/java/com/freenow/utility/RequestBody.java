package com.freenow.utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestBody {
    private String objectClass;
    private Object objectInstance;

    public RequestBody(Class objectClass, Object objectInstance) {
        this.objectClass = objectClass.getName();
        this.objectInstance = objectInstance;
    }
}
