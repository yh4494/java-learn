package topdf.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-30 13:35
 * @Version V1.0
 */
@Setter
@Getter
public class TestPdfModel extends AbstractEmailModel implements Serializable {

    private static final long serialVersionUID = 5299150424311776164L;

    private String name;

    private String some;

}
