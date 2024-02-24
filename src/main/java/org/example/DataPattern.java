package org.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DataPattern {
    private final String city;
    private final String name;
    private final String phone;
}
