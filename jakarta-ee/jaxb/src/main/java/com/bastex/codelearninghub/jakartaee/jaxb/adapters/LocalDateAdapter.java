package com.bastex.codelearninghub.jakartaee.jaxb.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import lombok.NonNull;

import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(final String dateAsText) {
        if (dateAsText == null || dateAsText.isBlank()) {
            throw new IllegalStateException("Unable to parse date");
        }

        return LocalDate.parse(dateAsText);
    }

    @Override
    public String marshal(@NonNull final LocalDate localDate) {
        return localDate.toString();
    }
}
