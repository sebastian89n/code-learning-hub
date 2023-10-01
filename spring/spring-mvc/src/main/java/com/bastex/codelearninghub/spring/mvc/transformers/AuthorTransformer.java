package com.bastex.codelearninghub.spring.mvc.transformers;

import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import com.bastex.codelearninghub.spring.data.domain.query.AuthorSort;
import com.bastex.codelearninghub.spring.mvc.dto.request.AuthorSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorTransformer {
    AuthorTransformer INSTANCE = Mappers.getMapper(AuthorTransformer.class);

    AuthorResponse toAuthorResponse(AuthorProjection authorProjection);

    AuthorSort toAuthorSort(AuthorSortRequest authorSortRequest);
}
