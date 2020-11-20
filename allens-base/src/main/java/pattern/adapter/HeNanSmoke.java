package pattern.adapter;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-20 13:30
 * @Version V1.0
 */
public class HeNanSmoke implements Smoke {

    private void henanCompany () {
        System.out.println("sell henan smoke");
    }

    @Override
    public void sell() {
        henanCompany();
    }
}
