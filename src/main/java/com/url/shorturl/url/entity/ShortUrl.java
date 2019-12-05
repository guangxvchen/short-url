package com.url.shorturl.url.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenguangxu
 * @since 2019-09-25
 */
@Data
@Accessors(chain = true)
@TableName("short_url")
public class ShortUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * md5
     */
    private String md5;

    /**
     * 短连接映射
     */
    private String urlKey;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 源地址
     */
    private String urlValue;


}
