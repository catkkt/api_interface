package com.api.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 根据id请求更改
 *
 * @author kk
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}