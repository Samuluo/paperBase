package com.paper.demo.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Paper对象", description="")
public class Paper extends Model<Paper> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String type;

    private String content;

    @TableField("optionA")
    private String optionA;

    @TableField("optionB")
    private String optionB;

    @TableField("optionC")
    private String optionC;

    @TableField("optionD")
    private String optionD;

    @TableField("optionE")
    private String optionE;

    @TableField("optionF")
    private String optionF;

    private String answer;

    private Integer score;

    private String creator;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
