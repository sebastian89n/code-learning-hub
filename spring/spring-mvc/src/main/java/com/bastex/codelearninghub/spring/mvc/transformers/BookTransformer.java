package com.bastex.codelearninghub.spring.mvc.transformers;

import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSort;
import com.bastex.codelearninghub.spring.mvc.dto.request.BookSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookTransformer {
    BookTransformer INSTANCE = Mappers.getMapper(BookTransformer.class);

    BookResponse toBookResponse(BookProjection bookProjection);

    BookSort toBookSort(BookSortRequest bookSortRequest);
}
