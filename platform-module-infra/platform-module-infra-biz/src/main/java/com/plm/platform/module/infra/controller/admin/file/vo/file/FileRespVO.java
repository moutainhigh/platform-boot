package com.plm.platform.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 文件 Response VO,不返回 content 字段，太大")
@Data
public class FileRespVO {

    @Schema(description = "文件编号", required = true, example = "1024")
    private Long id;

    @Schema(description = "配置编号", required = true, example = "11")
    private Long configId;

    @Schema(description = "文件路径", required = true, example = "platform.jpg")
    private String path;

    @Schema(description = "原文件名", required = true, example = "platform.jpg")
    private String name;

    @Schema(description = "文件 URL", required = true, example = "https://www.example.com/platform.jpg")
    private String url;

    @Schema(description = "文件MIME类型", example = "application/octet-stream")
    private String type;

    @Schema(description = "文件大小", example = "2048", required = true)
    private Integer size;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
