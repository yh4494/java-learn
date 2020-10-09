package topdf.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-30 13:39
 * @Version V1.0
 */
@Setter
@Getter
public abstract class AbstractEmailModel implements Serializable {

    private static final long serialVersionUID = 3597426963657558696L;

    // 邮件标题
    private String title;

    // 委托单位
    private String to;

    // 客服
    private String from;

}
