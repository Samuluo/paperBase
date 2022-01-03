package com.paper.demo.model.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@ApiModel(value="MentalityExam对象", description="")
public class MentalityExam extends Model<MentalityExam> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String section1;

    private String section2;

    private String section3;

    private String section4;

    private String section5;

    private String creator;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
