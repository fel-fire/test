package com.felfire.Chapter3.autowiring;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Foo {
    String id = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
}
