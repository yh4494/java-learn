package pattern.adapter;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-20 13:33
 * @Version V1.0
 */
public class Adapter extends ZheJiangSmoke implements Smoke {

    @Override
    public void sell() {
        super.zhejiangCompany();
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.sell();
    }
}
