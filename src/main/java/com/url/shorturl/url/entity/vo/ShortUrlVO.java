package com.url.shorturl.url.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author chenguangxu
 * @since 2019-09-25
 */
@Data
public class ShortUrlVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String urlValue;

    private String title;

}
