package com.bastex.codelearninghub.jakartaee.jaxrs.transformers;

import com.bastex.codelearninghub.jakartaee.jaxrs.domain.Feedback;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.FeedbackRequest;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbackResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Mapper(config = MapperBaseConfig.class)
public abstract class FeedbackTransformer {
    private static final DateTimeFormatter STANDARD_DATE_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
            .withZone(ZoneId.of("UTC"));

    public static FeedbackTransformer INSTANCE = Mappers.getMapper(FeedbackTransformer.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    public abstract Feedback toFeedback(FeedbackRequest feedbackRequest);

    public abstract FeedbackResponse toFeedbackResponse(Feedback feedback);

    String transformInstantToString(final Instant instant) {
        return STANDARD_DATE_OUTPUT_FORMAT.format(instant);
    }

    @AfterMapping
    void toFeedbackAfterMapping(final FeedbackRequest feedbackRequest, @MappingTarget final Feedback feedback) {
        feedback.setCreated(Instant.now());
    }
}
