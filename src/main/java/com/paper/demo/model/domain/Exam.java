package com.paper.demo.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author hjh
 * @since 2021-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Exam对象", description="")
public class Exam extends Model<Exam> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userId;

    private Integer recordId1;

    private Integer recordId2;

    private Integer recordId3;

    private Integer recordId4;

    private Integer recordId5;

    private Integer recordId6;

    private Integer recordId7;

    private Integer recordId8;

    private Integer recordId9;

    private Integer recordId10;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
