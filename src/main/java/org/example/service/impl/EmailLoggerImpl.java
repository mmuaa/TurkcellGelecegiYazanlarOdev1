package org.example.service.impl;

import org.example.service.Logger;

public class EmailLoggerImpl implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message + ", Email logger ile loglandı.");
    }
}
