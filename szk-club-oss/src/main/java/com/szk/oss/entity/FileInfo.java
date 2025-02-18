package com.szk.oss.entity;

import lombok.Data;

/**
 * 文件类
 * 
 * @author: szk
 * @date: 2023/10/12
 */
@Data
public class FileInfo {

    private String fileName;

    private Boolean directoryFlag;

    private String etag;

}
