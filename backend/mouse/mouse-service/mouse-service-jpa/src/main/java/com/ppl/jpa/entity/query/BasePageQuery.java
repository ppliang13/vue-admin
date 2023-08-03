package com.ppl.jpa.entity.query;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Created by pisiliang on 2023/8/2 16:17
 */
@Data
public class BasePageQuery {
    private Integer page;
    private Integer size;

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }
}
